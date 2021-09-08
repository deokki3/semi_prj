package com.moviereview.admin.dao;

import com.moviereview.admin.vo.SeatVo;

public class TestDao {
public static void main(String[] args) {

	SeatDao dao=SeatDao.getInstance();
	char c='A'-1;
	int a=0;
	for(int i=0;i<60;i++) {
		a=i%10;
		if(i%10==0) {
			c+=1;
		}
		String crdnt=c + "" + a;
		SeatVo vo=new SeatVo(0,2,crdnt,false);
		dao.insert(vo);
	}
}
	
}
