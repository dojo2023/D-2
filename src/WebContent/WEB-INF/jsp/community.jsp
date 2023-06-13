<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h1>${CommunityName}<input type="button" value="参加者"></h1>
<hr>

<c:forEach var="e" items="${cardList}" >

	名前 1/1 21:30(仮)<br>
    <input type="text" name="NUMBER" value="${e.RemarkText}" disabled><br>
	名前 1/1 21:30(仮)<br>
    <input type="text" name="NAME" value="${e.RemarkText}" disabled><br>
	名前 1/1 21:30(仮)<br>
    <input type="text" name="ADDRESS" value="${e.RemarkText}" disabled><br>


	<hr>
</c:forEach>
<form method="POST" action="/product_D2/CommunityServlet">
<input type="textarea" name="communityname" >
<input type="submit" name="SUBMIT" value="送信">
</form>
</body>
<footer>
</footer>
</html>