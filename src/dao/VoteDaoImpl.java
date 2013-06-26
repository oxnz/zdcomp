package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;

//import entity.Reply;
import entity.Vote;


public class VoteDaoImpl {
	private Connection conn=null;
	private ResultSet rs=null;
	
	//给某作品投票
	public boolean insertNewVote(Vote vote){
		boolean isOK=false;
		conn=DBHelper.getConnection();
		String sql="insert into vote(user_id,work_id,vote_time) values(?,?,?)";
		Object[] values=new Object[]{
				new Integer(vote.getUser_id()),
				new Integer(vote.getWork_id()),
				new String(vote.getVote_time())
			};
		int result=DBHelper.executeUpdate(conn, sql, values);
		if(result>0){
			isOK=true;
		}
		DBHelper.CloseAll(conn, rs);
		return isOK;
	}
	
	//查询某一个作品的投票数
	public int selectVoteCount(int work_id){
		int count=0;
		conn=DBHelper.getConnection();
		String sql="select count(*) number from vote where work_id=?";
		Object[] values=new Object[]{
				new Integer(work_id)
			};
		rs=DBHelper.executeQuery(conn, sql,values);
		try {
			if(rs.next()){
				count=rs.getInt("number");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBHelper.CloseAll(conn, rs);
		return count;
	}
	
	//查询某个用户是否已对某作品投过票
	public boolean selectIsVoted(int user_id,int work_id){
		boolean isVoted=false;
		conn=DBHelper.getConnection();
		String sql="select count(*) number from vote where user_id=? and work_id=?";
		Object[] values=new Object[]{
				new Integer(user_id),
				new Integer(work_id)
			};
		rs=DBHelper.executeQuery(conn, sql,values);
		try {
			if(rs.next()){
				int count=rs.getInt("number");
				if(count>=1){
					isVoted=true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBHelper.CloseAll(conn, rs);
		return isVoted;
	}
	
}
