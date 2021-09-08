package com.moviereview.user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moviereview.user.dao.ActorsDao;
import com.moviereview.user.dao.MoviesDao;
import com.moviereview.user.vo.ActorsVo;
import com.moviereview.user.vo.MoviesVo;
@WebServlet("/actorDetailList")
public class ActorDetailListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num_pk=Integer.parseInt(req.getParameter("num_pk"));
		
		MoviesDao mdao=MoviesDao.getInstance();
		ArrayList<MoviesVo> actorDetailList=mdao.actorDetailList(num_pk);
		
		req.setAttribute("actorDetailList", actorDetailList);
		
		ActorsDao adao=ActorsDao.getInstance();
		ActorsVo avo=adao.getActorInfo(num_pk);
		req.setAttribute("avo", avo);
		
		req.setAttribute("mainpage", "/home/main/mainpage.jsp");
		req.setAttribute("content", "/home/main/actorDetailList.jsp");
		
		req.getRequestDispatcher("/home/index.jsp").forward(req, resp);
	}
}
	