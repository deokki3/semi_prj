package com.moviereview.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moviereview.user.dao.DirectorDao;
import com.moviereview.user.vo.DirectorVo;

@WebServlet("/directorsList")
public class DirectorsListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		DirectorDao dao=DirectorDao.getInstance();
		ArrayList<DirectorVo> directorsList=dao.directirsList();
		
		req.setAttribute("directorsList", directorsList);
		
		req.setAttribute("mainpage","/home/main/mainpage.jsp");
		req.setAttribute("content", "/home/main/directorsList.jsp");
		
		req.getRequestDispatcher("/home/index.jsp").forward(req, resp);		
	}
}
