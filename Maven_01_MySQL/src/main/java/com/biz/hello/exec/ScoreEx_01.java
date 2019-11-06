package com.biz.hello.exec;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.biz.hello.config.DBConnection;
import com.biz.hello.dao.ScoreDao;
import com.biz.hello.persistence.ScoreDTO;

public class ScoreEx_01 {

	public static void main(String[] args) {

		SqlSession sqlSession = DBConnection.getSqlSessionFactory().openSession(true);
		ScoreDao sDao = sqlSession.getMapper(ScoreDao.class);
		List<ScoreDTO> sList = sDao.selectAll();
		
		for(ScoreDTO dto : sList) {
			System.out.println(dto.toString());
		}
	}

}
