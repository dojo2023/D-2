<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/common.css">
        <link rel="stylesheet" href="css/confirm.css">
        <title>コミュニティ作成確認｜with IT</title>
        <link rel="icon" href="image/favicon.ico">
    </head>
    <body>
<div class="header">
        <!--画面上にスクロール-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.4/css/all.css">
	<div id="page_top"><a href="#"></a></div>
<!--スクロール終わり-->
    <header>
        
            <a href="/product_D2/top"><img src="image/logo.png" class="logo_contents" width="10%" height="10%"></a>
        </div>
    </header>

<hr>
<div class="confirm_main">
    <h1>作成確認</h1>
		<!-- 確認の表示 -->
        <div class="confirm_contents">
            <h4>コミュニティ名：</h4>
                ${name}<br>

            <h4>タグ：</h4>
                <c:set var="sendLang" value="" />
                <c:forEach var="e" items="${language}">
                ${e}&nbsp;
                <c:set var="sendLang" value="${sendLang},${e}"/>
                </c:forEach>

                <c:set var="sendPurp" value="" />
                <c:forEach var="e" items="${purpose}">
                ${e}&nbsp;
                <c:set var="sendPurp" value="${sendPurp},${e}"/>
                </c:forEach>

                <c:set var="sendCert" value="" />
                <c:forEach var="e" items="${certification}">
                ${e}&nbsp;
                <c:set var="sendCert" value="${sendCert},${e}"/>
                </c:forEach>
                ${career}<br>

            <h4>コミュニティの概要：</h4>
                ${summary}<br>

        </div>
        <div class="confirm_msg">
            <p>以上の内容でよろしいですか？</p><br>
            <!--  confirmServletへ送信 -->
            <form method="POST" action="/product_D2/community_create_confirm">

            <input type="hidden" name="community_name" value="${name}">
            <input type="hidden" name="sendLang" value="${sendLang}" >
            <input type="hidden" name="sendPurp" value="${sendPurp}" >
            <input type="hidden" name="sendCert" value="${sendCert}" >
            <input type="hidden" name="career" value="${career}">
            <input type="hidden" name="summary" value="${summary}">
            <input class="btn" type="submit" name="SUBMIT" value="作成して会話を開始"><br>
            </form>

            <!-- 前のページに戻る -->
            <input class="btn no" type="button" name="BACK" value="入力画面に戻る" onclick="history.back()" id="back" >

            <script>

            </script>
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
            <p>ヘルプはこちらから</p>
            <p>&copy;2023 Sakuraiya. All rights reserved.</p>
        </div>
        </div>

    </body>

</html>