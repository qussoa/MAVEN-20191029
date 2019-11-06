package com.biz.sec.work;

import java.util.Map;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class SecEx_02 {
	public static void main(String[] args) {

		//java 환경변수 가져오기
		Map<String, String> envList = System.getenv();
		
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();

		String saltPassword = envList.get("BIZ");
		String planText1 = "java";
		String planText2 = "Republic of Korea";

		String encText1 = "";
		String encText2 = "";

		pbEnc.setAlgorithm("PBEWithMD5AndDES");
		pbEnc.setPassword(saltPassword);

		encText1 = pbEnc.encrypt(planText1);
		encText2 = pbEnc.encrypt(planText2);

		System.out.printf("plan : %s -> enc : %s\n", planText1, encText1);
		System.out.printf("plan : %s -> enc : %s\n", planText2, encText2);

		// 복호화
		String decText1 = pbEnc.decrypt(encText1);
		String decText2 = pbEnc.decrypt(encText2);

		System.out.printf("enc : %s -> dec : %s\n", encText1, decText1);
		System.out.printf("enc : %s -> dec : %s\n", encText2, decText2);
	}
}
