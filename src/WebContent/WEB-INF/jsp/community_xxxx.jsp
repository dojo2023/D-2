<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Remark" %>

<!DOCTYPE html>
<html>
 <link rel="stylesheet" href="css/common.css">
 <link rel="stylesheet" href="css/community.css?20230620">
<head>

<meta charset="UTF-8">
<title>コミュニティ</title>
<link rel="icon" href="favicon.ico">
<!--画面上にスクロール-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.4/css/all.css">
	<div id="page_top"><a href="#"></a></div>
<!--スクロール終わり-->
<div class="header">
	<a href="/product_D2/top"><img src="image/logo.png" class="logo_contents" width="10%" height="10%"></a>
</div>
</head>
<body>
<%
String[] dispDate = null;
ArrayList<Remark> remarks = (ArrayList<Remark>)(request.getAttribute("chat_data"));
if (remarks.size() != 0) {
	dispDate = new String[remarks.size()];
	for (int i=0; i<dispDate.length; i++) {
		dispDate[i] = remarks.get(i).getRemarkDate().substring(0, 16);
	}
}
request.setAttribute("dispDate", dispDate);
%>
<div class="c">
<div class="ctitle"><h1>${community_data.communityName}</h1></div>
<c:forEach var="tag" items="${community_data.communityLanguage}">
#${tag}&nbsp;
</c:forEach>
<c:forEach var="tag" items="${community_data.communityPurpose}">
#${tag}&nbsp;
</c:forEach>
<c:if test="${not empty community_data.communityCareer}">
#${community_data.communityCareer}&nbsp;
</c:if>
<c:forEach var="tag" items="${community_data.communityCertification}">
#${tag}&nbsp;
</c:forEach>
<div id="overlay">
<button id="btn"class="btn">
<img src="image/member.png"></button><div class="E">
<c:forEach var="member" items="${member_data}">
${member}&nbsp;
</c:forEach>
</div></div>
<hr>
</div>
<div class="a">
<c:forEach var="e" items="${chat_data}" varStatus="st" >
<c:choose>
<c:when test="${user.userId==e.userId}">
<div class="ore">
${speaker_data[st.index]}&nbsp;&nbsp;
<div class="minifont">${dispDate[st.index]}</div>
<p class="message">${e.remarkText}</p><br><br>
</div>
</c:when>
<c:otherwise>
<div class="oreigai">
${speaker_data[st.index]}&nbsp;&nbsp;
<div class="minifont">${dispDate[st.index]}</div>
<p class="message">${e.remarkText}</p><br><br>
</div>
</c:otherwise>
</c:choose>
</c:forEach>

</div>
<div class="b">
 <form method="POST" action="/product_D2/community">
 <input type="hidden" name="community_id" value="${community_data.communityId}">
<input type="textarea" id="messagetext" name="remark_text" placeholder="メッセージを入力してください">
<input class="btn" id="messagesubmit"type="submit" name="SUBMIT" value="送　信" disabled>
<br><br>
</form>
</div>
</body>

<div class="footer_all">
<footer class="footer">
	<img class="footer_logo" src="image/logo.png"  width="10%" height="10%">
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


<style>.a{overflow-y: scroll;}</style>
<script src="js/jquery-3.6.4.min.js"></script>
<script src="js/community.js"></script>

</html>