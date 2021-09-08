package com.moviereview.user.vo;

public class DirectorVo {
	private int num_pk;
	private String name;
	private String img_path;
	
	public DirectorVo() {}

	public DirectorVo(int num_pk, String name, String img_path) {
		super();
		this.num_pk = num_pk;
		this.name = name;
		this.img_path = img_path;
	}

	public int getNum_pk() {
		return num_pk;
	}

	public void setNum_pk(int num_pk) {
		this.num_pk = num_pk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	
	
}
