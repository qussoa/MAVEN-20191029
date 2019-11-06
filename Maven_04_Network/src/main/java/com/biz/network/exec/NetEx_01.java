package com.biz.network.exec;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.UnknownHostException;

public class NetEx_01 {
 
	public static void main(String[] args) throws UnknownHostException {
		
		InetAddress naver = InetAddress.getByName("www.naver.com");
		System.out.println(naver);
		
		InetAddress google = InetAddress.getByName("www.google.com");
		System.out.println(google);

		InetAddress daum = InetAddress.getByName("www.daum.net");
		System.out.println(daum);
		
		System.out.println(naver.getHostAddress()); // IP 주소
		System.out.println(naver.getHostName()); 	// Domain 주소
		
		// 내 컴퓨터의 NIC(Network Interface Card, ran카드)에 설정된 IP
		InetAddress local = InetAddress.getLocalHost();
		
		// 내 컴퓨터 내부의 App들이 서로 통신을 하거나 통신 test 용으로 만들어진 IP
		InetAddress loopBack = InetAddress.getLoopbackAddress();
		System.out.println("local : " + local);
		System.out.println("loopback : " + loopBack);
		
		/*
		 * port
		 * TCP/IP 프로토콜에서 1개의 IP주소에 다수의 어플리케이션이 
		 * 통신할 수 있도록하는 구조
		 * 0~65535까지 사용할 수 있고 그 중 0~1023까지는 임의로 사용할 수 없도록 정해져있다
		 * 사용자가 port를 임의로 설정하여 사용하면 1개의 컴퓨터에서 여러개의 통신 어플리케이션을
		 * 작동시킬 수 있다.
		 */
	}
}
