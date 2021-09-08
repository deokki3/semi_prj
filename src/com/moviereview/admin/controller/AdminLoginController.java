package com.moviereview.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/admin/login")
public class AdminLoginController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		
		if(id.equals("admin") && pwd.equals("1234")) { //아이디와 비밀번호가 일치하는 경우
			// 로그인하기
			HttpSession session=req.getSession();
			session.setAttribute("id",id);
			resp.sendRedirect(req.getContextPath() + "/movieBooking/index.jsp");
		} else { //아이디 또는 비밀번호가 맞지 않는 경우
			// 로그인페이지로 이동하기
			req.setAttribute("errMsg", "아이디 또는 비밀번호가 맞지 않습니다.");
			req.getRequestDispatcher("/movieBooking/admin/login/adminlogin.jsp").forward(req, resp);
		}
	}
}
