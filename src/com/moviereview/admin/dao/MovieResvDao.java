package com.moviereview.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.moviereview.admin.vo.MovieResvVo;
import com.moviereview.db.DBConnection;

public class MovieResvDao {
	private static MovieResvDao instance=new MovieResvDao();
	private MovieResvDao() {}
	
	public static MovieResvDao getInstance() {
		return instance;
	}
	
	public int insert(MovieResvVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getCon();
			String sql="insert into MOVIE_RESV_TB values(SEQ_MOVIE_RESV_TB_NUM_PK.nextval,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, vo.getMovie_ls_num_fk());
			pstmt.setInt(2, vo.getPrice());
			return pstmt.executeUpdate();
		} catch(SQLException se) {
			se.printStackTrace();
			return -1;
		} finally {
			DBConnection.close(con,pstmt,null);
		}
	}
	
	public ArrayList<MovieResvVo> list(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<MovieResvVo> list=new ArrayList<>();
		try {
			con=DBConnection.getCon();
			String sql="select * from movie_resv_tb";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MovieResvVo vo=new MovieResvVo(
							rs.getInt("NUM_PK"),
							rs.getInt("MOVIE_LS_NUM_FK"),
							rs.getInt("PRICE")
						);
				list.add(vo);
			}
			return list;
		} catch(SQLException se) {
			se.printStackTrace();
			return null;
		} finally {
			DBConnection.close(con,pstmt,null);
		}
	}
}
