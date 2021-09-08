package com.moviereview.user.dao;

public class StaffDao {
	private static StaffDao instance=new StaffDao();
	private StaffDao() {}
	
	public static StaffDao getInstance() {
		return instance;
	}
	

}
