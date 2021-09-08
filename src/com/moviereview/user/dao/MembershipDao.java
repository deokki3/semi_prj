package com.moviereview.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.moviereview.db.DBConnection;
import com.moviereview.user.vo.MembershipVo;

public class MembershipDao {
	private static MembershipDao instance=new MembershipDao();
	private MembershipDao() {}
	
	public static MembershipDao getInstance() {
		return instance;
	}
	

	public int insert(MembershipVo vo) {
		String sql="insert into membership_tb values(SEQ_MEMBERSHIP_TB_NUM_PK.nextval,?,'silver',500)";
		Connection con =null;
		PreparedStatement pstmt=null;
		try {
			con =DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getMembers_id_fk());

			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con,pstmt,null);
		}
	}
	
	
	
	public MembershipVo getinfo(String members_id_fk) {
		String sql="select * from membership_tb where members_id_fk=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, members_id_fk);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				MembershipVo vo=new MembershipVo(
						rs.getInt("num_pk"),
						rs.getString("members_id_fk"),
						rs.getString("grade"),
						rs.getInt("point")); 
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
	
	public int Mupdate(MembershipVo vo) {
		String sql="update membership_tb set point=point+50 where members_id_fk=?";
		Connection con =null;
		PreparedStatement pstmt=null;
		try {
			con =DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getMembers_id_fk());
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con,pstmt,null);
		}
	}
	public int Useupdate(MembershipVo vo) {
		String sql="update membership_tb set point=point-? where members_id_fk=?";
		Connection con =null;
		PreparedStatement pstmt=null;
		try {
			con =DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, vo.getPoint());
			pstmt.setString(2, vo.getMembers_id_fk());
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con,pstmt,null);
		}
	}
}
