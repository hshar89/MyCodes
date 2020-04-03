package com.forkjoin;

import java.util.concurrent.RecursiveAction;

public class SimpleRecursiveAction extends RecursiveAction{
    private int simulatedWork;
    
    public SimpleRecursiveAction(int sw) {
    	this.simulatedWork = sw;
    }
	@Override
	protected void compute() {
		if(simulatedWork>100) {
			
			System.out.println("Parallel execution and split task"+simulatedWork);
			
			SimpleRecursiveAction src1 = new SimpleRecursiveAction(simulatedWork/2);
			SimpleRecursiveAction src2 = new SimpleRecursiveAction(simulatedWork/2);
			
			src1.fork();
			src2.fork();
			
		}else {
			
			System.out.println("No Need for parallel execution, sequential algo is OK "+simulatedWork);
		}
		
	}

}
