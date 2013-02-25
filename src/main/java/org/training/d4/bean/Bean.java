package org.training.d4.bean;

/**
 * The Class Bean.
 */
public abstract class Bean {

	/** The id. */
	private int id;

	/**
	 * Instantiates a new bean.
	 */
	public Bean() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new bean.
	 *
	 * @param id the id
	 */
	protected Bean(int id) {
		super();
		this.id = id;
	}

	/**
	 * Gets the id.
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

}
