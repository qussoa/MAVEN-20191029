package com.biz.sec.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class DBConnectionSEC {

	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		// 전체 환경변수 읽어오기
		Map<String, String> envList = System.getenv();
		//전체 환경변수중 BIZ 키 변수값만 추출
		String saltPass = System.getenv().get("BIZ");
		// 환경변수중 BIZ 키값만 가져오기
		saltPass = System.getenv("BIZ");
		
		String configFile = "com/biz/sec/config/mybatis-config.xml";
		InputStream is;
		
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
		pbEnc.setAlgorithm("PBEWithMD5AndDES");
		pbEnc.setPassword(saltPass);
		
		String userName = "dD71CJZxiGtccfjtPafSiA==";
		String password = "7fe1p8LMbfzgN2ognbcNOw==";
		
		Properties pros = new Properties();
		/*
		 * DBMS에 접근할 USERNAME, PASSWORD를 실제 값으로 적용하고
		 * 프로젝트를 실행할 것 
		 */
		pros.put("username",pbEnc.decrypt(userName));
		pros.put("password",pbEnc.decrypt(password));  
		try {
			is = Resources.getResourceAsStream(configFile);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			if(sqlSessionFactory == null) {
				sqlSessionFactory = builder.build(is,pros);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
