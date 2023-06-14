<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
<h1>ログイン</h1>
<form method="POST" action="/product_D2/login">
<input type="text" name="id" placeholder="ID">
<input type="password" name="pw" placeholder="パスワード">
<input type="submit" value="ログイン">
</form>
アカウントをお持ちでない方は<a href="/product_D2/sign_up">こちら</a>
<a href="/product_D2/top">ゲストとして利用する</a>

</body>
</html>