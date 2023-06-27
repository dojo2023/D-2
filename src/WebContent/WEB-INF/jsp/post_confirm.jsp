<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <link rel="stylesheet" href="css/common.css">
        <link rel="stylesheet" href="css/confirm.css">
		<title>記事投稿確認画面</title>
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
<hr>
<div class="confirm_main">
	<h1>作成確認</h1>
	 <div class="confirm_contents">

	<h4>タイトル</h4>
		${article_data.articleTitle}<br>

	<h4>作成者</h4>>
		${article.userId}<br>

	<h4>タグ</h4>
		<c:set var="sendLang" value="" />
        <c:forEach var="e" items="${ariticle_data.articleLanguage}">
        ${e},
        <c:set var="sendLang" value="${sendLang},${e} "/>
        </c:forEach>

        <c:set var="sendPurp" value="" />
         <c:forEach var="e" items="${article_data.articlePurpose}">
         ${e},
         <c:set var="sendPurp" value="${sendPurp},${e} "/>
         </c:forEach>

         <c:set var="sendCert" value="" />
         <c:forEach var="e" items="${article_data.articleCertification}">
         ${e},
         <c:set var="sendCert" value="${sendCert},${e} "/>
         </c:forEach>

         ${article_data.career}<br>


	<h4>本文</h4>
		${article_data.text}<br>

<!-- 画像ファイル↓ -->
		<c:if test="${not empty articleImg1Path}" >
        <img src="${articleImg1Path}" style="max-width:200px;"></c:if><br>
        <c:if test="${not empty articleImg2Path}" >
        <img src="${articleImg2Path}" style="max-width:200px;"></c:if><br>
        <c:if test="${not empty articleImg3Path}" >
        <img src="${articleImg3Path}" style="max-width:200px;"></c:if><br>

	</div>
	<div class="confirm_msg">
		<p>以上の内容でよろしいですか？</p><br>
		<form method="POST" action="/product_D2/post_result">
		<input type="hidden" name="article_title" value="${ariticle_data.articleTitle}">
		<input type="hidden" name="article_user" value="${article_data.userId}">
        <input type="hidden" name="sendLang" value="${sendLang}" >
        <input type="hidden" name="sendPurp" value="${sendPurp}" >
        <input type="hidden" name="article_career" value="${article_data.articleCareer}">
        <input type="hidden" name="sendCert" value="${sendCert}" >
        <input type="hidden" name="article_favs" value=0>
        <input type="hidden" name="article_text" value="${article_data.articleText}">
        <input type="hidden" name="article_img1" value="${article_data.articleImg1}">
        <input type="hidden" name="article_img2" value="${article_data.articleImg2}">
        <input type="hidden" name="article_img3" value="${article_data.articleImg3}">
	    <input class="btn" type="submit" name="SUBMIT" value="投稿"><br>
        </form>

            <!-- 前のページに戻る -->
            <input class="btn no" type="button" name="BACK" value="入力画面に戻る" onclick="history.back()" id="back" >

	</div>
	</div>

        <hr>

   <div class="footer_all">
<footer class="footer">
	<img class="footer_logo" src="image/logo2.png"  width="15%" height="15%">
	<div class="footer_contents">
		<b><p>コンテンツ</p></b>
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
	<a href="/product_D2/help"><p>ヘルプはこちらから</p></a>
	<p>&copy;2023 Sakuraiya. All rights reserved.</p>
</div>
</div>

    </body>

</html>

