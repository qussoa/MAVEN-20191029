package com.biz.oracle.exec;

import java.util.Map;
import java.util.Set;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncEx_04 {
	public static void main(String[] args) {
		
		// os의 환경변수값을 가져와서 Map에 저장하기
		Map<String,String> systemENV = System.getenv();
		
		Set<String> keys = systemENV.keySet();
		for(String s : keys) {
			System.out.printf("%s = %s\n",s,systemENV.get(s));
		}
				
		String user = "";
		String password = "";
		String encUser = "";
		String encPassword = "";
		// salt값을 외부에 노출하지 않기 위해서 system(OS)의
		// 환경변수중 일부 값을 가져와서 사용하기
		// 암호화키를 최소한 소스코드에서 감추겠다
		String salt = systemENV.get("USERNAME");

		
		String encUser = "2n8givmEO6lwoJ3U2halSw==";
		String encPassword = "Os1O6naIv0uhDSz/cxKhDg==";
		
		// 문자열을 암호화
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();

		// 암호화타입
		// MD5 또는 DES형식의 암호화타입
		// 가장 쉽게 접근할 수 있는 암호화 타입
		// jasypt만으로 암호화시키는 방법
		String encType = "PBEWithMD5AndDES";

		// MD5, DE5 방식으로 암호화하여 key값으로 salt 문자열을
		// 사용하라
		pbEnc.setAlgorithm(encType);
		pbEnc.setPassword(salt);
		user = pbEnc.decrypt(encUser);
		password = pbEnc.decrypt(encPassword);

		
		
		System.out.printf("%s -> %s\n", encUser, user);
		System.out.printf("%s -> %s\n", encPassword, password);

		/*
		 * iolist2 -> 2n8givmEO6lwoJ3U2halSw== 
		 * iolist2 -> Os1O6naIv0uhDSz/cxKhDg==
		 */
	}
}
