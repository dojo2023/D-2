package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Article;

public class ArticleDao {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Article> select(Article param) {
		Connection conn = null;
		List<Article> articleList = new ArrayList<Article>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/myBC", "sa", "");

			// SQL文を準備する
			String sql = "select , article_title, article_creat, article_language, article_purpose, article_career, article_certification, article_favs, article_text from article_title like ? and article_creat like ? and article_language like ? and article_purpose like ? and article_career like ? and article_certification like ? and article_favs like ? and article_text like ? order by article_id";
			PreparedStatement pStmt = conn.prepareStatement(sql);


			/*検索キーワードをタグリストと一致するか調べる。
			 * 一致すれば空の配列に1、一致しなければ0を足していきフラグを作成
			 * 作成したフラグで検索*/


			// SQL文を完成させる
			if (param.getNumber() != null) {
				pStmt.setString(1, "%" + param.getNumber() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getName() != null) {
				pStmt.setString(2, "%" + param.getName() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getAddress() != null) {
				pStmt.setString(3, "%" + param.getAddress() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Bc card = new Bc(
				rs.getString("NUMBER"),
				rs.getString("NAME"),
				rs.getString("ADDRESS")
				);
				cardList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}

		// 結果を返す
		return cardList;
	}

}
//引数ありでデータをデータベースに登録する。
public boolean insert(Article data) {
	String language;
	String purpose;
	String certification;
	Connection conn = null;
	boolean result = false;


	try {
		//JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		//データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/mybc", "sa", "");

		//配列になっている使用言語をフラグ形式に変換。
		language = Flag.languageFlag(data.getArticleLanguage());

		//配列になっている使用理由をフラグ形式に変換。
		purpose = Flag.purposeFlag(data.getArticlePurpose());

		//配列になっている使用理由をフラグ形式に変換。
		certification = Flag.certificationFlag(data.getArticleCertification());

		//SQL文を準備する
		String sql = "insert into article( article_title, user_id, article_create, article_update, article_language, article_purpose, article_career, article_certification, article_favs, article_text, article_img1, article_img2, article_img3) values(?,?,?,?,?,?,?,?,?,?,?,?,?);";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		//SQL文を完成させる
		pStmt.setString(1, data.getArticleTitle());
		pStmt.setString(2, data.getUserId());
		pStmt.setString(3, "current_timestamp");
		pStmt.setString(4, "current_timestamp");
		pStmt.setString(5, language);
		pStmt.setString(6,  purpose);
		pStmt.setString(7, data.getArticleCareer());
		pStmt.setString(8, certification);
		pStmt.setInt(9, data.getArticleFavs());
		pStmt.setString(10, data.getArticleText());
		pStmt.setString(11, data.getArticleImg1());
		pStmt.setString(12, data.getArticleImg2());
		pStmt.setString(13, data.getArticleImg3());
		pStmt.executeUpdate();
		result = true;

	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	finally {
		//データベース切断
		if(conn != null) {
			try {
				conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
				result = false;
			}
		}
	}

	//結果を返す
	return result;
}

//引数ありでデータをデータベースに登録する。
	public boolean update(Article data) {
		String language;
		String purpose;
		String certification;
		Connection conn = null;
		boolean result = false;


		try {
			//JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			//データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/mybc", "sa", "");

			//配列になっている使用言語をフラグ形式に変換。
			language = Flag.languageFlag(data.getArticleLanguage());

			//配列になっている使用理由をフラグ形式に変換。
			purpose = Flag.purposeFlag(data.getArticlePurpose());

			//配列になっている使用理由をフラグ形式に変換。
			certification = Flag.certificationFlag(data.getArticleCertification());

			//SQL文を準備する
			String sql = "update article set article_title=?, article_language=?, article_purpose=?, article_career=?, article_certification=?, article_favs=?, article_text=?, article_img1=?, article_img2=?, article_img3=? where article_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			pStmt.setString(1, data.getArticleTitle());
			pStmt.setString(2, language);
			pStmt.setString(3, purpose);
			pStmt.setString(4, data.getArticleCareer());
			pStmt.setString(5, certification);
			pStmt.setInt(6, data.getArticleFavs());
			pStmt.setString(7, data.getArticleText());
			pStmt.setString(8, data.getArticleImg1());
			pStmt.setString(9, data.getArticleImg2());
			pStmt.setString(10, data.getArticleImg3());
			pStmt.setString(11, data.getArticleImg3());
			pStmt.executeUpdate();
			result = true;

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			//データベース切断
			if(conn != null) {
				try {
					conn.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
					result = false;
				}
			}
		}

		//結果を返す
		return result;
	}

//記事idから一致する記事のデータを持ってくる
	public Article load(int id){
		String language, purpose, certification;
		String lang_data[] = new String[16];
		String purp_data[] = new String[11];
		String cert_data[] = new String[14];
		Connection conn = null;
		Article data;

		try {
			//JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			//データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/mybc", "sa", "");

			//SQL文を準備する
			String sql = "select * from article where article_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			pStmt.setInt(1,id);
			ResultSet rs = pStmt.executeQuery();

			//フラグ形式のデータをString型の変数に入れる
			language = rs.getString("article_language");
			purpose = rs.getString("article_purpose");
			certification = rs.getString("article_certification");

			//フラグ形式のデータを日本語に戻し、配列に入れる。
			lang_data = ReFlag.languageReFlag(language);
			purp_data = ReFlag.purposeReFlag(purpose);
			cert_data = ReFlag.certificationReFlag(certification);

			//結果表をArticle型の変数にコピー
				data = new Article(
					rs.getInt("article_id"),
					rs.getString("artcile_title"),
					rs.getString("user_id"),
					rs.getString("article_create"),
					rs.getString("article_update"),
					lang_data,
					purp_data,
					rs.getString("article_career"),
					cert_data,
					rs.getInt("article_favs"),
					rs.getString("article_text"),
					rs.getString("article_img1"),
					rs.getString("article_img2"),
					rs.getString("article_img3")
					);
		}
		catch(SQLException e) {
			e.printStackTrace();
			data = null;
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			data = null;
		}
		finally {
			//データベースを切断
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					data = null;
				}
			}
		}

		//結果を返す
		return data;

	}

	//引数の記事idと一致する記事を削除する
			public boolean delete(int id){
				boolean result = false;
				Connection conn = null;


				try {
					//JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					//データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/mybc", "sa", "");

					//SQL文を準備する
					String sql = "delete from article where article_id = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					//SQL文を完成させる
					if(pStmt.executeUpdate()==1) {
						result = true;
					}
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
				catch(ClassNotFoundException e) {
					e.printStackTrace();
				}
				finally {
					//データベースを切断
					if(conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}

				//結果を返す
				return result;

			}
}
