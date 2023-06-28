<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/create.css">
<title>ユーザー登録|with IT</title>
<link rel="icon" href="favicon.ico">
</head>
<body>
<!--画面上にスクロール-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.4/css/all.css">
	<div id="page_top"><a href="#"></a></div>
<!--スクロール終わり-->
	<header>
		<div class="header">
			<img src="image/logo.png" class="logo_contents" width="10%" height="10%"></a>
		</div>
		</header>
<hr>
<div class="create_main">
	<h4>ID/パスワード/ユーザー名</h4>
	<form method="POST" action="/product_D2/sign_up" name="suForm" id="su_form">

	ID <span id="userid_error" class="alertMsg"></span><br>
	<input type="text" name="userid" id="user_id" placeholder="16文字以内" class="textform userInf"><br>

	ユーザー名 <span id="username_error" class="alertMsg"></span><br>
	<input type="text" name="username" id="user_name" placeholder="ニックネームを入力してください 16文字以内" class="textform userInf"><br>

	パスワード <span id="password_error" class="alertMsg"></span><br>
	<input type="password" name="pw_first" id="pw_first" placeholder="16文字以内" class="textform userInf"><br>

	パスワード（確認）<span id="password_confirm_error" class="alertMsg"></span><br>
	<input type="password" name="password" id="password" placeholder="もう一度パスワードを入力してください" class="textform userInf"><br>

	<hr>
	<h4>お客様の基本情報</h4>
	<div class="contentA">
		使用中または興味のある言語 <span id="language_error" class="alertMsg"></span><br>
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
	</div>
	<div class="contentB">
	学びたいこと <span id="purpose_error" class="alertMsg"></span><br>
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
	</div>

	<div class="contentC">
	取りたい資格 <span id="certification_error" class="alertMsg"></span><br>
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
	</div>

	<div class="contentD">
		<p class="D_title">現時点でのスキル</p><br>
		<select name="career" class="select">
			<option value="入門：文法を勉強中">入門：文法を勉強中</option>
			<option value="初級：簡単なプログラムを書ける">初級：簡単なプログラムを書ける</option>
			<option value="中級：業務経験がある">中級：業務経験がある</option>
			<option value="上級：上流工程の仕事も担当できる">上級：上流工程の仕事も担当できる</option>
			<option value="エキスパート：リーダーとして開発できる">エキスパート：リーダーとして開発できる</option>
		</select>
	</div>

	<hr>
	<div class="sign_btn_wrap">
		<input type="button" onclick="location.href='/product_D2/login'" value="戻る" class="sign_btn sign_no ">
		<input type="submit" value="確認" class="sign_btn">
		<c:if test="${isExistingId == 'f'}">
		<br>
		</c:if>
		<c:if test="${isExistingId == 't'}">
		<p class="alertMsg">すでに登録されているユーザーIDです</p><br>
		</c:if>
	</div>
	</form>

</div>

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

<script src="/product_D2/js/sign_up.js"></script>
</body>
</html>