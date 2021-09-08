package com.moviereview.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/movieBooking/movieChoice")
public class MovieChoiceController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num_pk=Integer.parseInt(req.getParameter("num_pk"));
		
		
		req.getRequestDispatcher("/movieBooking/movieList/moviechoice.jsp").forward(req, resp);
	}
}
