package com.concurrencyLearning.synchronizationdemo;

public class DemoMain {
     public static void main(String[] args) throws InterruptedException {
	SynchronizationUnderstanding syncUnderstanding1 = new SynchronizationUnderstanding();
	SynchronizationUnderstanding syncUnderstanding2 = new SynchronizationUnderstanding();
	RunnableTask1 task1 = new RunnableTask1(syncUnderstanding1);
	RunnableTask2 task2 = new RunnableTask2(syncUnderstanding2);
	Thread t1 = new Thread(task1);
	Thread t2 = new Thread(task2);
	t1.start();
	t2.start();
}
}
