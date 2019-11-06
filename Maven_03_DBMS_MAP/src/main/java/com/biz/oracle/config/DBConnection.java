package com.biz.oracle.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class DBConnection {

	private static SqlSessionFactory sqlSessionFactory;

	static {
		String configFile = "com/biz/oracle/config/config-oracle.xml";
		InputStream inputStream = null;

		String encType = "PBEWithMD5AndDES";
		String encUser = "dogZbCB/oDSYzO17bUXm0g==";
		String encPassword = "53glZAAyQAKCdcxifz7vFUL4ON8lO6cY";
		
		// 암호화된 encuser, encPassword를 복호화하기 준비
		Map<String,String> systemENV = System.getenv();
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
		pbEnc.setAlgorithm(encType);
		pbEnc.setPassword(systemENV.get("USERNAME"));
		
		// 복호화된 문자열을 mybatis-config.xml 전달하기 위한 절차
		Properties pros = new Properties();
		pros.put("username", pbEnc.decrypt(encUser));
		pros.put("password", pbEnc.decrypt(encPassword));
		
	//	USERID -> dogZbCB/oDSYzO17bUXm0g==
	//	PASSWORD -> 53glZAAyQAKCdcxifz7vFUL4ON8lO6cY
		try {
			inputStream = Resources.getResourceAsStream(configFile);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			if (sqlSessionFactory == null) {
				sqlSessionFactory = builder.build(inputStream,pros);
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
