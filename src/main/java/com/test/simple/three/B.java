package com.test.simple.three;

import java.io.IOException;

public class B extends A{
	protected void method1() throws IOException{//replace with Exception then you see error
		System.out.println("B");
	}
}
