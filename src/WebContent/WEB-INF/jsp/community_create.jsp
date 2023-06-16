<!-- 6/15 13:09 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/common.css">
        <link rel="stylesheet" href="css/create.css">
        <title>コミュニティ作成|with IT</title>
    </head>
    <body>
<header>
<div class="header">
	<a href="/product_D2/TopServlet"><img src="image/logo.png" class="logo_contents" width="10%" height="10%"></a>
</div>
</header>
<div class="create_main">
        <form method="POST" action="/product_D2/CommunityCreateServlet" id='form'>

        <hr>
        <h4>コミュニティ名</h4><br>
        <input type="text"  class="textform" name="community_name" id="community_name" onkeyup="counter('community_name','count1')">
        <span id="count1">0</span>/30</p>
        <p id="output1"></p>

        <hr>
        <h4>タグ</h4><br>
        <div class="contentA">
        使用言語<br>
            <table>
            <tr>
            <td><input type="checkbox" class="tag" name="language" value="Java">Java</td>
            <td><input type="checkbox" class="tag" name="language" value="JavaScript">JavaScript</td>
            <td><input type="checkbox" class="tag" name="language" value="TypeScript">TypeScript</td>
            <td><input type="checkbox" class="tag" name="language" value="C++(C)">C++(C)</td>
            </tr>
            <tr>
            <td><input type="checkbox" class="tag" name="language" value="C#">C#</td>
            <td><input type="checkbox" class="tag" name="language" value="Python">Python</td>
            <td><input type="checkbox" class="tag" name="language" value="SQL">SQL</td>
            <td><input type="checkbox" class="tag" name="language" value="HTML&CSS">HTML&amp;CSS</td>
            </tr>
            <tr>
            <td><input type="checkbox" class="tag" name="language" value="PHP">PHP</td>
            <td><input type="checkbox" class="tag" name="language" value="Scala">Scala</td>
            <td><input type="checkbox" class="tag" name="language" value="Swift">Swift</td>
            <td><input type="checkbox" class="tag" name="language" value="Ruby">Ruby</td>
            </tr>
            <tr>
            <td><input type="checkbox" class="tag" name="language" value="R言語">R言語</td>
            <td><input type="checkbox" class="tag" name="language" value="Kotlin">Kotlin</td>
            <td><input type="checkbox" class="tag" name="language" value="Go">Go</td>
            <td><input type="checkbox" class="tag" name="language" value="その他">その他</td>
            </tr>
            </table>
        </div>

        <div class="contentB">
            <br>使用理由<br>
            <table>
            <tr>
            <td><input type="checkbox" class="tag" name="purpose" value="プログラミング">プログラミング</td>
            <td><input type="checkbox" class="tag" name="purpose" value="資格">資格</td>
            <td><input type="checkbox" class="tag" name="purpose" value="システム開発">システム開発</td>
            <td><input type="checkbox" class="tag" name="purpose" value="業界研究">業界研究</td>
            </tr>
            <tr>
            <td><input type="checkbox" class="tag" name="purpose" value="ITニュース">ITニュース</td>
            <td><input type="checkbox" class="tag" name="purpose" value="キャリア">キャリア</td>
            <td><input type="checkbox" class="tag" name="purpose" value="データベース">データベース</td>
            <td><input type="checkbox" class="tag" name="purpose" value="Officeスキル">Officeスキル</td>
            </tr>
            <tr>
            <td><input type="checkbox" class="tag" name="purpose" value="セキュリティ">セキュリティ</td>
            <td><input type="checkbox" class="tag" name="purpose" value="OS">OS</td>
            <td><input type="checkbox" class="tag" name="purpose" value="その他">その他</td>
            </tr>
            </table>
        </div>

        <div class="contentC">
        <br>取りたい資格<br>
            <table>
            <tr>
            <td><input type="checkbox" class="tag" name="certification" value="ITパスポート">ITパスポート</td>
            <td><input type="checkbox" class="tag" name="certification" value="情報セキュリティマネジメント試験">情報セキュリティマネジメント試験</td>
            <td><input type="checkbox" class="tag" name="certification" value="基本情報技術者試験">基本情報技術者試験</td>
            <td><input type="checkbox" class="tag" name="certification" value="応用情報技術者試験">応用情報技術者試験</td>
            </tr>
            <tr>
            <td><input type="checkbox" class="tag" name="certification" value="ストラテジスト試験">ITストラテジスト試験</td>
            <td><input type="checkbox" class="tag" name="certification" value="システムアーキテクト試験">システムアーキテクト試験</td>
            <td><input type="checkbox" class="tag" name="certification" value="プロジェクトマネージャ試験">プロジェクトマネージャ試験</td>
            <td><input type="checkbox" class="tag" name="certification" value="ネットワークスペシャリスト試験">ネットワークスペシャリスト試験</td>
            </tr>
            <tr>
            <td><input type="checkbox" class="tag" name="certification" value="データベーススペシャリスト試験">データベーススペシャリスト試験</td>
            <td><input type="checkbox" class="tag" name="certification" value="エンベデッドシステムスペシャリスト試験">エンベデッドシステムスペシャリスト試験</td>
            <td><input type="checkbox" class="tag" class="tag" name="certification" value="ITサービスマネージャ試験">ITサービスマネージャ試験</td>
            <td><input type="checkbox" class="tag" name="certification" value="システム監査技術者試験">システム監査技術者試験</td>
            </tr>
            <tr>
            <td><input type="checkbox" name="certification" value="情報処理安全確保支援士試験">情報処理安全確保支援士試験</td>
            <td><input type="checkbox" name="certification" value="その他">その他</td>
			</tr>
			</table>
        </div>

        <div class="contentD">
        <br>プログラミング歴<br>
            <select name="career" class="select" id="tag">
                <option value="">---</option>
                <option value="入門：文法を勉強中">入門：文法を勉強中</option>
                <option value="初級：簡単なプログラムを書ける">初級：簡単なプログラムを書ける</option>
                <option value="中級：業務経験がある">中級：業務経験がある</option>
                <option value="上級：上流工程の仕事も担当できる">上級：上流工程の仕事も担当できる</option>
                <option value="エキスパート：リーダーとして開発できる">エキスパート：リーダーとして開発できる</option>
            </select>
        </div>
		<p id=outputTag></p>
        <hr>
        <h4>コミュニティの概要</h4><br>
        <input type="text" name="community_summary" class= "textbox" id="community_summary" onkeyup="counter('community_summary','count2')">
        <span id="count2">0</span>/100</p>
        <p id="output2">

        <hr>
        <div class="btn_wrap">
        <input class="btn" type="submit" name="REGIST" value="入力した内容を確認する"><br>
        </div>
        </form>
    </div>
    </div>

<div class="footer_all">
<footer class="footer">
	<img class="footer_logo" src="image/logo.png"  width="10%" height="10%">
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

<script src="/product_D2/js/community_create.js"></script>

    </body>
</html>