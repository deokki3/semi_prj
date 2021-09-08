package com.moviereview.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moviereview.user.dao.ActorsDao;
import com.moviereview.user.dao.DirectorDao;
import com.moviereview.user.vo.ActorsVo;
import com.moviereview.user.vo.DirectorVo;

@WebServlet("/aInsert")
public class ActorInsertController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("mainpage", "/home/main/mainpage.jsp");
		req.setAttribute("content", "/home/main/aInsert.jsp");
		
		req.getRequestDispatcher("/home/index.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name=req.getParameter("name");
		String img_path=req.getParameter("img_path");
		String field=req.getParameter("field");
		
		ActorsVo vo=new ActorsVo(0,name,img_path);
		ActorsDao dao=ActorsDao.getInstance();
		
		DirectorVo dvo=new DirectorVo(0,name,img_path);
		DirectorDao ddao=DirectorDao.getInstance();
		
		int n=0;
		if(field.equals("actor")) {
			n=dao.aInsert(vo);
		}
		if(field.equals("director")) {
			n=ddao.dInsert(dvo);
		}
		
		
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
