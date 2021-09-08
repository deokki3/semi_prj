package com.moviereview.user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moviereview.user.dao.ActorsDao;
import com.moviereview.user.dao.CrewDao;
import com.moviereview.user.dao.DirectorDao;
import com.moviereview.user.dao.LikeDao;
import com.moviereview.user.dao.MembersDao;
import com.moviereview.user.dao.MembersRateDao;
import com.moviereview.user.dao.MoviesDao;
import com.moviereview.user.dao.ProRateDao;
import com.moviereview.user.dao.ReviewDao;
import com.moviereview.user.vo.ActorsVo;
import com.moviereview.user.vo.CrewVo;
import com.moviereview.user.vo.DirectorVo;

import com.moviereview.user.vo.MembersRateVo;
import com.moviereview.user.vo.MembersVo;
import com.moviereview.user.vo.MoviesVo;
import com.moviereview.user.vo.ProRateVo;
import com.moviereview.user.vo.ReviewVo;

@WebServlet("/movieDetail")
public class MovieDetailController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num_pk=Integer.parseInt(req.getParameter("num_pk"));
		String id_pk=req.getParameter("id_pk");
		int movie_ls_num_fk=num_pk;
		//영화정보
		MoviesDao mdao=MoviesDao.getInstance();
		MoviesVo mvo=mdao.getinfo(num_pk);

		req.setAttribute("mvo",mvo);
		
		//유저정보
		MembersDao dao=MembersDao.getInstance();
		MembersVo m1vo=dao.getInfo(id_pk);
		req.setAttribute("m1vo", m1vo);
		
		//유저의 좋아요
		LikeDao ldao=LikeDao.getInstance();
		int like_or_dislike=ldao.getInfo(id_pk, movie_ls_num_fk);
		req.setAttribute("status", like_or_dislike); 



		//멤버 평균 평점 및 개인평점
		MembersRateDao mrdao=MembersRateDao.getInstance();
		Double membersAvgrate=mrdao.membersAvgrate(num_pk);
		ArrayList<MembersRateVo> rateList=mrdao.rateList(movie_ls_num_fk);
		int rate=mrdao.getInfo(num_pk);

		req.setAttribute("membersAvgrate", membersAvgrate);
		req.setAttribute("rateList", rateList);
		req.setAttribute("rate", rate);
		
		
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
		
		//리뷰 리스트 가져오기 

		String spageNum=req.getParameter("pageNum");
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
	
		int startRow=(pageNum-1)*10+1;
		int endRow=startRow+9;
		ReviewDao rdao=ReviewDao.getInstance();
		ArrayList<ReviewVo> reviewList=rdao.reviewList(movie_ls_num_fk,startRow, endRow);
		req.setAttribute("reviewList", reviewList);

		
		//리뷰 추가하기 메인에
		String review=(String)req.getAttribute("review");
		if(review==null ) {
			review="/home/main/review.jsp";
		}
	
		req.setAttribute("review", review);


	//	req.setAttribute("top", "/home/main/navigationBar.jsp");//네비게이션바 띄우기
		req.setAttribute("mainpage", "/home/main/mainpage.jsp");
		req.setAttribute("content", "/home/main/movieDetail.jsp");
		
		req.getRequestDispatcher("/home/index.jsp").forward(req, resp);
	}
}
