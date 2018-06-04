package com.wfms.jvm;

class SuperClass {
	static {
		System.out.println("super class init");
	}
	
	public static int value = 123;
}

class SubClass extends SuperClass {
	static {
		System.out.println("sub class init");
	}
}

public class NotInitialization {

	public static void main(String[] args) {
//		System.out.println(SubClass.value);
		SuperClass[] a = new SuperClass[10];
	}
}
