package com.biz.sec.exec;

import org.apache.ibatis.session.SqlSession;

import com.biz.sec.config.DBConnection;
import com.biz.sec.config.DBConnectionSEC;

public class IolistEx_01 {
	public static void main(String[] args) {
		
		// mybatis-config.xml DBConnection class, iolist-mapper.xml 테스트코드
		DBConnectionSEC.getSqlSessionFactory().openSession(true);
		System.out.println("DBOK");
	}
}
