package com.moviereview.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moviereview.admin.dao.MovieResvDao;
import com.moviereview.admin.vo.MovieResvVo;

@WebServlet("/movieBooking/movieList")
public class MovieBookingListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MovieResvDao dao=MovieResvDao.getInstance();
		ArrayList<MovieResvVo> movieBookingList=dao.list();
		
		req.setAttribute("movieBookingList", movieBookingList);
		req.getRequestDispatcher("/movieBooking/movieList/movielist.jsp").forward(req, resp);
	}
}
