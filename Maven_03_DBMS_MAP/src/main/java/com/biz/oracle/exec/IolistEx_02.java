package com.biz.oracle.exec;

import org.apache.ibatis.session.SqlSession;

import com.biz.oracle.config.DBConnection;
import com.biz.oracle.mapper.IolistDao;
import com.biz.oracle.service.IolistServiceV1;

public class IolistEx_02 {
	
	public static void main(String[] args) {
	
		IolistServiceV1 is = new IolistServiceV1();
		is.selectMapListView();
	}
}
