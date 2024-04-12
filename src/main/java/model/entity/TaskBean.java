package model.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class TaskBean {
	private int task_id;
	private String task_name;
	private int category_id;
	private Date limit_date;
	private String user_id;
	private Character status_code;
	private String memo;
	private Timestamp create_datetime;
	private Timestamp update_datetime;
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
	public Character getStatus_code() {
		return status_code;
	}
	/**
	 * @param status_code セットする status_code
	 */
	public void setStatus_code(Character status_code) {
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
	 * @return create_datetime
	 */
	public Timestamp getCreate_datetime() {
		return create_datetime;
	}
	/**
	 * @param create_datetime セットする create_datetime
	 */
	public void setCreate_datetime(Timestamp create_datetime) {
		this.create_datetime = create_datetime;
	}
	/**
	 * @return update_datetime
	 */
	public Timestamp getUpdate_datetime() {
		return update_datetime;
	}
	/**
	 * @param update_datetime セットする update_datetime
	 */
	public void setUpdate_datetime(Timestamp update_datetime) {
		this.update_datetime = update_datetime;
	}	
}
