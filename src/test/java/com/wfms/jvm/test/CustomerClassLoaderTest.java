package com.wfms.jvm.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.wfms.jvm.CustomerClassLoader;

public class CustomerClassLoaderTest {

	public static void main(String[] args) {
		
		CustomerClassLoader customerClassLoader = new CustomerClassLoader("D:");
//		Thread.currentThread().setContextClassLoader(customerClassLoader);
		ClassLoader systemcl = Thread.currentThread().getContextClassLoader();
		System.out.println(systemcl);
//		System.out.println(customerClassLoader.getClass().getClassLoader());
		try {
			Class c = customerClassLoader.loadClass("TestCustomerClassLoader");
			System.out.println(c.getClassLoader().toString());
			if(c != null) {
				Object object = c.newInstance();
				Method method = c.getDeclaredMethod("say");
				method.invoke(object, null);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
}
