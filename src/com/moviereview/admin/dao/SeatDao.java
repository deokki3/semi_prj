package com.moviereview.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.moviereview.admin.vo.SeatVo;
import com.moviereview.db.DBConnection;

public class SeatDao {
	private static SeatDao instance=new SeatDao();
	private SeatDao() {}
	
	public static SeatDao getInstance() {
		return instance;
	}
	
	public int insert(SeatVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getCon();
			String sql="insert into seat_tb values(SEQ_SEAT_TB_NUM_PK.nextval,?,?,0)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, vo.getTheater_num_fk());
			pstmt.setString(2, vo.getCrdnt());
			return pstmt.executeUpdate();
		} catch(SQLException se) {
			se.printStackTrace();
			return -1;
		} finally{
			DBConnection.close(con, pstmt, null);
		}
	}
	
	public ArrayList<SeatVo> list(int theater_num_fk){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<SeatVo> list=new ArrayList<>();
		boolean dplct_check=false;
		try {
			con=DBConnection.getCon();
			String sql="select * from seat_tb where theater_num_fk=? order by num_pk";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getString("dplct_check").equals("0")) {
					dplct_check=false;
				}else {
					dplct_check=true;
				}
				SeatVo vo=new SeatVo(
						rs.getInt("num_pk"),
						rs.getInt("theater_num_fk"),
						rs.getString("crdnt"),
						dplct_check
						);
				list.add(vo);
			}
			return list;
		} catch(SQLException se) {
			se.printStackTrace();
			return null;
		} finally{
			DBConnection.close(con, pstmt, rs);
		}
	}
}
