package com.moviereview.user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moviereview.user.dao.MoviesDao;
import com.moviereview.user.vo.MoviesVo;
@WebServlet("/otherMovieCategory")
public class OtherMovieController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MoviesDao dao=MoviesDao.getInstance();
		ArrayList<MoviesVo> romanceMovie=dao.romanceMovieList();
		req.setAttribute("romanceMovie", romanceMovie);
		
		ArrayList<MoviesVo> dramaMovie=dao.dramaMovieList();
		req.setAttribute("dramaMovie", dramaMovie);
		
		ArrayList<MoviesVo> sfMoive=dao.sfMovieList();
		req.setAttribute("sfMoive", sfMoive);
		
		req.setAttribute("searchMain", "/home/search/searchMain.jsp");
		req.setAttribute("searchContent", "/home/genre/genre4.jsp");
		
		req.getRequestDispatcher("/home/search/searchIndex.jsp").forward(req, resp);
	}
}
