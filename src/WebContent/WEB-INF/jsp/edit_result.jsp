<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 6/21 17:18 update by yahaba -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/result.css">
<title>更新完了通知|with IT</title>
</head>
<body>

<header>
    <div class="header">
        <a href="/product_D2/top"><img src="image/logo.png" class="logo_contents" width="10%" height="10%"></a>
    </div>
</header>

<div class="result_main">
        <h4>更新完了しました！</h4>
        <img src="image/result.png" class="result_img">
    <!-- 更新した記事のページに飛ぶために記事idを取得して記事ページのサーブレットに飛ばす -->
    <div class="result_q">
        <p>更新した記事を読みますか？</p>
        <div class="btn_wrap">
            <form method="POST" action="/product_D2/article">
            <input type="hidden" name="article_id" value="${article_data.articleId}">
            <input type="submit" name="GoArticle" value="はい" class="btn">
            </form>
            <input type="button" name="GoTop" value="いいえ" onclick="location.href='/product_D2/top'" class="btn no">
        </div>
    </div>
</div>

 <div class="footer_all">
        <footer class="footer">
            <img class="footer_logo" src="image/logo2.png"  width="15%" height="15%">
            <div class="footer_contents">
                コンテンツ
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
</body>
</html>