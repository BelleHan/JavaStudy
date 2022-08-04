package com.study.hhs.FileIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.study.hhs.annotation.MenuAnnotation;

public class FileHandler {
	
	// 파일 객체 생성 
	File folder = new File("data");
	
	// 입력을 위한 스캐너 객체 생성
	Scanner scan = new Scanner(System.in);
	
	// 버퍼를 이용해서 입출력 속도 향상
	BufferedWriter fw = null;
	
	//FileReader 객체 생성
	FileReader fileReader = null;
	
	// 속도를 높이기 위해 BufferedReader 객체 사용
	BufferedReader bufReader = null;

	// 새로운 파일을 생성하는 함수
	@MenuAnnotation(2)
	public void saveFile() throws IOException {
		
		
		if (!folder.exists()) {
			folder.mkdir();
		}
		
		System.out.println("========================================");
		System.out.print("파일 제목 : ");
		
		// 파일 제목 입력
		String fileName = scan.nextLine();
		
		System.out.print("파일 내용 : ");
		
		// 파일 내용 입력
		String txt = scan.nextLine();
		System.out.println("========================================");
		
		fileName = folder.getPath() + File.separator + fileName + ".txt";
		
		try {
			
			fw = new BufferedWriter(new FileWriter(fileName));
			
			// 출력
			fw.write(txt);
			// 남아있는 데이터 모두 출력
			fw.flush();
			
			// 스트림 닫기
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			try {
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		//return;
	}
	
	// 파일 리스트를 출력하는 함수
	@MenuAnnotation(3)
	public void readList() throws IOException {
		
		int index = 1;
		System.out.println("=============================================");
		// 모든 파일 리스트 출력
		for (File file : folder.listFiles()) {
			System.out.println(index + ". " + file.getName());
			//System.out.println("절대경로 : " + file.getAbsolutePath());
			index++;
		}
		
		System.out.println(index + ". 메뉴 보기");
		System.out.println("=============================================");
		
		System.out.print("번호를 입력하세요.");
		int menuNum = scan.nextInt();
		scan.nextLine();
		
		// 메뉴 보기 입력 시 다시 메뉴 출력 함수 호출
		if (menuNum == index) {
			return;
		} else {
			// 파일 출력 함수 호출
			readFile(menuNum);
		}
		
	}
	
	// 파일 내용 출력 함수
	public void readFile(int menuNum) throws IOException {
		
		try {
			
			File file = folder.listFiles()[menuNum-1];
			
			System.out.println("==========================================");
			System.out.println("파일명 : " + file.getName());
			
			fileReader = new FileReader(file);
			
			bufReader = new BufferedReader(fileReader);
			String content = "";
			System.out.println("파일내용 : ");
			// 파일 내용 출력
			while((content = bufReader.readLine()) != null) {
				System.out.println(content);
			}
			System.out.println("==========================================");
			
			// 스트림 닫기
			bufReader.close();
			fileReader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			try {
				bufReader.close();
				fileReader.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		// 다시 파일 리스트 출력 함수 호출
		readList();
		
	}
	
	@MenuAnnotation(4)
	public void exit() {
		System.out.println("프로그램을 종료합니다.");
	}

}
