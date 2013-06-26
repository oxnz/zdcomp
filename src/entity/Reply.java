package entity;

public class Reply {
	private int record_id;
	private String nickname;
	private int work_id;
	private String content;
	private int reply_type;
	private String reply_time;
	/**
	 * constructor
	 * */
	public Reply(int recordId, String nickname, int workId, String content,
			int replyType, String replyTime) {
		record_id = recordId;
		this.nickname=nickname;
		work_id = workId;
		this.content = content;
		reply_type = replyType;
		reply_time = replyTime;
	}
	public int getRecord_id() {
		return record_id;
	}
	public void setRecord_id(int recordId) {
		record_id = recordId;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getWork_id() {
		return work_id;
	}
	public void setWork_id(int workId) {
		work_id = workId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReply_type() {
		return reply_type;
	}
	public void setReply_type(int replyType) {
		reply_type = replyType;
	}
	public String getReply_time() {
		return reply_time;
	}
	public void setReply_time(String replyTime) {
		reply_time = replyTime;
	}
	
	
}
