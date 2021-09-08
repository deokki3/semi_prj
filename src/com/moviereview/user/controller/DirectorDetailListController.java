package com.moviereview.user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moviereview.user.dao.DirectorDao;
import com.moviereview.user.dao.MoviesDao;
import com.moviereview.user.vo.DirectorVo;
import com.moviereview.user.vo.MoviesVo;

@WebServlet("/directorDetailList")
public class DirectorDetailListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num_pk=Integer.parseInt(req.getParameter("num_pk"));
		
		MoviesDao mdao=MoviesDao.getInstance();
		ArrayList<MoviesVo> directorDetailList=mdao.directorDetailList(num_pk);
		
		req.setAttribute("directorDetailList", directorDetailList);
		
		DirectorDao ddao=DirectorDao.getInstance();
		DirectorVo dvo=ddao.getDirectorInfo(num_pk);
		req.setAttribute("dvo", dvo);
		
		req.setAttribute("mainpage", "/home/main/mainpage.jsp");
		req.setAttribute("content", "/home/main/directorDetailList.jsp");
	
		req.getRequestDispatcher("/home/index.jsp").forward(req, resp);
	}
}
