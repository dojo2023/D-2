<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>完了通知</title>
</head>
<body>
<div>更新完了しました！</div>
<!-- 更新した記事のページに飛ぶために記事idを取得して記事ページのサーブレットに飛ばす -->
<div>更新した記事を読みますか？</div>
<form method="POST" action="/product_D2/ArticleServlet.java">
<input type="hidden" name="article_id" value="${article_data.articleId}">
<input type="submit" name="GoArticle" value="はい">
</form>
<input type="button" name="GoTop" value="いいえ" onclick="location.href='/product_D2/TopServlet.java'">
</body>
</html>