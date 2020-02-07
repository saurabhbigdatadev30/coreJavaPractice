package com.concurrencyLearning.synchronizationdemo;

public class RunnableTask1 implements Runnable{
	SynchronizationUnderstanding synchUnderstanding;
	

	public RunnableTask1(SynchronizationUnderstanding synchUnderstanding) {
		super();
		this.synchUnderstanding = synchUnderstanding;
	}


	@Override
	public void run() {
		synchUnderstanding.methodA();
		
	}
	
	

}
