package com.source.code.learn.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

	private static ReentrantLock lock=new ReentrantLock(true);
	private static Condition condition=lock.newCondition();
	
	public static void doWork(){
		lock.lock();
		try {
			
			condition.await();
			condition.signal();
			condition.signalAll();
			System.out.println("dfsdfsdfsd");
			
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException{
		Thread thread1=new Thread(new  Runnable(){

			public void run() {
				doWork();
			}
			
		});
		Thread thread2=new Thread(new  Runnable(){

			public void run() {
				doWork();
			}
			
		});
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		
	}
}
