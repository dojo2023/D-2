<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/search.css">
<title>記事検索結果一覧｜with IT</title>
</head>
<body>

<header>
<div class="header">
	<a href="/product_D2/TopServlet"><img src="image/logo.png" class="logo_contents" width="10%" height="10%"></a>
</div>
<div class="header_bottom">
	<a href="/product_D2/ArticleServlet"><h1 class="tab_article">記事</h1></a>
	<a href="/product_D2/CommunityServlet"><h1 class="tab_community">コミュニティ</h1></a>
	<div class="search">
		<form action="/product_D2/ArticleServlet" method="get">
			<input type="search" name="search" placeholder="キーワードを入力">
				<input class="article_search" type="submit" name="article_search" value="記事検索">
				<input class="community_search" type="submit" name="community_search" value="コミュニティ検索">
		</form></div>
</div>
</header>

<div class="main">
	<h2>記事検索結果</h2>
	<div class="article">
	<div class="search_contents">
<c:if test="${empty articleResults}">
<p>一致するデータなし</p>
</c:if>

	<c:forEach var="comment" items="${articleResults}">
		<a href="javascript:form.submit();">${article.articleTitle}</a><br>
		<c:set var="sendLang" value="" />
		<c:forEach var="lang" items="${community.communityLanguage}">

            <c:set var="sendLang" value="${sendLang},${lang} "/>
            <c:out value="${lang } " />
            </c:forEach>

    <c:set var="sendPurp" value="" />
            <c:forEach var="purp" items="${purpose}">

            <c:set var="sendPurp" value="${sendPurp},${purp} "/>
            <c:out value="${purp } " />
            </c:forEach>

	<c:set var="sendCert" value="" />
            <c:forEach var="cert" items="${certification}">

            <c:set var="sendCert" value="${sendCert},${cert} "/>
            <c:out value="${cert } " />
            </c:forEach>
		${article.articleFavs}
		<form action="/product_D2/ArticleServlet" name="form" method="get">
		<input type="hidden" name="articleId" value="${article.articleId}">
		</form>
	</c:forEach>
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
</html>