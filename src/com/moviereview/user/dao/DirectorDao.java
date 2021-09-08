package com.moviereview.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.moviereview.db.DBConnection;
import com.moviereview.user.vo.DirectorVo;


public class DirectorDao {
	private static DirectorDao instance=new DirectorDao();
	private DirectorDao() {}
	
	public static DirectorDao getInstance() {
		return instance;
	}
	
	//감독 정보
	public DirectorVo getDirectorInfo(int num_pk){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select * from director_tb where num_pk in"
					+ "(select director_num_fk from staff_tb where movie_ls_num_fk=?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num_pk);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String name=rs.getString("name");
				String img_path=rs.getString("img_path");
				DirectorVo dvo=new DirectorVo(rs.getInt("num_pk"),name,img_path);
				return dvo;
			}
			return null;
		}catch(SQLException s){
			s.printStackTrace();
			return null;
		}finally {
			DBConnection.close(con, pstmt, rs);
		}
	}
	
	//감독 추가
	public int dInsert(DirectorVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			String sql="insert into director_tb values(seq_director_tb_num_pk.nextval,?,?)";
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getImg_path());
			return pstmt.executeUpdate();
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}
	
	//감독 삭제
	public int dDelete(int num_pk) {
		Connection con=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		try {
			String sql1="delete from staff_tb where director_num_fk=?";
			String sql2="delete from director_tb where num_pk=?";
			
			con=DBConnection.getCon();
			pstmt1=con.prepareStatement(sql1);
			pstmt1.setInt(1, num_pk);
			pstmt2=con.prepareStatement(sql2);
			pstmt2.setInt(1, num_pk);
			int a=pstmt1.executeUpdate();
			int b=pstmt2.executeUpdate();
			int n=a+b;
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt1, null);
		}
	}
	
	//모든 감독 리스트
		public ArrayList<DirectorVo> directirsList(){
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				String sql="select * from (select director.*,rownum rnum from "
							+ "(	select * from director_tb order by num_pk desc  )"
							+ " director)";		

				con=DBConnection.getCon();
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				ArrayList<DirectorVo> directorsList=new ArrayList<DirectorVo>();
				while(rs.next()) {
					DirectorVo vo=new DirectorVo(
							rs.getInt("num_pk"),
							rs.getString("name"),
							rs.getString("img_path"));
					directorsList.add(vo);
				}
				return directorsList;
				
			}catch(SQLException s) {
				s.printStackTrace();
				return null;
			}finally {
				DBConnection.close(con, pstmt, rs);
			}
		}
		
		//감독검색
		public ArrayList<DirectorVo> searchDirector(String keyword){
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				con=DBConnection.getCon();
				String sql="select * from director_tb where name like '%"+ keyword +"%'";
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				ArrayList<DirectorVo> getdirectorInfo=new ArrayList<DirectorVo>();
				while(rs.next()) {
					String name=rs.getString("name");
					String img_path=rs.getString("img_path");
					DirectorVo dvo=new DirectorVo(rs.getInt("num_pk"),name,img_path);
					getdirectorInfo.add(dvo);
					
				}
				return getdirectorInfo;

			}catch(SQLException se) {
				se.printStackTrace();
				return null;
			}finally {
				DBConnection.close(con, pstmt, rs);
			}
		}
}

