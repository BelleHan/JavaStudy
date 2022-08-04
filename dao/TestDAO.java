package com.study.hhs.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.study.hhs.mybatis.MyBatisConnectionFactory;

public class TestDAO {
	
	SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
	
	public void createTmpTable() {
		
		try {
			sqlSession.update("TestMapper.createTmpTable");
		} finally {
			sqlSession.commit();
			sqlSession.close();
			
			System.out.println("테이블 생성 완료");
		}
		
	}
	
	public void dropTmpTable() {
		
		try {
			sqlSession.update("TestMapper.dropTmpTable");
		} finally {
			sqlSession.commit();
			sqlSession.close();
			
			System.out.println("테이블 삭제 완료");
		}
		
	}
	
	public void selectTestHs() {
		try {
			List<String> selectList = sqlSession.selectList("selectTestHs");
			
		} finally {
			sqlSession.close();
		}
	}
	
	public void selectTicIcStsComm() {
		try {
			List<String> selectList = sqlSession.selectList("selectTicIcStsComm");
			
		} finally {
			sqlSession.close();
		}
	}
	
	public void selectTicCbndSandanInter() {
		try {
			List<String> selectList = sqlSession.selectList("selectTicCbndSandanInter");
			
		} finally {
			sqlSession.close();
		}
	}
	
	public void selectTicIcSaleStatis() {
		try {
			List<String> selectList = sqlSession.selectList("selectTicIcSaleStatis");
			
		} finally {
			sqlSession.close();
		}
	}

}
