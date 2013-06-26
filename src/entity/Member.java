package entity;

public class Member {
	private int member_id;
	private int team_id;
	private String name;
	private String job;
	private String school;
	private String college;
	private String experience;
	private String telephone;
	private String photo;
	
	/**
	 * constructor
	 * */
	public Member(int memberId, int teamId, String name, String job,
			String school, String college, String experience, String telephone,
			String photo) {
		super();
		member_id = memberId;
		team_id = teamId;
		this.name = name;
		this.job = job;
		this.school = school;
		this.college = college;
		this.experience = experience;
		this.telephone = telephone;
		this.photo = photo;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int memberId) {
		member_id = memberId;
	}
	public int getTeam_id() {
		return team_id;
	}
	public void setTeam_id(int teamId) {
		team_id = teamId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
