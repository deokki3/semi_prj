package com.moviereview.admin.vo;

import java.util.Date;

public class ShowTimeVo {
	private int num_pk;
	private int movie_resv_num_fk;
	private Date start_time;
	private Date end_time;
	
	public ShowTimeVo() {}
	public ShowTimeVo(int num_pk, int movie_resv_num_fk, Date start_time, Date end_time) {
		super();
		this.num_pk = num_pk;
		this.movie_resv_num_fk = movie_resv_num_fk;
		this.start_time = start_time;
		this.end_time = end_time;
	}
	public int getNum_pk() {
		return num_pk;
	}
	public void setNum_pk(int num_pk) {
		this.num_pk = num_pk;
	}
	public int getMovie_resv_num_fk() {
		return movie_resv_num_fk;
	}
	public void setMovie_resv_num_fk(int movie_resv_num_fk) {
		this.movie_resv_num_fk = movie_resv_num_fk;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	
	
}
