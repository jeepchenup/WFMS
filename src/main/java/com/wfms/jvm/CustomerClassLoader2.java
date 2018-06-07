package com.wfms.jvm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CustomerClassLoader2 extends ClassLoader{

	private String path;
	
	public CustomerClassLoader2() {
	}

	public CustomerClassLoader2(String path) {
		this.path = path;
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		
		String filename = getFileName(name);
		
		File file = new File(path, filename);
		
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			int len = 0;
			while((len = fileInputStream.read()) != -1) {
				byteArrayOutputStream.write(len);
			}
			
			byte[] data = byteArrayOutputStream.toByteArray();
			fileInputStream.close();
			byteArrayOutputStream.close();
			
			return defineClass(name, data, 0, data.length);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return super.findClass(name);
	}
	
	private String getFileName(String name) {
		int index = name.lastIndexOf('.');
		if(index == -1) {
			return name + ".class";
		} else {
			return name.substring(index+1) + ".class";
		}
	}
	
}
