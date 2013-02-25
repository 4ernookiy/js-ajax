package org.training.d4.bean;

import java.util.Date;

/**
 * The Class Message.
 */
public class Message extends Bean {

	/** The user. */
	private User user;

	/** The date. */
	private Date date;

	/** The text. */
	private String text;

	/**
	 * Instantiates a new message.
	 */
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new message.
	 * @param id the id
	 */
	public Message(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the user.
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 * @param user the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Gets the date.
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 * @param date the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Gets the text.
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text.
	 * @param text the new text
	 */
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "\nMessage [user=" + user.getEmail() + ", date=" + date + ", text=" + text
				+ "]";
	}

}