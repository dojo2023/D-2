<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>記事編集</title>
</head>
<body>
<h1>記事編集</h1>
<main>
<!-- 編集前の記事（チェックボックス部分）をjsで持ってくる？ -->

記事タイトル<br>
<form method="POST" action="product_D2/EditServlet" id="form">
<label><input type="text" name="title" value="${article.articleTitle}" placeholder="記事タイトル"></label>
<h2>タグ選択</h2>
言語<br>
<table class=language-tag>
<tr>
<td>
<label><input type="checkbox" name="language" value="Java">Java</label>
</td>
<td>
<label><input type="checkbox" name="language" value="JavaScript">JavaScript</label>
</td>
<td>
<label><input type="checkbox" name="language" value="TypeScript">TypeScript</label>
</td>
<td>
<label><input type="checkbox" name="language" value="C++(C)">C++(C)</label>
</td>
</tr>
<tr>
<td>
<label><input type="checkbox" name="language" value="C#">C#</label>
</td>
<td>
<label><input type="checkbox" name="language" value="Python">Python</label>
</td>
<td>
<label><input type="checkbox" name="language" value="SQL">SQL</label>
</td>
<td>
<label><input type="checkbox" name="language" value="HTML & CSS">HTML &amp; CSS</label>
</td>
</tr>
<tr>
<td>
<label><input type="checkbox" name="language" value="PHP">PHP</label>
</td>
<td>
<label><input type="checkbox" name="language" value="Scala">Scala</label>
</td>
<td>
<label><input type="checkbox" name="language" value="Swift">Swift</label>
</td>
<td>
<label><input type="checkbox" name="language" value="Ruby">Ruby</label>
</td>
</tr>
<tr>
<td>
<label><input type="checkbox" name="language" value="R言語">R言語</label>
</td>
<td>
<label><input type="checkbox" name="language" value="Kotlin">Kotlin</label>
</td>
<td>
<label><input type="checkbox" name="language" value="Go">Go</label>
</td>
<td>
<label><input type="checkbox" name="language" value="その他">その他</label>
</td>
</tr>
</table>

使用理由<br>
<table class="purpose-tag">
<tr>
<td>
<label><input type="checkbox" name="purpose" value="プログラミング">プログラミング</label>
</td>
<td>
<label><input type="checkbox" name="purpose" value="資格">資格</label>
</td>
<td>
<label><input type="checkbox" name="purpose" value="システム開発">システム開発</label>
</td>
<td>
<label><input type="checkbox" name="purpose" value="業界研究">業界研究</label>
</td>
</tr>
<tr>
<td>
<label><input type="checkbox" name="purpose" value="ITニュース">ITニュース</label>
</td>
<td>
<label><input type="checkbox" name="purpose" value="キャリア">キャリア</label>
</td>
<td>
<label><input type="checkbox" name="purpose" value="データベース">データベース</label>
</td>
<td>
<label><input type="checkbox" name="purpose" value="Officeスキル">Officeスキル</label>
</td>
</tr>
<tr>
<td>
<label><input type="checkbox" name="purpose" value="セキュリティ">セキュリティ</label>
</td>
<td>
<label><input type="checkbox" name="purpose" value="OS">OS</label>
</td>
<td>
<label><input type="checkbox" name="purpose" value="その他">その他</label>
</td>
</tr>
<label></table>

資格<br>
<table class="certification-tag">
<tr>
<td>
<label><input type="checkbox" name="certification" value="ITパスポート">ITパスポート</label>
</td>
<td>
<label><input type="checkbox" name="certification" value="情報セキュリティマネジメント試験">情報セキュリティマネジメント試験</label>
</td>
<td>
<label><input type="checkbox" name="certification" value="基本情報技術者試験">基本情報技術者試験</label>
</td>
<td>
<label><input type="checkbox" name="certification" value="応用情報技術者試験">応用情報技術者試験</label>
</td>
</tr>
<tr>
<td>
<label><input type="checkbox" name="certification" value="ITストラテジスト試験">ITストラテジスト試験</label>
</td>
<td>
<label><input type="checkbox" name="certification" value="システムアーキテクト試験">システムアーキテクト試験</label>
</td>
<td>
<label><input type="checkbox" name="certification" value="プロジェクトマネージャ試験">プロジェクトマネージャ試験</label>
</td>
<td>
<label><input type="checkbox" name="certification" value="ネットワークスペシャリスト試験">ネットワークスペシャリスト試験</label>
</td>
</tr>
<tr>
<td>
<label><input type="checkbox" name="certification" value="データベーススペシャリスト試験">データベーススペシャリスト試験</label>
</td>
<td>
<label><input type="checkbox" name="certification" value="エンベデッドシステムスペシャリスト試験">エンベデッドシステムスペシャリスト試験</label>
</td>
<td>
<label><input type="checkbox" name="certification" value="ITサービスマネージャ試験">ITサービスマネージャ試験</label>
</td>
<td>
<label><input type="checkbox" name="certification" value="システム監査技術者試験">システム監査技術者試験</label>
</td>
</tr>
<tr>
<td>
<label><input type="checkbox" name="certification" value="情報処理安全確保支援士試験">情報処理安全確保支援士試験</label>
</td>
<td>
<label><input type="checkbox" name="certification" value="その他">その他</label>
</td>
</tr>
<tr>
<td>
プログラミング歴<br>
<select name="career">
<option value="">---</option>
<option value="入門：文法を勉強中">入門：文法を勉強中</option>
<option value="初級：簡単なプログラムを書ける">初級：簡単なプログラムを書ける</option>
<option value="中級：業務経験がある">中級：業務経験がある</option>
<option value="上級：上流工程の仕事も担当できる">上級：上流工程の仕事も担当できる</option>
<option value="エキスパート：リーダーとして開発できる">エキスパート：リーダーとして開発できる</option>
</select>
</td>
</tr>
<tr>
<td>
本文<br>
<input type="file" name="img" style="display:none"><img src="/D2sample/img/image.png" width="30px">
<textarea name="text" placeholder="本文">${article.text}</textarea>
</td>
</tr>
<tr>
<td>
<input type="submit" name="SUBMIT" value="削除">
</td>
<td>
<input type="submit" name="SUBMIT" value="プレビュー">
</td>
</tr>
</table>
</form>
</main>
<footer>
</footer>
</body>
</html>