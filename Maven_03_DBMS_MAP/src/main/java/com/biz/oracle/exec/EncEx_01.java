package com.biz.oracle.exec;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncEx_01 {
	public static void main(String[] args) {
		String user = "USERID";
		String password = "PASSWORD";
		String salt = "com.biz.oracle";

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
		String encUser = pbEnc.encrypt(user);
		String encPassword = pbEnc.encrypt(password);

		System.out.printf("%s -> %s\n", user, encUser);
		System.out.printf("%s -> %s\n", password, encPassword);

		/*
		 * USERID -> PuE94gZTjmuXJrt2EZ9OPw==
		 * PASSWORD -> J+KIrHqHsdR8DJSSlPiF6Zu+szawp0gx
		 */
	}
}
