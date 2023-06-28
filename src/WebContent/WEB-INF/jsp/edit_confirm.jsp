<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/confirm.css">
<title>記事編集確認|with IT</title>
<link rel="icon" href="image/favicon.ico">
</head>
<body>
<!--画面上にスクロール-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.4/css/all.css">
	<div id="page_top"><a href="#"></a></div>
<!--スクロール終わり-->
<header>
<div class="header">
	<a href="/product_D2/top"><img src="image/logo.png" class="logo_contents" width="10%" height="10%"></a>
</div>
</header>

<div class="confirm_main">
    <hr>
<h1>記事編集確認</h1>
    <div class="confirm_contents">
        <!-- プレビュー表示 -->
        <h4 class="article_title">「${article.articleTitle}」</h4><br>

        <p class="article_tag">
            ${article.articleUpdate}<br>

            <c:set var="sendLang" value="" />
            <c:forEach var="lang" items="${article.articleLanguage}">
            <c:set var="sendLang" value="${sendLang},${lang}" />
            #<c:out value="${lang} " />
            </c:forEach>
            <br>
            <c:set var="sendPurp" value="" />
            <c:forEach var="purp" items="${article.articlePurpose}">
            <c:set var="sendPurp" value="${sendPurp},${purp}" />
            #<c:out value="${purp }" />
            </c:forEach>
            <br>
            ${user.career}<br>

            <c:set var="sendCert" value="" />
            <c:forEach var="cert" items="${article.articleCertification}">
            <c:set var="sendCert" value="${sendCert},${cert}" />
            #<c:out value="${cert } " />
            </c:forEach>
            <br>
        </p>

        ${article.articleText}<br>
        <c:if test="${not empty article.articleImg1}" >
        <img src="${article.articleImg1}"></c:if><br>
        <c:if test="${not empty article.articleImg2}" >
        <img src="${article.articleImg2}"></c:if><br>
        <c:if test="${not empty article.articleImg3}" >
        <img src="${article.articleImg3}"></c:if><br>
    </div>

    <!-- edit_result.jspに送信 -->
    <div class="confirm_msg">
        <p>以上の内容で更新してよろしいですか？</p><br>
        <form method="post" action="/product_D2/edit_result">
        <input type="hidden" name="articleId" value="${article.articleId}">
        <input type="hidden" name="articleTitle" value="${article.articleTitle}">
        <input type="hidden" name="userId" value="${article.userId}">
        <input type="hidden" name="articleCreate" value="${article.articleCreate}">
        <input type="hidden" name="articleUpdate" value="${article.articleUpdate}">
        <input type="hidden" name="sendLang" value="${sendLang}">
        <input type="hidden" name="sendPurp" value="${sendPurp}">
        <input type="hidden" name="articleCareer" value="${article.articleCareer}">
        <input type="hidden" name="sendCert" value="${sendCert}">
        <input type="hidden" name="articleFavs" value="${article.articleFavs}">
        <input type="hidden" name="articleText" value="${article.articleText}">
        <input type="hidden" name="articleImg1" value="${article.articleImg1}">
        <input type="hidden" name="articleImg2" value="${article.articleImg2}">
        <input type="hidden" name="articleImg3" value="${article.articleImg3}">
        <input type="submit" value="更新" class="btn">
        </form>
        <button type="button" onclick="history.back()" class="btn no">編集画面に戻る</button>
    </div>
    <hr>
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