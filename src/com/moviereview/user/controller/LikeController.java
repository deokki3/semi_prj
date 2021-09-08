package com.moviereview.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moviereview.user.dao.LikeDao;
import com.moviereview.user.vo.LikeVo;
@WebServlet("/like")
public class LikeController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num_pk=0;
		String members_id_fk=req.getParameter("id_pk"); // 입력받은 아이디
		//System.out.println("membersID: "+members_id_fk);
		int movie_ls_num_fk=Integer.parseInt(req.getParameter("num_pk")); //입력받은 영화번호
		int like_or_dislike=0;//처음은 0
		LikeVo vo=new LikeVo(num_pk,members_id_fk,movie_ls_num_fk,like_or_dislike);
		LikeDao dao=LikeDao.getInstance();
		int like_or_dislike1=dao.getInfo(members_id_fk, movie_ls_num_fk);
		boolean r=dao.isLikeid(members_id_fk, movie_ls_num_fk);
		//테이블에 이름이 비어있으면(없으면) 추가
		if(!r) {
			dao.insert(vo);
			//좋아요 눌렀을때 상태를 1 & 좋아요 1
			dao.lupdate(members_id_fk, movie_ls_num_fk);
			req.setAttribute("status", 1);  
			req.getRequestDispatcher("/movieDetail").forward(req, resp);
			}
		
			//테이블에 아이디가 있을 때
		else if(r) {
			//좋아요 또는 싫어요 상태일때 
			if(like_or_dislike1==1||like_or_dislike1==-1) {

					
				
						dao.delete(members_id_fk, movie_ls_num_fk);
						req.setAttribute("status", 0); 
						
						
			}
					
			req.getRequestDispatcher("/movieDetail").forward(req, resp);
		}//특정 오류가 났을 경우
				else {
				req.setAttribute("status", 0); 
				req.getRequestDispatcher("/movieDetail").forward(req, resp);
				}
			
			}
			
		}

