package com.moviereview.user.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.moviereview.db.DBConnection;
import com.moviereview.user.vo.ActorsVo;
import com.moviereview.user.vo.MoviesVo;


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
	//모든 영화 리스트 
	public ArrayList<MoviesVo> moviesList(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select * from movie_ls_tb";
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<MoviesVo> moviesList=new ArrayList<MoviesVo>();
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
				moviesList.add(vo);
			}
			return moviesList;
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			DBConnection.close(con, pstmt, rs);
		}
	}
	
	//영화 수정하기
	public int movieUpdate(MoviesVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			String sql="update movie_ls_tb set title=?, content=?,"
					+ "img_path=?, genre=?,country=?, opening_date=?,"
					+ "preview_url=? where num_pk=?";
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getImg_path());
			pstmt.setString(4, vo.getGenre());
			pstmt.setString(5, vo.getCountry());
			pstmt.setDate(6, vo.getOpening_date());
			pstmt.setString(7, vo.getPreview_url());
			pstmt.setInt(8, vo.getNum_pk());
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}
	
	//영화 삭제하기
	public int mDelete(int num_pk,String title) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			String sql="delete from movie_ls_tb where num_pk=? and title=?";
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num_pk);
			pstmt.setString(2,title);
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}

	//배우 클릭했을때 그배우의 영화 리스트
		public ArrayList<MoviesVo> actorDetailList(int num_pk){
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				String sql="select * from (select trunc(a.avgrate,1) avgrate,b.* from "
						+ "(select m.num_pk n,avg(r.rate) avgrate from movie_ls_tb m,members_rate_tb r "
						+ "where m.num_pk=r.movie_ls_num_fk(+) group by m.num_pk) a,movie_ls_tb b "
						+ "where n=num_pk(+) order by num_pk) where num_pk in "
						+ "(select movie_ls_num_fk from crew_tb where actor_num_fk=?)";
				con=DBConnection.getCon();
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, num_pk);
				rs=pstmt.executeQuery();
				ArrayList<MoviesVo> actorDetailList=new ArrayList<MoviesVo>();
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
							rs.getDate("reg_date"),
							rs.getDouble("avgrate"));;
					actorDetailList.add(vo);
				}
				return actorDetailList;
			}catch(SQLException s) {
				s.printStackTrace();
				return null;
			}finally {
				DBConnection.close(con, pstmt, rs);
			}	
		}
		
	//감독 클릭했을때 영화 리스트
	public ArrayList<MoviesVo> directorDetailList(int num_pk){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select * from (select trunc(a.avgrate,1) avgrate,b.* from "
					+ "(select m.num_pk n,avg(r.rate) avgrate from movie_ls_tb m,members_rate_tb r "
					+ "where m.num_pk=r.movie_ls_num_fk(+) group by m.num_pk) a,movie_ls_tb b "
					+ "where n=num_pk(+) order by num_pk) where num_pk in "
					+ "(select movie_ls_num_fk from staff_tb where director_num_fk=?)";
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num_pk);
			rs=pstmt.executeQuery();
			ArrayList<MoviesVo> directorDetailList=new ArrayList<MoviesVo>();
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
						rs.getDate("reg_date"),
						rs.getDouble("avgrate"));
				directorDetailList.add(vo);
			}
			return directorDetailList;
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			DBConnection.close(con, pstmt, rs);
		}
	}
	
	
	//첫번째 컬렉션 리스트(최근 개봉영화)
	public ArrayList<MoviesVo> latestMovieList(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select * from (select trunc(a.avgrate,1) avgrate,b.* from "
					+ "(select m.num_pk n,avg(r.rate) avgrate from movie_ls_tb m,members_rate_tb r "
					+ "where m.num_pk=r.movie_ls_num_fk(+) group by m.num_pk) a,movie_ls_tb b "
					+ "where n=num_pk(+) order by num_pk) where opening_date>'20210101' order by avgrate desc nulls last";
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
						rs.getDate("reg_date"),
						rs.getDouble("avgrate"));
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
				String sql="select * from (select trunc(a.avgrate,1) avgrate,b.* from "
						+ "(select m.num_pk n,avg(r.rate) avgrate from movie_ls_tb m,members_rate_tb r "
						+ "where m.num_pk=r.movie_ls_num_fk(+) group by m.num_pk) a,movie_ls_tb b "
						+ "where n=num_pk(+) order by num_pk) where genre='액션' order by avgrate desc nulls last";
						
						//"select * from movie_ls_tb where genre='액션'";
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
							rs.getDate("reg_date"),
							rs.getDouble("avgrate"));
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
				String sql="select * from (select trunc(a.avgrate,1) avgrate,b.* from "
						+ "(select m.num_pk n,avg(r.rate) avgrate from movie_ls_tb m,members_rate_tb r "
						+ "where m.num_pk=r.movie_ls_num_fk(+) group by m.num_pk) a,movie_ls_tb b "
						+ "where n=num_pk(+) order by num_pk) where genre in('범죄','스릴러') order by avgrate desc nulls last";
						
						//"select * from movie_ls_tb where genre in('범죄','스릴러')";
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
							rs.getDate("reg_date"),
							rs.getDouble("avgrate"));
					crimeThrillerMovie.add(vo);
				}
				return crimeThrillerMovie;
			}catch(SQLException s) {
				s.printStackTrace();
				return null;
			}
		}
		//일단 제목으로 검색
				public ArrayList<MoviesVo> movieSearch(String keyword){
					String sql="select * from movie_ls_tb where title like '%"+ keyword +"%'";
					Connection con=null;
					PreparedStatement pstmt=null;
					ResultSet rs=null;
					try {
						con=DBConnection.getCon();
						pstmt=con.prepareStatement(sql);
						rs=pstmt.executeQuery();
						ArrayList<MoviesVo> list=new ArrayList<MoviesVo>();
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
							list.add(vo);
						}
						return list;
					}catch(SQLException se) {
						se.printStackTrace();
						return null;
					}
				}
				//검색창 추천영화
				public ArrayList<MoviesVo> suggestMovie(){
					Connection con=null;
					PreparedStatement pstmt=null;
					ResultSet rs=null;
					try {
						String sql="select * from (select trunc(a.avgrate,1) avgrate,b.* from "
								+ "(select m.num_pk n,avg(r.rate) avgrate from movie_ls_tb m,members_rate_tb r "
								+ "where m.num_pk=r.movie_ls_num_fk(+) group by m.num_pk) a,movie_ls_tb b "
								+ "where n=num_pk(+) order by num_pk) where genre in('로맨스','공포') order by avgrate desc nulls last";
						con=DBConnection.getCon();
						pstmt=con.prepareStatement(sql);
						rs=pstmt.executeQuery();
						ArrayList<MoviesVo> suggestMovie=new ArrayList<MoviesVo>();
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
							suggestMovie.add(vo);
						}
						return suggestMovie;
					}catch(SQLException s) {
						s.printStackTrace();
						return null;	
					}finally {
						DBConnection.close(con, pstmt, rs);
					}
				}
				//나라별(미국)영화
				public ArrayList<MoviesVo> americanMovie(){
					Connection con=null;
					PreparedStatement pstmt=null;
					ResultSet rs=null;
					try {
						String sql="select * from (select trunc(a.avgrate,1) avgrate,b.* from "
								+ "(select m.num_pk n,avg(r.rate) avgrate from movie_ls_tb m,members_rate_tb r "
								+ "where m.num_pk=r.movie_ls_num_fk(+) group by m.num_pk) a,movie_ls_tb b "
								+ "where n=num_pk(+) order by num_pk) where country='미국' order by avgrate desc nulls last";
						con=DBConnection.getCon();
						pstmt=con.prepareStatement(sql);
						rs=pstmt.executeQuery();
						ArrayList<MoviesVo> americanMovie=new ArrayList<MoviesVo>();
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
							americanMovie.add(vo);
						}
						return americanMovie;
					}catch(SQLException s) {
						s.printStackTrace();
						return null;	
					}finally {
						DBConnection.close(con, pstmt, rs);
					}
				}
				//나라별(한국)영화
				public ArrayList<MoviesVo> koreanMovie(){
					Connection con=null;
					PreparedStatement pstmt=null;
					ResultSet rs=null;
					try {
						String sql="select * from (select trunc(a.avgrate,1) avgrate,b.* from "
								+ "(select m.num_pk n,avg(r.rate) avgrate from movie_ls_tb m,members_rate_tb r "
								+ "where m.num_pk=r.movie_ls_num_fk(+) group by m.num_pk) a,movie_ls_tb b "
								+ "where n=num_pk(+) order by num_pk) where country='한국' order by avgrate desc nulls last";
						con=DBConnection.getCon();
						pstmt=con.prepareStatement(sql);
						rs=pstmt.executeQuery();
						ArrayList<MoviesVo> koreanMovie=new ArrayList<MoviesVo>();
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
							koreanMovie.add(vo);
						}
						return koreanMovie;
					}catch(SQLException s) {
						s.printStackTrace();
						return null;	
					}finally {
						DBConnection.close(con, pstmt, rs);
					}
				}
				//나라별(영국)영화
				public ArrayList<MoviesVo> englishMovie(){
					Connection con=null;
					PreparedStatement pstmt=null;
					ResultSet rs=null;
					try {
						String sql="select * from (select trunc(a.avgrate,1) avgrate,b.* from "
								+ "(select m.num_pk n,avg(r.rate) avgrate from movie_ls_tb m,members_rate_tb r "
								+ "where m.num_pk=r.movie_ls_num_fk(+) group by m.num_pk) a,movie_ls_tb b "
								+ "where n=num_pk(+) order by num_pk) where country='영국' order by avgrate desc nulls last";
						con=DBConnection.getCon();
						pstmt=con.prepareStatement(sql);
						rs=pstmt.executeQuery();
						ArrayList<MoviesVo> englishMovie=new ArrayList<MoviesVo>();
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
							englishMovie.add(vo);
						}
						return englishMovie;
					}catch(SQLException s) {
						s.printStackTrace();
						return null;	
					}finally {
						DBConnection.close(con, pstmt, rs);
					}
				}
				
				//로맨스영화
				public ArrayList<MoviesVo> romanceMovieList(){
					Connection con=null;
					PreparedStatement pstmt=null;
					ResultSet rs=null;
					try {
						String sql="select * from (select trunc(a.avgrate,1) avgrate,b.* from "
								+ "(select m.num_pk n,avg(r.rate) avgrate from movie_ls_tb m,members_rate_tb r "
								+ "where m.num_pk=r.movie_ls_num_fk(+) group by m.num_pk) a,movie_ls_tb b "
								+ "where n=num_pk(+) order by num_pk) where genre='로맨스' order by avgrate desc nulls last";
								
								
						con=DBConnection.getCon();
						pstmt=con.prepareStatement(sql);
						rs=pstmt.executeQuery();
						ArrayList<MoviesVo> romanceMovie=new ArrayList<MoviesVo>();
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
									rs.getDate("reg_date"),
									rs.getDouble("avgrate"));
							romanceMovie.add(vo);
						}
						return romanceMovie;
					}catch(SQLException s) {
						s.printStackTrace();
						return null;	
					}finally {
						DBConnection.close(con, pstmt, rs);
					}
				}
				
				//드라마영화
				public ArrayList<MoviesVo> dramaMovieList(){
					Connection con=null;
					PreparedStatement pstmt=null;
					ResultSet rs=null;
					try {
						String sql="select * from (select trunc(a.avgrate,1) avgrate,b.* from "
								+ "(select m.num_pk n,avg(r.rate) avgrate from movie_ls_tb m,members_rate_tb r "
								+ "where m.num_pk=r.movie_ls_num_fk(+) group by m.num_pk) a,movie_ls_tb b "
								+ "where n=num_pk(+) order by num_pk) where genre='드라마' order by avgrate desc nulls last";
								
								
						con=DBConnection.getCon();
						pstmt=con.prepareStatement(sql);
						rs=pstmt.executeQuery();
						ArrayList<MoviesVo> dramaMovieList=new ArrayList<MoviesVo>();
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
									rs.getDate("reg_date"),
									rs.getDouble("avgrate"));
							dramaMovieList.add(vo);
						}
						return dramaMovieList;
					}catch(SQLException s) {
						s.printStackTrace();
						return null;	
					}finally {
						DBConnection.close(con, pstmt, rs);
					}
				}
				
				//SF영화
				public ArrayList<MoviesVo> sfMovieList(){
					Connection con=null;
					PreparedStatement pstmt=null;
					ResultSet rs=null;
					try {
						String sql="select * from (select trunc(a.avgrate,1) avgrate,b.* from "
								+ "(select m.num_pk n,avg(r.rate) avgrate from movie_ls_tb m,members_rate_tb r "
								+ "where m.num_pk=r.movie_ls_num_fk(+) group by m.num_pk) a,movie_ls_tb b "
								+ "where n=num_pk(+) order by num_pk) where genre='SF' order by avgrate desc nulls last";
								
								
						con=DBConnection.getCon();
						pstmt=con.prepareStatement(sql);
						rs=pstmt.executeQuery();
						ArrayList<MoviesVo> sfMovieList=new ArrayList<MoviesVo>();
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
									rs.getDate("reg_date"),
									rs.getDouble("avgrate"));
							sfMovieList.add(vo);
						}
						return sfMovieList;
					}catch(SQLException s) {
						s.printStackTrace();
						return null;	
					}finally {
						DBConnection.close(con, pstmt, rs);
					}
				}
				
				//96~00년도 영화리스트
				public ArrayList<MoviesVo> oneMovieList(){
					Connection con=null;
					PreparedStatement pstmt=null;
					ResultSet rs=null;
					try {
						String sql="select * from (select trunc(a.avgrate,1) avgrate,b.* from "
								+ "(select m.num_pk n,avg(r.rate) avgrate from movie_ls_tb m,members_rate_tb r "
								+ "where m.num_pk=r.movie_ls_num_fk(+) group by m.num_pk) a,movie_ls_tb b "
								+ "where n=num_pk(+) order by num_pk) where opening_date>'19960101' and opening_date<'20001231' order by avgrate desc nulls last";
						con=DBConnection.getCon();
						pstmt=con.prepareStatement(sql);
						rs=pstmt.executeQuery();
						ArrayList<MoviesVo> oneMovieList=new ArrayList<MoviesVo>();
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
									rs.getDate("reg_date"),
									rs.getDouble("avgrate"));
							oneMovieList.add(vo);
						}
						return oneMovieList;
					}catch(SQLException s) {
						s.printStackTrace();
						return null;	
					}finally {
						DBConnection.close(con, pstmt, rs);
					}
				}
				
				//01~10년도 영화리스트
				public ArrayList<MoviesVo> twoMovieList(){
					Connection con=null;
					PreparedStatement pstmt=null;
					ResultSet rs=null;
					try {
						String sql="select * from (select trunc(a.avgrate,1) avgrate,b.* from "
								+ "(select m.num_pk n,avg(r.rate) avgrate from movie_ls_tb m,members_rate_tb r "
								+ "where m.num_pk=r.movie_ls_num_fk(+) group by m.num_pk) a,movie_ls_tb b "
								+ "where n=num_pk(+) order by num_pk) where opening_date>'20010101' and opening_date<'20101231' order by avgrate desc nulls last";
						con=DBConnection.getCon();
						pstmt=con.prepareStatement(sql);
						rs=pstmt.executeQuery();
						ArrayList<MoviesVo> twoMovieList=new ArrayList<MoviesVo>();
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
									rs.getDate("reg_date"),
									rs.getDouble("avgrate"));
							twoMovieList.add(vo);
						}
						return twoMovieList;
					}catch(SQLException s) {
						s.printStackTrace();
						return null;	
					}finally {
						DBConnection.close(con, pstmt, rs);
					}
				}
				
				//11~21년도 영화리스트
						public ArrayList<MoviesVo> threeMovieList(){
							Connection con=null;
							PreparedStatement pstmt=null;
							ResultSet rs=null;
							try {
								String sql="select * from (select trunc(a.avgrate,1) avgrate,b.* from "
										+ "(select m.num_pk n,avg(r.rate) avgrate from movie_ls_tb m,members_rate_tb r "
										+ "where m.num_pk=r.movie_ls_num_fk(+) group by m.num_pk) a,movie_ls_tb b "
										+ "where n=num_pk(+) order by num_pk) where opening_date>'20110101' and opening_date<'20211231' order by avgrate desc nulls last";
								con=DBConnection.getCon();
								pstmt=con.prepareStatement(sql);
								rs=pstmt.executeQuery();
								ArrayList<MoviesVo> threeMovieList=new ArrayList<MoviesVo>();
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
											rs.getDate("reg_date"),
											rs.getDouble("avgrate"));
									threeMovieList.add(vo);
								}
								return threeMovieList;
							}catch(SQLException s) {
								s.printStackTrace();
								return null;	
							}finally {
								DBConnection.close(con, pstmt, rs);
							}
						}
}
