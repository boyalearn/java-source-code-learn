package com.source.code.learn.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
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
		ThreadPoolExecutor executor=new ThreadPoolExecutor(5,
				                                           10,
				                                           1000L,
				                                           TimeUnit.MICROSECONDS,
				                                           new LinkedBlockingQueue<Runnable>(1000),
				                                           new ThreadPoolExecutor.DiscardPolicy());
		ScheduledExecutorService pool=Executors.newScheduledThreadPool(2);
		pool.scheduleAtFixedRate(new Task(), 0, 4, TimeUnit.SECONDS);
		pool.scheduleAtFixedRate(new Task(), 0, 4, TimeUnit.SECONDS);
		pool.scheduleAtFixedRate(new Task(), 0, 4, TimeUnit.SECONDS);
		pool.scheduleAtFixedRate(new Task(), 0, 4, TimeUnit.SECONDS);
		pool.scheduleAtFixedRate(new Task(), 0, 4, TimeUnit.SECONDS);
	}

}
