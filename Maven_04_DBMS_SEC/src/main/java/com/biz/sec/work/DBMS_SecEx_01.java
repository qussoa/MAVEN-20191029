package com.biz.sec.work;

import java.util.Map;
import java.util.Scanner;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class DBMS_SecEx_01 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// java 환경변수 가져오기
		Map<String, String> envList = System.getenv();

		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();

		pbEnc.setAlgorithm("PBEWithMD5AndDES");
		pbEnc.setPassword(envList.get("BIZ"));

		String saltPassword = envList.get("BIZ");
		System.out.print("username -> ");
		String planUserName = scan.nextLine();
		System.out.print("password -> ");
		String planPassword = scan.nextLine();

		String encUserName = pbEnc.encrypt(planUserName);
		String encPassword = pbEnc.encrypt(planPassword);

		System.out.printf("username : %s -> dec : %s\n", planUserName, encUserName);
		System.out.printf("password : %s -> dec : %s\n", planPassword, encPassword);
		
		// username dD71CJZxiGtccfjtPafSiA==
		// password 7fe1p8LMbfzgN2ognbcNOw==

	}
}
