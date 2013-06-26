package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import entity.Reply;
import java.util.*;

public class ReplyDaoImpl {
	private Connection conn=null;
	private ResultSet rs=null;
	

	public boolean insertNewReply(Reply reply){
		boolean isOK=false;
		conn=DBHelper.getConnection();
		String sql="insert into reply(nickname,work_id,content,reply_type,reply_time)"
					+" values(?,?,?,?,?)";
		Object[] values=new Object[]{
				new String(reply.getNickname()),
				new Integer(reply.getWork_id()),
				new String(reply.getContent()),
				new Integer(reply.getReply_type()),
				new String(reply.getReply_time())
			};
		int result=DBHelper.executeUpdate(conn, sql, values);
		if(result>0){
			isOK=true;
		}
		DBHelper.CloseAll(conn, rs);
		return isOK;
	}
	
	
	public ArrayList<Reply> selectAllNormalReply(int work_id){
		ArrayList<Reply> list=new ArrayList<Reply>();
		conn=DBHelper.getConnection();
		String sql="select * from reply where work_id=? and reply_type=1";
		Object[] values=new Object[]{
				new Integer(work_id)
			};
		rs=DBHelper.executeQuery(conn, sql,values);
		try {
			while(rs.next()){
				Reply reply=new Reply(
						rs.getInt("record_id"),
						rs.getString("nickname"),
						rs.getInt("work_id"),
						rs.getString("content"),
						1,
						rs.getString("reply_time")
				);
				list.add(reply);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBHelper.CloseAll(conn, rs);
		return list;
	} 
	
	//���work_id��ѯ������ί����,type=2
	public ArrayList<Reply> selectAllOfficialReply(int work_id){
		ArrayList<Reply> list=new ArrayList<Reply>();
		conn=DBHelper.getConnection();
		String sql="select * from reply where work_id=? and reply_type=2";
		Object[] values=new Object[]{
				new Integer(work_id)
			};
		rs=DBHelper.executeQuery(conn, sql,values);
		try {
			while(rs.next()){
				Reply reply=new Reply(
						rs.getInt("record_id"),
						rs.getString("nickname"),
						rs.getInt("work_id"),
						rs.getString("content"),
						2,
						rs.getString("reply_time")
				);
				list.add(reply);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBHelper.CloseAll(conn, rs);
		return list;
	} 
	
	
}
