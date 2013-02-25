package org.training.d4.dao.xml;

import java.util.HashMap;
import java.util.Map;

import org.training.d4.bean.Message;
import org.training.d4.dao.DaoException;
import org.training.d4.dao.DaoFactory;
import org.training.d4.dao.IMessageDao;
import org.xml.sax.SAXException;

/**
 * The Class CommentImplXml.
 */
public class MessageImplXml extends GenericDAOXml<Message> implements IMessageDao {

	/** The tag. */
	private Tags tag;

	/** The value tag. */
	private String valueTag;
	/** The comment. */
	private Message message;

	/** The id. */
	private int id;

	/**
	 * Instantiates a new comment impl xml.
	 * @throws DaoException
	 *             the dao exception
	 */
	public MessageImplXml() throws DaoException {
		super("/xml/Message.xml", Message.class);
	}

	/**
	 * The Enum Tags.
	 */
	private static enum Tags {

		/** The comment. */
		MESSAGE,
		/** The issueid. */
		ADDEDBY,
		/** The adddate. */
		ADDDATE,
		/** The text. */
		TEXT;
		/** The Constant TO_ENUM. */
		private static final Map<String, Tags> TO_ENUM = new HashMap<String, Tags>();
		static {
			for (Tags op : values()) {
				TO_ENUM.put(op.toString(), op);
			}
		}

		/**
		 * From string.
		 * @param string
		 *            the string
		 * @return the tags
		 */
		public static Tags fromString(String string) {
			return TO_ENUM.get(string.toUpperCase());
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startElement
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			org.xml.sax.Attributes attributes) throws SAXException {
		tag = Tags.fromString(qName);
		if (tag == null) {
			return;
		}

		switch (tag) {
		case MESSAGE:
			String tmp = attributes.getValue("id").trim();
			int bid = Integer.parseInt(tmp);
			message = new Message(bid);
			tag = null;
			break;
		default:
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		tag = Tags.fromString(qName);
		if (tag == null) {
			return;
		}

		switch (tag) {
		case ADDEDBY:
			id = Integer.parseInt(valueTag);
			try {
				message.setUser(DaoFactory.getFactory().getUserDao().findByID(id));
			} catch (DaoException e) {
				throw new SAXException(e);
			}
			break;
		case ADDDATE:
			message.setDate(getDateFromString(valueTag));
			break;
		case TEXT:
			message.setText(valueTag);
			break;
		case MESSAGE:
			getEntities().put(message.getId(), message);
			message = null;
			break;
		default:
		}
		tag = null;
	}

	/*
	 * (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (tag == null || Tags.MESSAGE == tag) {
			return;
		}
		valueTag = new String(ch, start, length).trim();
	}

}
