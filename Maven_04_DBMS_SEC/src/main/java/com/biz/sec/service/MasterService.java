package com.biz.sec.service;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.biz.sec.config.DBConnection;
import com.biz.sec.mapper.MDDao;
import com.biz.sec.persistence.DetailDTO;
import com.biz.sec.persistence.MasterDTO;
import com.biz.sec.persistence.MasterDetailVO;

public class MasterService {

	protected MDDao mDao;
	protected Scanner scan;
	{
		mDao = DBConnection.getSqlSessionFactory().openSession(true).getMapper(MDDao.class);
		scan = new Scanner(System.in);
	}

	public void insertMaster() {
		System.out.println(" 문제 입력(0:종료) ");
		System.out.print(": ");
		String strQ = scan.nextLine();
		if(strQ.equals("0")) return;
		MasterDTO mdto = MasterDTO.builder()
				.m_subject(strQ).build();
		
		System.out.printf("m_seq : %d", mdto.getM_seq());
		int ret = mDao.insertMaster(mdto);
		System.out.printf("m_seq : %d", mdto.getM_seq());

		if(ret > 0) {
			System.out.println("완료");
		}else {
			System.out.println("실패");
		}
		
	}
	
	public void masterAndDetail() {
		List<MasterDetailVO> mdList = mDao.selectAll();
		Collections.shuffle(mdList);
		for (MasterDetailVO mVO : mdList) {
			System.out.print(mVO.getM_seq() + " : ");
			System.out.println(mVO.getM_subject());

			List<DetailDTO> deList = mVO.getDeList();
			if (deList != null) {
				int nNum = 1;
				for (DetailDTO ddto : deList) {
					System.out.printf("%d\t",nNum++);
					System.out.printf("%s\t",ddto.getD_subject());
					System.out.printf("%s\n",ddto.getD_ok());
				}
			}
		}
	}
}
