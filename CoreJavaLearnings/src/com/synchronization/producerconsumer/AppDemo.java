package com.synchronization.producerconsumer;

public class AppDemo {
	static Processor processor = new Processor();
	
	static ProcessorLock processorlck = new ProcessorLock();
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				processor.producer();
			//	processorlck.producer();
				
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				processor.consumer();
			//	 processorlck.consumer();
			}
		});

		t1.start();
		t2.start();
	}

}
