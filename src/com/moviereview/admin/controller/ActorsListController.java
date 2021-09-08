package com.moviereview.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moviereview.user.dao.ActorsDao;
import com.moviereview.user.vo.ActorsVo;

@WebServlet("/aList")
public class ActorsListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
req.setCharacterEncoding("utf-8");
		
		String keyword=req.getParameter("keyword");
		
		String spageNum=req.getParameter("pageNum");
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		ActorsDao dao=ActorsDao.getInstance();
		int startRow=(pageNum-1)*18+1;
		int endRow=startRow+17;
		
		
		ArrayList<ActorsVo> actorsList=dao.actorsList(startRow,endRow,keyword);
		
		int pageCount=(int)Math.ceil(dao.getActorCount()/18.0);
		
		int startPageNum=((pageNum-1)/18*10)+1;
		
		int endPageNum=startPageNum+9;

		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("keyword", keyword);
		
		req.setAttribute("actorsList", actorsList);
	
		req.setAttribute("mainpage","/home/main/mainpage.jsp");
		req.setAttribute("content", "/home/main/actorsList.jsp");
		
		req.getRequestDispatcher("/home/index.jsp").forward(req, resp);		
	}
}
