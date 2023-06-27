<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/common.css">
		<link rel="stylesheet" href="css/create.css">
		<title>投稿ページ | with IT</title>
	<link rel="icon" href="image/favicon.ico">

	</head>

	<body>
	<!--画面上にスクロール-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.4/css/all.css">
	<div id="page_top"><a href="#"></a></div>
	<!--スクロール終わり-->
	<header>
	<div class="header">
	<a href="/product_D2/top"><img src="image/logo.png" class="logo_contents" width="10%" height="10%"></a>
	</div>
	</header>

		<main>
			<div class="create_main">
			<form id="form" method="POST" action="/product_D2/post" enctype="multipart/form-data">
			<hr>
				<h4>タイトル</h4>
				<input class="textform" type="text" name="article_title" id="article_title" onkeyup="counter('article_title','count1')">
				<span id="count1">0</span>/50
				<p id="output1"></p>

				<hr>
				<h4>タグ</h4>

				<div class="contentA">
					対象言語<br>

					<table>
						<tr>
							<td><label><input type="checkbox" class="tag" name="language" value="Java">Java</label></td>
							<td><label><input type="checkbox" class="tag" name="language" value="JavaScript">JavaScript</label></td>
							<td><label><input type="checkbox" class="tag" name="language" value="TypeScript">TypeScript</label></td>
							<td><label><input type="checkbox" class="tag" name="language" value="C/C++">C/C++</label></td>
							<td><label><input type="checkbox" class="tag" name="language" value="C#">C#</label></td>
						</tr>

						<tr>
							<td><label><input type="checkbox" class="tag" name="language" value="Python">Python</label></td>
							<td><label><input type="checkbox" class="tag" name="language" value="SQL">SQL</label></td>
							<td><label><input type="checkbox" class="tag" name="language" value="HTML&CSS">HTML&amp;CSS</label></td>
							<td><label><input type="checkbox" class="tag" name="language" value="PHP">PHP</label></td>
							<td><label><input type="checkbox" class="tag" name="language" value="Scala">Scala</label></td>
						</tr>

						<tr>
							<td><label><input type="checkbox" class="tag" name="language" value="Swift">Swift</label></td>
							<td><label><input type="checkbox" class="tag" name="language" value="Ruby">Ruby</label></td>
							<td><label><input type="checkbox" class="tag" name="language" value="R">R</label></td>
							<td><label><input type="checkbox" class="tag" name="language" value="Kotlin">Kotlin</label></td>
							<td><label><input type="checkbox" class="tag" name="language" value="Go">Go</label></td>
						</tr>
					</table>
				</div>

				<div class="contentB">
					ジャンル<br>
					<table>
						<tr>
							<td><label><input type="checkbox" class="tag" name="purpose" value="プログラミング">プログラミング</label></td>
							<td><label><input type="checkbox" class="tag" name="purpose" value="資格">資格</label></td>
							<td><label><input type="checkbox" class="tag" name="purpose" value="システム開発">システム開発</label></td>
							<td><label><input type="checkbox" class="tag" name="purpose" value="業界研究">業界研究</label></td>
							<td><label><input type="checkbox" class="tag" name="purpose" value="ITニュース">ITニュース</label></td>
						</tr>

						<tr>
							<td><label><input type="checkbox" class="tag" name="purpose" value="キャリア">キャリア</label></td>
							<td><label><input type="checkbox" class="tag" name="purpose" value="データベース">データベース</label></td>
							<td><label><input type="checkbox" class="tag" name="purpose" value="Officeスキル">Officeスキル</label></td>
							<td><label><input type="checkbox" class="tag" name="purpose" value="セキュリティ">セキュリティ</label></td>
							<td><label><input type="checkbox" class="tag" name="purpose" value="OS">OS</label></td>
						</tr>
					</table>
				</div>

				<div class="contentC">
					対象となる資格<br>
					<table>
						<tr>
							<td><label><input type="checkbox" class="tag" name="certification" value="ITパスポート">ITパスポート</label></td>
							<td><label><input type="checkbox" class="tag" name="certification" value="情報セキュリティマネジメント試験">情報セキュリティマネジメント試験</label></td>
							<td><label><input type="checkbox" class="tag" name="certification" value="基本情報技術者試験">基本情報技術者試験</label></td>
							<td><label><input type="checkbox" class="tag" name="certification" value="応用情報技術者試験">応用情報技術者試験</label></td>
						</tr>

						<tr>
							<td><label><input type="checkbox" class="tag" name="certification" value="ITストラテジスト試験">ITストラテジスト試験</label></td>
							<td><label><input type="checkbox" class="tag" name="certification" value="システムアーキテクト試験">システムアーキテクト試験</label></td>
							<td><label><input type="checkbox" class="tag" name="certification" value="プロジェクトマネージャー試験">プロジェクトマネージャー試験</label></td>
							<td><label><input type="checkbox" class="tag" name="certification" value="ネットワークスペシャリスト試験">ネットワークスペシャリスト試験</label></td>
						</tr>

						<tr>
							<td><label><input type="checkbox" class="tag" name="certification" value="データベーススペシャリスト試験">データベーススペシャリスト試験</label></td>
							<td><label><input type="checkbox" class="tag" name="certification" value="エンベデッドシステムスペシャリスト試験">エンベデッドシステムスペシャリスト試験</label></td>
							<td><label><input type="checkbox" class="tag" name="certification" value="ITサービスマネージャ試験">ITサービスマネージャ試験</label></td>
							<td><label><input type="checkbox" class="tag" name="certification" value="システム監査技術者試験">システム監査技術者試験</label></td>
						</tr>

						<tr>
							<td><label><input type="checkbox" class="tag" name="certification" value="情報処理安全確保支援士試験">情報処理安全確保支援士試験</label></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</table>
				</div>

				<div class="contentD">
					対象となるプログラミング歴<br>
					<select class="select" name="career" class="tag" id="tag">
						<option value ="">---</option>
						<option value="入門：文法を勉強中">入門：文法を勉強中</option>
						<option value="初級：簡単なプログラムを書ける">初級：簡単なプログラムを書ける</option>
						<option value="中級：業務経験がある">中級：業務経験がある</option>
						<option value="上級：上流工程の仕事も担当できる">上級：上流工程の仕事も担当できる</option>
						<option value="エキスパート：リーダーとして開発できる">エキスパート：リーダーとして開発できる</option>
					</select>
				</div>
				<p id="outputTag"></p>

			<hr>
			<div class="edit_contents">
				<h4>本文</h4>
				<textarea class="edit_txt" name="article_text" id="article_text" placeholder="本文を入力してください" onkeyup="counter('article_text','count2')"></textarea>
				<br>
				<span id="count2">0</span>/10000
				<p id="output2">

				<input type="file" name="img1" id="img1" accept="image/*" onchange="previewImage1(this);"><input type="button" value="ファイルを追加" id="addimg2"><br>
				<input type="hidden" name="img2" id="img2" accept="image/*" onchange="previewImage2(this);"><input type="hidden" value="ファイルを追加" id="addimg3"><br>
				<input type="hidden" name="img3" id="img3" accept="image/*" onchange="previewImage3(this);"><br>
				<canvas id="preview1" style="max-width:200px;"></canvas>
				<canvas id="preview2" style="max-width:200px;"></canvas>
				<canvas id="preview3" style="max-width:200px;"></canvas>

			</div>

			<div class="btn_wrap">
				<input class="btn" type="submit" value="プレビュー画面へ">
			</div>

			</form>
			</div>

		<div class="footer_all">
			<footer class="footer">
				<img class="footer_logo" src="image/logo2.png"  width="15%" height="15%">
				<div class="footer_contents">
					<b><p>コンテンツ</p></b>
					<ul>
						<c:choose>
						<c:when test="${not empty user.userId}">
						<li><a href="/product_D2/top">トップ</a></li>
						<li><a href="/product_D2/post">記事投稿</a></li>
						<li><a href="/product_D2/community_create">コミュニティ作成</a></li>
						<li>ログイン</li>
						<li><a href="/product_D2/login">ログアウト</a></li>
						<li>ユーザー登録</li>
						</c:when>
						<c:otherwise>
						<li><a href="/product_D2/top">トップ</a></li>
						<li>記事投稿</li>
						<li>コミュニティ作成</li>
						<li><a href="/product_D2/login">ログイン</a></li>
						<li>ログアウト</li>
						<li><a href="/product_D2/sign_up">ユーザー登録</a></li>
						</c:otherwise>
						</c:choose>
					</ul>
					</div>
			</footer>
			<div class="footer_bottom">
				<a href="/product_D2/help"><p>ヘルプはこちらから</p></a>
				<p>&copy;2023 Sakuraiya. All rights reserved.</p>
			</div>
			</div>
		</main>

		<script src="/product_D2/js/post.js"></script>
		<script>
			function previewImage1(obj){

				var fileReader = new FileReader();

				// 読み込み後に実行する処理
				fileReader.onload = (function() {

					// canvas にプレビュー画像を表示
					var canvas = document.getElementById('preview1');
					var ctx = canvas.getContext('2d');
					var image = new Image();
					image.src = fileReader.result;
					console.log(fileReader.result) // ← (確認用)

					image.onload = (function () {
						canvas.width = image.width;
						canvas.height = image.height;
						ctx.drawImage(image, 0, 0);
					});
				});
				// 画像読み込み
				fileReader.readAsDataURL(obj.files[0]);
				console.log(fileReader.result) // ← (確認用)null
			}

			function previewImage2(obj){

				var fileReader = new FileReader();

				// 読み込み後に実行する処理
				fileReader.onload = (function() {

					// canvas にプレビュー画像を表示
					var canvas = document.getElementById('preview2');
					var ctx = canvas.getContext('2d');
					var image = new Image();
					image.src = fileReader.result;
					console.log(fileReader.result) // ← (確認用)

					image.onload = (function () {
						canvas.width = image.width;
						canvas.height = image.height;
						ctx.drawImage(image, 0, 0);
					});
				});
				// 画像読み込み
				fileReader.readAsDataURL(obj.files[0]);
				console.log(fileReader.result) // ← (確認用)null
			}

			function previewImage3(obj){

				var fileReader = new FileReader();

				// 読み込み後に実行する処理
				fileReader.onload = (function() {

					// canvas にプレビュー画像を表示
					var canvas = document.getElementById('preview3');
					var ctx = canvas.getContext('2d');
					var image = new Image();
					image.src = fileReader.result;
					console.log(fileReader.result) // ← (確認用)

					image.onload = (function () {
						canvas.width = image.width;
						canvas.height = image.height;
						ctx.drawImage(image, 0, 0);
					});
				});
				// 画像読み込み
				fileReader.readAsDataURL(obj.files[0]);
				console.log(fileReader.result) // ← (確認用)null
			}
		</script>
	</body>
</html>