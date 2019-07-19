package spring;

import java.util.Date;

public class Member {
	private Long id;
	private String email;
	private String password;
	private String name;
	private Date regDate;
	public Member() {}
	public Member(String email, String password, String name, Date regDate){
		this.email = email;
		this.password = password;
		this.name = name;
		this.regDate = regDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pw) {
		this.password = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public void changePw(String oldPw, String newPw) {
		if(!password.equals(oldPw)) {
			throw new IdPasswordNotMatchingException();
		}
		this.password = newPw;
	}
	public boolean matchPassword(String pwd) {
		return this.password.equals(pwd);
	}

}
