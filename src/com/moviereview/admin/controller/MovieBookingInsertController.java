package com.moviereview.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moviereview.admin.dao.MovieResvDao;
import com.moviereview.admin.dao.MoviesDao;
import com.moviereview.admin.vo.MovieResvVo;
import com.moviereview.admin.vo.MoviesVo;

@WebServlet("/movieBooking/admin/movieInsert")
public class MovieBookingInsertController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int movie_ls_num_fk=Integer.parseInt(req.getParameter("movie_ls_num_fk"));
		int price=Integer.parseInt(req.getParameter("price"));
		
		MovieResvVo Vo1=new MovieResvVo(0,movie_ls_num_fk,price);
		MovieResvDao dao1=MovieResvDao.getInstance();
		int n1=dao1.insert(Vo1);
	}
}
