package com.biz.oracle.exec;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncEx_02 {
	public static void main(String[] args) {
		String user = "";
		String password = "";
		String salt = "com.biz.oracle";

		
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
