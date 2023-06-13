<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h1>の検索結果</h1>
<hr>
<c:if test="${empty cardList}">
<p>一致するデータなし</p>
</c:if>
<c:forEach var="e" items="${cardList}" >
	<form method="POST" action="/product_D2/CommunityServlet">
	<input type="text" name="NUMBER" value="${e.CommunityName}"><br>
	<input type="text" name="NAME" value="${e.CommunityLanguage}"><br>
	<input type="text" name="NAME" value="${e.CommunityPurpose}"><br>
	<input type="text" name="NAME" value="${e.CommunityCareer}"><br>
	<input type="text" name="NAME" value="${e.CommunityCertification}"><br>
	<input type="text" name="ADDRESS" value="${e.CommunitySummary}"><br>
	<!-- ここに最新の発言を加える --><br>
	<input type="submit" name="SUBMIT" value="参加"></form>
	<hr>
</c:forEach>

</body>
<footer>
</footer>
</html>