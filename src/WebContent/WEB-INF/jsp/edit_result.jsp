<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <a href="/product_D2/TopServlet"><img src="image/logo.png" class="logo_contents" width="10%" height="10%"></a>
    </div>
</header>

<div class="result_main">
        <h4>更新完了しました！</h4>
        <img src="image/result.png" class="result_img">
    <!-- 更新した記事のページに飛ぶために記事idを取得して記事ページのサーブレットに飛ばす -->
    <div class="result_q">
        <p>更新した記事を読みますか？</p>
        <div class="btn_wrap">
            <form method="POST" action="/product_D2/ArticleServlet.java">
            <input type="hidden" name="article_id" value="${article_data.articleId}">
            <input type="submit" name="GoArticle" value="はい" class="btn">
            </form>
            <input type="button" name="GoTop" value="いいえ" onclick="location.href='/product_D2/TopServlet.java'" class="btn no">
        </div>
    </div>
</div>

 <div class="footer_all">
        <footer class="footer">
            <img class="footer_logo" src="image/logo2.png"  width="15%" height="15%">
            <div class="footer_contents">
                コンテンツ
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