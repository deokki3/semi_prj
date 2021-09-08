package com.moviereview.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moviereview.user.dao.MoviesDao;

@WebServlet("/mDelete")
public class MovieDeleteController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num_pk=Integer.parseInt(req.getParameter("num_pk"));
		String title=req.getParameter("title");
		MoviesDao dao=MoviesDao.getInstance();
		int n=dao.mDelete(num_pk, title);
		if(n>0) {
			req.setAttribute("code","success");
			req.setAttribute("mainpage", "/home/main/mainpage.jsp");
			req.setAttribute("content", "/home/main/result.jsp");
			req.getRequestDispatcher("/home/index.jsp").forward(req, resp);
		}else {
			req.setAttribute("code","fail");
			req.setAttribute("mainpage", "/home/main/mainpage.jsp");
			req.setAttribute("content", "/home/main/result.jsp");
			req.getRequestDispatcher("/home/index.jsp").forward(req, resp);
		}
	}
}
