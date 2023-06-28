<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<meta charset="UTF-8">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/search.css">
<title>検索結果</title>
<header>
<!--画面上にスクロール-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.4/css/all.css">
	<div id="page_top"><a href="#"></a></div>
<!--スクロール終わり-->
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
</head>
<body>
<div class="search_main">
<h2 class="searchresult">検索結果</h2>
<hr>
 <div class="search_contents">
<c:if test="${empty communityResults}">
<p>一致するデータなし</p>
</c:if>

<c:forEach var="community" items="${communityResults}" >
	<br>
	<div class="cp_card01">

<div class="description">
<form action="/product_D2/community" method="GET">
    ${community.communityName}<hr><br>
    <div class="worddisplay">
		<c:forEach var="lang" items="${community.communityLanguage}">
            <c:out value="# ${lang } " />
        </c:forEach>
        <c:forEach var="purp" items="${purpose}">
            <c:out value="# ${purp } " />
        </c:forEach>
        <c:forEach var="cert" items="${certification}">
           	<c:out value="# ${cert } " />
        </c:forEach>

	#${community.communityCareer}<br><br></div>
    <div id="limitedtext">${community.communitySummary}</div><br><br>
	<input type="hidden" name="communityId" value="${community.communityId }">
	<c:if test="${not empty user.userId}">
		<input class="join" type="submit" name="SUBMIT" value="参加">
	</c:if>
	</form></div></div>
</c:forEach>
</div>
</div></div>
</body>

<div class="footer_all">
<footer class="footer">
	<img class="footer_logo" src="image/logo2.png"  width="10%" height="10%">
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
<script>const applyTextLimit = () => {
    let maxLength = 100; //上限文字数
    let limitedText = document.getElementById('limitedtext');
    let originalText = limitedText.innerText;
    if (originalText.length > maxLength) {
      limitedText.innerText = originalText.substr(0, maxLength) + '...';
    }
  }
  applyTextLimit();</script>
</html>