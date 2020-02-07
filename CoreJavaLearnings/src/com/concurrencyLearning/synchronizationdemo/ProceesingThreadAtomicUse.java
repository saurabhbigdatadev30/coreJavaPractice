package com.concurrencyLearning.synchronizationdemo;

public class ProceesingThreadAtomicUse {
	private static int counter = 0;

	public static void processThread() {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				++counter;

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				++counter;

			}
		});

		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				++counter;

			}
		});
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		processThread();
		System.out.println("counter is " + counter);
	}

}
