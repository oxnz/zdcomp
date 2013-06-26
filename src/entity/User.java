package entity;

public class User {
	private int user_id;
	private String email;
	private String qq;
	private String password;
	private String nickname;
	private int user_type;

	public User() {}
	public User(int userId, String email, String qq, String password, String nickname, int userType) {
		this.user_id = userId;
		this.email = email;
		this.qq = qq;
		this.password = password;
		this.nickname = nickname;
		user_type = userType;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getUser_type() {
		return user_type;
	}
	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}

}
