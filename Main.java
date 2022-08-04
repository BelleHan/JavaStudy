package com.study.hhs;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.study.hhs.annotation.StringAnnotationReader;
import com.study.hhs.controller.TestController;


public class Main {
	
	static Logger logger = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		
		// Basic Configuration
//		Logger logger = Logger.getLogger(Main.class);
//		BasicConfigurator.configure();
		
		// Properties File Configuration
//		String log4jConfigFile = System.getProperty("user.dir") + "\\src\\com\\study\\hhs\\resources\\log4j.properties";
//		PropertyConfigurator.configure(log4jConfigFile);

		// XML File Configuration		
		String log4jConfigFile = System.getProperty("user.dir") + "\\src\\com\\study\\hhs\\resources\\log4j.xml";
		DOMConfigurator.configure(log4jConfigFile);
		
		TestController controller = new TestController();
		StringAnnotationReader annoReader = new StringAnnotationReader();
		
		Scanner scan = new Scanner(System.in);
		logger.debug("조회할 테이블명 ( TicIcStsComm / TicCbndSandanInter / TicIcSaleStatis ) 입력 : ");
		String tableName = scan.next();
		String selectQuery = "select" + tableName;
		
		annoReader.readAnnotation(selectQuery, "com.study.hhs.controller.TestController");
		
	}

}
