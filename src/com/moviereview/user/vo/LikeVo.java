package com.moviereview.user.vo;

public class LikeVo {
	private int num_pk;
	private String members_id_fk;
	private int movie_ls_num_fk;
	private int like_or_dislike;
	public LikeVo() {}
	public LikeVo(int num_pk, String members_id_fk, int movie_ls_num_fk, int like_or_dislike) {
		super();
		this.num_pk = num_pk;
		this.members_id_fk = members_id_fk;
		this.movie_ls_num_fk = movie_ls_num_fk;
		this.like_or_dislike = like_or_dislike;
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
	public int getLike_or_dislike() {
		return like_or_dislike;
	}
	public void setLike_or_dislike(int like_or_dislike) {
		this.like_or_dislike = like_or_dislike;
	}
	
	
	
	

}
