package com.moviereview.admin.vo;

public class TheaterVo {
	private int num_pk;
	private int showtime_num_fk;
	private String name;
	private int theater_num;
	private int seat_tot_cnt;
	public TheaterVo() {}
	public TheaterVo(int num_pk, int showtime_num_fk, String name, int theater_num, int seat_tot_cnt) {
		super();
		this.num_pk = num_pk;
		this.showtime_num_fk = showtime_num_fk;
		this.name = name;
		this.theater_num = theater_num;
		this.seat_tot_cnt = seat_tot_cnt;
	}
	public int getNum_pk() {
		return num_pk;
	}
	public void setNum_pk(int num_pk) {
		this.num_pk = num_pk;
	}
	public int getShowtime_num_fk() {
		return showtime_num_fk;
	}
	public void setShowtime_num_fk(int showtime_num_fk) {
		this.showtime_num_fk = showtime_num_fk;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTheater_num() {
		return theater_num;
	}
	public void setTheater_num(int theater_num) {
		this.theater_num = theater_num;
	}
	public int getSeat_tot_cnt() {
		return seat_tot_cnt;
	}
	public void setSeat_tot_cnt(int seat_tot_cnt) {
		this.seat_tot_cnt = seat_tot_cnt;
	}
	
}
