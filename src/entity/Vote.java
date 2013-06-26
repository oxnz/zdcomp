package entity;

public class Vote {
	private int record_id;
	private int user_id;
	private int work_id;
	private String vote_time;
	/**
	 * constructor
	 * */
	public Vote(int recordId, int userId, int workId, String voteTime) {
		super();
		record_id = recordId;
		user_id = userId;
		work_id = workId;
		vote_time = voteTime;
	}
	public int getRecord_id() {
		return record_id;
	}
	public void setRecord_id(int recordId) {
		record_id = recordId;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int userId) {
		user_id = userId;
	}
	public int getWork_id() {
		return work_id;
	}
	public void setWork_id(int workId) {
		work_id = workId;
	}
	public String getVote_time() {
		return vote_time;
	}
	public void setVote_time(String voteTime) {
		vote_time = voteTime;
	}
	
	
}
