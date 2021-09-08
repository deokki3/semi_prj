package com.moviereview.admin.vo;

import java.sql.Date;

public class MoviesVo {
	private int num_pk;
	private String title;
	private String content;
	private String img_path;
	private String genre;
	private String country;
	private Date opening_date; 
	private String preview_url;
	private Date reg_date;
	
	public MoviesVo() {}
	
	public MoviesVo(int num_pk, String title, String content, String img_path, String genre, String country,
			Date opening_date, String preview_url, Date reg_date) {
		super();
		this.num_pk = num_pk;
		this.title = title;
		this.content = content;
		this.img_path = img_path;
		this.genre = genre;
		this.country = country;
		this.opening_date = opening_date;
		this.preview_url = preview_url;
		this.reg_date = reg_date;
	}


	public int getNum_pk() {
		return num_pk;
	}

	public void setNum_pk(int num_pk) {
		this.num_pk = num_pk;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getOpening_date() {
		return opening_date;
	}

	public void setOpening_date(Date opening_date) {
		this.opening_date = opening_date;
	}

	public String getPreview_url() {
		return preview_url;
	}

	public void setPreview_url(String preview_url) {
		this.preview_url = preview_url;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

}
