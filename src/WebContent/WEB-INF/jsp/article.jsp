<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Article" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/article.css">
<title>タイトル｜with IT</title>
<link rel="icon" href="image/favicon.ico">
</head>
<body>
<%
String dispDate = ((Article)(request.getAttribute("article"))).getArticleCreate().substring(0, 16);
request.setAttribute("dispDate", dispDate);
%>
<!--画面上にスクロール-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.4/css/all.css">
	<div id="page_top"><a href="#"></a></div>
<!--スクロール終わり-->
<header>
<div class="header">
	<a href="/product_D2/top"><img src="image/logo.png" class="logo_contents" width="10%" height="10%"></a>
</div>
</header>

<div class="main">
	<div class="article_details">
		<h4 class="minifont">作成日：${dispDate}</h4>
		<h4 class="minifont">作成者：${writerName}</h4>

		<h2>「${article.articleTitle}」</h2>

		<h4 class="minifont">
			<c:forEach var="tag" items="${article.articleLanguage}">
			#${tag}&nbsp;
			</c:forEach>
			<c:forEach var="tag" items="${article.articlePurpose}">
			#${tag}&nbsp;
			</c:forEach>
			<c:if test="${not empty article.articleCareer}">
			#${article.articleCareer}&nbsp;
			</c:if>
			<c:forEach var="tag" items="${article.articleCertification}">
			#${tag}&nbsp;
			</c:forEach>
		</h4><hr>
		<div class="box1">${article.articleText}</div>
		<img src="${article.articleImg1}" style="max-width:200px;">
		<img src="${article.articleImg2}" style="max-width:200px;">
		<img src="${article.articleImg3}" style="max-width:200px;">
	</div>
	<p></p>


	<!-- 変更前
	 <form action="/product_D2/ArticleServlet" method="post" id="fav_form">
		<input type="submit" value="${article.articleId}" name="favs" id="fav"> -->

		<form id="fav_form">
		<input type=hidden id="aId" value="${article.articleId}">
		<input type="button"  id="btnfav" value="♡">


		</form>
		<div class="good">${article.articleFavs}</div>


	<div class="box3">
	<h4>コメント</h4><hr>
	<c:forEach var="com" items="${comment}" varStatus="st">
		${commenter[st.index]}
		<div class="minifont">${com.commentDate}</div><br>
		<div class="pre">${com.commentText}</div><br><hr>
	</c:forEach>
	<form action="/product_D2/article" method="post">
		<textarea id="comment" name="comment" rows="4" cols="50"></textarea>
		<input type="hidden" name="articleId" value="${article.articleId}">
		<input class="btn" type="submit" value="コメント" name="form" id="comment">
	</form>
</div></div>

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
	<p>ヘルプはこちらから</p>
	<p>&copy;2023 Sakuraiya. All rights reserved.</p>
</div>
</div>

<script src="/product_D2/js/article.js"></script>

</body>
</html>