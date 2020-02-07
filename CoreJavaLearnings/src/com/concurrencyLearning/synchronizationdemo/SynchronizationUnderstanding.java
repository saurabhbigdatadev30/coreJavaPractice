package com.concurrencyLearning.synchronizationdemo;

public class SynchronizationUnderstanding {
 
  
 

public synchronized void methodA(){
	
	  for (int i=0;i<5;i++){
		  try {
			  System.out.println("Counter in Thread " + ";"+ Thread.currentThread().getName()+ "==" +i);
			Thread.sleep(3500);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  //System.out.println("Current Executing Thread >>"+ ""+Thread.currentThread().getName());
		 
	  }
  }

/*public  void decrement(){
	System.out.println("CURRENT THREAD INCREMENT" + ":" + Thread.currentThread().getName());
	  for (int i=0;i<14;i++){
		  System.out.println( --i);
	  }
  }*/

}
