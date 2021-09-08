package com.moviereview.admin.controller;

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

@WebServlet("/aUpdate")
public class ActorUpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num_pk=Integer.parseInt(req.getParameter("num_pk"));
		ActorsDao dao=ActorsDao.getInstance();
		ActorsVo vo=dao.getActorInfo(num_pk);
		req.setAttribute("vo", vo);
		
		MoviesDao mdao=MoviesDao.getInstance();
		ArrayList<MoviesVo> actorDetailList=mdao.actorDetailList(num_pk);
		
		req.setAttribute("actorDetailList", actorDetailList);
		
		req.setAttribute("mainpage", "/home/main/mainpage.jsp");
		req.setAttribute("content", "/home/main/actorUpdate.jsp");
		
		req.getRequestDispatcher("/home/index.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int num_pk=Integer.parseInt(req.getParameter("num_pk"));
		String name=req.getParameter("name");
		String img_path=req.getParameter("img_path");
		ActorsVo vo=new ActorsVo(num_pk,name,img_path);
		System.out.println(num_pk);
		System.out.println(name);
		System.out.println(img_path);
		ActorsDao dao=ActorsDao.getInstance();
		int n=dao.aUpdate(vo);
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
