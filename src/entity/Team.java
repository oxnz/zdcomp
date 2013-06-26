package entity;

public class Team implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int team_id;
	private String leader_name;
	private String team_name;
	
	/**
	 * constructor
	 * */
	public Team(int teamId, String leader_name, String teamName) {
		super();
		team_id = teamId;
		this.leader_name=leader_name;
		team_name = teamName;
	}
	public int getTeam_id() {
		return team_id;
	}
	public void setTeam_id(int teamId) {
		team_id = teamId;
	}
	
	public String getLeader_name() {
		return leader_name;
	}
	public void setLeader_name(String leaderName) {
		leader_name = leaderName;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String teamName) {
		team_name = teamName;
	}
	
	
}
