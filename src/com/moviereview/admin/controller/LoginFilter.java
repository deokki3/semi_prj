package com.moviereview.admin.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebFilter("/home/movieDetail")
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		boolean login =false;
		//세션에 아이디가 있는 지 검사후 
		HttpServletRequest req=(HttpServletRequest)request;
		HttpSession session=req.getSession();
		if(session!=null) {
			String id_pk=(String)session.getAttribute("id_pk");
			if(id_pk!=null) {
				login=true;
			}
		}

		// 있으면 요청페이지로 이동하고 없으면 로그인페이지로 이동하기
		if(login==true) {
			chain.doFilter(req, response);
		}
		else {
			HttpServletResponse resp=(HttpServletResponse)response;
			resp.sendRedirect(req.getContextPath()+"/user/login.jsp");
			
		}
		
		
	}
	
	
}