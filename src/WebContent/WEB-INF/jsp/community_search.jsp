<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<meta charset="UTF-8">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/search.css">
<title>検索結果</title>
<header>
<div class="header">
	<a href="/product_D2/top"><img src="image/logo.png" class="logo_contents" width="10%" height="10%"></a>
</div>
<div class="header_bottom">
	<div class="search">
		<form action="/product_D2/top" method="post">
			<input type="search" name="search" placeholder="キーワードを入力" class="search_input">
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
<div class="cp_card01">
    <div class="photo"><div class="photo1"></div></div>
<div class="description">
<c:forEach var="community" items="${communityResults}" >

    <h2>${community.communityName}</h2>
    <div class="worddisplay"><c:set var="sendLang" value="" />
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

	${community.communityCareer}<br><br></div>
    <div id="limitedtext">${community.communitySummary}</div><br><br>
	<form action="/product_D2/community" method="GET">
	<input type="hidden" name="communityId" value="${community.communityId }">
	<input class="join" type="submit" name="SUBMIT" value="参加">
	</form><hr>
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
			<li>投稿</li>
			<li>コミュニティ</li>
			<li>ログイン</li>
			<li>ログアウト</li>
			<li>新規作成</li>
			<li>トップページ</li>
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