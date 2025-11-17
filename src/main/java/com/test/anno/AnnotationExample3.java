package com.test.anno;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Annot1 {
	String str();
	int val();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Annot2 {
	String description();
}


@Annot1(str = "class level", val = 30)
@Annot2(description = "class level desc")
public class AnnotationExample3 {

	@Annot1(str = "method level", val = 20)
	@Annot2(description = "method level desc")
	public static void myMethod() {
		AnnotationExample3 obj = new AnnotationExample3();
		Annotation[] classAnnotations = obj.getClass().getAnnotations();
		System.out.println("Class level annotations: ");
		for(Annotation anno:classAnnotations) {
			System.out.println(anno + "\n");
		}
		System.out.println("Method level annotations: ");
		try {
			Method method = obj.getClass().getMethod("myMethod");
			Annotation[] annotations = method.getAnnotations();
			
			for(Annotation anno:annotations) {
				System.out.println(anno);
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		myMethod();
	}

}
