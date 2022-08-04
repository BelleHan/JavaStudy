package com.study.hhs.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StringAnnotationReader {
	
	public void readAnnotation(String input, String className) {
		
		String methodName = null;
		Method[] methodList = null;

		try {
			for(Method m : Class.forName(className).getMethods()) {
				if(m.isAnnotationPresent(TestAnnotation.class)) {
					TestAnnotation annotation = m.getDeclaredAnnotation(TestAnnotation.class);
								
					if(input.equalsIgnoreCase(annotation.value())) {
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
