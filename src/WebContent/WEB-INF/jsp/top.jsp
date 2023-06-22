<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<div class="search">
		<form action="/product_D2/TopServlet" method="get">
			<input type="search" name="search" placeholder="キーワードを入力" class="search_input">
				<input class="article_search" type="submit" name="search" value="記事検索">
				<input class="community_search" type="submit" name="search" value="コミュニティ検索">
		</form></div>
</div>
</header>

<div class="top_main">

	<div class="contents_left">
		<div class="tab_container">
			<input id="tab1" type="radio" name="tab_item" checked>
			<label class="tab_item" for="tab1">おすすめ記事</label>
			<input id="tab2" type="radio" name="tab_item">
			<label class="tab_item" for="tab2">おすすめコミュニティ</label>
			<div class="tab_content" id="tab1_content">
			  <div class="tab_content_description">
				<div class="c-txtsp">
					<hr>
					<c:forEach var="recommendArticle" items="${recArticle}">
						<h4>「${article.articleTitle}」</h4><br>
						<p>作成者：${article.userId}<br>作成日時：${article.articleCreate}</p>
						<hr>
					</c:forEach>
			  	</div>
				</div>
				</div>
			<div class="tab_content" id="tab2_content">
			  <div class="tab_content_description">
				<div class="c-txtsp">
					<hr>
					<c:forEach var="recommendCommunity" items="${recCommunity}">
						<h4>「${community.communityName}」</h4><br>
						<p>最終発言日時：${community.communityDate}<br>
						コミュニティの説明：${community.communitySummary}</p>
					<hr>
					</c:forEach>
					</div>
			  </div>
			</div>
		  </div>
		</div>
		
		<div class="contents_right">
			<div class="contents_user">
				<h3 class="right_title">ようこそ${user.userName}さん！</h3>
				<p class="txt">「今知りたい」を即解決！with ITへようこそ！</p>
				<img src="image/character.png" class="chara">
				<div class="btn_wrap">
				<a href="/product_D2/LoginServlet"><p class="btn">ログイン</p></a> <a href="/product_D2/SignUpServlet"><p class="btn">新規登録</p></a>
				</div>
			</div>
			
			<div class="contents_myarticle">
				<h3 class="right_title">自分が投稿した記事</h3>
				<p class="txt">あなたがこれまでに投稿した記事の一覧です。<br>みんなの疑問を即解決！</p>
				
				<c:if test="${empty articleResults}">
				<p>記事は投稿されていません</p>
				</c:if>
				
				<c:forEach var="article" items="${articleResults}">
					<p>${article.articleTitle}</p>
					<div class="btn_wrap">
						<form action="/product_D2/EditServlet" method="get">
							<input type="hidden" name="article_id" value="${article.articleId}">
							<input type="submit" value="編集" class="btn">
						</form>
						<form action="/product_D2/ArticleServlet" method="get">
							<input type="hidden" name="article_id" value="${article.articleId}">
							<input type="submit" value="閲覧" class="btn">
						</form>
					</div>
				</c:forEach>
				
				<a href="/product_D2/PostServlet"><p class="btn_post">→記事を新規投稿する</p></a>
			</div>
			<div class="contents_community">
				<h3 class="right_title">コミュニティ新規作成</h3>
				<p class="txt">コミュニティ機能で疑問を即解決！</p>
				<div class="btn_wrap">
				<a href="/product_D2/CommunityCreateServlet"><p class="btn_b">さっそく話しに行く！</p></a>
				</div>
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