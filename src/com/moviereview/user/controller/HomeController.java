package com.moviereview.user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moviereview.user.dao.MembersDao;
import com.moviereview.user.dao.MoviesDao;
import com.moviereview.user.vo.MembersVo;
import com.moviereview.user.vo.MoviesVo;



@WebServlet("/home")
public class HomeController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//최신 영화 뽑아오기(content1)
		MoviesDao dao=MoviesDao.getInstance();
		ArrayList<MoviesVo> latestMovieList=dao.latestMovieList();
		req.setAttribute("latestMovieList",latestMovieList);
		//액션 영화 뽑아오기
		ArrayList<MoviesVo> actionMovieList=dao.actionMovieList();
		req.setAttribute("actionMovieList",actionMovieList);
		//범죄 스릴러 영화 뽑아오기
		ArrayList<MoviesVo> crimeThrillerMovieList=dao.crimeThrillerMovieList();
		req.setAttribute("crimeThrillerMovieList", crimeThrillerMovieList);


		
		
		String mainpage=(String)req.getAttribute("mainpage");
		String banner=(String)req.getAttribute("banner");
		String content=(String)req.getAttribute("content");
		String content1=(String)req.getAttribute("content1");
		String content2=(String)req.getAttribute("content2");
		String content3=(String)req.getAttribute("content3");
	//	네비게이션바 추가
		String top=(String)req.getAttribute("top");
		
		if(top==null) {
			top="/home/main/navigationBar.jsp";
		}
		req.setAttribute("top", top);
		if(mainpage==null || mainpage.equals("")) {
			mainpage="/home/main/mainpage.jsp";
		} 
		if(content==null || content.equals("")) {
			content="/home/content/content.jsp";
		}
		req.setAttribute("mainpage", mainpage);
		req.setAttribute("content", content);

		if(banner==null || banner.equals("")) {
			banner="/home/banner/banner.jsp";
		}
		req.setAttribute("banner", banner);
		
		if(content1==null || content1.equals("")) {
			content1="/home/content/content1.jsp";
		}
		req.setAttribute("content1", content1);
		
		if(content2==null || content2.equals("")) {
			content2="/home/content/content2.jsp";
		}
		req.setAttribute("content2", content2);

		if(content3==null || content3.equals("")) {
			content3="/home/content/content3.jsp";
		}
		req.setAttribute("content3", content3);
	
	
		
		String cp=req.getContextPath();
		ServletContext application=getServletContext();
		application.setAttribute("cp", cp);
		
		req.getRequestDispatcher("/home/index.jsp").forward(req, resp);
	}
}
