package com.study.hhs.controller;

import com.study.hhs.annotation.TestAnnotation;
import com.study.hhs.dao.TestDAO;

public class TestController {
	
	TestDAO dao = new TestDAO();
	
	@TestAnnotation("createTmpTable")
	public void createTmpTable() {
		
		dao.createTmpTable();
		
	}
	
	@TestAnnotation("dropTmpTable")
	public void dropTmpTable() {
		
		dao.dropTmpTable();
		
	}
	
	@TestAnnotation("selectTestHs")
	public void selectTestHs() {
		
		dao.selectTestHs();
		
	}
	
	@TestAnnotation("selectTicIcStsComm")
	public void selectTicIcStsComm() {
		
		dao.selectTicIcStsComm();
		
	}
	
	@TestAnnotation("selectTicCbndSandanInter")
	public void selectTicCbndSandanInter() {
		
		dao.selectTicCbndSandanInter();
		
	}
	
	@TestAnnotation("selectTicIcSaleStatis")
	public void selectTicIcSaleStatis() {
		
		dao.selectTicIcSaleStatis();
		
	}
	
	

}
