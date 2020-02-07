package com.synchronization.producerconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InterprocessThreadCommunication {
	private static List<Object> lstObject = new ArrayList<>();
	boolean status = false;
	private static Object lock = new Object();
	
	public void producer() {
		synchronized (lock) {
			while (true)
			{
				if (status)
				{
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				else
				{
					Object objX = getObject();
					lstObject.add(objX);
					System.out.println("Producer thread --" + lstObject.toString() + "CURRENT SIZE -" + "-" + lstObject.size());
					status = true;
					try {
						Thread.sleep(600L);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					lock.notifyAll();
				}
			}
			
		}

	}
	
	
	
	public void consumer()
	{
		synchronized (lock) {
			while (true)
			{
				if (!status)
				{
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
				{
					System.out.println("Consuming --" + lstObject.remove(lstObject.size()-1) +"CURRENT SIZE -" +lstObject.size() );
					status = false;
					lock.notifyAll();
				}
				
	}
		}
		}
	
	
	
	private Object  getObject() 
	{
		Random random = new Random();
		return (Object) random.nextDouble();
	}

}
