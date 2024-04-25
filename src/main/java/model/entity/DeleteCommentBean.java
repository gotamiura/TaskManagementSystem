package model.entity;

import java.sql.Timestamp;

public class DeleteCommentBean {
	
	private int commentId;
	private int taskId;
	private String taskName;
	private String userId;
	private String userName;
	private String comment;
	private Timestamp updateDatetime;
	/**
	 * @return commentId
	 */
	public int getCommentId() {
		return commentId;
	}
	/**
	 * @param commentId セットする commentId
	 */
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	/**
	 * @return taskId
	 */
	public int getTaskId() {
		return taskId;
	}
	/**
	 * @param taskId セットする taskId
	 */
	public void setTaskId(int taskId) {
		this.taskId = taskId;
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
	 * @return comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment セットする comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @return updateDatetime
	 */
	public Timestamp getUpdateDatetime() {
		return updateDatetime;
	}
	/**
	 * @param updateDatetime セットする updateDatetime
	 */
	public void setUpdateDatetime(Timestamp updateDatetime) {
		this.updateDatetime = updateDatetime;
	}
	
	
}
