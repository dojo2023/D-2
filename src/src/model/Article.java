package model;

import java.io.Serializable;

public class Article  implements Serializable{

	private int articleId;
	private String articleTitle;
	private String userId;
	private String articleCreate;
	private String articleUpdate;
	private String[] articleLanguage;
	private String[] articlePurpose;
	private String articleCareer;
	private String[] articleCertification;
	private int articleFavs;
	private String articleText;
	private String articleImg;

	public Article(int articleId,String articleTitle,String userId,String articleCreate,String articleUpdate,
			String[] articleLanguage,String[] articlePurpose, String articleCareer,
			String[] articleCertification,int articleFavs,String articleText,String articleImg) {
		this.articleId=articleId;
		this.articleTitle=articleTitle;
		this.userId=userId;
		this.articleCreate=articleCreate;
		this.articleUpdate=articleUpdate;
		this.articleLanguage=articleLanguage;
		this.articlePurpose=articlePurpose;
		this.articleCareer=articleCareer;
		this.articleCertification=articleCertification;
		this.articleFavs=articleFavs;
		this.articleText=articleText;
		this.articleImg=articleImg;
	}

	public Article() {
		this.articleId=0;
		this.articleTitle="";
		this.userId="";
		this.articleCreate="";
		this.articleUpdate="";
		this.articleLanguage=null;
		this.articlePurpose=null;
		this.articleCareer="";
		this.articleCertification=null;
		this.articleFavs=0;
		this.articleText="";
		this.articleImg="";
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

	public String[] getArticleLanguage() {
		return articleLanguage;
	}

	public void setArticleLanguage(String[] articleLanguage) {
		this.articleLanguage = articleLanguage;
	}

	public String[] getArticlePurpose() {
		return articlePurpose;
	}

	public void setArticlePurpose(String[] articlePurpose) {
		this.articlePurpose = articlePurpose;
	}

	public String getArticleCareer() {
		return articleCareer;
	}

	public void setArticleCareer(String articleCareer) {
		this.articleCareer = articleCareer;
	}

	public String[] getArticleCertification() {
		return articleCertification;
	}

	public void setArticleCertification(String[] articleCertification) {
		this.articleCertification = articleCertification;
	}

	public int getArticleFavs() {
		return articleFavs;
	}

	public void setArticleFavs(int articleFavs) {
		this.articleFavs = articleFavs;
	}

	public String getArticleText() {
		return articleText;
	}

	public void setArticleText(String articleText) {
		this.articleText = articleText;
	}

	public String getArticleImg() {
		return articleImg;
	}

	public void setArticleImg(String articleImg) {
		this.articleImg = articleImg;
	}


}
