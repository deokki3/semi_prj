package com.moviereview.user.vo;

import java.sql.Date;

public class MembersVo {

	private String id_pk;
	private String pwd;
	private String nick;
	private Date birth_date;
	private String phone;
	private String email;
	private String intro;
	public MembersVo() {}
	public MembersVo(String id_pk, String pwd, String nick, Date birth_date, String phone, String email,
			String intro) {
		super();
		this.id_pk = id_pk;
		this.pwd = pwd;
		this.nick = nick;
		this.birth_date = birth_date;
		this.phone = phone;
		this.email = email;
		this.intro = intro;
	}
	public String getId_pk() {
		return id_pk;
	}
	public void setId_pk(String id_pk) {
		this.id_pk = id_pk;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public Date getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
}
