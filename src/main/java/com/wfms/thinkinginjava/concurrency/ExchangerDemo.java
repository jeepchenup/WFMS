package com.wfms.thinkinginjava.concurrency;

import java.util.concurrent.*;

public class ExchangerDemo {

	private static final Exchanger<String> exgr = new Exchanger<String>();
	private static final Exchanger<TransformObj> exgrObj = new Exchanger<TransformObj>();

	private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

	public static void main(String[] args) {

		threadPool.execute(new Runnable() {
			public void run() {
				try {
					String A = "������ˮA";// A¼��������ˮ����
					String getChange = exgr.exchange(A);
					System.out.println(getChange);
					TransformObj obj = exgrObj.exchange(new TransformObj("objA"));
					System.out.println(Thread.currentThread().getName() + " - " + obj);
				} catch (InterruptedException e) {
				}
			}
		});

		threadPool.execute(new Runnable() {
			public void run() {
				try {
					String B = "������ˮB";// B¼��������ˮ����
					String A = exgr.exchange("B");
					System.out.println("A��B�����Ƿ�һ�£�" + A.equals(B) + ",A¼����ǣ�" + A + ",B¼���ǣ�" + B);
					TransformObj obj = exgrObj.exchange(new TransformObj("objB"));
					System.out.println(Thread.currentThread().getName() + " - " + obj);
				} catch (InterruptedException e) {
				}
			}
		});

		threadPool.shutdown();

	}
	
	static class TransformObj {
		private String name;
		
		TransformObj(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "TransformObj [name=" + name + "]";
		}
		
	}
}