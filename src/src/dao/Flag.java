package dao;

import java.util.Arrays;

public class Flag {
	public static String languageFlag(String[] language) {
		String flag = "";
		if (Arrays.asList(language).contains("Java")) {
			flag += "1";
		} else {
			flag += "0";
		}
		if (Arrays.asList(language).contains("JavaScript")) {
			flag += "2";
		} else {
			flag += "0";
		}
		if (Arrays.asList(language).contains("TypeScript")) {
			flag += "3";
		} else {
			flag += "0";
		}
		if (Arrays.asList(language).contains("C/C++")) {
			flag += "4";
		} else {
			flag += "0";
		}
		if (Arrays.asList(language).contains("C#")) {
			flag += "5";
		} else {
			flag += "0";
		}
		if (Arrays.asList(language).contains("Python")) {
			flag += "6";
		} else {
			flag += "0";
		}
		if (Arrays.asList(language).contains("SQL")) {
			flag += "7";
		} else {
			flag += "0";
		}
		if (Arrays.asList(language).contains("HTML&CSS")) {
			flag += "8";
		} else {
			flag += "0";
		}
		if (Arrays.asList(language).contains("PHP")) {
			flag += "9";
		} else {
			flag += "0";
		}
		if (Arrays.asList(language).contains("Scala")) {
			flag += "a";
		} else {
			flag += "0";
		}
		if (Arrays.asList(language).contains("Swift")) {
			flag += "b";
		} else {
			flag += "0";
		}
		if (Arrays.asList(language).contains("Ruby")) {
			flag += "c";
		} else {
			flag += "0";
		}
		if (Arrays.asList(language).contains("R")) {
			flag += "d";
		} else {
			flag += "0";
		}
		if (Arrays.asList(language).contains("Kotlin")) {
			flag += "e";
		} else {
			flag += "0";
		}
		if (Arrays.asList(language).contains("Go")) {
			flag += "f";
		} else {
			flag += "0";
		}
		if (Arrays.asList(language).contains("その他")) {
			flag += "g";
		} else {
			flag += "0";
		}
		System.out.println(Arrays.asList(language).contains("Java"));
		System.out.println(Arrays.asList(language).contains("JavaScript"));
		System.out.println(Arrays.asList(language).contains("TypeScript"));
		System.out.println(Arrays.asList(language).contains("C/C++"));
		System.out.println(Arrays.asList(language).contains("C#"));
		System.out.println(Arrays.asList(language).contains("Python"));
		System.out.println(Arrays.asList(language).contains("SQL"));
		System.out.println(Arrays.asList(language).contains("HTML&CSS"));
		System.out.println(Arrays.asList(language).contains("PHP"));
		System.out.println(Arrays.asList(language).contains("Scala"));
		System.out.println(Arrays.asList(language).contains("Swift"));
		System.out.println(Arrays.asList(language).contains("Ruby"));
		System.out.println(Arrays.asList(language).contains("R"));
		System.out.println(Arrays.asList(language).contains("Kotlin"));
		System.out.println(Arrays.asList(language).contains("Go"));
		System.out.println(Arrays.asList(language).contains("その他"));
		return flag;
	}

	public static String purposeFlag(String[] purpose) {
		String flag = "";
		if (Arrays.asList(purpose).contains("プログラミング")) {
			flag += "1";
		} else {
			flag += "0";
		}
		if (Arrays.asList(purpose).contains("資格")) {
			flag += "2";
		} else {
			flag += "0";
		}
		if (Arrays.asList(purpose).contains("システム開発")) {
			flag += "3";
		} else {
			flag += "0";
		}
		if (Arrays.asList(purpose).contains("業界研究")) {
			flag += "4";
		} else {
			flag += "0";
		}
		if (Arrays.asList(purpose).contains("ITニュース")) {
			flag += "5";
		} else {
			flag += "0";
		}
		if (Arrays.asList(purpose).contains("キャリア")) {
			flag += "6";
		} else {
			flag += "0";
		}
		if (Arrays.asList(purpose).contains("データベース")) {
			flag += "7";
		} else {
			flag += "0";
		}
		if (Arrays.asList(purpose).contains("Officeスキル")) {
			flag += "8";
		} else {
			flag += "0";
		}
		if (Arrays.asList(purpose).contains("セキュリティ")) {
			flag += "9";
		} else {
			flag += "0";
		}
		if (Arrays.asList(purpose).contains("OS")) {
			flag += "a";
		} else {
			flag += "0";
		}
		if (Arrays.asList(purpose).contains("その他")) {
			flag += "b";
		} else {
			flag += "0";
		}
		return flag;
	}

	public static String certificationFlag(String[] certification) {
		String flag = "";
		if (Arrays.asList(certification).contains("ITパスポート")) {
			flag += "1";
		} else {
			flag += "0";
		}
		if (Arrays.asList(certification).contains("情報セキュリティマネジメント試験")) {
			flag += "2";
		} else {
			flag += "0";
		}
		if (Arrays.asList(certification).contains("基本情報技術者試験")) {
			flag += "3";
		} else {
			flag += "0";
		}
		if (Arrays.asList(certification).contains("応用情報技術者試験")) {
			flag += "4";
		} else {
			flag += "0";
		}
		if (Arrays.asList(certification).contains("ITストラテジスト試験")) {
			flag += "5";
		} else {
			flag += "0";
		}
		if (Arrays.asList(certification).contains("システムアーキテクト試験")) {
			flag += "6";
		} else {
			flag += "0";
		}
		if (Arrays.asList(certification).contains("プロジェクトマネージャ試験")) {
			flag += "7";
		} else {
			flag += "0";
		}
		if (Arrays.asList(certification).contains("ネットワークスペシャリスト試験")) {
			flag += "8";
		} else {
			flag += "0";
		}
		if (Arrays.asList(certification).contains("データベーススペシャリスト試験")) {
			flag += "9";
		} else {
			flag += "0";
		}
		if (Arrays.asList(certification).contains("エンベデッドシステムスペシャリスト試験")) {
			flag += "a";
		} else {
			flag += "0";
		}
		if (Arrays.asList(certification).contains("ITサービスマネージャ試験")) {
			flag += "b";
		} else {
			flag += "0";
		}
		if (Arrays.asList(certification).contains("システム監査技術者試験")) {
			flag += "c";
		} else {
			flag += "0";
		}
		if (Arrays.asList(certification).contains("情報処理安全確保支援士試験")) {
			flag += "d";
		} else {
			flag += "0";
		}
		if (Arrays.asList(certification).contains("その他")) {
			flag += "e";
		} else {
			flag += "0";
		}
		return flag;
	}
}
