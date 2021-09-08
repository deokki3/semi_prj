package com.moviereview.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.moviereview.db.DBConnection;
import com.moviereview.user.vo.MembersVo;

public class MembersDao {
	private static MembersDao instance=new MembersDao();
	private MembersDao() {}
	
	public static MembersDao getInstance() {
		return instance;
	}
	
	public int insert(MembersVo vo) {
		String sql="insert into members_tb values(?,?,?,?,?,?,?)";
		Connection con =null;
		PreparedStatement pstmt=null;
		try {
			con =DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getId_pk());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getNick());
			pstmt.setDate(4, vo.getBirth_date());
			pstmt.setString(5, vo.getPhone());
			pstmt.setString(6, vo.getEmail());
			pstmt.setString(7, vo.getIntro());
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con,pstmt,null);
		}
	}
	public boolean isMember(String id_pk,String pwd) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select * from members_tb where id_pk=? and pwd=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id_pk);
			pstmt.setString(2, pwd);
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


/*	public ArrayList<MembersVo> list(){
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from members";
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<MembersVo> mlist=new ArrayList<MembersVo>();
			while(rs.next()) {
				MembersVo vo=new MembersVo(
					rs.getInt("num"),
					rs.getString("name"),
					rs.getString("phone"),
					rs.getString("addr"),
					rs.getDate("regdate"));
				mlist.add(vo);
				
			}
			return mlist;
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			DBConnection.close(con, pstmt, rs);
		}
		
	} 
	//회원삭제
	
	public int delete(String id_pk) {
		String sql="delete from members_tb where id_pk=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id_pk);
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, null);
		}

		
	}
	
	//컬럼 변경
	public int alter(String id_pk) {
	String sql="alter table members_tb";
	Connection con=null;
	PreparedStatement pstmt=null;
	try {
		con=DBConnection.getCon();
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id_pk);
		int n=pstmt.executeUpdate();
		return n;
	}catch(SQLException s) {
		s.printStackTrace();
		return -1;
	}finally {
		DBConnection.close(con, pstmt, null);
	}

	
}
	*/

	public MembersVo getInfo(String id_pk) {
		String sql="select * from members_tb where id_pk=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id_pk);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				MembersVo vo=new MembersVo(
						rs.getString("id_pk"),
						rs.getString("pwd"), //얘는 멤버(유저 ) 
						rs.getString("nick"),
						rs.getDate("birth_date"),
						rs.getString("phone"),
						rs.getString("email"),
						rs.getString("intro"));
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
	
	public int update(MembersVo vo) {
		String sql="update members_tb set pwd=?,nick=?,birth_date=?,phone=?,email=?,intro=? where id_pk=?";
		Connection con =null;
		PreparedStatement pstmt=null;
		try {
			con =DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getNick());
			pstmt.setDate(3, vo.getBirth_date());
			pstmt.setString(4, vo.getPhone());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getIntro());
			pstmt.setString(7, vo.getId_pk());
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
