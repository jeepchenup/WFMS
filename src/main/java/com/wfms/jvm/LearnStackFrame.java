package com.wfms.jvm;

import java.util.concurrent.TimeUnit;

public class LearnStackFrame {

	public static void main(String[] args) {
		{
			byte[] placeholder = new byte[64 * 1024 * 1024];
		}
//		int a = 0;
		System.gc();
	}
}
