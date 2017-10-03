package com.qfedu.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AddHelloThread implements Runnable{
	//Collections.synchronizedList(  new ArrayList<>())  new CopyOnWriteArrayList<>() ;
	
	//private static List list=new CopyOnWriteArrayList<>() ;
	
	public AddHelloThread(List<String> list) {
	}
	
	
//	@Override
//	public void run() {
//		for(int i=1;i<100000;++i) {
//			list.add("hello");
//		} 
//	}
	
	private static ExecutorService pool=
			Executors.newFixedThreadPool(5);
	
	public static void main(String[] args) {
		
		List<String> list=Collections.synchronizedList(new ArrayList<>());
		for(int i=1;i<5;++i) {
//			new Thread(new AddHelloThread(list)).start();
			pool.execute(new AddHelloThread(list));
		}
		while(!pool.isTerminated());
		pool.shutdown();
		while(!pool.isTerminated());
		System.out.println(list.size());
		// ¹Ø»ú¹³×Ó   ()->{}
		//Runtime.getRuntime().addShutdownHook
		//(new Thread(()->{System.out.println(list.size());}));
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
