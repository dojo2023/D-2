<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="/product_D2/css/create.css">
        <title>コミュニティ作成</title>
    </head>
    <body>

        <form method="POST" action="/product_D2/CommunityCreateServlet">

        <p>コミュニティ名<br>
        <input type="text" name="community_name"></p>

        <p>タグ<br>
            使用言語<br>
            <table>
            <tr>
            <td><input type="checkbox" name="language" value="Java">Java</td>
            <td><input type="checkbox" name="language" value="JavaScript">JavaScript</td>
            <td><input type="checkbox" name="language" value="TypeScript">TypeScript</td>
            <td><input type="checkbox" name="language" value="">C++(C)</td>
            </tr>
            <tr>
            <td><input type="checkbox" name="language" value="C#">C#</td>
            <td><input type="checkbox" name="language" value="Python">Python</td>
            <td><input type="checkbox" name="language" value="SQL">SQL</td>
            <td><input type="checkbox" name="language" value="HTML&CSSPHP">HTML&CSSPHP</td>
            </tr>
            <tr>
            <td><input type="checkbox" name="language" value="Scala">Scala</td>
            <td><input type="checkbox" name="language" value="Swift">Swift</td>
            <td><input type="checkbox" name="language" value="Ruby">Ruby</td>
            <td><input type="checkbox" name="language" value="R言語">R言語</td>
            </tr>
            <tr>
            <td><input type="checkbox" name="language" value="Kotlin">Kotlin</td>
            <td><input type="checkbox" name="language" value="Go">Go</td>
            <td><input type="checkbox" name="language" value="その他">その他</td>
            </tr>
            </table>

            <br>使用理由<br>
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

            <br>取りたい資格<br>
            <input type="checkbox" name="certification" value="ITパスポート">ITパスポート
            <input type="checkbox" name="certification" value="情報セキュリティマネジメント試験">情報セキュリティマネジメント試験
            <input type="checkbox" name="certification" value="基本情報技術者試験">基本情報技術者試験
            <input type="checkbox" name="certification" value="応用情報技術者試験">応用情報技術者試験
            <br>
            <input type="checkbox" name="certification" value="ストラテジスト試験">ITストラテジスト試験
            <input type="checkbox" name="certification" value="システムアーキテクト試験">システムアーキテクト試験
            <input type="checkbox" name="certification" value="プロジェクトマネージャ試験">プロジェクトマネージャ試験
            <input type="checkbox" name="certification" value="ネットワークスペシャリスト試験">ネットワークスペシャリスト試験
            <br>
            <input type="checkbox" name="certification" value="データベーススペシャリスト試験">データベーススペシャリスト試験
            <input type="checkbox" name="certification" value="エンベデッドシステムスペシャリスト試験">エンベデッドシステムスペシャリスト試験
            <input type="checkbox" name="certification" value="ITサービスマネージャ試験">ITサービスマネージャ試験
            <input type="checkbox" name="certification" value="システム監査技術者試験">システム監査技術者試験
            <br>
            <input type="checkbox" name="certification" value="情報処理安全確保支援士試験">情報処理安全確保支援士試験
            <input type="checkbox" name="certification" value="その他">その他

            <br>プログラミング歴<br>
            <select name="career">
                <option value="入門">入門：文法を勉強中</option>
                <option value="初級">初級：簡単なプログラムを書ける</option>
                <option value="中級">中級：業務経験がある</option>
                <option value="上級">上級：上流工程の仕事も担当できる</option>
                <option value="エキスパート">エキスパート：リーダーとして開発できる</option>
            </select>
        </p>

        <p>コミュニティの概要<br>
        <input type="text" name="community_summary"></p>

        <input type="submit" name="REGIST" value="確認"><br>
        </form>


    </body>
</html>