package com.moviereview.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moviereview.user.dao.MembersDao;
import com.moviereview.user.dao.MembershipDao;
import com.moviereview.user.vo.MembersVo;
import com.moviereview.user.vo.MembershipVo;
@WebServlet("/mypage")
public class MyPageController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id_pk=req.getParameter("id_pk");
		String members_id_fk=id_pk;
		MembersDao dao=MembersDao.getInstance();
		MembersVo vo=dao.getInfo(id_pk);
		MembershipDao dao1=MembershipDao.getInstance();
		MembershipVo mvo=dao1.getinfo(members_id_fk);
		req.setAttribute("vo", vo);
		req.setAttribute("mvo", mvo);
		req.getRequestDispatcher("/mypage/mypage.jsp").forward(req, resp);
		

	}

}
