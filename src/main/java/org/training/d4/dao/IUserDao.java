package org.training.d4.dao;

import org.training.d4.bean.User;

/**
 * The Interface IUserDao.
 */
public interface IUserDao extends GenericDAO<User, Integer> {

	/**
	 * Gets the user.
	 * @param email the email
	 * @return the user
	 * @throws DaoException the dao exception
	 */
	User getUser(String email) throws DaoException;
}
