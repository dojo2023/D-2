package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import model.Article;
import model.Comment;
import model.User;

public class ArticleDao {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public ArrayList<Article> select(String query) {
		Connection conn = null;
		ArrayList<Article> result = new ArrayList<Article>();
		String[] queryArray = query.split("[ 　]+");

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/Data", "sa", "");

			//本文、タイトルで検索をかける

			//sql文を準備
			String sql = "select * from article where";
			String[] setStr = new String[queryArray.length];


			//sql文を完成させる
			for(int i=0; i<queryArray.length; i++) {
				sql += " ?";
				setStr[i] = "concat(article_title, article_text) like %"+ queryArray[i] +"%";
				if(i < queryArray.length-1) {
					sql += " and";
				}
			}
			PreparedStatement pStmt = conn.prepareStatement(sql);
			for (int i=0; i<setStr.length; i++) {
				pStmt.setString(i, setStr[i]);
			}

			//sql文を実行
			ResultSet rs = pStmt.executeQuery();

			//結果表をArticleに保存し、配列に順次入れていく
			while(rs.next()) {
				String language[] = new String[16];
				String purpose[] = new String[11];
				String certification[] = new String[14];
				language = ReFlag.languageReFlag(rs.getString("article_language"));
				purpose = ReFlag.purposeReFlag(rs.getString("article_purpose"));
				certification = ReFlag.certificationReFlag(rs.getString("article_certification"));
				Article data = new Article(
						rs.getInt("article_id"),
						rs.getString("artcile_title"),
						rs.getString("user_id"),
						rs.getString("article_create"),
						rs.getString("article_update"),
						language,
						purpose,
						rs.getString("article_career"),
						certification,
						rs.getInt("article_favs"),
						rs.getString("article_text"),
						rs.getString("article_img1"),
						rs.getString("article_img2"),
						rs.getString("article_img3")
						);
				result.add(data);
			}

			//タグで検索する
			String[] langId= new String[queryArray.length], purpId=new String[queryArray.length], certId=new String[queryArray.length];
			//検索ワードが含まれるタグが存在するかどうかから。

			for(int i=0; i<queryArray.length; i++) {
				sql = "select * from language_list where language_item like %" + queryArray[i] +"%";
				pStmt = conn.prepareStatement(sql);
				//sql文を実行
				rs = pStmt.executeQuery();
				while(rs.next()) {
					langId[i] += rs.getString("language_id");
				}

				sql = "select * from purpose_list where purpose_item like %" + queryArray[i] +"%";
				pStmt = conn.prepareStatement(sql);
				//sql文を実行
				rs = pStmt.executeQuery();
				while(rs.next()) {
					purpId[i] += rs.getString("purpose_id");
				}

				sql = "select * from certification_list where certification_item like %" + queryArray[i] +"%";
				pStmt = conn.prepareStatement(sql);
				//sql文を実行
				rs = pStmt.executeQuery();
				while(rs.next()) {
					certId[i] += rs.getString("certification_id");
				}
			}

			String langIdforSQL="", purpIdforSQL="", certIdforSQL="";
			String comp = "123456789ABCDEFG";
			for(int i=0; i<16; i++) {
				for(int j=0; j<queryArray.length; j++) {
					if(langId[j].indexOf(String.valueOf(comp.charAt(i)))!=-1) {
						langIdforSQL += String.valueOf(comp.charAt(i));
						break;
					}
					if(j==queryArray.length-1) {
						langIdforSQL += "0";
					}
				}
			}
			for(int i=0; i<11; i++) {
				for(int j=0; j<queryArray.length; j++) {
					if(purpId[j].indexOf(String.valueOf(comp.charAt(i)))!=-1) {
						purpIdforSQL += String.valueOf(comp.charAt(i));
						break;
					}
					if(j==queryArray.length-1) {
						purpIdforSQL += "0";
					}
				}
			}
			for(int i=0; i<14; i++) {
				for(int j=0; j<queryArray.length; j++) {
					if(certId[j].indexOf(String.valueOf(comp.charAt(i)))!=-1) {
						certIdforSQL += String.valueOf(comp.charAt(i));
						break;
					}
					if(j==queryArray.length-1) {
						certIdforSQL += "0";
					}
				}
			}

