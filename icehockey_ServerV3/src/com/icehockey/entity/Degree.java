package com.icehockey.entity;

public class Degree {

	private int userId;
	private String userName;
	private int degreeeId;
	private String degreeName;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getDegreeeId() {
		return degreeeId;
	}
	public void setDegreeeId(int degreeeId) {
		this.degreeeId = degreeeId;
	}
	public String getDegreeName() {
		return degreeName;
	}
	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}
	public Degree(int userId, String userName, int degreeeId, String degreeName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.degreeeId = degreeeId;
		this.degreeName = degreeName;
	}
	@Override
	public String toString() {
		return "Degree [userId=" + userId + ", userName=" + userName
				+ ", degreeeId=" + degreeeId + ", degreeName=" + degreeName
				+ "]";
	}
	
}
