package entity;

public class Remark {
	private int record_id;
	private int user_id;
	private int work_id;
	private double score;
	private String remark_time;
	
	/**
	 * constructor
	 * */
	public Remark(int recordId, int userId, int workId, double score,String time) {
		super();
		record_id = recordId;
		user_id = userId;
		work_id = workId;
		this.score = score;
		this.remark_time=time;
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
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getRemark_time() {
		return remark_time;
	}
	public void setRemark_time(String remarkTime) {
		remark_time = remarkTime;
	}
	
	
}
