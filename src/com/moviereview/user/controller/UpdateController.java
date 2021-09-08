package com.moviereview.user.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.moviereview.user.dao.MembersDao;
import com.moviereview.user.vo.MembersVo;


@WebServlet("/user/update")
public class UpdateController extends HttpServlet{
	

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//doget이 페이지를 누르면 그 해당 jsp의 정보를 가져오는건데 
		String id_pk=req.getParameter("id_pk");
		MembersDao dao=MembersDao.getInstance();
		MembersVo vo=dao.getInfo(id_pk);
		req.setAttribute("vo", vo); 


		req.getRequestDispatcher("/user/update.jsp").forward(req, resp);
	
	}

	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
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
		MembersVo vo=new MembersVo(id_pk,pwd,nick,d,phone,email,intro);
		MembersDao dao=MembersDao.getInstance();
		int n=dao.update(vo);
		if(n>0) {
		//	req.getRequestDispatcher("/mypage/mypage.jsp").forward(req, resp);
			resp.sendRedirect(req.getContextPath()+"/mypage?id_pk="+id_pk);
			
		}else {
			req.setAttribute("result", "fail");
			req.getRequestDispatcher("/user/showResult.jsp").forward(req, resp);
		}
		
	
	
	}
	
	
}
