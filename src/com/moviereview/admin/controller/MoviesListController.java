package com.moviereview.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moviereview.user.dao.MoviesDao;
import com.moviereview.user.vo.MoviesVo;

@WebServlet("/mList")
public class MoviesListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MoviesDao dao=MoviesDao.getInstance();
		ArrayList<MoviesVo> moviesList=dao.moviesList();
		req.setAttribute("moviesList", moviesList);
		
		
		req.setAttribute("mainpage", "/home/main/mainpage.jsp");
		req.setAttribute("content", "/home/main/moviesList.jsp");
		
		req.getRequestDispatcher("/home/index.jsp").forward(req, resp);
	}
}
