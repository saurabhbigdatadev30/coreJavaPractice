package com.synchronization.producerconsumer;

import java.util.concurrent.Semaphore;

public class ConsumerSemaphore implements Runnable{
	 
    Semaphore semaphoreConsumer;
    Semaphore semaphoreProducer;
    
    public ConsumerSemaphore(Semaphore semaphoreConsumer,Semaphore semaphoreProducer) {
           this.semaphoreConsumer=semaphoreConsumer;
           this.semaphoreProducer=semaphoreProducer;
    }
 
    public void run() {
    	System.out.println("CONSUMER THREAD ....");
           
           for(int i=1;i<=5;i++){
                  try {
                      semaphoreConsumer.acquire();
                      System.out.println("Consumed : "+i);
                      semaphoreProducer.release();
                  } catch (InterruptedException e) {
                        e.printStackTrace();
                  }
           }
    }
    
}