package dao;

import java.util.ArrayList;

public class ReFlag {
	//引数はフラグ形式の文字列、戻り値の型はStringの配列
	//使用言語をフラグ形式から内容に変更する
	public static String[] languageReFlag(String flag) {
		System.out.println("langFlag:" + flag);
		ArrayList<String> langList = new ArrayList<String>();
		int i = 0;
		char c = flag.charAt(i);

		if(c == '1') {
			langList.add("Java");
		}
		i++;
		c = flag.charAt(i);
		if(c == '2') {
			langList.add("JavaScript");
		}
		i++;
		c = flag.charAt(i);
		if(c == '3') {
			langList.add("TypeScript");
		}
		i++;
		c = flag.charAt(i);
		if(c == '4') {
			langList.add("C/C++");
		}
		i++;
		c = flag.charAt(i);
		if(c == '5') {
			langList.add("C#");
		}
		i++;
		c = flag.charAt(i);
		if(c == '6') {
			langList.add("Python");
		}
		i++;
		c = flag.charAt(i);
		if(c == '7') {
			langList.add("SQL");
		}
		i++;
		c = flag.charAt(i);
		if(c == '8') {
			langList.add("HTML&CSS");
		}
		i++;
		c = flag.charAt(i);
		if(c == '9') {
			langList.add("PHP");
		}
		i++;
		c = flag.charAt(i);
		if(c == 'a') {
			langList.add("Scala");
		}
		i++;
		c = flag.charAt(i);
		if(c == 'b') {
			langList.add("Swift");
		}
		i++;
		c = flag.charAt(i);
		if(c == 'c') {
			langList.add("Ruby");
		}
		i++;
		c = flag.charAt(i);
		if(c == 'd') {
			langList.add("R");
		}
		i++;
		c = flag.charAt(i);
		if(c == 'e') {
			langList.add("Kotlin");
		}
		i++;
		c = flag.charAt(i);
		if(c == 'f') {
			langList.add("Go");
		}
		i++;
		c = flag.charAt(i);
		if(c == 'g') {
			langList.add("その他");
		}

		return langList.toArray(new String[langList.size()]);

	}

	//引数はフラグ形式の文字列、戻り値の型はStringの配列
	//使用目的をフラグ形式から内容に変更する
	public static String[] purposeReFlag(String flag) {
		ArrayList<String> purpList = new ArrayList<String>();
		int i = 0;
		char c = flag.charAt(i);

		if(c == '1') {
			purpList.add("プログラミング");
		}
		i++;
		c = flag.charAt(i);
		if(c == '2') {
			purpList.add("資格");
		}
		i++;
		c = flag.charAt(i);
		if(c == '3') {
			purpList.add("システム開発");
		}
		i++;
		c = flag.charAt(i);
		if(c == '4') {
			purpList.add("業界研究");
		}
		i++;
		c = flag.charAt(i);
		if(c == '5') {
			purpList.add("ITニュース");
		}
		i++;
		c = flag.charAt(i);
		if(c == '6') {
			purpList.add("キャリア");
		}
		i++;
		c = flag.charAt(i);
		if(c == '7') {
			purpList.add("データベース");
		}
		i++;
		c = flag.charAt(i);
		if(c == '8') {
			purpList.add("Officeスキル");
		}
		i++;
		c = flag.charAt(i);
		if(c == '9') {
			purpList.add("セキュリティ");
		}
		i++;
		c = flag.charAt(i);
		if(c == 'a') {
			purpList.add("OS");
		}
		i++;
		c = flag.charAt(i);
		if(c == 'b') {
			purpList.add("その他");
		}

		return purpList.toArray(new String[purpList.size()]);

	}

	//引数はフラグ形式の文字列、戻り値の型はStringの配列
	//資格をフラグ形式から内容に変更する
	public static String[] certificationReFlag(String flag) {
		ArrayList<String> certList = new ArrayList<String>();
		int i = 0;
		char c = flag.charAt(i);

		if(c == '1') {
			certList.add("ITパスポート");
		}
		i++;
		c = flag.charAt(i);
		if(c == '2') {
			certList.add("情報セキュリティマネジメント試験");
		}
		i++;
		c = flag.charAt(i);
		if(c == '3') {
			certList.add("基本情報技術者試験");
		}
		i++;
		c = flag.charAt(i);
		if(c == '4') {
			certList.add("応用情報技術者試験");
		}
		i++;
		c = flag.charAt(i);
		if(c == '5') {
			certList.add("ITストラテジスト試験");
		}
		i++;
		c = flag.charAt(i);
		if(c == '6') {
			certList.add("システムアーキテクト試験");
		}
		i++;
		c = flag.charAt(i);
		if(c == '7') {
			certList.add("プロジェクトマネージャ試験");
		}
		i++;
		c = flag.charAt(i);
		if(c == '8') {
			certList.add("ネットワークスペシャリスト試験");
		}
		i++;
		c = flag.charAt(i);
		if(c == '9') {
			certList.add("データベーススペシャリスト試験");
		}
		i++;
		c = flag.charAt(i);
		if(c == 'a') {
			certList.add("エンベデッドシステムスペシャリスト試験");
		}
		i++;
		c = flag.charAt(i);
		if(c == 'b') {
			certList.add("ITサービスマネージャ試験");
		}
		i++;
		c = flag.charAt(i);
		if(c == 'c') {
			certList.add("システム監査技術者試験");
		}
		i++;
		c = flag.charAt(i);
		if(c == 'd') {
			certList.add("情報処理安全確保支援士試験");
		}
		i++;
		c = flag.charAt(i);
		if(c == 'e') {
			certList.add("その他");
		}

		return certList.toArray(new String[certList.size()]);
	}

}
