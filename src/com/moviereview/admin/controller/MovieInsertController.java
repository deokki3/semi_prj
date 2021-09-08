package com.moviereview.admin.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moviereview.user.dao.MoviesDao;
import com.moviereview.user.vo.MoviesVo;


@WebServlet("/mInsert")
public class MovieInsertController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("mainpage", "/home/main/mainpage.jsp");
		req.setAttribute("content", "/home/main/mInsert.jsp");
		req.getRequestDispatcher("/home/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		String img_path=req.getParameter("img_path");
		String genre=req.getParameter("genre");
		String country=req.getParameter("country");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/mm/dd");
		
		String d=req.getParameter("opening_date");
		//Date opening_date= java.sql.Date.valueOf(d);
		Date opening_date= java.sql.Date.valueOf(d);
		String preview_url=req.getParameter("preview_url");
		MoviesVo vo=new MoviesVo(0, title, content, img_path, genre, country, opening_date, preview_url, null);

		MoviesDao dao=MoviesDao.getInstance();
		int n=dao.mInsert(vo);
		if(n>0) {
			req.setAttribute("code","success");
			req.setAttribute("mainpage", "/home/main/mainpage.jsp");
			req.setAttribute("content", "/home/main/result.jsp");
		}else {
			req.setAttribute("code","fail");
			req.setAttribute("mainpage", "/home/main/mainpage.jsp");
			req.setAttribute("content", "/home/main/result.jsp");
		}
		req.getRequestDispatcher("/home/index.jsp").forward(req, resp);
	}
}
