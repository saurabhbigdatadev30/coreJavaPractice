package com.newconcurencypacke.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InvokeAllUsage {
	public InvokeAllUsage() {
		System.out.println("creating service");
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		List<MyCallable> callableTaskLst = new ArrayList<MyCallable>();
		
		for (int i = 0; i < 10; i++) {
			MyCallable myCallable = new MyCallable((long) i + 1);
			callableTaskLst.add(myCallable);
		}
		System.out.println("Start");
		try {
			List<Future<Long>> futures = service.invokeAll(callableTaskLst);
			for (Future<Long> future : futures) {
				try {
					System.out.println("future.isDone = " + future.isDone());
					System.out.println("future: Return =" + future.get());
				} catch (CancellationException ce) {
					ce.printStackTrace();
				} catch (ExecutionException ee) {
					ee.printStackTrace();
					
				} catch (InterruptedException ie) {
					Thread.currentThread().interrupt(); // ignore/reset
				}
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
		
		
		System.out.println("Completed");
		service.shutdown();
	}

	public static void main(String args[]) {
		InvokeAllUsage demo = new InvokeAllUsage();
	}

	class MyCallable implements Callable<Long> {
		Long id = 0L;

		public MyCallable(Long val) {
			this.id = val;
		}

		public Long call() {
               System.out.println("id val" +id);
			if (id % 5 == 0) {
				id = id / 0;
			}
			return id;
		}
		
		
		public void test() throws SQLException{
			String url ="";
			Connection con = DriverManager.getConnection(url);
		}
	}
}
