package com.wfms.jvm;

import java.lang.invoke.CallSite;
import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * ��java.lang.invoke��������࣬ģ��invokedynamicָ��
 * @author jeepc
 *
 */
public class InvokeDynamicTest {

	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, TypeNotPresentException, Throwable {
		INDY_BootstrapMethod().invokeExact("dddd");
	}
	
	public static void testMethod(String s) {
		System.out.println("Hello String: " + s);
	}
	
	public static CallSite BootstrapMethod(MethodHandles.Lookup lookup, String name, MethodType mt) throws Throwable{
		return new ConstantCallSite(lookup.findStatic(InvokeDynamicTest.class, name, mt));
	}
	
	private static MethodType MT_BootstrapMethod(){
		return MethodType.fromMethodDescriptorString("(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", null);
	}
	
	private static MethodHandle MH_BootstrapMethod() throws NoSuchMethodException, IllegalAccessException {
		return MethodHandles.lookup().findStatic(InvokeDynamicTest.class, "BootstrapMethod", MT_BootstrapMethod());
	}
	
	private static MethodHandle INDY_BootstrapMethod() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, TypeNotPresentException, Throwable {
		CallSite cs = (CallSite) MH_BootstrapMethod().invokeWithArguments(MethodHandles.lookup(), "testMethod", MethodType.fromMethodDescriptorString("(Ljava/lang/String;)V", null));
		return cs.dynamicInvoker();
	}
}
