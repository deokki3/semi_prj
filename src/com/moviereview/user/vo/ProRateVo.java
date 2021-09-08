package com.moviereview.user.vo;

public class ProRateVo {
	private int num_pk;
	private int movie_ls_num_fk;
	private Double rate;
	
	public ProRateVo() {}

	public ProRateVo(int num_pk, int movie_ls_num_fk, Double rate) {
		super();
		this.num_pk = num_pk;
		this.movie_ls_num_fk = movie_ls_num_fk;
		this.rate = rate;
	}

	public int getNum_pk() {
		return num_pk;
	}

	public void setNum_pk(int num_pk) {
		this.num_pk = num_pk;
	}

	public int getMovie_ls_num_fk() {
		return movie_ls_num_fk;
	}

	public void setMovie_ls_num_fk(int movie_ls_num_fk) {
		this.movie_ls_num_fk = movie_ls_num_fk;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}
	
}
