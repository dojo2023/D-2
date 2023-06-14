<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録確認</title>
</head>
<body>
<h1>登録確認</h1>
ユーザーID<br>
${user.userId}<br>
パスワード<br>
********<br>
ユーザー名<br>
${user.userName}<br>
使用中または興味のある言語<br>
<c:set var="sendLang" value="" />
<c:forEach var="lang" items="${user.language}">
<c:set var="sendLang" value="${sendLang},${lang}" />
<c:out value="${lang} " />
</c:forEach>
<br>
学びたいこと<br>
<c:set var="sendPurp" value="" />
<c:forEach var="purp" items="${user.purpose}">
<c:set var="sendPurp" value="${sendPurp},${purp}" />
<c:out value="${purp }" />
</c:forEach>
<br>
現時点でのスキル<br>
${user.career}<br>
取りたい資格<br>
<c:set var="sendCert" value="" />
<c:forEach var="cert" items="${user.certification}">
<c:set var="sendCert" value="${sendCert},${cert}" />
<c:out value="${cert } " />
</c:forEach>
<br>
以上の内容でよろしいですか？<br>
<form method="post" action="/product_D2/sign_up_result">
<input type="hidden" name="userId" value="${user.userId}">
<input type="hidden" name="password" value="${user.password}">
<input type="hidden" name="userName" value="${user.userName}">
<input type="hidden" name="sendLang" value="${sendLang}">
<input type="hidden" name="sendPurp" value="${sendPurp}">
<input type="hidden" name="career" value="${user.career}">
<input type="hidden" name="sendCert" value="${sendCert}">
<input type="submit" value="はい">
</form>
<button type="button" onclick="history.back()">いいえ</button>
</body>
</html>