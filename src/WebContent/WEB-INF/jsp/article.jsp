<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タイトル｜with IT</title>
</head>
<body>

<header>
<div class="header">
	<a href="/product_D2/TopServlet"><img src="image/logo.png" class="logo_contents" width="10%" height="10%"></a>
</div>
</header>

<div class="main">
	<div class="article_details">
		<h2>「${article.articleTitle}」</h2>
		<h4>作成日：${article.articleCreate}</h4>
		<h4>作成者：${article.userName}</h4>
		<h4>#${article.articleLanguage} #${article.articlePurpose} #${article.articleCareer} #${article.articleCertificaiton}</h4>
		<p>${article.articleText}</p>
		${article.ariticleImg1}
		${article.ariticleImg2}
		${article.ariticleImg3}
	</div>
	<p></p>
	<form action="/product_D2/ArticleServlet" method="post" id="fav_form">
		<input type="submit" value="favs" name="favs" id="fav">
		${article.articleFavs}
	</form>
	<h4>コメント</h4>
	${comment.userId}
	${comment.commentDate}
	${comment.commentText}
	<form action="/product_D2/ArticleServlet" method="post">
		<textarea id="comment" name="comment" rows="4" cols="50"></textarea>
		<input type="hidden" name="articleId" value="${article.articleId}">
		<input type="submit" value="コメント" name="comment" id="comment">
	</form>
</div>

<div class="footer_all">
<footer class="footer">
	<img class="footer_logo" src="image/logo2.png"  width="15%" height="15%">
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

<script src="/product_D2/js/article.js"></script>

</body>
</html>