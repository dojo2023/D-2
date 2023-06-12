package model;

import java.io.Serializable;

public class Article  implements Serializable{

	private int articleId;
	private String articleTitle;
	private String userId;
	private String articleCreate;
	private String articleUpdate;
	private String articleTag;
	private int articleFavs;
	private String articleLink;

	public Article(int articleId,String articleTitle,String userId,String articleCreate,String articleUpdate,String articleTag,int articleFavs,String articleLink) {
		this.articleId=articleId;
		this.articleTitle=articleTitle;
		this.userId=userId;
		this.articleCreate=articleCreate;
		this.articleUpdate=articleUpdate;
		this.articleTag=articleTag;
		this.articleFavs=articleFavs;
		this.articleLink=articleLink;
	}

	public Article() {
		this.articleId=0;
		this.articleTitle="";
		this.userId="";
		this.articleCreate="";
		this.articleUpdate="";
		this.articleTag="";
		this.articleFavs=0;
		this.articleLink="";
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getArticleCreate() {
		return articleCreate;
	}

	public void setArticleCreate(String articleCreate) {
		this.articleCreate = articleCreate;
	}

	public String getArticleUpdate() {
		return articleUpdate;
	}

	public void setArticleUpdate(String articleUpdate) {
		this.articleUpdate = articleUpdate;
	}

	public String getArticleTag() {
		return articleTag;
	}

	public void setArticleTag(String articleTag) {
		this.articleTag = articleTag;
	}

	public int getArticleFavs() {
		return articleFavs;
	}

	public void setArticleFavs(int articleFavs) {
		this.articleFavs = articleFavs;
	}

	public String getArticleLink() {
		return articleLink;
	}

	public void setArticleLink(String articleLink) {
		this.articleLink = articleLink;
	}


}
