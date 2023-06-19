<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
 <link rel="stylesheet" href="css/common.css?20230615">
 <link rel="stylesheet" href="css/community.css?20230616">
<head>

<meta charset="UTF-8">
<title>コミュニティ</title>
<div class="header">
	<a href="/product_D2/TopServlet"><img src="image/logo.png" class="logo_contents" width="10%" height="10%"></a>
</div>
</head>
<body>

<div class="c">
<div class="ctitle"><h1>コミュニティ名</h1></div>

<button id="btn"class="btn">
<img src="image/member.png"></button><div class="E">参加者の一覧 </div>
<hr>
</div>
<div class="a">
<c:forEach var="e" items="${cardList}" >


    <input type="text" value="${e.remarkText}" disabled><br>




	<hr>
</c:forEach>
<!-- サンプルテキスト -->
<p class="message">こんにちは（例文）</p><br><br><p class="message">こんにちは</p><br><br><p class="message">こんにちは</p><br><br><p class="message">こんにちは</p><br><br><p class="message">こんにちは</p><br><br><p class="message">こんにちは</p>
</div>
<div class="b">
 <form method="POST" action="/product_D2/CommunityServlet">
<input type="textarea" id="messagetext" name="REMARKTEXT" placeholder="メッセージを入力してください">
<input class="btn" id="messagesubmit" type="submit" name="SUBMIT" value="送　信">
<br><br>
</form>
</div>
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


<style>.a{overflow-y: scroll;}</style>
<script src="js/jquery-3.6.4.min.js"></script>
<script src="js/community.js"></script>

</html>