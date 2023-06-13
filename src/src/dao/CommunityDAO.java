package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Community;

public class CommunityDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Community> select(Community param) {
		Connection conn = null;
		List<Community> cardList = new ArrayList<Community>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/Data", "sa", "");

			// SQL文を準備する
			String sql ="select community_id, community_date, community_name, community_language, community_purpose, community_career, community_certification, community_summary, from community WHERE community_name LIKE ? AND community_language LIKE ? AND community_purpose LIKE ? AND community_career LIKE ? AND community_certification LIKE ? AND community_summary LIKE ? ORDER BY community_id";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			if (param.getCommunityName() != null) {
				pStmt.setString(1, "%" + param.getCommunityName() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}if (param.getCommunityLanguage() != null) {
				pStmt.setString(2, "%" + param.getCommunityLanguage() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}if (param.getCommunityPurpose() != null) {
					pStmt.setString(3, "%" + param.getCommunityPurpose() + "%");
				}
			else {
				pStmt.setString(3, "%");
			}if (param.getCommunityCareer() != null) {
						pStmt.setString(4, "%" + param.getCommunityCareer() + "%");
			}
			else {
				pStmt.setString(4, "%");
			}if (param.getCommunityCertification() != null) {
						pStmt.setString(5, "%" + param.getCommunityCertification() + "%");
			}
			else {
				pStmt.setString(5, "%");
			}if (param.getCommunitySummary() != null) {
				pStmt.setString(6, "%" + param.getCommunitySummary() + "%");
			}
			else {
				pStmt.setString(6, "%");
			}



			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Community card = new Community(
				rs.getInt("community_id"),
				rs.getString("community_date"),
				rs.getString("community_name"),
				rs.getString("community_language"),
				rs.getString("community_purpose"),
				rs.getString("community_career"),
				rs.getString("community_certification"),
				rs.getString("community_summary")

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
				pStmt.setString(2, card.getCommunityLanguage());
			}
			else if(!card.getCommunityLanguage().equals("")) {
				pStmt.setString(2, "");
			}

			if (card.getCommunityPurpose() != null) {
				pStmt.setString(3, card.getCommunityPurpose());
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
				pStmt.setString(5, card.getCommunityCertification());
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




}
