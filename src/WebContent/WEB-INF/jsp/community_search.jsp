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
	<a href="/product_D2/TopServlet"><img src="image/logo.png" class="logo_contents" width="10%" height="10%"></a>
</div>
</header>
</head>
<body>
<div class="search_main">
<h1>検索結果</h1>
<hr>
 <div class="search_contents">
<c:if test="${empty communityResults}">
<p>一致するデータなし</p>
</c:if>

<c:forEach var="community" items="${communityResults}" >

    ${community.communityName}<br>
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

	${community.communityCareer}<br>
    ${community.communitySummary}<br>
	<form action="/product_D2/CommunityServlet" method="GET">
	<input type="hidden" name="communityId" value="${community.communityId }">
	<input type="submit" name="SUBMIT" value="参加">
	</form><hr>
</c:forEach>
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

</html>