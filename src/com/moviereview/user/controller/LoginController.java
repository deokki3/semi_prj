package com.moviereview.user.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.moviereview.user.dao.MembersDao;
import com.moviereview.user.vo.MembersVo;
import com.moviereview.user.dao.MembershipDao;
import com.moviereview.user.vo.MembershipVo;

@WebServlet("/user/login")
public class LoginController extends HttpServlet{


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
		String id_pk=req.getParameter("id_pk");
		String pwd=req.getParameter("pwd");
		String members_id_fk=id_pk;
 
		MembersDao dao=MembersDao.getInstance();
		MembershipDao dao1=MembershipDao.getInstance();
		boolean b=dao.isMember(id_pk, pwd);
		if(b) { //아이디 비밀번호 일치하는 경우
			//로그인하기
			HttpSession session=req.getSession();//세션객체 얻어오기(세션자체는 못쓴다)
			session.setAttribute("id_pk", id_pk);  //
			session.setAttribute("pwd", pwd);
			MembershipVo vo1 =dao1.getinfo(members_id_fk);
			MembersVo vo=dao.getInfo(id_pk); //멤버vo 가져오기
		
			req.setAttribute("vo", vo);
			req.setAttribute("vo1", vo1);
		
//			resp.sendRedirect(req.getHeader("referer"));
			resp.sendRedirect(req.getContextPath()+"/home");
			
		}else { //아이디 또는 비밀번호가 맞지 않는 경우
			//로그인페이지로 이동하기
			req.setAttribute("errMsg", "아이디 또는 비밀번호가 맞지 않아요.");
			req.getRequestDispatcher("/user/login.jsp").forward(req, resp);
		}
	}
}
