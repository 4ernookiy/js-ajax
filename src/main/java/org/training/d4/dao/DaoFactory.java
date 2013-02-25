package org.training.d4.dao;

import org.training.d4.dao.xml.XmlDaoFactory;

/**
 * A factory for creating DAO objects.
 */
public abstract class DaoFactory {

	/** The factory. */
	private static DaoFactory factory = null;
	/** The user dao. */
	private IUserDao userDao;
	/** The message dao. */
	private IMessageDao messageDao;

	/**
	 * Instantiates a new dAO factory.
	 * @param userDao the user dao
	 * @param messageDao the message dao
	 */
	protected DaoFactory(IUserDao userDao, IMessageDao messageDao) {
		super();
		this.userDao = userDao;
		this.messageDao = messageDao;
	}

	/**
	 * Gets the user dao.
	 * @return the user dao
	 */
	public IUserDao getUserDao() {
		return userDao;
	}

	/**
	 * Gets the i message dao.
	 * @return the i message dao
	 */
	public IMessageDao getIMessageDao() {
		return messageDao;
	}

	/**
	 * Gets the factory.
	 * @return the factory
	 * @throws DaoException the dao exception
	 */
	public static DaoFactory getFactory() throws DaoException {
		if (factory == null) {
			factory = new XmlDaoFactory();
			// factory = Class.forName("org.training.d4.dao.xml.XmlDaoFactory");
		}
		return factory;
	}
}
