package com.source.code.learn.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
	private static class Task implements Runnable{

		public void run() {
			System.out.println("is my thread pool start");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args){
		ScheduledExecutorService pool=Executors.newScheduledThreadPool(2);
		pool.scheduleAtFixedRate(new Task(), 0, 4, TimeUnit.SECONDS);
		pool.scheduleAtFixedRate(new Task(), 0, 4, TimeUnit.SECONDS);
		pool.scheduleAtFixedRate(new Task(), 0, 4, TimeUnit.SECONDS);
		pool.scheduleAtFixedRate(new Task(), 0, 4, TimeUnit.SECONDS);
		pool.scheduleAtFixedRate(new Task(), 0, 4, TimeUnit.SECONDS);
	}

}
