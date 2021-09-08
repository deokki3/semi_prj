package com.moviereview.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.moviereview.admin.vo.BannerVo;
import com.moviereview.db.DBConnection;


public class BannerDao {
	
	public int insert(BannerVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="insert into banner_tb values(SEQ_BANNER_TB_NUM_PK.nextval,?,?,?,?,?,?,sysdate)";
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getImgPath());
			pstmt.setString(4, vo.getUrl());
			pstmt.setDate(5, vo.getStartDate());
			pstmt.setDate(6, vo.getEndDate());
			System.out.println(sql);
			return pstmt.executeUpdate();
		}catch (SQLException se) {
			se.printStackTrace();
			return-1;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}
	
}
