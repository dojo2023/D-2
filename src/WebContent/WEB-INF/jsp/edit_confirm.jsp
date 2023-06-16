<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>記事編集確認</title>
</head>
<body>
<h1>記事編集確認</h1>
タイトル<br>
${article.title}<br>
言語<br>
<c:set var="sendLang" value="" />
<c:forEach var="lang" items="${user.language}">
<c:set var="sendLang" value="${sendLang},${lang}" />
<c:out value="${lang} " />
</c:forEach>
<br>
使用理由<br>
<c:set var="sendPurp" value="" />
<c:forEach var="purp" items="${user.purpose}">
<c:set var="sendPurp" value="${sendPurp},${purp}" />
<c:out value="${purp }" />
</c:forEach>
<br>
スキル<br>
${user.career}<br>
資格<br>
<c:set var="sendCert" value="" />
<c:forEach var="cert" items="${user.certification}">
<c:set var="sendCert" value="${sendCert},${cert}" />
<c:out value="${cert } " />
</c:forEach>
<br>
以上の内容で更新してよろしいですか？<br>
<form method="post" action="/product_D2/edit_result">
<input type="hidden" name="title" value="${article.title}">
<input type="hidden" name="sendLang" value="${sendLang}">
<input type="hidden" name="sendPurp" value="${sendPurp}">
<input type="hidden" name="sendLang" value="${sendLang}">
<input type="hidden" name="career" value="${user.career}">
<input type="hidden" name="sendCert" value="${sendCert}">
<input type="submit" value="更新">
</form>
<button type="button" onclick="history.back()">戻る</button>
</body>
</html>