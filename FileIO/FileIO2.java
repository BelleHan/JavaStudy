package com.study.hhs.FileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileIO2 {
	
	// 입력을 위한 스캐너 객체 생성
	Scanner scan = new Scanner(System.in);
	
	// 파일 객체 생성 (D드라이브의 fileList 폴더)
	File folder = new File("D:///data");
	
	// 메인 메서드
	public static void main(String[] args) {
		FileIO2 fileIo = new FileIO2();
		try {
			fileIo.showMenu();
			new FileIO2().showMenu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// 메뉴를 출력하는 함수
	private void showMenu() throws IOException{
		
		System.out.println("===========================================");
		System.out.println("1. 메뉴 출력");
		System.out.println("2. 파일 생성");
		System.out.println("3. 파일 출력");
		System.out.println("4. 종료");
		System.out.println("===========================================");
		System.out.print("메뉴 번호를 입력하세요.");
		
		int menu = scan.nextInt();
		
		try {
			selectMenu(menu);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// 입력한 메뉴에 따라서 함수를 호출해 주는 함수
	private void selectMenu(int menu) throws IOException{
		
		switch (menu) {
		
		case 1 : showMenu();  // 메누 출력
				 break;
		case 2 : try {
				saveFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 파일 생성
				 break;
		case 3 : readList(); // 파일 출력
			     break;
		case 4 : System.out.println("프로그램을 종료합니다."); 
				 return;
		default : System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
				  showMenu(); // 메뉴 출력
				  break;
		}
			
	}
	
	// 새로운 파일을 생성하는 함수
	private void saveFile() throws IOException{
		
		System.out.println("========================================");
		System.out.print("파일 제목 : ");
		
		// 파일 제목 입력
		scan.nextLine();
		String fileName = scan.nextLine();
		
		System.out.print("파일 내용 : ");
		
		// 파일 내용 입력
		String txt = scan.nextLine();
		System.out.println("========================================");
		
		fileName = "D:\\fileList\\" + fileName + ".txt";
		
		BufferedWriter fw =null;
		try {
			
			// 버퍼릴 이용해서 입출력 속도 향상
			fw = new BufferedWriter(new FileWriter(fileName));
			
			// 출력
			fw.write(txt);
			// 남아있는 데이터 모두 출력
			fw.flush();
			
			// 스트림 닫기
			fw.close();
	
		} catch (IOException e) {
			e.printStackTrace();
			
		}finally{
			try {
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		// 메뉴 출력 함수 호출
		showMenu();
	}
	
	// 파일 리스트를 출력하는 함수
	private void readList() {
			
		
		int index = 1;
		System.out.println("=============================================");
		// 모든 파일 리스트 출력
		for (File file : folder.listFiles()) {
			System.out.println(index + ". " + file.getName());
			index++;
		}
		
		System.out.println(index + ". 메뉴 보기");
		System.out.println("=============================================");
		
		System.out.print("번호를 입력하세요.");
		int menuNum = scan.nextInt();
		
		// 메뉴 보기 입력 시 다시 메뉴 출력 함수 호출
		if (menuNum == index) {
			try {
				showMenu();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// 파일 출력 함수 호출
			readFile(menuNum);
		}
		
		
	}
	
	// 파일 내용 출력 함수
	private void readFile(int menuNum) {
		
		try {
			
			File file = folder.listFiles()[menuNum-1];
			
			System.out.println("==========================================");
			System.out.println("파일명 : " + file.getName());
			
			//FileReader 객체 생성
			FileReader fileReader = new FileReader(file);
			
			// 속도를 높이기 위해 BufferedReader 객체 사용
			BufferedReader bufReader = new BufferedReader(fileReader);
			String content = "";
			System.out.println("파일내용 : ");
			// 파일 내용 출력
			while((content = bufReader.readLine()) != null) {
				System.out.println(content);
			}
			System.out.println("==========================================");
			
			// 스트림 닫기
			bufReader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 다시 파일 리스트 출력 함수 호출
		readList();
		
	}

}