			//SQL文を準備
			sql = "select * from article where article_language like ?";

			langIdforSQL = langIdforSQL.replaceAll("[1-9A-G]", "_");
			pStmt.setString(1, langIdforSQL);
			//SQL文を実行
			rs = pStmt.executeQuery();
			while(rs.next()) {
				String language[] = new String[16];
				String purpose[] = new String[11];
				String certification[] = new String[14];
				language = ReFlag.languageReFlag(rs.getString("article_language"));
				purpose = ReFlag.purposeReFlag(rs.getString("article_purpose"));
				certification = ReFlag.certificationReFlag(rs.getString("article_certification"));
				Article data = new Article(
						rs.getInt("article_id"),
						rs.getString("artcile_title"),
						rs.getString("user_id"),
						rs.getString("article_create"),
						rs.getString("article_update"),
						language,
						purpose,
						rs.getString("article_career"),
						certification,
						rs.getInt("article_favs"),
						rs.getString("article_text"),
						rs.getString("article_img1"),
						rs.getString("article_img2"),
						rs.getString("article_img3")
						);
				result.add(data);
			}


			//SQL文を準備
			sql = "select * from article where article_purpose like ?";

			purpIdforSQL = purpIdforSQL.replaceAll("[1-9A-G]", "_");
			pStmt.setString(1, purpIdforSQL);
			//SQL文を実行
			rs = pStmt.executeQuery();
			while(rs.next()) {
				String language[] = new String[16];
				String purpose[] = new String[11];
				String certification[] = new String[14];
				language = ReFlag.languageReFlag(rs.getString("article_language"));
				purpose = ReFlag.purposeReFlag(rs.getString("article_purpose"));
				certification = ReFlag.certificationReFlag(rs.getString("article_certification"));
				Article data = new Article(
						rs.getInt("article_id"),
						rs.getString("artcile_title"),
						rs.getString("user_id"),
						rs.getString("article_create"),
						rs.getString("article_update"),
						language,
						purpose,
						rs.getString("article_career"),
						certification,
						rs.getInt("article_favs"),
						rs.getString("article_text"),
						rs.getString("article_img1"),
						rs.getString("article_img2"),
						rs.getString("article_img3")
						);
				result.add(data);
			}

			//SQL文を準備
			sql = "select * from article where article_certification like ?";

			certIdforSQL = certIdforSQL.replaceAll("[1-9A-G]", "_");
			pStmt.setString(1, certIdforSQL);
			//SQL文を実行
			rs = pStmt.executeQuery();
			while(rs.next()) {
				String language[] = new String[16];
				String purpose[] = new String[11];
				String certification[] = new String[14];
				language = ReFlag.languageReFlag(rs.getString("article_language"));
				purpose = ReFlag.purposeReFlag(rs.getString("article_purpose"));
				certification = ReFlag.certificationReFlag(rs.getString("article_certification"));
				Article data = new Article(
						rs.getInt("article_id"),
						rs.getString("artcile_title"),
						rs.getString("user_id"),
						rs.getString("article_create"),
						rs.getString("article_update"),
						language,
						purpose,
						rs.getString("article_career"),
						certification,
						rs.getInt("article_favs"),
						rs.getString("article_text"),
						rs.getString("article_img1"),
						rs.getString("article_img2"),
						rs.getString("article_img3")
						);
				result.add(data);
			}

			for(int i=0; i<result.size();i++) {
				int articleId = result.get(i).getArticleId();
				for(int j=i+1;j<result.size();j++) {
					if(articleId == result.get(j).getArticleId()) {
						result.remove(j);
					}
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			result= null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			result = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					result = null;
				}
			}
		}

		// 結果を返す
		return result;
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
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/Data", "sa", "");

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
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/Data", "sa", "");

			//配列になっている使用言語をフラグ形式に変換。
			for(String lang: data.getArticleLanguage()) {
				System.out.println(lang);
			}
			System.out.println(Flag.languageFlag(data.getArticleLanguage()));
			language = Flag.languageFlag(data.getArticleLanguage());


