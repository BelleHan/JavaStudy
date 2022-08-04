package com.study.hhs;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.study.hhs.FileIO.FileMenu;
import com.study.hhs.annotation.AnnotationReader;

public class FileIOMain {
	
	public static void main(String[] args) {

		FileMenu menu = new FileMenu();
		AnnotationReader annoReader = new AnnotationReader();
		int menuNum = 1;
		
		String fileHandler = "com.study.hhs.FileIO.FileHandler";
		
		try {
			
			while (true) {
				 
				menuNum = menu.showMenu();
				
				if(menuNum == 4) break;
				
				annoReader.readAnnotation(menuNum, fileHandler);
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
