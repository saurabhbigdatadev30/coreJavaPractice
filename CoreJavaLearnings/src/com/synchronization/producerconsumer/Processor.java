package com.synchronization.producerconsumer;

import java.util.ArrayList;
import java.util.List;

public class Processor {
	private List<Integer> lstInt = new ArrayList<Integer>();
	private final int max_size = 5;
	private final int bottom = 0;
	private int value = 0;

	public void producer() {
		synchronized (lstInt) {
			while (true) {
				if (lstInt.size() == max_size) {
					System.out.println("WAIT FOR CONSUMER TO CONSUME");
					try {
						lstInt.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					lstInt.add(value);
					System.out.println("Value Added" + value);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					value++;
					lstInt.notifyAll();

				}
			}
		}
	}

	public void consumer() {
		synchronized (lstInt) {
			while (true) {
				if (lstInt.isEmpty()) {
					try {
						lstInt.wait();
						System.out.println("WAIT FOR PRODUCER TO PRODUCE");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else
				System.out.println("removed value" +lstInt.remove(lstInt.size() - 1));
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lstInt.notifyAll();
			}
		}

	}
}
