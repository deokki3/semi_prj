package com.moviereview.user.vo;

public class StaffVo {
	int num_pk;
	int director_num_fk;
	int movie_ls_num_fk;
	
	public StaffVo() {}

	public StaffVo(int num_pk, int director_num_fk, int movie_ls_num_fk) {
		super();
		this.num_pk = num_pk;
		this.director_num_fk = director_num_fk;
		this.movie_ls_num_fk = movie_ls_num_fk;
	}

	public int getNum_pk() {
		return num_pk;
	}

	public void setNum_pk(int num_pk) {
		this.num_pk = num_pk;
	}

	public int getDirector_num_fk() {
		return director_num_fk;
	}

	public void setDirector_num_fk(int director_num_fk) {
		this.director_num_fk = director_num_fk;
	}

	public int getMovie_ls_num_fk() {
		return movie_ls_num_fk;
	}

	public void setMovie_ls_num_fk(int movie_ls_num_fk) {
		this.movie_ls_num_fk = movie_ls_num_fk;
	}
	
	
	
}
