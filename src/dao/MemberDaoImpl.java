package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import entity.Member;

import java.util.*;

public class MemberDaoImpl {
	private Connection conn=null;
	private ResultSet rs=null;
	
	
	public ArrayList<Member> selectAllMembers(int team_id){
		ArrayList<Member> list=new ArrayList<Member>();
		conn=DBHelper.getConnection();
		String sql="select * from member where team_id=?";
		Object[] values=new Object[]{
				new Integer(team_id)
			};
		
		rs=DBHelper.executeQuery(conn, sql, values);
		try {
			while(rs.next()){
				Member member=new Member(
						rs.getInt("member_id"),
						team_id,
						rs.getString("name"),
						rs.getString("job"),
						rs.getString("school"),
						rs.getString("college"),
						rs.getString("experience"),
						rs.getString("telephone"),
						rs.getString("photo")
				);
				list.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBHelper.CloseAll(conn, rs);
		return list;
	}
}
