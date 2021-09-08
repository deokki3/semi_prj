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
@WebServlet("/genre.do")
public class GenreController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MoviesDao dao=MoviesDao.getInstance();
		
		ArrayList<MoviesVo> actionCategory=dao.actionMovieList();
		
		req.setAttribute("actionCategory", actionCategory);
		
		String genre=(String)req.getAttribute("genre");
		String genre1=(String)req.getAttribute("genre1");
		System.out.println(genre);
		
		if(genre==null) {
			genre="/home/search/genre.jsp";
		}
		req.setAttribute("genre", actionCategory);
		
		if(genre1==null) {
			genre="/home/search/genre1.jsp";
		}
		req.setAttribute("genre1", actionCategory);
		
		String cp=req.getContextPath();
		ServletContext application=getServletContext();
		application.setAttribute("cp", cp);
		req.getRequestDispatcher("/home/search/searchIndex2.jsp").forward(req, resp);
	}
}
