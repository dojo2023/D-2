<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>記事編集確認</title>
</head>
<body>
<h1>記事編集確認</h1>
<main>

<!-- プレビュー表示 -->

${article.title}<br>

${article.update}<br>

<c:set var="sendLang" value="" />
<c:forEach var="lang" items="${article.language}">
<c:set var="sendLang" value="${sendLang},${lang}" />
#<c:out value="${lang} " />
</c:forEach>
<br>
<c:set var="sendPurp" value="" />
<c:forEach var="purp" items="${article.purpose}">
<c:set var="sendPurp" value="${sendPurp},${purp}" />
#<c:out value="${purp }" />
</c:forEach>
<br>
${user.career}<br>

<c:set var="sendCert" value="" />
<c:forEach var="cert" items="${article.certification}">
<c:set var="sendCert" value="${sendCert},${cert}" />
#<c:out value="${cert } " />
</c:forEach>
<br>

${article.text}<br>
<c:if test="${not empty article.articleImg1}" >
<img src="${article.articleImg1}"></c:if><br>
<c:if test="${not empty article.articleImg2}" >
<img src="${article.articleImg2}"></c:if><br>
<c:if test="${not empty article.articleImg3}" >
<img src="${article.articleImg3}"></c:if><br>
<!-- edit_result.jspに送信 -->
以上の内容で更新してよろしいですか？<br>
<form method="post" action="/sample_d2/edit_result">
<input type="hidden" name="articleId" value="${article.articleId}">
<input type="hidden" name="articleTitle" value="${article.articleTitle}">
<input type="hidden" name="userId" value="${article.userId}">
<input type="hidden" name="articleCreate" value="${article.articleCreate}">
<input type="hidden" name="articleUpdate" value="${article.articleUpdate}">
<input type="hidden" name="articleLang" value="${article.articleLang}">
<input type="hidden" name="articlePurp" value="${article.articlePurp}">
<input type="hidden" name="articleCareer" value="${article.articleCareer}">
<input type="hidden" name="articleCert" value="${article.articleCert}">
<input type="hidden" name="articleFavs" value="${article.articleFavs}">
<input type="hidden" name="articleText" value="${article.articleText}">
<input type="hidden" name="articleImg1" value="${article.articleImg1}">
<input type="hidden" name="articleImg2" value="${article.articleImg2}">
<input type="hidden" name="articleImg3" value="${article.articleImg3}">
<input type="submit" value="更新">
</form>
<button type="button" onclick="history.back()">戻る</button>
</main>
</body>
</html>