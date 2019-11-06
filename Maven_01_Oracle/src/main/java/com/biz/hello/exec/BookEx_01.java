package com.biz.hello.exec;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.biz.hello.config.DBConnection;
import com.biz.hello.dao.BookDao;
import com.biz.hello.persistence.BookDTO;

public class BookEx_01 {

	public static void main(String[] args) {

		SqlSession sqlSession = DBConnection.getSqlSessionFactory().openSession(true);
		BookDao bDao = sqlSession.getMapper(BookDao.class);
		List<BookDTO> bList = bDao.selectAll();
		
		for(BookDTO dto : bList) {
			System.out.println(dto.toString());
		}
	}

}
