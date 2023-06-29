<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Article" %>
<%@ page import="model.Community" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/top.css">
<title>トップページ｜with IT</title>
<link rel="icon" href="image/favicon.ico">
</head>
<body>
<%
String[] dispDateArt = null;
String[] dispDateCom = null;
ArrayList<Article> recArt = (ArrayList<Article>)(session.getAttribute("recArticle"));
ArrayList<Community> recCom = (ArrayList<Community>)(session.getAttribute("recCommunity"));
if (recArt.size() != 0) {
	System.out.println("recArt size:" + recArt.size());
	for (Article a: recArt)
		System.out.println("Article Create:"+a.getArticleCreate());
	dispDateArt = new String[recArt.size()];
	for (int i=0; i<dispDateArt.length; i++) {
		dispDateArt[i] = recArt.get(i).getArticleCreate().substring(0, 16);
	}
}
if (recCom.size() != 0) {
	dispDateCom = new String[recCom.size()];
	for (int i=0; i<dispDateCom.length; i++) {
		dispDateCom[i] = recCom.get(i).getCommunityDate().substring(0, 16);
	}
}


request.setAttribute("dispDateArt", dispDateArt);
request.setAttribute("dispDateCom", dispDateCom);
%>
<!--画面上にスクロール-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.4/css/all.css">
	<div id="page_top"><a href="#"></a></div>
<!--スクロール終わり-->
<header>
<div class="header">
	<a href="/product_D2/top"><img src="image/logo.png" class="logo_contents" width="10%" height="10%"></a>
</div>
<div class="header_bottom">
	<div class="search">
		<form action="/product_D2/search" method="get">
			<input type="search" name="query" id="query_id" placeholder="キーワードを入力" class="search_input">
				<input class="article_search" type="submit" name="search" id="searchArt" value="記事検索" disabled>
				<input class="community_search" type="submit" name="search" id="searchCom" value="コミュニティ検索" disabled>
		</form></div>
</div>
</header>

