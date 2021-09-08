package com.moviereview.admin.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moviereview.admin.dao.BannerDao;
import com.moviereview.admin.vo.BannerVo;


@WebServlet("/insert")
public class BannerInsertController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/bannerInsert.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String title=req.getParameter("title");
		System.out.println(title);
		String content=req.getParameter("content");
		String imgpath=req.getParameter("imgPath");
		String url=req.getParameter("url");
		
		String s=req.getParameter("startDate");
		String e=req.getParameter("endDate");
		
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/mm/dd");
		Date startDate=java.sql.Date.valueOf(s);
		Date endDate=java.sql.Date.valueOf(e);
		System.out.println("startDate"+startDate);
		
		BannerVo vo=new BannerVo(0, title, content, imgpath, url, startDate, endDate, null);
		System.out.println(vo.getTitle());
		System.out.println(vo.getContent());
		System.out.println(vo.getImgPath());
		System.out.println(vo.getUrl());
		
		BannerDao dao=new BannerDao();
		int n=dao.insert(vo);
		if(n>0) {
			req.setAttribute("code", "success");
		}else {
			req.setAttribute("code", "fail");
		}
		req.getRequestDispatcher("/banner/result.jsp").forward(req, resp);
	}
}
