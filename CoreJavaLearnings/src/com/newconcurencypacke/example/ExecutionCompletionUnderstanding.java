package com.newconcurencypacke.example;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutionCompletionUnderstanding {
	public static void main(String[] args) {
		//invokeAllMethodUnderstanding();
		executionCompletionServiceDemo();
	}

	public static void executionCompletionServiceDemo() {
		final ExecutorService pool = Executors.newFixedThreadPool(2);
		final CompletionService<String> service = new ExecutorCompletionService<String>(pool);
		final List<? extends Callable<String>> callableList = Arrays.asList(
		    new SleepingCallable("first", 9000),
		    new SleepingCallable("second", 6050),
		    new SleepingCallable("third", 1650),
		    new SleepingCallable("fourth", 2000),
		    new SleepingCallable("fifth", 5)
				);
		
		for (final Callable<String> callable : callableList) {
		  service.submit(callable);
		}
		pool.shutdown();  
		try {
		  while (!pool.isTerminated()) {
		    final Future<String> future = service.take();
		    System.out.println(future.get());
		  }
		} catch (ExecutionException | InterruptedException ex) { }
	}

	public static void invokeAllMethodUnderstanding() {
		final ExecutorService pool = Executors.newFixedThreadPool(2);
		final List<? extends Callable<String>> callablestasks = Arrays.asList(
				new SleepingCallable("first", 9000),
			    new SleepingCallable("second", 6050),
			    new SleepingCallable("third", 1650),
			    new SleepingCallable("fourth", 2000),
			    new SleepingCallable("fifth", 5));
		try {
		  for (final Future<String> future : pool.invokeAll(callablestasks)) {
		    System.out.println(future.get());
		  }
		} catch (ExecutionException | InterruptedException ex) { }
		pool.shutdown();
	}

}
