package model;

import java.io.Serializable;

public class User implements Serializable {
	private String userId;
	private String password;
	private String userName;
	private String language;
	private String purpose;
	private String career;
	private String certification;

	public User() {
		this.userId = "";
		this.password = "";
		this.userName = "";
		this.language = "";
		this.purpose = "";
		this.career = "";
		this.certification = "";
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLanguage() {
		return language;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getCareer() {
		return career;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public String getCertification() {
		return certification;
	}
}
