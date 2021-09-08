package com.moviereview.user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moviereview.user.dao.MembersDao;
import com.moviereview.user.dao.MembersRateDao;
import com.moviereview.user.dao.MoviesDao;
import com.moviereview.user.dao.ReviewDao;
import com.moviereview.user.vo.MembersRateVo;
import com.moviereview.user.vo.MembersVo;
import com.moviereview.user.vo.MoviesVo;
import com.moviereview.user.vo.ReviewVo;




@WebServlet("/review")
public class ReviewController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//리뷰에 쓰일 정보들
		int num_pk=0;
		
		String members_id_fk=req.getParameter("id_pk");
		int movie_ls_num_fk=Integer.parseInt(req.getParameter("num_pk"));
		String content=req.getParameter("content");
		int rate=Integer.parseInt(req.getParameter("star"));
		System.out.println("rate: "+rate);
		
		//평점 넣기 
		MembersRateVo rvo=new MembersRateVo(num_pk,members_id_fk,movie_ls_num_fk,rate);
		MembersRateDao rdao=MembersRateDao.getInstance();
		
		ReviewVo vo=new ReviewVo(num_pk,members_id_fk,movie_ls_num_fk,content,null);

		ReviewDao dao=ReviewDao.getInstance();
		boolean r=dao.isReviewid(members_id_fk, movie_ls_num_fk);
		
		//아이디 및 영화 정보 가져오기
		MoviesDao moviedao=MoviesDao.getInstance();
		MoviesVo movievo=moviedao.getinfo(movie_ls_num_fk);
		
		MembersDao userdao=MembersDao.getInstance();
		MembersVo uservo=userdao.getInfo(members_id_fk);
		
		req.setAttribute("movievo",movievo); //리뷰 영역의 영화 정보(번호)
		req.setAttribute("uservo", uservo); //리뷰 영역의 유저 정보(아이디)
	
		
		
	
		
		//테이블에 없으면 
		if(!r) {
			dao.insert(vo); // 게시글 작성
			rdao.insert(rvo); //평점넣기
			req.setAttribute("insert", 1);
//			resp.sendRedirect(req.getContextPath()+"/movieDetail?num_pk="+movie_ls_num_fk+"id_pk="+members_id_fk);
			req.getRequestDispatcher("/movieDetail").forward(req, resp);
		}
		
		//아이디가 있으면 돌아가기
		else if(r){
			req.setAttribute("insert", 1);
			req.getRequestDispatcher("/movieDetail").forward(req, resp);
			
		}
		else
		req.getRequestDispatcher("/movieDetail").forward(req, resp);
	}
}
