package com.study.hhs.FileIO;

import java.io.IOException;
import java.util.Scanner;

import com.study.hhs.annotation.MenuAnnotation;

public class FileMenu {
	
	// 입력을 위한 스캐너 객체 생성
	Scanner scan = new Scanner(System.in);
	
	FileHandler file = new FileHandler();
	
	// 메뉴를 출력하는 함수
	@MenuAnnotation
	public int showMenu() throws IOException {
		
		System.out.println("===========================================");
		System.out.println("1. 메뉴 출력");
		System.out.println("2. 파일 생성");
		System.out.println("3. 파일 출력");
		System.out.println("4. 종료");
		System.out.println("===========================================");
		System.out.print("메뉴 번호를 입력하세요.");
		
		int menu = scan.nextInt();
		
		//selectMenu(menu);
		
		return menu;
		
	}
	
	// 입력한 메뉴에 따라서 함수를 호출해 주는 함수
	/*
	public void selectMenu(int menu) throws IOException {
		
		switch (menu) {
		
		case 1 : showMenu();  // 메누 출력
				 break;
		case 2 : file.saveFile(); // 파일 생성
				 showMenu();
				 break;
		case 3 : file.readList(); // 파일 출력
				 showMenu();
			     break;
		case 4 : System.out.println("프로그램을 종료합니다."); 
				 return;
		default : System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
				  showMenu(); // 메뉴 출력
				  break;
		}
			
	}
	*/

}
