package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Community;
import model.Remark;

public class CommunityDao {
	// 引数paramで検索項目を指定し、検索結果のリストを返す

		public ArrayList<Community> select(String query) {
			Connection conn = null;
			ArrayList<Community> result = new ArrayList<Community>();
			String[] queryArray = query.split("[ 　]+");

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/Data", "sa", "");

				//本文、タイトルで検索をかける

				//sql文を準備
				String sql = "select * from community where";
				String[] setStr = new String[queryArray.length];


				//sql文を完成させる
				for(int i=0; i<queryArray.length; i++) {
					sql += " ?";
					sql += " concat(community_name, community_summary) like %"+ queryArray[i] +"%";
					if(i < queryArray.length-1) {
						sql += " and";
					}
				}
				PreparedStatement pStmt = conn.prepareStatement(sql);

				//sql文を実行
				ResultSet rs = pStmt.executeQuery();

				//結果表をCommunityに保存し、配列に順次入れていく
				while(rs.next()) {
					String language[] = new String[16];
					String purpose[] = new String[11];
					String certification[] = new String[14];
					language = ReFlag.languageReFlag(rs.getString("community_language"));
					purpose = ReFlag.purposeReFlag(rs.getString("community_purpose"));
					certification = ReFlag.certificationReFlag(rs.getString("community_certification"));
					Community data = new Community(
							rs.getInt("community_id"),
							rs.getString("community_date"),
							rs.getString("community_name"),
							language,
							purpose,
							rs.getString("community_career"),
							certification,
							rs.getString("community_summary")
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
				sql = "select * from community where community_language like ?";

				langIdforSQL = langIdforSQL.replaceAll("[1-9A-G]", "_");
				pStmt.setString(1, langIdforSQL);
				//SQL文を実行
				rs = pStmt.executeQuery();
				while(rs.next()) {
					String language[] = new String[16];
					String purpose[] = new String[11];
					String certification[] = new String[14];
					language = ReFlag.languageReFlag(rs.getString("community_language"));
					purpose = ReFlag.purposeReFlag(rs.getString("community_purpose"));
					certification = ReFlag.certificationReFlag(rs.getString("community_certification"));
					Community data = new Community(
							rs.getInt("community_id"),
							rs.getString("community_date"),
							rs.getString("community_name"),
							language,
							purpose,
							rs.getString("community_career"),
							certification,
							rs.getString("community_summary")
							);
					result.add(data);
				}


				//SQL文を準備
				sql = "select * from community where community_purpose like ?";

				purpIdforSQL = purpIdforSQL.replaceAll("[1-9A-G]", "_");
				pStmt.setString(1, purpIdforSQL);
				//SQL文を実行
				rs = pStmt.executeQuery();
				while(rs.next()) {
					String language[] = new String[16];
					String purpose[] = new String[11];
					String certification[] = new String[14];
					language = ReFlag.languageReFlag(rs.getString("community_language"));
					purpose = ReFlag.purposeReFlag(rs.getString("community_purpose"));
					certification = ReFlag.certificationReFlag(rs.getString("community_certification"));
					Community data = new Community(
							rs.getInt("community_id"),
							rs.getString("community_date"),
							rs.getString("community_name"),
							language,
							purpose,
							rs.getString("community_career"),
							certification,
							rs.getString("community_summary")
							);
					result.add(data);
				}

				//SQL文を準備
				sql = "select * from community where community_certification like ?";

				certIdforSQL = certIdforSQL.replaceAll("[1-9A-G]", "_");
				pStmt.setString(1, certIdforSQL);
				//SQL文を実行
				rs = pStmt.executeQuery();
				while(rs.next()) {
					String language[] = new String[16];
					String purpose[] = new String[11];
					String certification[] = new String[14];
					language = ReFlag.languageReFlag(rs.getString("community_language"));
					purpose = ReFlag.purposeReFlag(rs.getString("community_purpose"));
					certification = ReFlag.certificationReFlag(rs.getString("community_certification"));
					Community data = new Community(
							rs.getInt("community_id"),
							rs.getString("community_date"),
							rs.getString("community_name"),
							language,
							purpose,
							rs.getString("community_career"),
							certification,
							rs.getString("community_summary")
							);
					result.add(data);
				}

				for(int i=0; i<result.size();i++) {
					int communityId = result.get(i).getCommunityId();
					for(int j=i+1;j<result.size();j++) {
						if(communityId == result.get(j).getCommunityId()) {
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





	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Community card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/Data", "sa", "");

			// SQL文を準備する
			String sql = "insert into community (community_name, community_language, community_purpose, community_career, community_certification, community_summary) values (?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			if (card.getCommunityName() != null) {
				pStmt.setString(1, card.getCommunityName());
			}
			else if(!card.getCommunityName().equals("")) {
				pStmt.setString(1, "");
		}

			if (card.getCommunityLanguage() != null) {
				pStmt.setObject(2, card.getCommunityLanguage());
			}
			else if(!card.getCommunityLanguage().equals("")) {
				pStmt.setString(2, "");
			}

			if (card.getCommunityPurpose() != null) {
				pStmt.setObject(3, card.getCommunityPurpose());
			}
			else if(!card.getCommunityPurpose().equals("")) {
				pStmt.setString(3, "");
			}

			if (card.getCommunityCareer() != null) {
				pStmt.setString(4, card.getCommunityCareer());
			}
			else if(!card.getCommunityCareer().equals("")) {
				pStmt.setString(4, "");
			}

			if (card.getCommunityCertification() != null) {
				pStmt.setObject(5, card.getCommunityCertification());
			}
			else if(!card.getCommunityCertification().equals("")) {
				pStmt.setString(5, "");
			}

			if (card.getCommunitySummary() != null) {
				pStmt.setString(6, card.getCommunitySummary());
			}
			else if(!card.getCommunitySummary().equals("")) {
				pStmt.setString(6, "");
			}



			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
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
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}

	public boolean insert(Remark card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/Data", "sa", "");

			// SQL文を準備する
			String sql = "insert into chat (remark_id, community_id, user_id, remark_text, remark_date) values (?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる


				pStmt.setInt(1, card.getRemarkId());
				pStmt.setInt(2, card.getCommunityId());
				pStmt.setString(3, card.getUserId());
				pStmt.setString(4, card.getRemarkText());
				pStmt.setString(5, card.getRemarkDate());








			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
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
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}

	public List<Remark> selectall() {
		Connection conn = null;
		List<Remark> cardList = new ArrayList<Remark>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/Data", "sa", "");

			// SQL文を準備する
			String sql = "SELECT * FROM chat ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる






			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Remark card = new Remark(
				rs.getInt("REMARK_ID"),
				rs.getInt("COMMUNITY_ID"),
				rs.getString("USER_ID"),
				rs.getString("REMARK_TEXT"),
				rs.getString("REMARK_DATE"))

				;
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
