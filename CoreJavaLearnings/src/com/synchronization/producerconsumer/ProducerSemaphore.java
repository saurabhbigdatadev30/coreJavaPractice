package com.synchronization.producerconsumer;

import java.util.concurrent.Semaphore;

public class ProducerSemaphore implements Runnable{
    
    Semaphore semaphoreProducer;
    Semaphore semaphoreConsumer;
    
    
    public ProducerSemaphore(Semaphore semaphoreProducer,Semaphore semaphoreConsumer) {
           this.semaphoreProducer=semaphoreProducer;
           this.semaphoreConsumer=semaphoreConsumer;
    }
 
    public void run() {
    	System.out.println("PRODUCER THREAD ....");
           for(int i=1;i<=5;i++){
                  try {
                      semaphoreProducer.acquire();
                      System.out.println("Produced : "+i);
                      semaphoreConsumer.release();
                        
                  } catch (InterruptedException e) {
                        e.printStackTrace();
                  }
           }          
    }
}
