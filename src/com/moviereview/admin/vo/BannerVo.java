package com.moviereview.admin.vo;

import java.sql.Date;

public class BannerVo {
	private int num;//seq_banner_tb_num_pk
	private String title;
	private String content;
	private String imgPath;
	private String url;
	private Date startDate;
	private Date endDate;
	private Date regDate;
	public BannerVo() {}
	
	public BannerVo(int num, String title, String content, String imgPath, String url, Date startDate, Date endDate,
			Date regDate) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.imgPath = imgPath;
		this.url = url;
		this.startDate = startDate;
		this.endDate = endDate;
		this.regDate = regDate;
	}

	public void setNum(int num) {
		this.num = num;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getNum() {
		return num;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getImgPath() {
		return imgPath;
	}
	public String getUrl() {
		return url;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public Date getRegDate() {
		return regDate;
	}
}
