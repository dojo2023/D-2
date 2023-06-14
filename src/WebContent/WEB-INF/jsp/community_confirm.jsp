<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="/product_D2/css/confirm.css">
        <title>コミュニティ作成確認</title>
    </head>
    <body>
		<!-- 確認の表示 -->
        <p>コミュニティ名<br>
            ${name}
        </p>

        <p>タグ<br>
			<c:set var="sendLang" value="" />
            <c:forEach var="e" items="${language}">
            ${e}<br>
            <c:set var="sendLang" value="${sendLang},${lang} "/>
            </c:forEach><br>

			<c:set var="sendPurp" value="" />
            <c:forEach var="e" items="${porpuse}">
            ${e}<br>
            <c:set var="sendPurp" value="${sendPurp},${e} "/>
            </c:forEach><br>

			<c:set var="sendCert" value="" />
            <c:forEach var="e" items="${certification}">
            ${e}<br>
            <c:set var="sendCert" value="${sendCert},${e} "/>
            </c:forEach><br>

            ${career}
        </p>

        <p>概要<br>
            ${summary}
        </p>

		<!--  confirmServletへ送信 -->
     	<form method="POST" action="/product_D2/CommunityCreateConfirmServlet.java">

		<input type="hidden" name="community_name" value="${name}">
		<input type="hidden" name="sendLang" value="${sendLang}" >
		<input type="hidden" name="sendPurp" value="${sendPurp}" >
		<input type="hidden" name="sendCert" value="${sendCert}" >
		<input type="hidden" name="career" value="${career}">
		<input type="hidden" name="summary" value="${summary}">
		<input type="hidden" name="SUBMIT" value="作成して会話を開始"><br>
		</form>

		<!-- 前のページに戻る -->
		<input type="button" name="BACK" value="前のページに戻る" onclick="history.back()" id="back" >

		<script>

		</script>


    </body>

</html>