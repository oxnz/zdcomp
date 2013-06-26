package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;

public class UserDaoImpl {
	private Connection conn = null;
	private ResultSet rs = null;

	public boolean insertNewUser(User user) {
		boolean isOK = false;
		conn = DBHelper.getConnection();
		String sql = "insert into user (email, qq, password, nickname, user_type) values(?,?,?,?,?)";
		Object[] values = new Object[] {
				new String(user.getEmail()),
				new String(user.getQq()),
				new String(user.getPassword()),
				new String(user.getNickname()),
				new Integer(user.getUser_type())
		};
		
		int result = DBHelper.executeUpdate(conn, sql, values);
		if (result > 0) {
			isOK = true;
			System.out.println(result);
		}
		DBHelper.CloseAll(conn, rs);
		return isOK;
	}
	
	public User selectUserById(int user_id) {
		User user = null;
		conn = DBHelper.getConnection();
		String sql = "select * from user where user_id=?";
		Object[] values = new Object[]{new Integer(user_id)};
		rs = DBHelper.executeQuery(conn, sql, values);
		try {
			if (rs.next()) {
				user = new User(
						user_id,
						rs.getString("email"),
						rs.getString("qq"),
						rs.getString("password"),
						rs.getString("nickname"),
						rs.getInt("user_type")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBHelper.CloseAll(conn, rs);
		return user;
	}
	
	public boolean selectIsPwdCorrect(String email, String pwd) {
		boolean isOK =false;
		conn = DBHelper.getConnection();
		String sql = "select password from user where email=?";
		Object[] values = new Object[]{new String(email)};
		rs = DBHelper.executeQuery(conn, sql, values);
		try {
			if (rs.next()) {
				if (pwd.equals(rs.getString("password"))) {
					isOK = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBHelper.CloseAll(conn, rs);
		return isOK;
	}
	
	public boolean selectIsRegistered(String email) {
		boolean isOK = false;
		conn = DBHelper.getConnection();
		String sql = "select email from user where email=?";
		Object[] values = new Object[] {new String(email)};
		rs = DBHelper.executeQuery(conn, sql, values);
		try {
			if (rs.next()) {
				isOK = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBHelper.CloseAll(conn, rs);
		return isOK;
	}
	
	public User selectUserByEmail(String email) {
		User user = null;
		conn = DBHelper.getConnection();
		String sql = "select * from user where email=?";
		Object[] values = new Object[] { new String(email) };
		rs = DBHelper.executeQuery(conn, sql, values);
		try {
			if (rs.next()) {
				user = new User(
						rs.getInt("user_id"),
						email,
						rs.getString("qq"),
						rs.getString("password"),
						rs.getString("nickname"),
						rs.getInt("user_type")
						);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBHelper.CloseAll(conn, rs);
		return user;
	}
	
}
