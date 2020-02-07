package com.synchronization.producerconsumer;

import java.util.concurrent.Semaphore;

public class DemoMainSemaphore {
	public static void main(String[] args) {

		Semaphore semaphoreProducer = new Semaphore(1);
		Semaphore semaphoreConsumer = new Semaphore(0);
		System.out.println("semaphoreProducer permit=1 | semaphoreConsumer permit=0");

		ProducerSemaphore producer = new ProducerSemaphore(semaphoreProducer, semaphoreConsumer);
		ConsumerSemaphore consumer = new ConsumerSemaphore(semaphoreConsumer, semaphoreProducer);

		Thread producerThread = new Thread(producer, "ProducerThread");
		Thread consumerThread = new Thread(consumer, "ConsumerThread");

		producerThread.start();
		consumerThread.start();

	}
}
