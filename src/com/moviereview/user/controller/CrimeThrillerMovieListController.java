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
@WebServlet("/crimeThrillerMovieList")
public class CrimeThrillerMovieListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MoviesDao dao=MoviesDao.getInstance();
		ArrayList<MoviesVo> crimeThrillerMovieList=dao.crimeThrillerMovieList();
		req.setAttribute("crimeThrillerMovieList", crimeThrillerMovieList);
		
		req.getRequestDispatcher("/home/content/content3.jsp").forward(req, resp);
	}
}
