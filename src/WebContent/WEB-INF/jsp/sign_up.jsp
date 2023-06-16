<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
<h1>ユーザー登録</h1>
<form method="POST" action="/product_D2/sign_up" name="suForm" id="su_form">
ID <span id="userid_error"></span><br>
<input type="text" name="userid" id="user_id" placeholder="ID"><br>
パスワード <span id="password_error"></span><br>
<input type="password" name="pw_first" id="pw_first" placeholder="パスワード"><br>
パスワード（確認）<span id="password_confirm_error"></span><br>
<input type="password" name="password" id="password" placeholder="パスワード(確認)"><br>
ユーザー名 <span id="username_error"></span><br>
<input type="text" name="username" id="user_name" placeholder="ユーザー名"><br>
使用中または興味のある言語 <span id="language_error"></span><br>
<table>
<tr>
	<td><input type="checkbox" name="language" value="Java">Java</td>
	<td><input type="checkbox" name="language" value="JavaScript">JavaScript</td>
	<td><input type="checkbox" name="language" value="TypeScript">TypeScript</td>
	<td><input type="checkbox" name="language" value="C/C++">C/C++</td>
</tr>
<tr>
	<td><input type="checkbox" name="language" value="C#">C#</td>
	<td><input type="checkbox" name="language" value="Python">Python</td>
	<td><input type="checkbox" name="language" value="SQL">SQL</td>
	<td><input type="checkbox" name="language" value="HTML&CSS">HTML&amp;CSS</td>
</tr>
<tr>
	<td><input type="checkbox" name="language" value="PHP">PHP</td>
	<td><input type="checkbox" name="language" value="Scala">Scala</td>
	<td><input type="checkbox" name="language" value="Swift">Swift</td>
	<td><input type="checkbox" name="language" value="Ruby">Ruby</td>
</tr>
<tr>
	<td><input type="checkbox" name="language" value="R">R</td>
	<td><input type="checkbox" name="language" value="Kotlin">Kotlin</td>
	<td><input type="checkbox" name="language" value="Go">Go</td>
	<td><input type="checkbox" name="language" value="その他">その他</td>
</tr>
</table>
学びたいこと <span id="purpose_error"></span><br>
<table>
<tr>
	<td><input type="checkbox" name="purpose" value="プログラミング">プログラミング</td>
	<td><input type="checkbox" name="purpose" value="資格">資格</td>
	<td><input type="checkbox" name="purpose" value="システム開発">システム開発</td>
	<td><input type="checkbox" name="purpose" value="業界研究">業界研究</td>
</tr>
<tr>
	<td><input type="checkbox" name="purpose" value="ITニュース">ITニュース</td>
	<td><input type="checkbox" name="purpose" value="キャリア">キャリア</td>
	<td><input type="checkbox" name="purpose" value="データベース">データベース</td>
	<td><input type="checkbox" name="purpose" value="Officeスキル">Officeスキル</td>
</tr>
<tr>
	<td><input type="checkbox" name="purpose" value="セキュリティ">セキュリティ</td>
	<td><input type="checkbox" name="purpose" value="OS">OS</td>
	<td><input type="checkbox" name="purpose" value="その他">その他</td>
</tr>
</table>
現時点でのスキル<br>
<select name="career">
	<option value="入門：文法を勉強中">入門：文法を勉強中</option>
	<option value="初級：簡単なプログラムを書ける">初級：簡単なプログラムを書ける</option>
	<option value="中級：業務経験がある">中級：業務経験がある</option>
	<option value="上級：上流工程の仕事も担当できる">上級：上流工程の仕事も担当できる</option>
	<option value="エキスパート：リーダーとして開発できる">エキスパート：リーダーとして開発できる</option>
</select><br>
取りたい資格 <span id="certification_error"></span><br>
<table>
<tr>
	<td><input type="checkbox" name="certification" value="ITパスポート">ITパスポート</td>
	<td><input type="checkbox" name="certification" value="情報セキュリティマネジメント試験">情報セキュリティマネジメント試験</td>
	<td><input type="checkbox" name="certification" value="基本情報技術者試験">基本情報技術者試験</td>
	<td><input type="checkbox" name="certification" value="応用情報技術者試験">応用情報技術者試験</td>
</tr>
<tr>
	<td><input type="checkbox" name="certification" value="ITストラテジスト試験">ITストラテジスト試験</td>
	<td><input type="checkbox" name="certification" value="システムアーキテクト試験">システムアーキテクト試験</td>
	<td><input type="checkbox" name="certification" value="プロジェクトマネージャ試験">プロジェクトマネージャ試験</td>
	<td><input type="checkbox" name="certification" value="ネットワークスペシャリスト試験">ネットワークスペシャリスト試験</td>
</tr>
<tr>
	<td><input type="checkbox" name="certification" value="データベーススペシャリスト試験">データベーススペシャリスト試験</td>
	<td><input type="checkbox" name="certification" value="エンベデッドシステムスペシャリスト試験">エンベデッドシステムスペシャリスト試験</td>
	<td><input type="checkbox" name="certification" value="ITサービスマネージャ試験">ITサービスマネージャ試験</td>
	<td><input type="checkbox" name="certification" value="システム監査技術者試験">システム監査技術者試験</td>
</tr>
<tr>
	<td><input type="checkbox" name="certification" value="情報処理安全確保支援士試験">情報処理安全確保支援士試験</td>
	<td><input type="checkbox" name="certification" value="その他">その他</td>
</tr>
</table>
<input type="button" onclick="location.href='/product_D2/login'" value="戻る">
<input type="submit" value="確認">
<c:if test="${isExistingId == 'f'}">
<br>
</c:if>
<c:if test="${isExistingId == 't'}">
すでに登録されているユーザーIDです<br>
</c:if>
</form>
<script src="/product_D2/js/sign_up.js"></script>
</body>
</html>