package dao;

public class ReFlag {
	//引数はフラグ形式の文字列、戻り値の型はStringの配列
	//使用言語をフラグ形式から内容に変更する
	public static String[] languageReFlag(String flag) {
		String[] language = new String[16];
		int i = 0;
		char c = flag.charAt(i);

		if(c == '1') {
			language[i] = "Java";
		} else if(c == '0') {
			language[i] = "";
		}
		i++;
		if(c == '1') {
			language[i] = "JavaScript";
		} else if(c == '0') {
			language[i] = "";
		}
		i++;
		if(c == '1') {
			language[i] = "TypeScript";
		} else if(c == '0') {
			language[i] = "";
		}
		i++;
		if(c == '1') {
			language[i] = "C++(C)";
		} else if(c == '0') {
			language[i] = "";
		}
		i++;
		if(c == '1') {
			language[i] = "C#";
		} else if(c == '0') {
			language[i] = "";
		}
		i++;
		if(c == '1') {
			language[i] = "Python";
		} else if(c == '0') {
			language[i] = "";
		}
		i++;
		if(c == '1') {
			language[i] = "SQL";
		} else if(c == '0') {
			language[i] = "";
		}
		i++;
		if(c == '1') {
			language[i] = "HTML&CSS";
		} else if(c == '0') {
			language[i] = "";
		}
		i++;
		if(c == '1') {
			language[i] = "PHP";
		} else if(c == '0') {
			language[i] = "";
		}
		i++;
		if(c == '1') {
			language[i] = "Scala";
		} else if(c == '0') {
			language[i] = "";
		}
		i++;
		if(c == '1') {
			language[i] = "Swift";
		} else if(c == '0') {
			language[i] = "";
		}
		i++;
		if(c == '1') {
			language[i] = "Ruby";
		} else if(c == '0') {
			language[i] = "";
		}
		i++;
		if(c == '1') {
			language[i] = "R言語";
		} else if(c == '0') {
			language[i] = "";
		}
		i++;
		if(c == '1') {
			language[i] = "Kotolin";
		} else if(c == '0') {
			language[i] = "";
		}
		i++;
		if(c == '1') {
			language[i] = "Go";
		} else if(c == '0') {
			language[i] = "";
		}
		i++;
		if(c == '1') {
			language[i] = "その他";
		} else if(c == '0') {
			language[i] = "";
		}

		return language;

	}

	//引数はフラグ形式の文字列、戻り値の型はStringの配列
	//使用目的をフラグ形式から内容に変更する
	public static String[] purposeReFlag(String flag) {
		String[] purpose = new String[11];
		int i = 0;
		char c = flag.charAt(i);

		if(c == '1') {
			purpose[i] = "プログラミング";
		} else if(c == '0') {
			purpose[i] = "";
		}
		i++;
		if(c == '1') {
			purpose[i] = "資格";
		} else if(c == '0') {
			purpose[i] = "";
		}
		i++;if(c == '1') {
			purpose[i] = "システム開発";
		} else if(c == '0') {
			purpose[i] = "";
		}
		i++;if(c == '1') {
			purpose[i] = "業界研究";
		} else if(c == '0') {
			purpose[i] = "";
		}
		i++;if(c == '1') {
			purpose[i] = "ITニュース";
		} else if(c == '0') {
			purpose[i] = "";
		}
		i++;if(c == '1') {
			purpose[i] = "キャリア";
		} else if(c == '0') {
			purpose[i] = "";
		}
		i++;if(c == '1') {
			purpose[i] = "データベース";
		} else if(c == '0') {
			purpose[i] = "";
		}
		i++;if(c == '1') {
			purpose[i] = "Officeスキル";
		} else if(c == '0') {
			purpose[i] = "";
		}
		i++;if(c == '1') {
			purpose[i] = "セキュリティ";
		} else if(c == '0') {
			purpose[i] = "";
		}
		i++;if(c == '1') {
			purpose[i] = "OS";
		} else if(c == '0') {
			purpose[i] = "";
		}
		i++;if(c == '1') {
			purpose[i] = "その他";
		} else if(c == '0') {
			purpose[i] = "";
		}

		return purpose;

	}

	//引数はフラグ形式の文字列、戻り値の型はStringの配列
	//資格をフラグ形式から内容に変更する
	public static String[] certificationReFlag(String flag) {
		String[] certification = new String[14];
		int i = 0;
		char c = flag.charAt(i);

		if(c == '1') {
			certification[i] = "ITパスポート";
		} else if(c == '0') {
			certification[i] = "";
		}
		i++;
		if(c == '1') {
			certification[i] = "情報セキュリティマネジメント試験";
		} else if(c == '0') {
			certification[i] = "";
		}
		i++;
		if(c == '1') {
			certification[i] = "基本情報技術者試験";
		} else if(c == '0') {
			certification[i] = "";
		}
		i++;
		if(c == '1') {
			certification[i] = "応用情報技術者試験";
		} else if(c == '0') {
			certification[i] = "";
		}
		i++;if(c == '1') {
			certification[i] = "ITストラテジスト試験";
		} else if(c == '0') {
			certification[i] = "";
		}
		i++;if(c == '1') {
			certification[i] = "システムアーキテクト試験";
		} else if(c == '0') {
			certification[i] = "";
		}
		i++;if(c == '1') {
			certification[i] = "プロジェクトマネージャ試験";
		} else if(c == '0') {
			certification[i] = "";
		}
		i++;if(c == '1') {
			certification[i] = "ネットワークスペシャリスト試験";
		} else if(c == '0') {
			certification[i] = "";
		}
		i++;if(c == '1') {
			certification[i] = "データベーススペシャリスト試験";
		} else if(c == '0') {
			certification[i] = "";
		}
		i++;if(c == '1') {
			certification[i] = "エンベデッドシステムスペシャリスト試験";
		} else if(c == '0') {
			certification[i] = "";
		}
		i++;if(c == '1') {
			certification[i] = "ITサービスマネージャ試験";
		} else if(c == '0') {
			certification[i] = "";
		}
		i++;if(c == '1') {
			certification[i] = "システム監査技術者試験";
		} else if(c == '0') {
			certification[i] = "";
		}
		i++;if(c == '1') {
			certification[i] = "情報処理安全確保支援士試験";
		} else if(c == '0') {
			certification[i] = "";
		}
		i++;if(c == '1') {
			certification[i] = "その他";
		} else if(c == '0') {
			certification[i] = "";
		}

		return certification;
	}

}
