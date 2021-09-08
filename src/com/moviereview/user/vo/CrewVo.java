package com.moviereview.user.vo;

public class CrewVo {
	int num_pk;
	int actor_num_fk;
	int movie_ls_num_fk;
	
	public CrewVo() {}

	public CrewVo(int num_pk, int actor_num_fk, int movie_ls_num_fk) {
		super();
		this.num_pk = num_pk;
		this.actor_num_fk = actor_num_fk;
		this.movie_ls_num_fk = movie_ls_num_fk;
	}

	public int getNum_pk() {
		return num_pk;
	}

	public void setNum_pk(int num_pk) {
		this.num_pk = num_pk;
	}

	public int getActor_num_fk() {
		return actor_num_fk;
	}

	public void setActor_num_fk(int actor_num_fk) {
		this.actor_num_fk = actor_num_fk;
	}

	public int getMovie_ls_num_fk() {
		return movie_ls_num_fk;
	}

	public void setMovie_ls_num_fk(int movie_ls_num_fk) {
		this.movie_ls_num_fk = movie_ls_num_fk;
	}
	
	
}
