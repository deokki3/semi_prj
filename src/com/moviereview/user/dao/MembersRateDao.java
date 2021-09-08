package com.moviereview.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.moviereview.db.DBConnection;
import com.moviereview.user.vo.MembersRateVo;
import com.moviereview.user.vo.MembersVo;
import com.moviereview.user.vo.ReviewVo;




public class MembersRateDao {
	private static MembersRateDao instance=new MembersRateDao();
	private MembersRateDao() {}
	
	public static MembersRateDao getInstance() {
		return instance;
	}
	
	// 유저가 영화 평점 추가하기
	public int insert(MembersRateVo vo) {
		String sql="insert into members_rate_tb values(SEQ_MEMBERS_RATE_TB_NUM_PK.nextval,?,?,?)";
		Connection con =null;
		PreparedStatement pstmt=null;
		try {
			con =DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getMembers_id_fk());
			pstmt.setInt(2, vo.getMovie_ls_num_fk());
			pstmt.setDouble(3, vo.getRate());

			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con,pstmt,null);
		}
	}
	
	//평점 가져오기
	public ArrayList<MembersRateVo> rateList(int movie_ls_num_fk){
		String sql="select * from members_rate_tb where movie_ls_num_fk=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, movie_ls_num_fk);
			rs=pstmt.executeQuery();
			ArrayList<MembersRateVo> rateList=new ArrayList<MembersRateVo>();
			while(rs.next()) {
				MembersRateVo vo=new MembersRateVo(
						rs.getInt("num_pk"), 
						rs.getString("members_id_fk"), 
						rs.getInt("movie_ls_num_fk"), 
						rs.getInt("rate"));
				rateList.add(vo);
			}
			return rateList;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			DBConnection.close(con, pstmt, rs);
		}
	}
	
	// 평점 가져오기 
	public int getInfo(int num_pk) {
		String sql="select rate from members_rate_tb where num_pk=? ";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num_pk);
		
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("rate");
			}
			return -1;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, null);
		}

		
	}
	
	// 영화 디테일 부분 평균평점 뽑아오기
	public double membersAvgrate(int num_pk) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select trunc(avg(rate),1) avgrate from members_rate_tb "
					+ "where movie_ls_num_fk=? group by movie_ls_num_fk";
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num_pk);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				double membersAvgrate=rs.getDouble("avgrate");
				return membersAvgrate;
			}
			return 0;
		}catch(SQLException s) {
			s.printStackTrace();
			return 0;
		}finally {
			DBConnection.close(con, pstmt, rs);
		}
	}
}
