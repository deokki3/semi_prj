package com.moviereview.admin.vo;

public class SeatVo {
	private int num_pk;
	private int theater_num_fk;
	private String crdnt;
	private boolean dplct_check;
	public SeatVo() {}
	public SeatVo(int num_pk, int theater_num_fk, String crdnt, boolean dplct_check) {
		super();
		this.num_pk = num_pk;
		this.theater_num_fk = theater_num_fk;
		this.crdnt = crdnt;
		this.dplct_check = dplct_check;
	}
	public int getNum_pk() {
		return num_pk;
	}
	public void setNum_pk(int num_pk) {
		this.num_pk = num_pk;
	}
	public int getTheater_num_fk() {
		return theater_num_fk;
	}
	public void setTheater_num_fk(int theater_num_fk) {
		this.theater_num_fk = theater_num_fk;
	}
	public String getCrdnt() {
		return crdnt;
	}
	public void setCrdnt(String crdnt) {
		this.crdnt = crdnt;
	}
	public boolean isDplct_check() {
		return dplct_check;
	}
	public void setDplct_check(boolean dplct_check) {
		this.dplct_check = dplct_check;
	}
}
