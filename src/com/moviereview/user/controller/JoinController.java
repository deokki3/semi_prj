package com.moviereview.user.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moviereview.user.dao.LikeDao;
import com.moviereview.user.dao.MembersDao;
import com.moviereview.user.dao.MembershipDao;
import com.moviereview.user.vo.LikeVo;
import com.moviereview.user.vo.MembersVo;
import com.moviereview.user.vo.MembershipVo;

@WebServlet("/user/join")
public class JoinController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect(req.getContextPath()+"/user/join.jsp");
	
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//파라미터 받아오기
		req.setCharacterEncoding("utf-8");
		String id_pk=req.getParameter("id_pk");
		String pwd=req.getParameter("pwd");
		String nick=req.getParameter("nick");
		String birth_date=req.getParameter("birth_date");
		String phone=req.getParameter("phone");
		String email=req.getParameter("email");
		String intro=req.getParameter("intro");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/mm/dd");
		

		
		Date d = java.sql.Date.valueOf(birth_date);
		int num_pk=0;
		String members_id_fk=id_pk;
		String grade="";
		int point =0;
	//멤버쉽 tb에 넣기
		MembersVo vo=new MembersVo(id_pk,pwd,nick,d,phone,email,intro);
		MembersDao dao=MembersDao.getInstance();
		int n=dao.insert(vo);
		MembershipVo vo1=new MembershipVo(num_pk,members_id_fk,grade,point);
		MembershipDao dao1=MembershipDao.getInstance();
		

		
		if(n>0) {
			int m=dao1.insert(vo1);
			

			}
			else {
			req.setAttribute("result","fail");
			req.getRequestDispatcher("/user/showResult.jsp").forward(req, resp);
		}
//		}
		resp.sendRedirect(req.getContextPath()+"/home");
		
		
	
	}

}
