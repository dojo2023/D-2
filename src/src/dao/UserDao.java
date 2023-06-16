package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDao {
	public boolean isLoginOK(User user) {
		Connection conn = null;
		boolean loginResult = false;
		String name;

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/Data", "sa", "");
			String sql = "select * from USER where user_id = ? and password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getUserId());
			pStmt.setString(2, user.getPassword());
			ResultSet rs = pStmt.executeQuery();
			if (rs.next())
				loginResult = true;
			name = rs.getString("user_name");
			user.setUserName(name);
		} catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}
		return loginResult;
	}

	public boolean addUser(User user) {
		Connection conn = null;
		boolean addResult = false;

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/Data", "sa", "");
			String sql = "insert into user values (?,?,?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getUserId());
			pStmt.setString(2, user.getPassword());
			pStmt.setString(3, user.getUserName());
			pStmt.setString(4, Flag.languageFlag(user.getLanguage()));
			pStmt.setString(5, Flag.purposeFlag(user.getPurpose()));
			pStmt.setString(6, user.getCareer());
			pStmt.setString(7, Flag.certificationFlag(user.getCertification()));
			pStmt.executeUpdate();
			addResult = true;
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
					addResult = false;
				}
			}
		}
		return addResult;
	}

	public String getUserNameById(String userId) {
		Connection conn = null;
		String userName = null;

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/Data", "sa", "");
			String sql = "select * from USER where user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userId);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next())
				userName = rs.getString("user_name");
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
		return userName;
	}

	public boolean isExistingId(String userId) {
		boolean isExisting = false;
		Connection conn = null;

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/src/Data", "sa", "");
			String sql = "select * from USER where user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userId);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next())
				isExisting = true;
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
		return isExisting;
	}
}
