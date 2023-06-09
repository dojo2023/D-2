package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import model.Community;
import model.Remark;
import model.User;

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
				String sql = "select * from community where ";

				//sql文を完成させる
				for(int i=0; i<queryArray.length; i++) {
					sql += "concat(community_name, community_summary) ilike '%" + queryArray[i] + "%'";
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
					sql = "select * from language_list where language_item ilike '%" + queryArray[i] +"%'";
					pStmt = conn.prepareStatement(sql);
					//sql文を実行
					rs = pStmt.executeQuery();
					while(rs.next()) {
						langId[i] += rs.getString("language_id");
					}

					sql = "select * from purpose_list where purpose_item ilike '%" + queryArray[i] +"%'";
					pStmt = conn.prepareStatement(sql);
					//sql文を実行
					rs = pStmt.executeQuery();
					while(rs.next()) {
						purpId[i] += rs.getString("purpose_id");
					}

					sql = "select * from certification_list where certification_item ilike '%" + queryArray[i] +"%'";
					pStmt = conn.prepareStatement(sql);
					//sql文を実行
					rs = pStmt.executeQuery();
					while(rs.next()) {
						certId[i] += rs.getString("certification_id");
					}
				}

				String langIdforSQL="0000000000000000";
				String purpIdforSQL="00000000000";
				String certIdforSQL="00000000000000";
				String comp = "123456789ABCDEFG";
				int head;
				for(int i=0; i<16; i++) {
					for(int j=0; j<queryArray.length; j++) {
						head = 0;
						if (Objects.nonNull(langId[j])) {
							for (int k=0; k<langId[j].length(); k++) {
								if (langId[j].indexOf(comp.charAt(i)) != -1) {
									head = comp.indexOf(comp.charAt(i));
									langIdforSQL = langIdforSQL.substring(0, head) + comp.charAt(head) + langIdforSQL.substring(head+1);
								}
							}
						}
					}
				}
				for(int i=0; i<11; i++) {
					for(int j=0; j<queryArray.length; j++) {
						head = 0;
						if (Objects.nonNull(purpId[j])) {
							for (int k=0; k<purpId[j].length(); k++) {
								if (purpId[j].indexOf(comp.charAt(i)) != -1) {
									head = comp.indexOf(comp.charAt(i));
									purpIdforSQL = purpIdforSQL.substring(0, head) + comp.charAt(head) + purpIdforSQL.substring(head+1);
								}
							}
						}
					}
				}
				for(int i=0; i<14; i++) {
					for(int j=0; j<queryArray.length; j++) {
						head = 0;
						if (Objects.nonNull(certId[j])) {
							for (int k=0; k<certId[j].length(); k++) {
								if (certId[j].indexOf(comp.charAt(i)) != -1) {
									head = comp.indexOf(comp.charAt(i));
									certIdforSQL = certIdforSQL.substring(0, head) + comp.charAt(head) + certIdforSQL.substring(head+1);
								}
							}
						}
					}
				}
				System.out.println("langIdForSQL:" + langIdforSQL);
				System.out.println("purpIdForSQL:" + purpIdforSQL);
				System.out.println("certIdForSQL:" + certIdforSQL);
				//SQL文を準備
				sql = "select * from community where community_language not like ?";

				langIdforSQL = langIdforSQL.replaceAll("0", "_");
				langIdforSQL = langIdforSQL.replaceAll("[1-9a-g]", "0");
				pStmt = conn.prepareStatement(sql);
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
				sql = "select * from community where community_purpose not like ?";
				purpIdforSQL = purpIdforSQL.replaceAll("0", "_");
				purpIdforSQL = purpIdforSQL.replaceAll("[1-9a-g]", "0");
				pStmt = conn.prepareStatement(sql);
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
				sql = "select * from community where community_certification not like ?";
				certIdforSQL = certIdforSQL.replaceAll("0", "_");
				certIdforSQL = certIdforSQL.replaceAll("[1-9a-g]", "0");
				pStmt = conn.prepareStatement(sql);
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
		public int addCommunity(Community data) {
			String communityName;
			String communityLanguage;
			String communityPurpose;
			String communityCertification;
			String communitySummary;
			Connection conn = null;
			int result=-1;


			try {
				//JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				//データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/Data", "sa", "");

				//配列になっている使用言語をフラグ形式に変換。
				communityLanguage = Flag.languageFlag(data.getCommunityLanguage());

				//配列になっている使用理由をフラグ形式に変換。
				communityPurpose = Flag.purposeFlag(data.getCommunityPurpose());

				//配列になっている使用理由をフラグ形式に変換。
				communityCertification = Flag.certificationFlag(data.getCommunityCertification());

				//SQL文を準備する
				String sql = "insert into community( community_date, community_name, community_language, community_purpose, community_career, community_certification, community_summary ) values(?,?,?,?,?,?,?);";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				//SQL文を完成させる
				pStmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
				pStmt.setString(2, data.getCommunityName());
				pStmt.setString(3, communityLanguage);
				pStmt.setString(4,  communityPurpose);
				pStmt.setString(5, data.getCommunityCareer());
				pStmt.setString(6, communityCertification);
				pStmt.setString(7, data.getCommunitySummary());
				pStmt.executeUpdate();

				sql= "select community_id from community order by community_date desc";
				pStmt=conn.prepareStatement(sql);
				ResultSet rs=pStmt.executeQuery();

				rs.next();
				result=rs.getInt("community_id");
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
						result = -1;
					}
				}
			}

			//結果を返す
			return result;
		}

		//コミュニティidから一致するコミュニティのデータを持ってくる
		public Community getCommunityById(int id){
			String language, purpose, certification;
			String lang_data[] = new String[16];
			String purp_data[] = new String[11];
			String cert_data[] = new String[14];
			Connection conn = null;
			Community data;

			try {
				//JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				//データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/Data", "sa", "");

				//SQL文を準備する
				String sql = "select * from community where community_id = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				//SQL文を完成させる
				pStmt.setInt(1,id);
				ResultSet rs = pStmt.executeQuery();

				if (rs.next()) {
					//フラグ形式のデータをString型の変数に入れる
					language = rs.getString("community_language");
					purpose = rs.getString("community_purpose");
					certification = rs.getString("community_certification");

					//フラグ形式のデータを日本語に戻し、配列に入れる。
					lang_data = ReFlag.languageReFlag(language);
					purp_data = ReFlag.purposeReFlag(purpose);
					cert_data = ReFlag.certificationReFlag(certification);

					//結果表をCommunity型の変数にコピー
						data = new Community(
								rs.getInt("community_id"),
								rs.getString("community_date"),
								rs.getString("community_name"),
								lang_data,
								purp_data,
								rs.getString("community_career"),
								cert_data,
								rs.getString("community_summary")
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


	public ArrayList<Remark> getRemarks(int id) {
		Connection conn = null;
		ArrayList<Remark> RemarkResult = new ArrayList<Remark>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/Data", "sa", "");

			// SQL文を準備する
			String sql = "SELECT * FROM chat where community_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
            pStmt.setInt(1,id);





			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Remark card = new Remark(
				rs.getInt("remark_id"),
				rs.getInt("community_id"),
				rs.getString("user_id"),
				rs.getString("remark_text"),
				rs.getString("remark_date"))

				;
				RemarkResult.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			RemarkResult = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			RemarkResult = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					RemarkResult = null;
				}
			}
		}

		// 結果を返す
		return RemarkResult;
	}


	public ArrayList<String> getMember(int id) {
		Connection conn = null;
		ArrayList<String> Result = new ArrayList<String>();

		UserDao uDao= new UserDao();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/Data", "sa", "");

			// SQL文を準備する
			String sql = "SELECT * FROM member where community_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
            pStmt.setInt(1,id);





			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			String userName= null;
			while (rs.next()) {

				;
				userName=uDao.getUserNameById(rs.getString("user_id"));


				Result.add(userName);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			Result = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			Result = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					Result = null;
				}
			}
		}

		// 結果を返す
		return Result;
	}


	public boolean insert(Remark remark) {
		Connection conn = null;
		boolean result = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/Data", "sa", "");

			// SQL文を準備する
			String sql = "insert into chat ( community_id, user_id, remark_text, remark_date) values (?, ?, ?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, remark.getCommunityId());
			pStmt.setString(2, remark.getUserId());
			pStmt.setString(3, remark.getRemarkText());
			pStmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
			sql = "select * from member where community_id = ? and user_id = ?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, remark.getCommunityId());
			pStmt.setString(2, remark.getUserId());
			ResultSet rs = pStmt.executeQuery();
			if (!rs.next()) {
				sql = "insert into member (community_id, user_id) values (?, ?)";
				pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1, remark.getCommunityId());
				pStmt.setString(2, remark.getUserId());
				pStmt.executeUpdate();
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

	public ArrayList<Community> getRecommendCommunity() {
		ArrayList<Community> recommendCommunities = new ArrayList<Community>();
		Connection conn = null;
		Community community;
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/Data", "sa", "");
			String sql = "select * from community order by community_date desc limit 5";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				int communityId = rs.getInt("community_id");
				String communityDate = rs.getString("community_date");
				String communityName = rs.getString("community_name");
				String[] communityLanguage = ReFlag.languageReFlag(rs.getString("community_language"));
				String[] communityPurpose = ReFlag.purposeReFlag(rs.getString("community_purpose"));
				String communityCareer = rs.getString("community_career");
				String[] communityCertification = ReFlag.certificationReFlag(rs.getString("community_certification"));
				String communitySummary = rs.getString("community_summary");
				community = new Community(communityId, communityDate, communityName, communityLanguage,
						communityPurpose, communityCareer, communityCertification, communitySummary);
				recommendCommunities.add(community);
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
		return recommendCommunities;
	}

	public ArrayList<Community> getRecommendCommunity(User user) {
		ArrayList<Community> recommendCommunities = new ArrayList<Community>();
		Connection conn = null;
		String langFlag = Flag.languageFlag(user.getLanguage());
		String purpFlag = Flag.purposeFlag(user.getPurpose());
		String certFlag = Flag.certificationFlag(user.getCertification());
		ArrayList<Community> results = new ArrayList<Community>();
		String notLikeLang = langFlag.replaceAll("0", "_");
		notLikeLang = notLikeLang.replaceAll("[1-9A-Z]", "0");
		String notLikePurp = purpFlag.replaceAll("0", "_");
		notLikePurp = notLikePurp.replaceAll("[1-9A-Z]", "0");
		String notLikeCert = certFlag.replaceAll("0", "_");
		notLikeCert = notLikeCert.replaceAll("[1-9A-Z]", "0");
		Community community;

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/Data", "sa", "");
			String sql = "select * from community where community_language not like ? "
					+ "or community_purpose not like ? "
					+ "or community_certification not like ?"
					+ "or community_career = ? order by community_date desc";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, notLikeLang);
			pStmt.setString(2, notLikePurp);
			pStmt.setString(3, notLikeCert);
			pStmt.setString(4, user.getCareer());
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				int communityId = rs.getInt("community_id");
				String communityDate = rs.getString("community_date");
				String communityName = rs.getString("community_name");
				String[] communityLanguage = ReFlag.languageReFlag(rs.getString("community_language"));
				String[] communityPurpose = ReFlag.purposeReFlag(rs.getString("community_purpose"));
				String communityCareer = rs.getString("community_career");
				String[] communityCertification = ReFlag.certificationReFlag(rs.getString("community_certification"));
				String communitySummary = rs.getString("community_summary");
				community = new Community(communityId, communityDate, communityName,
						communityLanguage, communityPurpose, communityCareer,
						communityCertification, communitySummary);
				results.add(community);
			}
			int[] matchRate = new int[results.size()];
			int maxRate = 0;
			int[][] ratedCommunityId = new int[results.size()][2];
			int[] resultIdArray = new int[5];
			Arrays.fill(resultIdArray, -1);
			int resultCount = 0;
			Arrays.fill(matchRate, 0);
			// 検索マッチ数分ループ
			for (int i=0; i<results.size(); i++) {
				// 各ユーザータグ分ループ
				for (int j=0; j<user.getLanguage().length; j++) {
					// マッチ記事1件に含まれるタグ分回してmatchRate加算
					for (int k=0; k<results.get(i).getCommunityLanguage().length; k++) {
						if (user.getLanguage()[j].equals(results.get(i).getCommunityLanguage()[k])) {
							matchRate[i]++;
						}
					}
				}
				for (int j=0; j<user.getPurpose().length; j++) {
					// マッチ記事1件に含まれるタグ分回してmatchRate加算
					for (int k=0; k<results.get(i).getCommunityPurpose().length; k++) {
						if (user.getPurpose()[j].equals(results.get(i).getCommunityPurpose()[k])) {
							matchRate[i]++;
						}
					}
				}
				for (int j=0; j<user.getCertification().length; j++) {
					// マッチ記事1件に含まれるタグ分回してmatchRate加算
					for (int k=0; k<results.get(i).getCommunityCertification().length; k++) {
						if (user.getCertification()[j].equals(results.get(i).getCommunityCertification()[k])) {
							matchRate[i]++;
						}
					}
				}
				if (user.getCareer().equals(results.get(i).getCommunityCareer())) {
					matchRate[i]++;
				}
				ratedCommunityId[i][0] = results.get(i).getCommunityId();
				ratedCommunityId[i][1] = matchRate[i];
				if (maxRate < matchRate[i]) {
					maxRate = matchRate[i];
				}
			}
			for (int i=maxRate; i>0; i--) {
				for (int[] ratedCommunity: ratedCommunityId) {
					if (ratedCommunity[1] == i) {
						resultIdArray[resultCount] = ratedCommunity[0];
						resultCount++;
						if (resultCount == 5) break;
					}
				}
				if (resultCount == 5) break;
			}
			for (int id: resultIdArray) {
				if (id > 0)
					recommendCommunities.add(getCommunityById(id));
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
		return recommendCommunities;
	}



}
