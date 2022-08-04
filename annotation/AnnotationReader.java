package com.study.hhs.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationReader {
	
	public void readAnnotation(int input, String className) {
		
		String methodName = null;
		Method[] methodList = null;

		try {
			for(Method m : Class.forName(className).getMethods()) {
				if(m.isAnnotationPresent(MenuAnnotation.class)) {
					MenuAnnotation annotation = m.getDeclaredAnnotation(MenuAnnotation.class);
								
					if(input == annotation.value()) {
						methodName = m.getName();

						try {
							m.invoke(Class.forName(className).newInstance());
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
								| InstantiationException | ClassNotFoundException e) {
							e.printStackTrace();
						}

					}
					
				}			
				
			}
			
		} catch (SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		

	}
	

}
