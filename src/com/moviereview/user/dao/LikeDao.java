package com.moviereview.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.moviereview.db.DBConnection;
import com.moviereview.user.vo.LikeVo;
import com.moviereview.user.vo.MembersVo;


public class LikeDao {
	private static LikeDao instance=new LikeDao();
	private LikeDao() {}
	
	public static LikeDao getInstance() {
		return instance;
	}
	public int insert(LikeVo vo) {
		String sql="insert into it_sounds_good_tb values(SEQ_IT_SOUNDS_GOOD_TB_NUM_PK.nextval,?,?,?)";
		Connection con =null;
		PreparedStatement pstmt=null;
		try {
			con =DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getMembers_id_fk());
			pstmt.setInt(2, vo.getMovie_ls_num_fk());
			pstmt.setInt(3, vo.getLike_or_dislike());
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -5;
		}finally {
			DBConnection.close(con,pstmt,null);
		}
	}
	public LikeVo getinfoId(String members_id_fk,int movie_ls_num_fk) {
		String sql="select * from it_sounds_good_tb where members_id_fk=? and movie_ls_num_fk=?";
		Connection con=null; 
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, members_id_fk);
			pstmt.setInt(2, movie_ls_num_fk);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				LikeVo vo=new LikeVo(
				rs.getInt("num_pk"),
				 rs.getString("members_id_fk"),
				 rs.getInt("movie_ls_num_fk"),
				 rs.getInt("like_or_dislike"));
				return vo;
				
				
			}
			return null;
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}
	
	public boolean isLikeid(String members_id_fk,int movie_ls_num_fk) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select * from it_sounds_good_tb where members_id_fk=? and movie_ls_num_fk=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, members_id_fk);
			pstmt.setInt(2, movie_ls_num_fk);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}else {
				return false;
				
			}
		
		}catch(SQLException se) {
			se.printStackTrace();
			return false;
		}finally {
			DBConnection.close(con,pstmt,rs);
		}
		
		
	}
	//좋아요 및 싫어요 값만 가져오기
	public int getInfo(String members_id_fk,int movie_ls_num_fk) {
		String sql="select * from it_sounds_good_tb where members_id_fk=? and movie_ls_num_fk=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, members_id_fk);
			pstmt.setInt(2, movie_ls_num_fk);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("like_or_dislike");
			
				
			}
			return -5;
		}catch(SQLException s) {
			s.printStackTrace();
			return -5;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}
	
	//좋아요
	public int lupdate(String members_id_fk,int movie_ls_num_fk) {
		String sql="update it_sounds_good_tb set like_or_dislike =1 where members_id_fk=? and movie_ls_num_fk=?";
		Connection con =null;
		PreparedStatement pstmt=null;
		try {
			con =DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, members_id_fk);
			pstmt.setInt(2, movie_ls_num_fk);
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -5;
		}finally {
			DBConnection.close(con,pstmt,null);
		}
	}

	//좋아요 및 싫어요 취소
	public int delete(String members_id_fk,int movie_ls_num_fk) {
		String sql="delete from it_sounds_good_tb where members_id_fk=? and movie_ls_num_fk=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, members_id_fk);
			pstmt.setInt(2, movie_ls_num_fk);
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -5;
		}finally {
			DBConnection.close(con, pstmt, null);
		}

		
	}
	//싫어요
	public int dupdate(String members_id_fk,int movie_ls_num_fk) {
		String sql="update it_sounds_good_tb set like_or_dislike =-1 where members_id_fk=? and movie_ls_num_fk=?";
		Connection con =null;
		PreparedStatement pstmt=null;
		try {
			con =DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, members_id_fk);
			pstmt.setInt(2, movie_ls_num_fk);
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -5;
		}finally {
			DBConnection.close(con,pstmt,null);
		}
	}
	

}
