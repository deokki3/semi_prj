package com.moviereview.user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moviereview.user.dao.MoviesDao;
import com.moviereview.user.vo.MoviesVo;
@WebServlet("/suggestMovie")
public class SuggestMovieController extends HttpServlet{
@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MoviesDao dao=MoviesDao.getInstance();
		ArrayList<MoviesVo> suggestMovie=dao.suggestMovie();
		req.setAttribute("suggestMovie", suggestMovie);
	
		req.getRequestDispatcher("/home/main/searchContent1.jsp").forward(req, resp);
		
	}
	
		
	
	
}
