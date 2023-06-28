<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/login.css">
<title>ログイン</title>
<link rel="icon" href="image/favicon.ico">
</head>
<body>
<div class="loginlogo"><h1><img src="image/logo2.png" class="logo_contents" width="20%" height="20%"></h1></div>
<form method="POST" action="/product_D2/login" name="auth">
<input type="text" name="id" id="id" placeholder="ID"><br>
<input type="password" name="pw" id="pw" placeholder="パスワード"><br>
<input type="submit" value="ログイン" onclick="return check()"><br>
</form>
<c:if test="${isError == 'f'}">
<br>
</c:if>
<c:if test="${isError == 't'}">
IDまたはパスワードが違います<br>
</c:if>
アカウントをお持ちでない方は<a href="/product_D2/sign_up">こちら</a><br><br>
<a href="/product_D2/top">ゲストとして利用する</a>
<script src="/product_D2/js/login.js"></script>
</body>
</html>