package com.biz.sec.work;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/*
 * jasypt 도구를 사용하여 문자열을 암호화하는 test 수행
 * 평문문자열(planText) : 읽을 수 있는 문자열
 * 암호화된 문자열(cryptText) : 읽을 수느 ㄴ있지만 무슨 내용인지 알수없는 형태   
 */
public class SecEx_01 {
	public static void main(String[] args) {
		/*
		 * java에서 쉽게 사용할 수 있는 암호화 복호화를 수행할 수 있는 클래스 암호화와 복호화를 동시에 수행할 수 있다.
		 * 
		 * 1. 암호화의 종류 : 단방향, 양방향 가. 단방향 : 평문 -> 암호문으로 변경 가 평문 <- 암호문 변경 불가 --> 보안성 유리하나
		 * 사용에 제약이 있음 나. 양방향 : 평문 <-> 암호문 변경 가능 보안성은 다소 떨어짐 편리함, salt key 노출되면 의미 없는
		 * 암호문이 됨
		 * 
		 * jasysp는 양반향 암호화를 수행하고 쉽게 사용할 수 있는 형태 DBMS의 접근 하기 위해 user ID와 password를
		 * 사용해야하는데 JDBC connection 코드에 userID와 password가 노출되어 보안에 취약하다
		 * 
		 * 최소한 소스코드차원에서만이라도 userid와 password를 암호화하여 보안을 유지하기 위한 방법으로 사용한다 그러나 이 방법으로 단방향
		 * 암호화기법은 사용이 불가능 JDBC에서 DBMS로 userID와 password를 전송하는 과정에서 평문으로 해당 데이터를 보내야하기
		 * 때문에 암호화된 문자열을 다시 평문으로 복호화해야 한다 이런 용도로 주로 사용하는 도구가 jasypt이고 그 중에서
		 * StandardPBEStringEnryptor를 많이 사용한다
		 */
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();

		// 암호화와 복호화를 수행할때 사용할 key
		String saltPassword = "com.biz";
		String planText1 = "java";
		String planText2 = "Republic of Korea";
		
		String encText1 = "";
		String encText2 = "";
		
		/*
		 * 암호화를 수행하는 코드
		 */
		pbEnc.setAlgorithm("PBEWithMD5AndDES");
		pbEnc.setPassword(saltPassword);
		
		encText1 = pbEnc.encrypt(planText1);
		encText2 = pbEnc.encrypt(planText2);
		
		System.out.printf("plan : %s -> enc : %s\n",planText1,encText1);
		System.out.printf("plan : %s -> enc : %s\n",planText2,encText2);
		
		// 복호화
		String decText1 = pbEnc.decrypt(encText1);
		String decText2 = pbEnc.decrypt(encText2);
	

		System.out.printf("enc : %s -> dec : %s\n",encText1,decText1);
		System.out.printf("enc : %s -> dec : %s\n",encText2,decText2);
	}
}
