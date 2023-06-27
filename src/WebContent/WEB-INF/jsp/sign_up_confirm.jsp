<!-- 6/15 14:58update by yahaba -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/confirm.css">
<title>登録確認|with IT</title>
</head>
<body>
<!--画面上にスクロール-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.4/css/all.css">
	<div id="page_top"><a href="#"></a></div>
<!--スクロール終わり-->

<header>

    <div class="header">
        <img src="image/logo.png" class="logo_contents" width="10%" height="10%">
    </div>
</header>

<hr>
<div class="confirm_main">
    <h1>登録確認</h1>
    <div class="confirm_contents">
        <h4>ユーザーID：</h4>
        ${user.userId}<br>
        <h4>パスワード：</h4>
        <p>********</p>
        <br>
        <h4>ユーザー名：</h4>
        ${user.userName}<br>
        <h4>使用中または興味のある言語：</h4>
        <c:set var="sendLang" value="" />
        <c:forEach var="lang" items="${user.language}">
        <c:set var="sendLang" value="${sendLang},${lang}" />
        <c:out value="${lang } " />
        </c:forEach>
        <br>
        <h4>学びたいこと：</h4>
        <c:set var="sendPurp" value="" />
        <c:forEach var="purp" items="${user.purpose}">
        <c:set var="sendPurp" value="${sendPurp},${purp}" />
        <c:out value="${purp } " />
        </c:forEach>
        <br>
        <h4>現時点でのスキル：</h4>
        ${user.career}<br>
        <h4>取りたい資格：</h4>
        <c:set var="sendCert" value="" />
        <c:forEach var="cert" items="${user.certification}">
        <c:set var="sendCert" value="${sendCert},${cert}" />
        <c:out value="${cert } " />
        </c:forEach>
        <br>
    </div>
    <div class="confirm_msg">
        <p>以上の内容でよろしいですか？</p><br>
        <form method="post" action="/product_D2/sign_up_result">
        <input type="hidden" name="userId" value="${user.userId}">
        <input type="hidden" name="password" value="${user.password}">
        <input type="hidden" name="userName" value="${user.userName}">
        <input type="hidden" name="sendLang" value="${sendLang}">
        <input type="hidden" name="sendPurp" value="${sendPurp}">
        <input type="hidden" name="career" value="${user.career}">
        <input type="hidden" name="sendCert" value="${sendCert}">
        <input class="btn yes" type="submit" value="この内容で登録">
        </form>
        <button class="btn no" type="button" onclick="history.back()">入力画面に戻る</button>
    </div>
    <hr>
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