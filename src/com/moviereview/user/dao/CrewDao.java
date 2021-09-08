package com.moviereview.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.moviereview.db.DBConnection;
import com.moviereview.user.vo.CrewVo;


public class CrewDao {
	private static CrewDao instance=new CrewDao();
	private CrewDao() {}
	
	public static CrewDao getInstance() {
		return instance;
	}
	
	//크루 추가
	public int crewInsert(CrewVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			String sql="insert into crew_tb values(seq_crew_tb_num_pk.nextval,?,?)";
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, vo.getActor_num_fk());
			pstmt.setInt(2, vo.getMovie_ls_num_fk());
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}
	//크루 삭제
	public int crewDelete(int num_pk) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			String sql="delete from crew_tb where num_pk=?";
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num_pk);
			return pstmt.executeUpdate();
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}
	
	//영화 클릭했을때 그 영화의 배우 리스트
	public ArrayList<CrewVo> crewDetailList(int num_pk){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select * from crew_tb where movie_ls_num_fk=?";
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,num_pk);
			rs=pstmt.executeQuery();
			ArrayList<CrewVo> crewDetailList=new ArrayList<CrewVo>();
			while(rs.next()) {
				CrewVo vo=new CrewVo(
					rs.getInt("num_pk"),
					rs.getInt("actor_num_fk"),
					rs.getInt("movie_ls_num_fk"));
				crewDetailList.add(vo);
			}
			return crewDetailList;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			DBConnection.close(con, pstmt, rs);
		}
	}
}
