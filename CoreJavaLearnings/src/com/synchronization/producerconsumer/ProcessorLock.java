package com.synchronization.producerconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProcessorLock {
	private List<Integer> lstInt = new ArrayList<Integer>();
	Executors exe;
	Lock lock = new ReentrantLock();
	private final int max_size = 5;
	private final int bottom = 0;
	private int value = 0;

	public void producer() {
		// synchronized (lstInt) {
		Condition condition = lock.newCondition();
		lock.lock();
		try {
			while (true) {
				if (lstInt.size() == max_size) {
					System.out.println("WAIT FOR CONSUMER TO CONSUME");
					condition.await();

				} else {
					lstInt.add(value);
					System.out.println("Value Added" + value);
						Thread.sleep(1000);
					value++;
					condition.signal();

				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			lock.unlock();
		}
	}

	public void consumer() {
		Condition condition = lock.newCondition();
		lock.lock();
		while (true) {
			try {
				while (true) {
					if (lstInt.isEmpty()) {
						System.out.println("WAIT FOR PRODUCER THREAD  TO PRODUCE");
						condition.await();

					} else {
						System.out.println("Value REMOVED" +	lstInt.remove(lstInt.size() - 1));
							Thread.sleep(100);
					//	value++;
						condition.signal();

					}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			finally {
				lock.unlock();
			}
	}

}
}