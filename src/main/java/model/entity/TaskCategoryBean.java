package model.entity;

import java.sql.Date;
import java.util.Objects;

/**
 * タスク一覧情報をサーブレットに送るためのBeanです。
 * @author gotamiura
 */
public class TaskCategoryBean {
	private int taskId;
	private String taskName;
	private String categoryName;
	private int categoryId;
	private Date limitDate;
	private String userName;
	private String userId;
	private String statusName;
	private String statusCode;
	private String memo;
	
	

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
	 * @param taskId セットする taskId
	 */
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	/**
	 * @return taskId
	 */
	public int getTaskId() {
		return taskId;
	}
	
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
	 * @return categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId セットする categoryId
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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
	public String getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode セットする statusCode
	 */
	public void setStatusCode(String statusCode) {
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
	@Override
	public int hashCode() {
		return Objects.hash(categoryId, categoryName, limitDate, memo, statusCode, statusName, taskId, taskName, userId,
				userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskCategoryBean other = (TaskCategoryBean) obj;
		return categoryId == other.categoryId && Objects.equals(categoryName, other.categoryName)
				&& Objects.equals(limitDate, other.limitDate) && Objects.equals(memo, other.memo)
				&& Objects.equals(statusCode, other.statusCode) && Objects.equals(statusName, other.statusName)
				&& taskId == other.taskId && Objects.equals(taskName, other.taskName)
				&& Objects.equals(userId, other.userId) && Objects.equals(userName, other.userName);
	}
	
	
}
