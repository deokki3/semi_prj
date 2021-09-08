package com.moviereview.admin.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moviereview.user.dao.ActorsDao;
import com.moviereview.user.dao.CrewDao;
import com.moviereview.user.dao.DirectorDao;
import com.moviereview.user.dao.MembersRateDao;
import com.moviereview.user.dao.MoviesDao;
import com.moviereview.user.dao.ProRateDao;
import com.moviereview.user.vo.ActorsVo;
import com.moviereview.user.vo.CrewVo;
import com.moviereview.user.vo.DirectorVo;
import com.moviereview.user.vo.MoviesVo;
import com.moviereview.user.vo.ProRateVo;
@WebServlet("/movieUpdate")
public class MovieUpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num_pk=Integer.parseInt(req.getParameter("num_pk"));
		MoviesDao dao=MoviesDao.getInstance();
		//영화 정보
		MoviesDao mdao=MoviesDao.getInstance();
		MoviesVo mvo=mdao.getinfo(num_pk);
				
		req.setAttribute("mvo",mvo);
				
		//멤버 평균 평점
		MembersRateDao mrdao=MembersRateDao.getInstance();
		Double membersAvgrate=mrdao.membersAvgrate(num_pk);
				
		req.setAttribute("membersAvgrate", membersAvgrate);
			
		//전문가 평점
		ProRateDao pdao=ProRateDao.getInstance();
		ProRateVo pvo=pdao.getProRate(num_pk);
				
		req.setAttribute("pvo", pvo);
				
		//크루 디테일리스트
		CrewDao cdao=CrewDao.getInstance();
		ArrayList<CrewVo> crewDetailList=cdao.crewDetailList(num_pk);
				
		req.setAttribute("crewDetailList",crewDetailList);
				
		//감독 정보
		DirectorDao ddao=DirectorDao.getInstance();
		DirectorVo dvo=ddao.getDirectorInfo(num_pk);
				
		req.setAttribute("dvo", dvo);
				
		//배우 정보
		ActorsDao adao=ActorsDao.getInstance();
		ArrayList<ActorsVo> getActorInfo=adao.getActorsInfo(num_pk);
				
		req.setAttribute("getActorInfo", getActorInfo);
		
		MoviesVo vo=new MoviesVo();
		req.setAttribute("vo", vo);
		
		req.setAttribute("mainpage", "/home/main/mainpage.jsp");
		req.setAttribute("content", "/home/main/movieUpdate.jsp");
		
		req.getRequestDispatcher("/home/index.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int num_pk=Integer.parseInt(req.getParameter("num_pk"));
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		String img_path=req.getParameter("img_path");
		String genre=req.getParameter("genre");
		String country=req.getParameter("country");
		String d=req.getParameter("opening_date");
		
		Date opening_date= java.sql.Date.valueOf(d);
		String preview_url=req.getParameter("preview_url");
		MoviesVo vo=new MoviesVo(num_pk, title, content, img_path, genre, country, opening_date, preview_url, null);
		
		MoviesDao dao=MoviesDao.getInstance();
		int n=dao.movieUpdate(vo);
		if(n>0) {
			req.setAttribute("code","success");
			req.setAttribute("mainpage", "/home/main/mainpage.jsp");
			req.setAttribute("content", "/home/main/result.jsp");
		}else {
			req.setAttribute("code","fail");
			req.setAttribute("mainpage", "/home/main/mainpage.jsp");
			req.setAttribute("content", "/home/main/result.jsp");
		}
		req.getRequestDispatcher("/home/index.jsp").forward(req, resp);
	}
}
