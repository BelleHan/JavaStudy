package com.study.hhs.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		
		try {
			
			Reader reader = Resources.getResourceAsReader("com/study/hhs/mybatis/mybatis_config.xml");
			
			if (sqlSessionFactory == null) {
				//sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  // default : development
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "operation");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}

}
