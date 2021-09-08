package com.moviereview.admin.vo;

import java.sql.Date;

public class MovieResvVo {
	private int num_pk;
	private int movie_ls_num_fk;
	private int price;
	public MovieResvVo() {}
	public MovieResvVo(int num_pk, int movie_ls_num_fk, int price) {
		super();
		this.num_pk = num_pk;
		this.movie_ls_num_fk = movie_ls_num_fk;
		this.price = price;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
