package com.test.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno2 {
	String str();
	int val();
}

public class AnnotationExample2 {
	
	@MyAnno2(str = "MK Annotation", val = 10)
	public static void myMeth(String str, int val) {
		AnnotationExample2 obj = new AnnotationExample2();
		
		try {
			Class<? extends AnnotationExample2> class1 = obj.getClass();
			Method method = class1.getMethod("myMeth",String.class,int.class);
			MyAnno2 myAnno = method.getAnnotation(MyAnno2.class);
			
			//here read the values that are passed to custom annotation
			System.out.println(myAnno.str()+"  "+myAnno.val());
			
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		myMeth("test", 10);
		
	}

}
