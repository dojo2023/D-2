package model;

import java.io.Serializable;

public class Community implements Serializable{

	private int communityId;
	private String communityDate;
	private String communityName;
	private String communityTag;
	private String communitySummary;

	public Community(int communityId,String communityDate,String communityName,String communityTag,String communitySummary){

	this.communityId=communityId;
	this.communityDate=communityDate;
	this.communityName=communityName;
	this.communityTag=communityTag;
	this.communitySummary=communitySummary;
	}

	public Community() {
		this.communityId=0;
		this.communityDate="";
		this.communityName="";
		this.communityTag="";
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

	public String getCommunityTag() {
		return communityTag;
	}

	public void setCommunityTag(String communityTag) {
		this.communityTag = communityTag;
	}

	public String getCommunitySummary() {
		return communitySummary;
	}

	public void setCommunitySummary(String communitySummary) {
		this.communitySummary = communitySummary;
	}



}
