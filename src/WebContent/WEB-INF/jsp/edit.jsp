<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>記事編集</title>
</head>
<body>
<h1>記事編集</h1>
<main>
<%
	String[] allLang = {"Java", "JavaScript", "TypeScript", "C++(C)",
						"C#", "Python", "SQL", "HTML&CSS",
						"PHP", "Scala", "Swift", "Ruby",
						"R言語", "Kotlin", "Go", "その他"};
	String[] allPurp = {"プログラミング", "資格", "システム開発", "業界研究",
						"ITニュース", "キャリア", "データベース", "Officeスキル",
						"セキュリティ", "OS", "その他"};
	String[] allCert = {"ITパスポート", "情報セキュリティマネジメント試験", "基本情報技術者試験", "応用情報技術者試験",
						"ITストラテジスト試験", "システムアーキテクト試験", "プロジェクトマネージャ試験", "ネットワークスペシャリスト試験",
						"データベーススペシャリスト試験", "エンベデッドシステムスペシャリスト試験", "ITサービスマネージャ試験", "システム監査技術者試験",
						"情報処理安全確保支援士試験", "その他"};
	String[] allCareer = {"入門：文法を勉強中", "初級：簡単なプログラムを書ける", "中級：業務経験がある",
						"上級：上流工程の仕事も担当できる", "エキスパート：リーダーとして開発できる"};
	request.setAttribute("allLang", allLang);
	request.setAttribute("allPurp", allPurp);
	request.setAttribute("allCert", allCert);
	request.setAttribute("allCareer", allCareer);
%>
<!-- 編集前の記事（チェックボックス部分）をjsで持ってくる？ -->

記事タイトル<br>
<form method="POST" action="product_D2/EditServlet" id="form">
<label><input type="text" name="title" value="${article.articleTitle}" placeholder="記事タイトル"></label>
<h2>タグ選択</h2>
言語<br>
<table class=language-tag>
<c:forEach var="lang" items="${allLang}" varStatus="st">
	<c:set var="flag" value="f" />
	<c:if test="${st.index % 4 == 0}">
		<tr>
	</c:if>
	<td>
	<c:forEach var="l" items="${article.articleLanguage}">
		<c:if test="${l == lang}">
			<label><input type="checkbox" name="language" value="${lang}" checked>
			<c:out value="${lang}" /></label>
			<c:set var="flag" value="t" />
		</c:if>
	</c:forEach>
	<c:if test="${flag == 'f'}">
		<label><input type="checkbox" name="language" value="${lang}">
		<c:out value="${lang}" /></label>
	</c:if>
	</td>
	<c:if test="${st.index % 4 == 3}">
		</tr>
	</c:if>
</c:forEach>
</table>

使用理由<br>
<table class="purpose-tag">
<c:forEach var="purp" items="${allPurp}" varStatus="st">
	<c:set var="flag" value="f" />
	<c:if test="${st.index % 4 == 0}">
		<tr>
	</c:if>
	<td>
	<c:forEach var="p" items="${article.articlePurpose}">
		<c:if test="${p == purp}">
			<label><input type="checkbox" name="purpose" value="${purp}" checked>
			<c:out value="${purp}" /></label>
			<c:set var="flag" value="t" />
		</c:if>
	</c:forEach>
	<c:if test="${flag == 'f'}">
		<label><input type="checkbox" name="purpose" value="${purp}">
		<c:out value="${purp}" /></label>
	</c:if>
	</td>
	<c:if test="${st.index % 4 == 3}">
		</tr>
	</c:if>
	<c:if test="${st.last}">
		<td></td>
		</tr>
	</c:if>
</c:forEach>
</table>

資格<br>
<table class="certification-tag">
<c:forEach var="cert" items="${allCert}" varStatus="st">
	<c:set var="flag" value="f" />
	<c:if test="${st.index % 4 == 0}">
		<tr>
	</c:if>
	<td>
	<c:forEach var="c" items="${article.articleCertification}">
		<c:if test="${c == cert}">
			<label><input type="checkbox" name="certification" value="${cert}" checked>
			<c:out value="${cert}" /></label>
			<c:set var="flag" value="t" />
		</c:if>
	</c:forEach>
	<c:if test="${flag == 'f'}">
		<label><input type="checkbox" name="certification" value="${cert}">
		<c:out value="${cert}" /></label>
	</c:if>
	</td>
	<c:if test="${st.index % 4 == 3}">
		</tr>
	</c:if>
	<c:if test="${st.last}">
		<td></td>
		<td></td>
		</tr>
	</c:if>
</c:forEach>
</table>
プログラミング歴<br>
<select name="career">
<c:forEach var="car" items="${allCareer}">
	<c:choose>
		<c:when test="${car == article.articleCareer}">
			<option value="${car}" selected><c:out value="${car}" /></option>
		</c:when>
		<c:otherwise>
			<option value="${car}"><c:out value="${car}" /></option>
		</c:otherwise>
	</c:choose>
</c:forEach>
</select><br>
本文<br>
<input type="file" name="img" style="display:none"><img src="/D2sample/img/image.png" width="30px">
<textarea name="text" placeholder="本文">${article.text}</textarea><br>
<input type="submit" name="SUBMIT" value="削除">
<input type="submit" name="SUBMIT" value="プレビュー">
</form>
</main>
<footer>
</footer>
</body>
</html>