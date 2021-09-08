package com.moviereview.user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moviereview.user.dao.MembersDao;
import com.moviereview.user.dao.MoviesDao;
import com.moviereview.user.vo.MembersVo;
import com.moviereview.user.vo.MoviesVo;

@WebServlet("/latestMovieList")
public class LatestMovieListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MoviesDao dao=MoviesDao.getInstance();
		ArrayList<MoviesVo> latestMovieList=dao.latestMovieList();
		req.setAttribute("latestMovieList",latestMovieList);
		String id_pk=req.getParameter("id_pk");
		MembersDao mdao=MembersDao.getInstance();
		MembersVo m1vo=mdao.getInfo(id_pk);
		req.setAttribute("m1vo", m1vo);
		
		req.getRequestDispatcher("/home/content/content1.jsp").forward(req, resp);
	}
}
