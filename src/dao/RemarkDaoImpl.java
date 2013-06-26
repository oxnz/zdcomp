package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Remark;

public class RemarkDaoImpl {
	private Connection conn=null;
	private ResultSet rs=null;
	
	public boolean insertNewRemark(Remark remark){
		boolean isOK=false;
		conn=DBHelper.getConnection();
		String sql="insert into remark(user_id,work_id,score,remark_time) values(?,?,?,?)";
		Object[] values=new Object[]{
				new Integer(remark.getUser_id()),
				new Integer(remark.getWork_id()),
				new Double(remark.getScore()),
				new String(remark.getRemark_time())
			};
		int result=DBHelper.executeUpdate(conn, sql, values);
		if(result>0){
			isOK=true;
		}
		DBHelper.CloseAll(conn, rs);
		return isOK;
	}
	
	//看该评委是否已经打过分
	public boolean selectIsRemarked(int user_id,int work_id){
		boolean isRemarked=false;
		conn=DBHelper.getConnection();
		String sql="select count(*) number from remark where user_id=? and work_id=?";
		Object[] values=new Object[]{
				new Integer(user_id),
				new Integer(work_id)
			};
		rs=DBHelper.executeQuery(conn, sql,values);
		try {
			if(rs.next()){
				int count=rs.getInt("number");
				if(count>=1){
					isRemarked=true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBHelper.CloseAll(conn, rs);
		return isRemarked;
	}
}
