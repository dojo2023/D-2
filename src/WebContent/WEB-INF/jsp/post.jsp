<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/common.css">
		<link rel="stylesheet" href="css/create.css">
		<title>投稿ページ | with IT</title>


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
			<hr>
			<form id="form" method="POST" action="/product_D2/post" enctype="multipart/form-data">
				<h4>タイトル</h4>
				<input class="textform" type="text" name="article_title" id="article_title" onkeyup="counter('article_title','count1')">
				<span id="count1">0</span>/50
				<p id="output1"></p>

				<hr>
				<h4>タグ</h4>

				<div class="contentA">
					<p>対象言語</p>

					<table>
						<tr>
							<td><label><input type="checkbox" class="tag" name="language" value="Java">Java</label></td>
							<td><label><input type="checkbox" class="tag" name="language" value="JavaScript">JavaScript</label></td>
							<td><label><input type="checkbox" class="tag" name="language" value="TypeScript">TypeScript</label></td>
							<td><label><input type="checkbox" class="tag" name="language" value="C++(C)">C++(C)</label></td>
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

							<td><label><input type="checkbox" class="tag" name="language" value="R言語">R言語</label></td>
							<td><label><input type="checkbox" class="tag" name="language" value="Kotolin">Kotlin</label></td>
							<td><label><input type="checkbox" class="tag" name="language" value="Go">Go</label></td></tr>
					</table>
				</div>

				<div class="contentB">
					<p>ジャンル</p>
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
					<p>対象となる資格</p>
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
							<td><label><input type="checkbox" class="tag" name="certification" value="ITサービスマネージャ試験">ITサービスマネージャ試験</label>
							</td>
							<td><label><input type="checkbox" class="tag" name="certification" value="システム監査技術者試験">システム監査技術者試験</label></td>
						</tr>

						<tr>
							<td><label><input type="checkbox" class="tag" name="certification" value="情報処理安全確保支援士試験">情報処理安全確保支援士試験</label></td>
						</tr>
					</table>
				</div>

				<div class="contentD">
					<p>対象となるプログラミング歴</p>
					<select class="select" name="career" class="tag" id="tag">
						<option value ="">---</option>
						<option value="入門：文法を勉強中">入門：文法を勉強中</option>
						<option value="初級：簡単なプログラムを書ける">初級：簡単なプログラムを書ける></option>
						<option value="中級：業務経験がある">中級：業務経験がある></option>
						<option value="上級：上流工程の仕事も担当できる">上級：上流工程の仕事も担当できる></option>
						<option value="エキスパート：リーダーとして開発できる">エキスパート：リーダーとして開発できる></option>
					</select>
				</div>

				<p id=outputTag></p>


			<div class="edit_contents">
				<hr>
				<h4>本文</h4><!-- cssでdisplay:inline -->
				<textarea class="edit_txt" name="text" id="article_text" placeholder="本文を入力してください" onkeyup="counter('article_text','count2')"></textarea>
				<br>
				<span id="count2">0</span>/10000
				<p id="output2">

				<input type="file" name="img1" id="img1" onchange="previewImage1(event)"><input type="button" value="ファイルを追加" id="addimg2"><br>
				<img id="img1-preview" src="#" alt="Image1 Preview"><br>
				<input type="hidden" name="img2" id="img2" onchange="previewImage2(event)"><input type="hidden" value="ファイルを追加" id="addimg3"><br>
				<img id="img2-preview" src="#" alt="Image2 Preview"><br>
				<input type="hidden" name="img3" id="img3" onchange="previewImage3(event)"><br>
				<img id="img3-preview" src="#" alt="Image3 Preview"><br>
				<!-- <input type="hidden" name="userid" value="{$userId}"> -->
				</div>

				<div class="btn_wrap">
				<input class="btn" type="submit" value="プレビュー画面へ"></div>

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
				<a href="/product_D2/help"><p>ヘルプはこちらから</p></a>
				<p>&copy;2023 Sakuraiya. All rights reserved.</p>
			</div>
			</div>
		</main>

		<script src="/product_D2/js/post.js"></script>
	</body>
</html>