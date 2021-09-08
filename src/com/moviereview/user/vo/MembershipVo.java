package com.moviereview.user.vo;

public class MembershipVo {
	private int num_pk ;
	private String members_id_fk;
	private String grade;
	private int point;
	
	public MembershipVo() {}

	public MembershipVo(int num_pk, String members_id_fk, String grade, int point) {
		super();
		this.num_pk = num_pk;
		this.members_id_fk = members_id_fk;
		this.grade = grade;
		this.point = point;
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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	
}
