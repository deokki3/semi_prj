package com.moviereview.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moviereview.admin.dao.MoviesDao;
import com.moviereview.admin.vo.MoviesVo;

@WebServlet("/movieBooking/admin/insertList")
public class MovieBookingInsertListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MoviesDao dao=MoviesDao.getInstance();
		ArrayList<MoviesVo> list=dao.list();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("/movieBooking/admin/crud/insert.jsp").forward(req, resp);
	}
}
