package com.wfms.jvm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleTest {

	static class ClassA{
		public void println(String s) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
		
		try {
			getPrintlnMH(obj).invokeExact("ddd");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static MethodHandle getPrintlnMH(Object obj) throws Throwable{
		//����÷����ķ������ͺͲ�������
		MethodType mt = MethodType.methodType(void.class, String.class);
		return MethodHandles.lookup().findVirtual(obj.getClass(), "println", mt).bindTo(obj);
	}
}
