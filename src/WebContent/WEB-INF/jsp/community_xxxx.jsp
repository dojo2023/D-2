<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
 <link rel="stylesheet" href="css/common.css?20230615">
 <link rel="stylesheet" href="css/community.css?20230620">
<head>

<meta charset="UTF-8">
<title>コミュニティ</title>
<div class="header">
	<a href="/product_D2/TopServlet"><img src="image/logo2.png" class="logo_contents" width="10%" height="10%"></a>
</div>
</head>
<body>

<div class="c">
<div class="ctitle"><h1>${community_data.communityName}</h1></div>
<c:forEach var="tag" items="${community_data.communityLanguage}">
#${tag}&nbsp;
</c:forEach>
<c:forEach var="tag" items="${community_data.communityPurpose}">
#${tag}&nbsp;
</c:forEach>
#${community_data.communityCareer}&nbsp;
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
${speaker_data[st.index]}
${e.remarkDate}
<p class="message"><input type="text" value="${e.remarkText}" disabled></p><br><br>

</c:forEach>

</div>
<div class="b">
 <form method="POST" action="/product_D2mmm/CommunityServlet">
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


<style>.a{overflow-y: scroll;}</style>
<script src="js/jquery-3.6.4.min.js"></script>
<script src="js/community.js"></script>

</html>