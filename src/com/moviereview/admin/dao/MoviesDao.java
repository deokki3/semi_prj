package com.moviereview.admin.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.moviereview.db.DBConnection;
import com.moviereview.admin.vo.MoviesVo;

public class MoviesDao {
	private static MoviesDao instance=new MoviesDao();
	private MoviesDao() {}
	
	public static MoviesDao getInstance() {
		return instance;
	}
	
	// 디테일 정보 뽑아오기
	public MoviesVo getinfo(int num_pk) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select * from movie_ls_tb where num_pk=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,num_pk);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				
				String title=rs.getString("title");
				String content=rs.getString("content");
				String img_path=rs.getString("img_path");
				String genre=rs.getString("genre");
				String country=rs.getString("country");
				Date opening_date=rs.getDate("opening_date");
				String preview_url=rs.getString("preview_url");
				Date reg_date=rs.getDate("reg_date");
				MoviesVo vo=new MoviesVo(num_pk, title, content, img_path, genre, country, opening_date, preview_url, reg_date);
				return vo;
			}else {
				return null;
			}
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			DBConnection.close(con, pstmt, rs);
		}
	}
	
	//영화 추가하기
	public int mInsert(MoviesVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			String sql="insert into movie_ls_tb values(SEQ_MOVIE_LS_TB_NUM_PK.nextval,?,?,?,?,?,?,?,sysdate)";
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getImg_path());
			pstmt.setString(4, vo.getGenre());
			pstmt.setString(5, vo.getCountry());
			pstmt.setDate(6, vo.getOpening_date());
			pstmt.setString(7, vo.getPreview_url());
			return pstmt.executeUpdate();
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}
	
	//첫번째 컬렉션 리스트(최근 개봉영화)
	public ArrayList<MoviesVo> latestMovieList(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select * from movie_ls_tb where opening_date>'20210101'";
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<MoviesVo> latestMovie=new ArrayList<MoviesVo>();
			while(rs.next()) {
				MoviesVo vo=new MoviesVo(
						rs.getInt("num_pk"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("img_path"),
						rs.getString("genre"),
						rs.getString("country"),
						rs.getDate("opening_date"),
						rs.getString("preview_url"),
						rs.getDate("reg_date"));
				latestMovie.add(vo);
			}
			return latestMovie;
		}catch(SQLException s) {
			s.printStackTrace();
			return null;	
		}finally {
			DBConnection.close(con, pstmt, rs);
		}
	}
	
	//두번째 컬렉션 리스트(액션영화)
		public ArrayList<MoviesVo> actionMovieList(){
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				String sql="select * from movie_ls_tb where genre='액션'";
				con=DBConnection.getCon();
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				ArrayList<MoviesVo> actionMovie=new ArrayList<MoviesVo>();
				while(rs.next()) {
					MoviesVo vo=new MoviesVo(
							rs.getInt("num_pk"),
							rs.getString("title"),
							rs.getString("content"),
							rs.getString("img_path"),
							rs.getString("genre"),
							rs.getString("country"),
							rs.getDate("opening_date"),
							rs.getString("preview_url"),
							rs.getDate("reg_date"));
					actionMovie.add(vo);
				}
				return actionMovie;
			}catch(SQLException s) {
				s.printStackTrace();
				return null;	
			}finally {
				DBConnection.close(con, pstmt, rs);
			}
		}
		
		//3번째 컬렉션 리스트(범죄 스릴러 영화)
		public ArrayList<MoviesVo> crimeThrillerMovieList(){
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				String sql="select * from movie_ls_tb where genre in('범죄','스릴러')";
				con=DBConnection.getCon();
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				ArrayList<MoviesVo> crimeThrillerMovie=new ArrayList<MoviesVo>();
				while(rs.next()) {
					MoviesVo vo=new MoviesVo(
							rs.getInt("num_pk"),
							rs.getString("title"),
							rs.getString("content"),
							rs.getString("img_path"),
							rs.getString("genre"),
							rs.getString("country"),
							rs.getDate("opening_date"),
							rs.getString("preview_url"),
							rs.getDate("reg_date"));
					crimeThrillerMovie.add(vo);
				}
				return crimeThrillerMovie;
			}catch(SQLException s) {
				s.printStackTrace();
				return null;
			}
		}
		
		public ArrayList<MoviesVo> list(){
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				String sql="select * from movie_ls_tb";
				con=DBConnection.getCon();
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				ArrayList<MoviesVo> crimeThrillerMovie=new ArrayList<MoviesVo>();
				while(rs.next()) {
					MoviesVo vo=new MoviesVo(
							rs.getInt("num_pk"),
							rs.getString("title"),
							rs.getString("content"),
							rs.getString("img_path"),
							rs.getString("genre"),
							rs.getString("country"),
							rs.getDate("opening_date"),
							rs.getString("preview_url"),
							rs.getDate("reg_date"));
					crimeThrillerMovie.add(vo);
				}
				return crimeThrillerMovie;
			}catch(SQLException s) {
				s.printStackTrace();
				return null;
			}
		}
}
