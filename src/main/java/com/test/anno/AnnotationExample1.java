package com.test.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
	String str();
	int val();
}

public class AnnotationExample1 {
	
	@MyAnno(str = "MK Annotation", val = 10)
	public static void myMeth() {
		AnnotationExample1 obj = new AnnotationExample1();
		
		try {
			Class<? extends AnnotationExample1> class1 = AnnotationExample1.class;//obj.getClass();
			Method method = class1.getMethod("myMeth");
			MyAnno myAnno = method.getAnnotation(MyAnno.class);
			
			//here read the values that are passed to custom annotation
			System.out.println(myAnno.str()+"  "+myAnno.val());
			
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		myMeth();
	}

}
