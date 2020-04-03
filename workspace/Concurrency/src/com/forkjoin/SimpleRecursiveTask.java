package com.forkjoin;

import java.util.concurrent.RecursiveTask;

public class SimpleRecursiveTask extends RecursiveTask<Integer>{
    
	private int simulatedWork;
	public SimpleRecursiveTask(int sw) {
		this.simulatedWork = sw;
	}
	@Override
	protected Integer compute() {
		
		if(simulatedWork>100) {
			
			System.out.println("Needs Parallel execution "+simulatedWork);
			SimpleRecursiveTask task1 = new SimpleRecursiveTask(simulatedWork/2);
			SimpleRecursiveTask task2 = new SimpleRecursiveTask(simulatedWork/2);
			
			task1.fork();
			task2.fork();
			
			int solution = 0;
			solution+=task1.join();
			solution+=task2.join();
			
			return solution;
		}else {
			System.out.println("No need for paraller execution..."+simulatedWork);
			return 2*simulatedWork;
		}
	}

}
