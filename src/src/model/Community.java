package model;

import java.io.Serializable;

public class Community implements Serializable{

	private int communityId;
	private String communityDate;
	private String communityName;
	private String[] communityLanguage;
	private String[] communityPurpose;
	private String communityCareer;
	private String[] communityCertification;
	private String communitySummary;

	public Community(int communityId,String communityDate,String communityName,
			String[] communityLanguage, String[] communityPurpose,
			String communityCareer,String[] communityCertification,String communitySummary){

	this.communityId=communityId;
	this.communityDate=communityDate;
	this.communityName=communityName;
	this.communityLanguage=communityLanguage;
	this.communityPurpose=communityPurpose;
	this.communityCareer=communityCareer;
	this.communityCertification=communityCertification;
	this.communitySummary=communitySummary;
	}

	public Community() {
		this.communityId=0;
		this.communityDate="";
		this.communityName="";
		this.communityLanguage=null;
		this.communityPurpose=null;
		this.communityCareer="";
		this.communityCertification=null;
		this.communitySummary="";
	}

	public int getCommunityId() {
		return communityId;
	}

	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}

	public String getCommunityDate() {
		return communityDate;
	}

	public void setCommunityDate(String communityDate) {
		this.communityDate = communityDate;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public String[] getCommunityLanguage() {
		return communityLanguage;
	}

	public void setCommunityLanguage(String[] communityLanguage) {
		this.communityLanguage = communityLanguage;
	}

	public String[] getCommunityPurpose() {
		return communityPurpose;
	}

	public void setCommunityPurpose(String[] communityPurpose) {
		this.communityPurpose = communityPurpose;
	}

	public String getCommunityCareer() {
		return communityCareer;
	}

	public void setCommunityCareer(String communityCareer) {
		this.communityCareer = communityCareer;
	}

	public String[] getCommunityCertification() {
		return communityCertification;
	}

	public void setCommunityCertification(String[] communityCertification) {
		this.communityCertification = communityCertification;
	}

	public String getCommunitySummary() {
		return communitySummary;
	}

	public void setCommunitySummary(String communitySummary) {
		this.communitySummary = communitySummary;
	}



}
