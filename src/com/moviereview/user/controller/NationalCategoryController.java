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
@WebServlet("/nationalsCategory")
public class NationalCategoryController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MoviesDao dao=MoviesDao.getInstance();
		ArrayList<MoviesVo> americanMovie=dao.americanMovie();
		req.setAttribute("americanMovie", americanMovie);
		
		ArrayList<MoviesVo> koreanMovie=dao.koreanMovie();
		req.setAttribute("koreanMovie", koreanMovie);
		
		ArrayList<MoviesVo> englishMoive=dao.englishMovie();
		req.setAttribute("englishMovie", englishMoive);
		
		req.setAttribute("searchMain", "/home/search/searchMain.jsp");
		req.setAttribute("searchContent", "/home/genre/genre2.jsp");
		
		req.getRequestDispatcher("/home/search/searchIndex.jsp").forward(req, resp);
	}
}
