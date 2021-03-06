package com.biz.sec.service;

import java.util.List;
import java.util.Map;

import com.biz.sec.config.DBConnection;
import com.biz.sec.mapper.IolistDao;

public class IolistServiceV1 {

	protected IolistDao iDao;
	
	/*
	 * static{},{} : 초기화 블럭
	 * static{} : static 블럭
	 * {} : instance 블럭
	 * 
	 * 인스턴스 생성자
	 * IolistService의 생성자보다 머저 실행되고
	 * 생성자 method에 관계없이 자동으로 실행되는 코드들의 묶음
	 * 
	 * 아래와 같이 생성자가 여러개 일떄
	 * 각 생성자 마다 필드변수를 초기화하는 코드를 넣어주어야 하는데
	 * 간혹 생략을 했을때 NullPointEnception이 발생할 수 있다
	 * IolistService is = new IolistService();
	 * IolistService is = new IolistService("aaaa"); 
	 * 
	 * 이럴때 공통으로 초기화, 생성하는 코드들을
	 * 인스턴스 생성자에 작성해주면
	 * 생성자 method에 관계없이 자동으로 실행하도록 할 수 있다
	 */
	{
		iDao = DBConnection.getSqlSessionFactory()
						   .openSession(true)	
						   .getMapper(IolistDao.class);
	}
	
	public void viewIolist() {
		List<Map<String, Object>> iolist = iDao.selectAllMap();
		
		for(Map<String, Object> io : iolist) {
			System.out.print(io.get("IO_SEQ") +"\t");
			System.out.print(io.get("IO_DATE")+"\t");
			System.out.print(io.get("IO_INOUT")+"\t");
			System.out.print(io.get("IO_QTY")+"\t");
			System.out.print(io.get("IO_PRICE")+"\t");
			System.out.print(io.get("IO_TOTAL")+"\t");
			System.out.print(io.get("IO_PCODE")+"\t");
			System.out.print(io.get("IO_DCODE")+"\n");
		}
	}

}
