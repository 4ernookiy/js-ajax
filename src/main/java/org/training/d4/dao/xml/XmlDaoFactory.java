package org.training.d4.dao.xml;

import org.training.d4.dao.DaoException;
import org.training.d4.dao.DaoFactory;

/**
 * A factory for creating XmlDao objects.
 */
public class XmlDaoFactory extends DaoFactory {

	/**
	 * Instantiates a new xml dao factory.
	 *
	 * @throws DaoException the dao exception
	 */
	public XmlDaoFactory() throws DaoException {
		super(new UserImplXml(), new MessageImplXml());
	}

}
