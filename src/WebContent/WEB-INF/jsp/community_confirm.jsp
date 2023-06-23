<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/common.css">
        <link rel="stylesheet" href="css/confirm.css">
        <title>コミュニティ作成確認｜with IT</title>
    </head>
    <body>

    <header>
        <div class="header">
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
                ${e},
                <c:set var="sendLang" value="${sendLang},${e} "/>
                </c:forEach>

                <c:set var="sendPurp" value="" />
                <c:forEach var="e" items="${purpose}">
                ${e},
                <c:set var="sendPurp" value="${sendPurp},${e} "/>
                </c:forEach>

                <c:set var="sendCert" value="" />
                <c:forEach var="e" items="${certification}">
                ${e},
                <c:set var="sendCert" value="${sendCert},${e} "/>
                </c:forEach>
                ${career}<br>

            <h4>コミュニティの概要：</h4>
                ${summary}<br>

        </div>
        <div class="confirm_msg">
            <p>以上の内容でよろしいですか？</p><br>
            <!--  confirmServletへ送信 -->
            <form method="POST" action="/product_D2/community">

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