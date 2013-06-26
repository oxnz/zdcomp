package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import entity.*;

import java.util.*;

public class WorkDaoImpl {
	private Connection conn=null;
	private ResultSet rs=null;
	
	
	public ArrayList<Work> selectAllWorks(){
		ArrayList<Work> list=new ArrayList<Work>();
		conn=DBHelper.getConnection();
		String sql="select * from work";
		
		rs=DBHelper.executeQuery(conn, sql);
		try {
			while(rs.next()){
				Work work=new Work(
						rs.getInt("work_id"),
						rs.getString("work_name"),
						rs.getInt("team_id"),
						rs.getInt("downloads"),
						rs.getString("logo"),
						rs.getString("pic1"),
						rs.getString("pic2"),
						rs.getString("pic3"),
						rs.getString("pic4"),
						rs.getString("pic5"),
						rs.getString("introduction"),
						rs.getString("address")
				);
				list.add(work);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBHelper.CloseAll(conn, rs);
		return list;
	} 
	
	//��ȡ��Ʒʵ��
	public Work selectWorkById(int work_id){
		Work work=null;
		conn=DBHelper.getConnection();
		String sql="select * from work where work_id=?";
		Object[] values=new Object[]{
				new Integer(work_id)
			};
		
		rs=DBHelper.executeQuery(conn, sql,values);
		try {
			if(rs.next()){
				work=new Work(
						rs.getInt("work_id"),
						rs.getString("work_name"),
						rs.getInt("team_id"),
						rs.getInt("downloads"),
						rs.getString("logo"),
						rs.getString("pic1"),
						rs.getString("pic2"),
						rs.getString("pic3"),
						rs.getString("pic4"),
						rs.getString("pic5"),
						rs.getString("introduction"),
						rs.getString("address")
				);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBHelper.CloseAll(conn, rs);
		return work;
	}
	
	//������+1
	public boolean updateDownloads(int work_id){
		boolean isOK=false;
		conn=DBHelper.getConnection();
		String sql="update work set downloads=downloads+1 where work_id=?";
		Object[] values=new Object[]{
				new Integer(work_id)
			};
		
		int result=DBHelper.executeUpdate(conn, sql, values);
		if(result>0){
			isOK=true;
		}
		DBHelper.CloseAll(conn, rs);
		return isOK;
	}
}
