package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Team;

public class TeamDaoImpl {
	private Connection conn=null;
	private ResultSet rs=null;
	
	//根据work_id查询队伍实体
	public Team selectTeamByWorkId(int work_id){
		Team team=null;
		conn=DBHelper.getConnection();
		String sql="select t.* from team t inner join work w on t.team_id=w.team_id where w.work_id=?";
		Object[] values=new Object[]{
				new Integer(work_id)
			};
		rs=DBHelper.executeQuery(conn, sql,values);
		try {
			if(rs.next()){
				team=new Team(
						rs.getInt("team_id"),
						rs.getString("leader_name"),
						rs.getString("team_name")
				);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBHelper.CloseAll(conn, rs);
		return team;
	}
}
