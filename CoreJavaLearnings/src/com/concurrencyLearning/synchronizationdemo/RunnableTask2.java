package com.concurrencyLearning.synchronizationdemo;

public class RunnableTask2 implements Runnable{

SynchronizationUnderstanding synchUnderstanding;
	

	public RunnableTask2(SynchronizationUnderstanding synchUnderstanding) {
	super();
	this.synchUnderstanding = synchUnderstanding;
}


	@Override
	public void run() {
		synchUnderstanding.methodA();
		
	}
	
}
