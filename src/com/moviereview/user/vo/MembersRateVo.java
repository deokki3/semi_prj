package com.moviereview.user.vo;

public class MembersRateVo {
	private int num_pk;
	private String members_id_fk;
	private int movie_ls_num_fk;
	private int rate;
	
	public MembersRateVo() {}

	public MembersRateVo(int num_pk,int rate) {
		super();
		this.num_pk = num_pk;
		this.rate = rate;
	}
	
	public MembersRateVo(int num_pk, String members_id_fk, int movie_ls_num_fk, int rate) {
		super();
		this.num_pk = num_pk;
		this.members_id_fk = members_id_fk;
		this.movie_ls_num_fk = movie_ls_num_fk;
		this.rate = rate;
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

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
	
}
