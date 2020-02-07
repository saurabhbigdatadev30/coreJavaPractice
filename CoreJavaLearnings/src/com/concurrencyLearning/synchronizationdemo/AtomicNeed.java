package com.concurrencyLearning.synchronizationdemo;

public class AtomicNeed {
	private static int counter1 = 0;

	public static void increment() {
		++counter1;
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				increment();
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				increment();
			}
		});
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				increment();
			}
		});
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("counter is " +counter1);
	}
	


}
