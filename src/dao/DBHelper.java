package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;

import sun.jdbc.odbc.ee.DataSource;

public class DBHelper {
	private static Connection conn = null;

	public static Connection getConnection() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/mysql");
			conn = ds.getConnection();
		} catch(Exception ex) {
			System.out.println(ex.toString());
		}
		return conn;
	}

	public static ResultSet executeQuery(Connection conn, String sql,
			Object[] values) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(sql);
			for (int i =0; i < values.length; i++) {
				pst.setObject(i+1, values[i]);
			}
			rs = pst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public static int executeUpdate(Connection conn, String sql,
			Object[] values) {
		int result = 0;
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			for (int i = 0; i < values.length; i++) {
				pst.setObject(i+1, values[i]);
			}
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static ResultSet executeQuery(Connection conn, String sql) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public static int executeUpdate(Connection conn, String sql) {
		int result = 0;
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static boolean executeInsert(Connection conn, String querySql, String insertSql) {
		try {
			if (executeQuery(conn, querySql) == null) {
				return false;
			}
			
			Statement stmt = conn.createStatement();
			boolean result = stmt.execute(insertSql);
			if (result == true) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void CloseAll(Connection conn, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
