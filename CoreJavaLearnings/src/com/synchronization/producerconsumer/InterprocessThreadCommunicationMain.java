package com.synchronization.producerconsumer;

public class InterprocessThreadCommunicationMain {
	public static void main(String[] args) {
		final InterprocessThreadCommunication objX = new InterprocessThreadCommunication();
		Thread th1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				objX.producer();
				
			}
		});
        Thread th2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				objX.consumer();
				
			}
		});
        th1.start();
        th2.start();
	}

}
