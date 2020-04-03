package com.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       /*ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
       SimpleRecursiveAction src = new SimpleRecursiveAction(2000);
       pool.invoke(src);*/
       
       System.out.println("\nThis is Recursive task");
       ForkJoinPool pool2 = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
       SimpleRecursiveTask srt = new SimpleRecursiveTask(1024);
       System.out.println(pool2.invoke(srt));
       
	}

}
