package com.moviereview.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.moviereview.db.DBConnection;
import com.moviereview.user.vo.ProRateVo;


public class ProRateDao {
	private static ProRateDao instance=new ProRateDao();
	private ProRateDao() {}
	
	public static ProRateDao getInstance() {
		return instance;
	}
	public ProRateVo getProRate(int num_pk) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select * from pro_rate_tb where movie_ls_num_fk=?";
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num_pk);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				ProRateVo vo=new ProRateVo(
						rs.getInt("num_pk"),
						rs.getInt("movie_ls_num_fk"),
						rs.getDouble("rate"));
				return vo;
			}
			return null;
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			DBConnection.close(con, pstmt, rs);
		}
	}
}
