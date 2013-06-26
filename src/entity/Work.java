package entity;

public class Work implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int work_id;
	private String work_name;
	private int team_id;
	private int downloads;
	private String logo;
	private String pic1;
	private String pic2;
	private String pic3;
	private String pic4;
	private String pic5;
	private String introduction;
	private String address;
	
	/**
	 * constructor
	 * */
	public Work(int workId, String workName, int teamId, int downloads,
			String logo, String pic1, String pic2, String pic3, String pic4,String pic5,
			String introduction,String address) {
		work_id = workId;
		work_name = workName;
		team_id = teamId;
		this.downloads = downloads;
		this.logo = logo;
		this.pic1 = pic1;
		this.pic2 = pic2;
		this.pic3 = pic3;
		this.pic4 = pic4;
		this.pic5= pic5;
		this.introduction = introduction;
		this.address=address;
	}
	public int getWork_id() {
		return work_id;
	}
	public void setWork_id(int workId) {
		work_id = workId;
	}
	public String getWork_name() {
		return work_name;
	}
	public void setWork_name(String workName) {
		work_name = workName;
	}
	public int getTeam_id() {
		return team_id;
	}
	public void setTeam_id(int teamId) {
		team_id = teamId;
	}
	public int getDownloads() {
		return downloads;
	}
	public void setDownloads(int downloads) {
		this.downloads = downloads;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getPic1() {
		return pic1;
	}
	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}
	public String getPic2() {
		return pic2;
	}
	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}
	public String getPic3() {
		return pic3;
	}
	public void setPic3(String pic3) {
		this.pic3 = pic3;
	}
	public String getPic4() {
		return pic4;
	}
	public void setPic4(String pic4) {
		this.pic4 = pic4;
	}
	
	public String getPic5() {
		return pic5;
	}
	public void setPic5(String pic5) {
		this.pic5 = pic5;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
