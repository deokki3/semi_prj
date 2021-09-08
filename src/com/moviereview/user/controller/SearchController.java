package com.moviereview.user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moviereview.user.dao.ActorsDao;
import com.moviereview.user.dao.DirectorDao;
import com.moviereview.user.dao.MoviesDao;
import com.moviereview.user.vo.ActorsVo;
import com.moviereview.user.vo.DirectorVo;
import com.moviereview.user.vo.MoviesVo;

@WebServlet("/search.do")
public class SearchController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String keyword=req.getParameter("keyword");
		MoviesVo vo=new MoviesVo();
		ActorsVo avo=new ActorsVo();
		DirectorVo dvo=new DirectorVo();
		
		MoviesDao dao=MoviesDao.getInstance();
		ActorsDao adao=ActorsDao.getInstance();
		DirectorDao ddao=DirectorDao.getInstance();
		
		ArrayList<MoviesVo> movieSearch=dao.movieSearch(keyword);
		ArrayList<ActorsVo> searchActor=adao.searchActor(keyword);
		ArrayList<DirectorVo> searchDirector=ddao.searchDirector(keyword);
		
		
		
		req.setAttribute("mslist", movieSearch);
		req.setAttribute("aslist", searchActor);
		req.setAttribute("dslist", searchDirector);
		
		req.setAttribute("keyword", keyword);
		req.getRequestDispatcher("/home/search/search.jsp").forward(req, resp);
	}
	
}

