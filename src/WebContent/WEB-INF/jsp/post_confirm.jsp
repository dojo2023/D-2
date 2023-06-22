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
	<header>
        <div class="header">
            <a href="/product_D2/TopServlet"><img src="image/logo.png" class="logo_contents" width="10%" height="10%"></a>
        </div>
    </header>
<hr>
<div class="confirm_main">
	<h1>作成確認</h1>
	 <div class="confirm_contents">

	<h4>タイトル</h4>
		${article_data.title}<br>

	<h4>作成者</h4>>
		${article.user}<br>

	<h4>タグ</h4>
		<c:set var="sendLang" value="" />
        <c:forEach var="e" items="${ariticle_data.language}">
        ${e},
        <c:set var="sendLang" value="${sendLang},${e} "/>
        </c:forEach>

        <c:set var="sendPurp" value="" />
         <c:forEach var="e" items="${article_data.purpose}">
         ${e},
         <c:set var="sendPurp" value="${sendPurp},${e} "/>
         </c:forEach>

         <c:set var="sendCert" value="" />
         <c:forEach var="e" items="${article_data.certification}">
         ${e},
         <c:set var="sendCert" value="${sendCert},${e} "/>
         </c:forEach>

         ${article_data.career}<br>


	<h4>本文</h4>
		${article_data.text}<br>

<!-- 画像ファイル↓ -->
		<img src="${article_img1}">
		${errorMessage}
		<img src="${article_img2}">
		${errorMessage}
		<img src="${article_img3}">
		${errorMessage}

	</div>
	<div class="confirm_msg">
		<p>以上の内容でよろしいですか？</p><br>
		<form method="POST" action="/product_D2/PostConfirmServlet.java">
		<input type="hidden" name="article_title" value="${ariticle_data.title}">
		<input type="hidden" name="article_user" value="${article_data.user}">
        <input type="hidden" name="sendLang" value="${sendLang}" >
        <input type="hidden" name="sendPurp" value="${sendPurp}" >
        <input type="hidden" name="article_career" value="${article_data.career}">
        <input type="hidden" name="sendCert" value="${sendCert}" >
        <input type="hidden" name="article_favs" value=0>
        <input type="hidden" name="article_text" value="${article_data.text}">
        <input type="hidden" name="article_img1" value="${article_data.img1}">
        <input type="hidden" name="article_img2" value="${article_data.img2}">
        <input type="hidden" name="article_img3" value="${article_data.img3}">
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

