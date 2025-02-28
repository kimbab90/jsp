package com.yedam.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yedam.mapper.BoardMapper;
import com.yedam.mapper.ReplyMapper;

public class DataSource {
	
	private static SqlSessionFactory getInstance() {
		String resource = "config/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		return sqlSessionFactory;
	}

	public static BoardMapper getBoardMapper() {
		SqlSessionFactory factory = DataSource.getInstance();

		SqlSession session = factory.openSession(true);

		return session.getMapper(BoardMapper.class);
	}

	public static ReplyMapper getReplyMapper() {
		SqlSessionFactory factory = DataSource.getInstance();

		SqlSession session = factory.openSession(true);

		return session.getMapper(ReplyMapper.class);
	}

}