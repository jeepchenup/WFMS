package com.wfms.jvm;

public class LearnClassLoader {

	public static void main(String[] args) {
		ClassLoader cl = LearnClassLoader.class.getClassLoader();
		System.out.println("ClassLoader : " + cl.toString());
		
		ClassLoader parentCL = cl.getParent();
		System.out.println("Parent ClassLoader : " + parentCL.toString());
		
		ClassLoader stringCL = String.class.getClassLoader();
		System.out.println("String ClassLoader : " + stringCL.toString());
	}
}
