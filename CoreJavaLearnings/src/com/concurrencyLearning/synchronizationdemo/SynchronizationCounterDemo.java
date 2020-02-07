 package com.concurrencyLearning.synchronizationdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author sbanerjee3011
 *   This class demonstrate the use of Atomic variables . Suppose we have counter variable (static)
 *   whick keeps the track of no threads , then to protect this variable from race condition we can 
 *   either create  a  synchronized method increment ()  which will inturn  increment the count variable.
 *   The other way is to use Atomic
 *   
 */

public class SynchronizationCounterDemo {
	private static int counter = 0;
	private static AtomicInteger counter1 =new AtomicInteger(0);
	//ExecutorService
	 

	public static void process() {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					++counter;
					counter1.getAndIncrement();
				}

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					++counter;
					counter1.getAndIncrement();
				}

			}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		process();
		System.out.println("counter" + ":" + counter);
		System.out.println("counter1 >>>>" + ":" + counter1);
		/*
		        Long id = 0L;

		

			if (id % 5 == 0) {
				id = id / 0;
			}
			System.out.println(id);*/
		
	}

}
