package model.entity;

import java.sql.Date;

public class TMSBean {
	private int task_id;
	private String task_name;
	private int category_id;
	private Date limit_date;
	private String user_id;
	private String status_code;
	private String memo;
	
	private String category_name;
	
	private String password;
	private String user_name;
	
	private String status_name;

	/**
	 * @return task_id
	 */
	public int getTask_id() {
		return task_id;
	}

	/**
	 * @param task_id セットする task_id
	 */
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	/**
	 * @return task_name
	 */
	public String getTask_name() {
		return task_name;
	}

	/**
	 * @param task_name セットする task_name
	 */
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	/**
	 * @return category_id
	 */
	public int getCategory_id() {
		return category_id;
	}

	/**
	 * @param category_id セットする category_id
	 */
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	/**
	 * @return limit_date
	 */
	public Date getLimit_date() {
		return limit_date;
	}

	/**
	 * @param limit_date セットする limit_date
	 */
	public void setLimit_date(Date limit_date) {
		this.limit_date = limit_date;
	}

	/**
	 * @return user_id
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id セットする user_id
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return status_code
	 */
	public String getStatus_code() {
		return status_code;
	}

	/**
	 * @param status_code セットする status_code
	 */
	public void setStatus_code(String status_code) {
		this.status_code = status_code;
	}

	/**
	 * @return memo
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * @param memo セットする memo
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * @return category_name
	 */
	public String getCategory_name() {
		return category_name;
	}

	/**
	 * @param category_name セットする category_name
	 */
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return user_name
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 * @param user_name セットする user_name
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * @return status_name
	 */
	public String getStatus_name() {
		return status_name;
	}

	/**
	 * @param status_name セットする status_name
	 */
	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}
}
