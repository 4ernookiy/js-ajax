package org.training.d4.bean;

/**
 * The Class User.
 */
public class User extends Bean {
	/** The first name. */
	private String firstName;
	/** The last name. */
	private String lastName;
	/** The email. */
	private String email;
	/** The role. */
	private Role role;
	/** The password. */
	private String password;
	/** The url foto. */
	private String urlFoto;

	/**
	 * Instantiates a new user.
	 */
	public User() {
		super();
	}

	/**
	 * Instantiates a new user.
	 * @param userId
	 *            the id
	 */
	public User(int userId) {
		super(userId);
	}

	/**
	 * Gets the first name.
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the role.
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 * @param role
	 *            the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * Gets the password.
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the email.
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the url foto.
	 * @return the url foto
	 */
	public String getUrlFoto() {
		return urlFoto;
	}

	/**
	 * Sets the url foto.
	 * @param urlFoto
	 *            the new url foto
	 */
	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\nUser [id=" + getId() + ", " + firstName + " " + lastName + ", email: "
				+ email + ", " + role + "]";
	}

}
