package com.wfms.jvm;

public class LearnClassLoader {

	public static void main(String[] args) {
		ClassLoader classLoader =  LearnClassLoader.class.getClassLoader();
		System.out.println("ClassLoader is:" + classLoader.toString() + " parent : " + classLoader.getParent().toString() + " parent parent : " + classLoader.getParent().getParent().toString());
//		System.out.println("ClassLoader is:" + int.class.getClassLoader().toString());
	}
}
