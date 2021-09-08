package com.moviereview.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.moviereview.db.DBConnection;
import com.moviereview.user.vo.MembersRateVo;
import com.moviereview.user.vo.ReviewVo;


public class ReviewDao {
	private static ReviewDao instance=new ReviewDao();
	private ReviewDao() {}
	
	public static ReviewDao getInstance() {
		return instance;
	}
	
	public int insert(ReviewVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="insert into review_tb values(SEQ_REVIEW_TB_NUM_PK.nextval,?,?,?,sysdate)";
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getMembers_id_fk());
			pstmt.setInt(2, vo.getMovie_ls_num_fk());
			pstmt.setString(3, vo.getContent());
			return pstmt.executeUpdate();
		}catch(SQLException s) {
			s.printStackTrace();
			return -1; //글번호에 -1이 들어가지 않을꺼니까 -1주기
		}finally {
			DBConnection.close(con,pstmt,null);
		}
	}
	
	
	//별점 테러 방지로 한 아이디에 한번
	public boolean isReviewid(String members_id_fk,int movie_ls_num_fk) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select * from review_tb where members_id_fk=? and movie_ls_num_fk=?";
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
	//새로운시도
	

	
	//리뷰 테이블 정보 가져오기
	
	public ArrayList<ReviewVo> reviewList(int movie_ls_num_fk,int startRow,int endRow){
		String sql="select * from " + 
				"(" + 
				"  select r.*,rownum rnum from" + 
				"  (" + 
				"	 select * from review_tb where movie_ls_num_fk=? order by num_pk desc" + 
				"  ) r" + 
				") where rnum>=? and rnum<=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, movie_ls_num_fk);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs=pstmt.executeQuery();
			ArrayList<ReviewVo> reviewList=new ArrayList<ReviewVo>();
			while(rs.next()) {
				ReviewVo vo=new ReviewVo(
						rs.getInt("num_pk"), 
						rs.getString("members_id_fk"), 
						rs.getInt("movie_ls_num_fk"), 
						rs.getString("content"),
						rs.getDate("reg_date"));
				reviewList.add(vo);
			}
			return reviewList;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			DBConnection.close(con, pstmt, rs);
		}
	}
	//전체 글의 갯수
	public int getCount(int movie_ls_num_fk) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select NVL(count(*),0) cnt from review_tb where movie_ls_num_fk=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, movie_ls_num_fk);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int n=rs.getInt(1);
				return n;
			}
			return -1;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, rs);
		}
	}

}
