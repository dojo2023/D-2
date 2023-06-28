<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/search.css?20230628">
<title>記事検索結果一覧｜with IT</title>
<link rel="icon" href="image/favicon.ico">
</head>
<body>

<header>

<div class="header">
	<a href="/product_D2/top"><img src="image/logo.png" class="logo_contents" width="10%" height="10%"></a>
</div>
<div class="header_bottom">
	<div class="search">
		<form action="/product_D2/search" method="get">
			<input type="search" name="query" placeholder="キーワードを入力" class="search_input">
				<input class="article_search" type="submit" name="search" value="記事検索">
				<input class="community_search" type="submit" name="search" value="コミュニティ検索">
		</form></div>
</div>
</header>

<div class="search_main">
	<h2>記事検索結果</h2>
	<div class="article">
	<div class="search_contents">
<c:if test="${empty articleResults}">
<p>一致するデータなし</p>
</c:if>

	<c:forEach var="article" items="${articleResults}" varStatus="st">
		<br>
		<div class="cp_card01">

	<div class="description"><form action="/product_D2/article" name="form${st.index}" method="get">
		<a href="javascript:form${st.index}.submit();">${article.articleTitle}</a><br><hr>
		<div class="worddisplay">
			<c:forEach var="lang" items="${atricle.communityLanguage}">
            	<c:out value="# ${lang} " />
            </c:forEach>
            <c:forEach var="purp" items="${article.articlePurpose}">
            	<c:out value="# ${purp} " />
            </c:forEach>
            <c:forEach var="cert" items="${article.articleCertification}">
            	<c:out value="# ${cert} " />
            </c:forEach><br>
			いいね ${article.articleFavs}<br><br></div>
		<input type="hidden" name="article_id" value="${article.articleId}">
		</form></div></div>
	</c:forEach>
	</div></div>
	</div>
	 <!--
	<div class="pagination">
		<div class="nav-links">
			  <a class="prev page-numbers" href="###">«</a>
			  <a class="page-numbers" href="###">1</a>
			  <span class="page-numbers current">2</span>
			  <a class="page-numbers" href="###">3</a>
			  <span class="page-numbers dots">…</span>
			  <a class="page-numbers" href="###">???</a>
			  <a class="next page-numbers" href="###">»</a>
</div>
	</div>-->
</div>
</div>
</body>
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
</html>