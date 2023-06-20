<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <link rel="stylesheet" href="css/common.css">
        <link rel="stylesheet" href="css/result.css">
		<title>投稿確認通知</title>
	</head>
<body>
	<header>
        <div class="header">
            <a href="/product_D2/TopServlet"><img src="image/logo.png" class="logo_contents" width="10%" height="10%"></a>
        </div>
    </header>
<hr>
<!-- 通知ページの画像 -->
<img src="" class="" >

<!-- 作成された記事のページに飛ぶために記事idを取得して記事ページのサーブレットに飛ばす -->
<p>投稿した記事を見ますか？</p>
<form method="POST" action="/product_D2/ArticleServlet.java">
<input type="hidden" name="article_id" value="${article_data.id}">
<input type="submit" name="GoArticle" value="はい">
</form>

<input type="button" name="GoTop" value="いいえ" onclick="location.href='/product_D2/TopServlet.java'">

<hr>

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