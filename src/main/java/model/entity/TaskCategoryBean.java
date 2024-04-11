package model.entity;

import java.util.Date;

/**
 * タスク一覧情報をサーブレットに送るためのBeanです。
 * @author gotamiura
 */
public class TaskCategoryBean {
	private String taskName;
	private String categoryName;
	private int categoryCode;
	private Date limitDate;
	private String userName;
	private String userId;
	private String statusName;
	private int statusCode;
	private String memo;
	/**
	 * @return taskName
	 */
	public String getTaskName() {
		return taskName;
	}
	/**
	 * @param taskName セットする taskName
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	/**
	 * @return categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName セットする categoryName
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * @return categoryCode
	 */
	public int getCategoryCode() {
		return categoryCode;
	}
	/**
	 * @param categoryCode セットする categoryCode
	 */
	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}
	/**
	 * @return limitDate
	 */
	public Date getLimitDate() {
		return limitDate;
	}
	/**
	 * @param limitDate セットする limitDate
	 */
	public void setLimitDate(Date limitDate) {
		this.limitDate = limitDate;
	}
	/**
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName セットする userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId セットする userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return statusName
	 */
	public String getStatusName() {
		return statusName;
	}
	/**
	 * @param statusName セットする statusName
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	/**
	 * @return statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode セットする statusCode
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
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
	

}
