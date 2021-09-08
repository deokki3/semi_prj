package com.moviereview.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.moviereview.db.DBConnection;
import com.moviereview.user.vo.ActorsVo;


public class ActorsDao {
	private static ActorsDao instance=new ActorsDao();
	private ActorsDao() {}
	
	public static ActorsDao getInstance() {
		return instance;
	}
	
	//배우 숫자 세기
	public int getActorCount() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select NVL(count(num_pk),0) from actor_tb";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int mnum=rs.getInt(1);
				return mnum;
			}
			return -1;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, rs);
		}
	}
	
	//배우 정보.
	public ActorsVo getActorInfo(int num_pk) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select * from actor_tb where num_pk=?";
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num_pk);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				ActorsVo vo=new ActorsVo(
					rs.getInt("num_pk"),
					rs.getString("name"),
					rs.getString("img_path"));
				return vo;	
			}
			return null;
		
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			DBConnection.close(con, pstmt, rs);
		}
	}
	//모든 배우 리스트
	public ArrayList<ActorsVo> actorsList(int startRow,int endRow,String keyword){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=null;
		try {
			if(keyword==null || keyword.equals("")) {
				sql="select * from (select actor.*,rownum rnum from "
						+ "(	select * from actor_tb order by num_pk desc  )"
						+ " actor) where rnum>=? and rnum<=?";		
			}else {
				sql="select * from (select actor.*,rownum rnum from "
						+ "(	select * from actor_tb where name like '%" +keyword+ "%' order by num_pk desc  )"
						+ " actor) where rnum>=? and rnum<=?";
			}
			
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			ArrayList<ActorsVo> actorsList=new ArrayList<ActorsVo>();
			while(rs.next()) {
				ActorsVo vo=new ActorsVo(
						rs.getInt("num_pk"),
						rs.getString("name"),
						rs.getString("img_path"));
				actorsList.add(vo);
			}
			return actorsList;
			
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			DBConnection.close(con, pstmt, rs);
		}
	}
	
	//배우 추가
	public int aInsert(ActorsVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			String sql="insert into actor_tb values(seq_actor_tb_num_pk.nextval,?,?)";
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
	
	//배우 수정
	public int aUpdate(ActorsVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			String sql="update actor_tb set name=?, img_path=? where num_pk=?";
			con=DBConnection.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getImg_path());
			pstmt.setInt(3, vo.getNum_pk());
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBConnection.close(con, pstmt, null);
		}
	}
	
	//배우 삭제
	public int aDelete(int num_pk) {
		Connection con=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		try {
			String sql1="delete from crew_tb where actor_num_fk=?";
			String sql2="delete from actor_tb where num_pk=?";
			
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
	
	//영화클릭했을때 그영화의 배우들(크루에서 뽑아옴).
	public ArrayList<ActorsVo> getActorsInfo(int num_pk) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getCon();
			String sql="select * from actor_tb where num_pk in"
					+ "(select actor_num_fk from crew_tb where movie_ls_num_fk=?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num_pk);
			rs=pstmt.executeQuery();
			ArrayList<ActorsVo> getActorsInfo=new ArrayList<ActorsVo>();
			while(rs.next()) {
				String name=rs.getString("name");
				String img_path=rs.getString("img_path");
				ActorsVo vo=new ActorsVo(rs.getInt(1), name, img_path);
				getActorsInfo.add(vo);

			}
			return getActorsInfo;

		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			DBConnection.close(con, pstmt, rs);
		}
	}
	
	//배우검색
		public ArrayList<ActorsVo> searchActor(String keyword){
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				con=DBConnection.getCon();
				String sql="select * from actor_tb where name like '%"+ keyword +"%'";
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				ArrayList<ActorsVo> getActorsInfo=new ArrayList<ActorsVo>();
				while(rs.next()) {
					String name=rs.getString("name");
					String img_path=rs.getString("img_path");
					ActorsVo vo=new ActorsVo(rs.getInt(1), name, img_path);
					getActorsInfo.add(vo);

				}
				return getActorsInfo;

			}catch(SQLException se) {
				se.printStackTrace();
				return null;
			}finally {
				DBConnection.close(con, pstmt, rs);
			}
		}
}

