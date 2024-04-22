package model.entity;

import java.sql.Timestamp;

public class UserBean {
	private String userId;
	private String password;
	private String userName;
	private Timestamp updateDatetime;
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
