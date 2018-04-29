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
					String A = "银行流水A";// A录入银行流水数据
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
					String B = "银行流水B";// B录入银行流水数据
					String A = exgr.exchange("B");
					System.out.println("A和B数据是否一致：" + A.equals(B) + ",A录入的是：" + A + ",B录入是：" + B);
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