<div class="top_main">

	<div class="contents_left">
		<div class="tab_container">
			<input id="tab1" type="radio" name="tab_item" checked>
			<label class="tab_item" for="tab1">おすすめ記事</label>
			<input id="tab2" type="radio" name="tab_item">
			<label class="tab_item" for="tab2">おすすめコミュニティ</label>
			<div class="tab_content" id="tab1_content">
			  <div class="tab_content_description">
				<div class="c-txtsp">
					<hr>
					<c:forEach var="recommendArticle" items="${recArticle}" varStatus="st">
						<form action="/product_D2/article" name="form${st.index}" method="get">
						<h4><a href="javascript:form${st.index}.item(0).submit()">「${recommendArticle.articleTitle}」</a></h4><br>
						<p>作成者：${recommendArticle.userId}<br>作成日時：${dispDateArt[st.index]}</p>
						<hr>
						<input type="hidden" name="article_id" value="${recommendArticle.articleId}">
						</form>
					</c:forEach>
			  	</div>
				</div>
				</div>
			<div class="tab_content" id="tab2_content">
			  <div class="tab_content_description">
				<div class="c-txtsp">
					<hr>
					<c:forEach var="recommendCommunity" items="${recCommunity}" varStatus="st">
						<form action="/product_D2/community" name="form${st.index}" method="get">
						<c:choose>
							<c:when test="${not empty user.userId}">
							<h4><a href="javascript:form${st.index}.submit();">「${recommendCommunity.communityName}」</a></h4><br>
							</c:when>
							<c:otherwise>
							<h4><a>「${recommendCommunity.communityName}」</a></h4><br>
							</c:otherwise>
						</c:choose>
						<p>コミュニティ作成日時：${dispDateCom[st.index]}<br>
						コミュニティの説明：${recommendCommunity.communitySummary}</p>
						<hr>
						<input type="hidden" name="community_id" value="${recommendCommunity.communityId}">
						</form>
					</c:forEach>
					</div>
			  </div>
			</div>
		  </div>
		</div>

		<div class="contents_right">
			<div class="contents_user">
				<h3 class="right_title">ようこそ${user.userName}さん！</h3>
				<p class="txt">「今知りたい」を即解決！with ITへようこそ！</p>
				<img src="image/character.png" class="chara">
				<div class="btn_wrap">
				<c:choose>
				<c:when test="${empty user.userId}">
					<a href="/product_D2/login"><p class="btn">ログイン</p></a> <a href="/product_D2/sign_up"><p class="btn">新規登録</p></a>
				</c:when>
				<c:otherwise>
					<a href="/product_D2/login"><p class="btn">ログアウト</p></a>
				</c:otherwise>
				</c:choose>
				</div>
			</div>

			<c:if test="${not empty user.userId}">
			<div class="contents_myarticle">
				<h3 class="right_title">自分が投稿した記事</h3>
				<p class="txt">あなたがこれまでに投稿した記事の一覧です。<br>みんなの疑問を即解決！</p>

				<c:if test="${empty wriArticle}">
				<p>記事は投稿されていません</p>
				</c:if>

				<c:forEach var="article" items="${wriArticle}">
					<p>${article.articleTitle}</p>
					<div class="btn_wrap_12">
						<form action="/product_D2/edit" method="get">
							<input type="hidden" name="article_id" value="${article.articleId}">
							<input type="submit" value="編集" class="btn1">
						</form>
						<form action="/product_D2/article" method="get">
							<input type="hidden" name="article_id" value="${article.articleId}">
							<input type="submit" value="閲覧" class="btn2">
						</form>
					</div>
				</c:forEach>

				<a href="/product_D2/post"><p class="btn_post">→記事を新規投稿する</p></a>
			</div>
			<div class="contents_community">
				<h3 class="right_title">コミュニティ新規作成</h3>
				<p class="txt">コミュニティ機能で疑問を即解決！</p>
				<div class="btn_wrap_b">
				<a href="/product_D2/community_create"><p class="btn_b">さっそく話しに行く！</p></a>
				</div>
			</div>
			</c:if>
		</div>
	</div>

<div class="footer_all">
<footer class="footer">
	<img class="footer_logo" src="image/logo2.png"  width="15%" height="15%">
	<div class="footer_contents">
		<b><p>コンテンツ</p></b>
		<ul>
			<c:choose>
			<c:when test="${not empty user.userId}">
			<li><a href="/product_D2/top">トップ</a></li>
			<li><a href="/product_D2/post">記事投稿</a></li>
			<li><a href="/product_D2/community_create">コミュニティ作成</a></li>
			<li>ログイン</li>
			<li><a href="/product_D2/login">ログアウト</a></li>
			<li>ユーザー登録</li>
			</c:when>
			<c:otherwise>
			<li><a href="/product_D2/top">トップ</a></li>
			<li>記事投稿</li>
			<li>コミュニティ作成</li>
			<li><a href="/product_D2/login">ログイン</a></li>
			<li>ログアウト</li>
			<li><a href="/product_D2/sign_up">ユーザー登録</a></li>
			</c:otherwise>
			</c:choose>
		</ul>
		</div>
</footer>
<div class="footer_bottom">
	<a href="/product_D2/help"><p>ヘルプはこちらから</p></a>
	<p>&copy;2023 Sakuraiya. All rights reserved.</p>
</div>
</div>
<script>
var query = document.getElementById('query_id');
const searchArticle = document.getElementById('searchArt');
const searchCommunity = document.getElementById('searchCom');
query.addEventListener('keyup', (e) => {
	if (1 <= e.target.value.trim().length) {
		searchArticle.disabled = false;
    	searchCommunity.disabled = false;
	}
	if (e.target.value.trim().length == 0) {
		searchArticle.disabled = true;
		searchCommunity.disabled = true;
	}
})

</script>
</body>
</html>