			//配列になっている使用理由をフラグ形式に変換。
			purpose = Flag.purposeFlag(data.getArticlePurpose());

			//配列になっている使用理由をフラグ形式に変換。
			certification = Flag.certificationFlag(data.getArticleCertification());

			//SQL文を準備する
			String sql = "update article set article_title=?, user_id=?, article_language=?, article_purpose=?, article_career=?, article_certification=?, article_favs=?, article_text=?, article_img1=?, article_img2=?, article_img3=? where article_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			pStmt.setString(1, data.getArticleTitle());
			pStmt.setString(2, data.getUserId());
			pStmt.setString(3, language);
			pStmt.setString(4, purpose);
			pStmt.setString(5, data.getArticleCareer());
			pStmt.setString(6, certification);
			pStmt.setInt(7, data.getArticleFavs());
			pStmt.setString(8, data.getArticleText());
			pStmt.setString(9, data.getArticleImg1());
			pStmt.setString(10, data.getArticleImg2());
			pStmt.setString(11, data.getArticleImg3());
			pStmt.setInt(12, data.getArticleId());
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

	//引数無しで空の記事を作り、その記事idを返す。
			public int insertGetId() {
				int article_id = 0;
				Connection conn = null;

				try {
					//JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					//データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/Data", "sa", "");

					//SQL文を準備する
					String sql = "insert into article( article_title, user_id, article_create, article_update, article_language, article_purpose, article_career, article_certification, article_favs, article_text, article_img1, article_img2, article_img3) values('','temp',current_timestamp,current_timestamp,'','','','',0,'','','','');";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					pStmt.executeUpdate();


					//article_idを取り出すためのsqlを準備
					sql = "select article_id from article where user_id = 'temp' order by article_create desc;";
					pStmt = conn.prepareStatement(sql);
					ResultSet rs = pStmt.executeQuery();
					if(rs.next()) {
						//値の取得
						article_id = rs.getInt("article_id");
					} else {
						article_id = 0;
					}


				}
				catch (SQLException e) {
					e.printStackTrace();
					article_id = 0;
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
							article_id = 0;
						}
					}
				}

				//結果を返す
				return article_id;
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
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/Data", "sa", "");

			//SQL文を準備する
			String sql = "select * from article where article_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			pStmt.setInt(1,id);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {

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
							rs.getString("article_title"),
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
			} else {
				data = null;
			}
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
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/Data", "sa", "");

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

	//引数user_idで自分の記事の一覧を配列に入れて戻す。
	public ArrayList<Article> getmyArticle(String user_id) {
		int i = 0;
		Connection conn = null;
		int number_of_row;
		ArrayList<Article> result = new ArrayList<Article>();

		try {
			//JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			//データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/Data", "sa", "");

			//SQL文を準備する
			String sql = "select * from article where user_id = ? order by article_id asc;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			pStmt.setString(1, user_id);

			//SQL文を実行する
			ResultSet rs = pStmt.executeQuery();

			//結果表をArticleに保存し、配列に順次入れていく
			while(rs.next()) {
				String language[] = new String[16];
				String purpose[] = new String[11];
				String certification[] = new String[14];
				language = ReFlag.languageReFlag(rs.getString("article_language"));
				purpose = ReFlag.purposeReFlag(rs.getString("article_purpose"));
				certification = ReFlag.certificationReFlag(rs.getString("article_certification"));
				Article data = new Article(
						rs.getInt("article_id"),
						rs.getString("artcile_title"),
						rs.getString("user_id"),
						rs.getString("article_create"),
						rs.getString("article_update"),
						language,
						purpose,
						rs.getString("article_career"),
						certification,
						rs.getInt("article_favs"),
						rs.getString("article_text"),
						rs.getString("article_img1"),
						rs.getString("article_img2"),
						rs.getString("article_img3")
						);
				result.add(data);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
						result = null;
					}
					catch (SQLException e) {
						e.printStackTrace();
						result = null;
					}
				}
		}

		//結果を返す
		return result;

	}


	//引数User型で自分にオススメの記事をサイズ5の配列に入れて戻す。
	public ArrayList<Article> getRecommendArticle(User user) {
		ArrayList<Article> recommendArticles = new ArrayList<Article>();
		Connection conn = null;
		String langFlag = Flag.languageFlag(user.getLanguage());
		String purpFlag = Flag.purposeFlag(user.getPurpose());
		String certFlag = Flag.certificationFlag(user.getCertification());
		ArrayList<Article> results = new ArrayList<Article>();
		String notLikeLang = langFlag.replaceAll("0", "_");
		notLikeLang = notLikeLang.replaceAll("[1-9A-Z]", "0");
		String notLikePurp = purpFlag.replaceAll("0", "_");
		notLikePurp = notLikePurp.replaceAll("[1-9A-Z]", "0");
		String notLikeCert = certFlag.replaceAll("0", "_");
		notLikeCert = notLikeCert.replaceAll("[1-9A-Z]", "0");
		Article article = new Article();

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/Data", "sa", "");
			String sql = "select * from article where article_language not like ? "
					+ "or article_purpose not like ? "
					+ "or article_certification not like ?"
					+ "or article_career = ? order by article_update desc";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, notLikeLang);
			pStmt.setString(2, notLikePurp);
			pStmt.setString(3, notLikeCert);
			pStmt.setString(4, user.getCareer());
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				int articleId = rs.getInt("article_id");
				String articleTitle = rs.getString("article_title");
				String userId = rs.getString("user_id");
				String articleCreate = rs.getString("article_create");
				String articleUpdate = rs.getString("article_update");
				String[] articleLanguage = ReFlag.languageReFlag(rs.getString("article_language"));
				String[] articlePurpose = ReFlag.purposeReFlag(rs.getString("article_purpose"));
				String articleCareer = rs.getString("article_career");
				String[] articleCertification = ReFlag.certificationReFlag(rs.getString("article_certification"));
				int articleFavs = rs.getInt("article_favs");
				String articleText = rs.getString("article_text");
				String articleImg1 = rs.getString("article_img1");
				String articleImg2 = rs.getString("article_img2");
				String articleImg3 = rs.getString("article_img3");
				article = new Article(articleId, articleTitle, userId, articleCreate,
						articleUpdate, articleLanguage, articlePurpose, articleCareer,
						articleCertification, articleFavs, articleText,
						articleImg1, articleImg2, articleImg3);
				results.add(article);
			}
			int[] matchRate = new int[results.size()];
			int maxRate = 0;
			int[][] ratedArticleId = new int[results.size()][2];
			int[] resultIdArray = new int[5];
			int resultCount = 0;
			Arrays.fill(matchRate, 0);
			// 検索マッチ数分ループ
			for (int i=0; i<results.size(); i++) {
				// 各ユーザータグ分ループ
				for (int j=0; j<user.getLanguage().length; j++) {
					// マッチ記事1件に含まれるタグ分回してmatchRate加算
					for (int k=0; k<results.get(i).getArticleLanguage().length; k++) {
						if (user.getLanguage()[j].equals(results.get(i).getArticleLanguage()[k])) {
							matchRate[i]++;
						}
					}
				}
				for (int j=0; j<user.getPurpose().length; j++) {
					// マッチ記事1件に含まれるタグ分回してmatchRate加算
					for (int k=0; k<results.get(i).getArticlePurpose().length; k++) {
						if (user.getPurpose()[j].equals(results.get(i).getArticlePurpose()[k])) {
							matchRate[i]++;
						}
					}
				}
				for (int j=0; j<user.getCertification().length; j++) {
					// マッチ記事1件に含まれるタグ分回してmatchRate加算
					for (int k=0; k<results.get(i).getArticleCertification().length; k++) {
						if (user.getCertification()[j].equals(results.get(i).getArticleCertification()[k])) {
							matchRate[i]++;
						}
					}
				}
				if (user.getCareer().equals(results.get(i).getArticleCareer())) {
					matchRate[i]++;
				}
				ratedArticleId[i][0] = results.get(i).getArticleId();
				ratedArticleId[i][1] = matchRate[i];
				if (maxRate < matchRate[i]) {
					maxRate = matchRate[i];
				}
			}
			for (int i=maxRate; i<0; i--) {
				for (int[] ratedArticle: ratedArticleId) {
					if (ratedArticle[1] == i) {
						resultIdArray[resultCount] = ratedArticle[0];
						resultCount++;
						if (resultCount == 5) break;
					}
				}
				if (resultCount == 5) break;
			}
			for (int id: resultIdArray) {
				recommendArticles.add(load(id));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return recommendArticles;
	}

	public ArrayList<Article> getRecommendArticle() {
		ArrayList<Article> recommendArticles = new ArrayList<Article>();
		Connection conn = null;
		Article article;
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/Data", "sa", "");
			String sql = "select * from article order by article_update desc";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				int articleId = rs.getInt("article_id");
				String articleTitle = rs.getString("article_title");
				String userId = rs.getString("user_id");
				String articleCreate = rs.getString("article_create");
				String articleUpdate = rs.getString("article_update");
				String[] articleLanguage = ReFlag.languageReFlag(rs.getString("article_language"));
				String[] articlePurpose = ReFlag.purposeReFlag(rs.getString("article_purpose"));
				String articleCareer = rs.getString("article_career");
				String[] articleCertification = ReFlag.certificationReFlag(rs.getString("article_certification"));
				int articleFavs = rs.getInt("article_favs");
				String articleText = rs.getString("article_text");
				String articleImg1 = rs.getString("article_img1");
				String articleImg2 = rs.getString("article_img2");
				String articleImg3 = rs.getString("article_img3");
				article = new Article(articleId, articleTitle, userId,
						articleCreate, articleUpdate, articleLanguage,
						articlePurpose, articleCareer, articleCertification,
						articleFavs, articleText, articleImg1, articleImg2, articleImg3);
				recommendArticles.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return recommendArticles;
	}

	//引数(int)1をもらってfavを1増やす
	public boolean addFavs(int article_id) {
		Connection conn = null;
		boolean result = false;

		try {
			//JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			//データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/Data", "sa", "");

			//SQL文を準備する
			String sql = "update article set article_favs = article_favs+1 where ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			pStmt.setInt(1, article_id);

			//SQLを実行する
			pStmt.executeUpdate();
			result = true;
		}
		catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			result = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					result = false;
				}
			}
		}

		return result;


	}

	//コメントを追加する機能
		public boolean setComment(int article_id, String user_id, String comment_text) {
			Connection conn = null;
			boolean result = false;

			try {
				//JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				//データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/Data", "sa", "");

				//SQL文を準備する
				String sql = "insert into comment (article_id, user_id, comment_date, comment_text) values(?, ?, ?, ?);";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				//SQL文を完成させる
				pStmt.setInt(1, article_id);
				pStmt.setString(2, user_id);
				pStmt.setString(3, "current_timestump");
				pStmt.setString(4, comment_text);

				//SQLを実行する
				pStmt.executeUpdate();
				result = true;
			}
			catch (SQLException e) {
				e.printStackTrace();
				result = false;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				result = false;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						result = false;
					}
				}
			}

			return result;
		}

		//article_idを引数とし、その記事のコメントをすべて取り出す。
		public ArrayList<Comment> getComment(int article_id){
			Connection conn = null;
			ArrayList<Comment> result = new ArrayList<Comment>();

			try {
				//JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				//データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/Data", "sa", "");

				//SQL文を準備する
				String sql = "select * from comment where article_id = ? order by comment_date asc;";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				//SQL文を完成させる
				pStmt.setInt(1, article_id);

				//SQLを実行する
				ResultSet rs = pStmt.executeQuery();

				while(rs.next()) {
					Comment comment = new Comment(
						rs.getInt("comment_id"),
						rs.getInt("article_id"),
						rs.getString("user_id"),
						rs.getString("comment_date"),
						rs.getString("comment_text")
						);
					result.add(comment);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				result = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				result = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						result = null;
					}
				}
			}

			return result;


		}
}
