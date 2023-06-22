<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/article.css">
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
		<h4 class="minifont">作成日：${article.articleCreate}</h4>
		<h4 class="minifont">作成者：${article.userName}</h4>

		<h2>「${article.articleTitle}」</h2>
		<h4 class="minifont">#${article.articleLanguage} #${article.articlePurpose} #${article.articleCareer} #${article.articleCertificaiton}</h4><hr>
		<div class="box1"><p>${article.articleText}</p></div>
		<div class="box2">${article.ariticleImg1}</div>
		<div class="box2">${article.ariticleImg2}</div>
		<div class="box2">${article.ariticleImg3}</div>
	</div>
	<p></p>
	<form action="/product_D2/ArticleServlet" method="post" id="fav_form">
		<input type="submit" value="1" name="favs" id="fav">
		<div class="good">${article.articleFavs}</div>
	</form>
	<div class="box3">
	<h4>コメント</h4><hr>
	${comment.userId}
	<div class="minifont">${comment.commentDate}</div><br>
	${comment.commentText}
	<form action="/product_D2/ArticleServlet" method="post">
		<textarea id="comment" name="comment" rows="4" cols="50"></textarea>
		<input class="btn" type="submit" value="送信" name="comment" id="comment">
	</form>
</div></div>

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