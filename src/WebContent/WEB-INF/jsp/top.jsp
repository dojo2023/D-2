<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/top.css">
<title>トップページ｜with IT</title>
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
		<form action="サイトURL" method="get">
			<input type="search" name="search" placeholder="キーワードを入力">
				<input class="article_search" type="submit" name="search" value="記事検索">
				<input class="community_search" type="submit" name="search" value="コミュニティ検索">
		</form></div>
</div>
</header>

<div class="top_main">
	<div class="contents_left">
		<h2>おすすめ記事</h2>
		<!-- ここにおすすめ記事を表示 -->
	</div>
	<div class="contents_right">
		<div class="contents_user">
			<h3>ようこそ${user.userName}さん！</h3>
			<a href="/product_D2/LoginServlet"><p>ログイン</p></a> <a href="/product_D2/SignUpServlet"><p>新規登録</p></a>
		</div>
		<div class="contents_myarticle">
			<h3>自分が投稿した記事</h3>
			<!-- この行に自分の記事を挿入 -->
			<a href="/product_D2/EditServlet"><p class="btn">編集</p></a>
			<a href="/product_D2/ArticleServlet"><p class="btn">閲覧</p></a>
			<a href="/product_D2/PostServlet"><p class="btn_post">→記事を新規投稿する</p></a>
		</div>
		<div class="contents_community">
			<h3>コミュニティ新規作成</h3>
			<a href="/product_D2/CommunityCreateServlet"><p class="btn">さっそく話しに行く！</p></a>
		</div>
	</div>
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

</body>
</html>