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
@WebServlet("/yearCategory")
public class YearCategoryController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MoviesDao dao=MoviesDao.getInstance();
		ArrayList<MoviesVo> oneMovieList=dao.oneMovieList();
		req.setAttribute("oneMovieList", oneMovieList);
		
		ArrayList<MoviesVo> twoMovieList=dao.twoMovieList();
		req.setAttribute("twoMovieList", twoMovieList);
		
		ArrayList<MoviesVo> threeMovieList=dao.threeMovieList();
		req.setAttribute("threeMovieList", threeMovieList);
		
		req.setAttribute("searchMain", "/home/search/searchMain.jsp");
		req.setAttribute("searchContent", "/home/genre/genre5.jsp");
		
		req.getRequestDispatcher("/home/search/searchIndex.jsp").forward(req, resp);
	}
}
