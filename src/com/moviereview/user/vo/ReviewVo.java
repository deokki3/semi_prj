package com.moviereview.user.vo;

import java.sql.Date;

public class ReviewVo {
	private int num_pk;
	private String members_id_fk;
	private int movie_ls_num_fk;
	private String content;
	private Date reg_date;

	
	public ReviewVo() {}

	public ReviewVo(int num_pk, String members_id_fk, int movie_ls_num_fk, String content, Date reg_date) {
		super();
		this.num_pk = num_pk;
		this.members_id_fk = members_id_fk;
		this.movie_ls_num_fk = movie_ls_num_fk;
		this.content = content;
		this.reg_date = reg_date;

	}

	public int getNum_pk() {
		return num_pk;
	}

	public void setNum_pk(int num_pk) {
		this.num_pk = num_pk;
	}

	public String getMembers_id_fk() {
		return members_id_fk;
	}

	public void setMembers_id_fk(String members_id_fk) {
		this.members_id_fk = members_id_fk;
	}

	public int getMovie_ls_num_fk() {
		return movie_ls_num_fk;
	}

	public void setMovie_ls_num_fk(int movie_ls_num_fk) {
		this.movie_ls_num_fk = movie_ls_num_fk;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}


	


}
