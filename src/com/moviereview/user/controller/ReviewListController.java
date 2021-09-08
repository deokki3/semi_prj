package com.moviereview.user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moviereview.user.dao.ReviewDao;
import com.moviereview.user.vo.ReviewVo;
@WebServlet("/reviewList")
public class ReviewListController extends HttpServlet{

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//리뷰 리스트 페이지 처리
		String spageNum=req.getParameter("pageNum");
		int movie_ls_num_fk=Integer.parseInt(req.getParameter("num_pk"));
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}

		
		int startRow=(pageNum-1)*4+1;
		int endRow=startRow+3;
		ReviewDao dao=ReviewDao.getInstance();
		ArrayList<ReviewVo> reviewList=dao.reviewList(movie_ls_num_fk,startRow, endRow);
		int pageCount=(int)Math.ceil(dao.getCount(movie_ls_num_fk)/4.0);		
		int startPageNum=((pageNum-1)/10*10)+1;
		int endPageNum=startPageNum+9;
		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}
		//리뷰 리스트 및 페이징처리 
		req.setAttribute("reviewList",reviewList);
		req.setAttribute("pageCount",pageCount);
		req.setAttribute("startPageNum",startPageNum);
		req.setAttribute("endPageNum",endPageNum);
		req.setAttribute("pageNum",pageNum);
		req.getRequestDispatcher("/movieDetail").forward(req, resp);
	                                                                                                        
	
	}
}
