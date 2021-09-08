package com.moviereview.user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moviereview.user.dao.MoviesDao;
import com.moviereview.user.vo.MoviesVo;
@WebServlet("/test")
public class SearchHomeController extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	MoviesDao dao=MoviesDao.getInstance();
	ArrayList<MoviesVo> suggestMovie=dao.suggestMovie();
	req.setAttribute("suggestMovie", suggestMovie);

	String searchMain=(String)req.getAttribute("searchMain");
	String searchContent=(String)req.getAttribute("searchContent"); 
	String searchContent1=(String)req.getAttribute("searchContent1"); 
	String search=(String)req.getAttribute("search");
	String category=(String)req.getAttribute("category");
	String category1=(String)req.getAttribute("category1");
	//	네비게이션바 추가
	String navigationBar2=(String)req.getAttribute("top");
	
	if(navigationBar2==null) {
		navigationBar2="/home/search/navigationBar2.jsp";
	}	
	req.setAttribute("navigationBar2", navigationBar2);
			
	if(searchMain==null) {
		searchMain="/home/search/searchMain.jsp";
	}
	if(searchContent==null) {
		searchContent="/home/search/searchContent.jsp";
	}
	req.setAttribute("searchMain", searchMain);
	req.setAttribute("searchContent", searchContent);
	
	if(searchContent1==null) {
		searchContent1="/home/search/searchContent1.jsp";
	}
	req.setAttribute("searchContent1", searchContent1);
	

	if(search==null) {
		search="/home/search/search.jsp";
	}
	req.setAttribute("search", search);
	
    if(category==null) {
    	category="/home/search/category.jsp";
    }
    req.setAttribute("category", category);
    
    if(category1==null) {
    	category1="/home/search/category1.jsp";
    }
    req.setAttribute("category1", category1);
	
	String cp=req.getContextPath();
	ServletContext application=getServletContext();
	application.setAttribute("cp", cp);
	req.getRequestDispatcher("/home/search/searchIndex.jsp").forward(req, resp);
  }
}
