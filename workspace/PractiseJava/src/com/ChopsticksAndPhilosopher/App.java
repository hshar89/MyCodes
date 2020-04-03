package com.ChopsticksAndPhilosopher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ExecutorService es = null;
		Philosopher philosophers[] = null;
		try {

			philosophers = new Philosopher[Constants.NUMBER_OF_PHILOSOPHERS];

			Chopstick[] chopsticks = new Chopstick[Constants.NUMBER_OF_CHOPSTICKS];
			for (int i = 0; i < Constants.NUMBER_OF_CHOPSTICKS; i++) {
				chopsticks[i] = new Chopstick(i);
			}

			es = Executors.newFixedThreadPool(Constants.NUMBER_OF_PHILOSOPHERS);
			for (int i = 0; i < Constants.NUMBER_OF_PHILOSOPHERS; i++) {
				philosophers[i] = new Philosopher(i, chopsticks[i],
						chopsticks[(i + 1) % Constants.NUMBER_OF_CHOPSTICKS]);
				es.execute(philosophers[i]);
			}

			Thread.sleep(Constants.DURATION_OF_SIMULATIONS);

			for (Philosopher p : philosophers) {
				p.setIsFull(true);
			}
		} finally {
			es.shutdown();
			while (!es.isTerminated()) {
				Thread.sleep(1000);
			}
			for (Philosopher p : philosophers) {
				System.out.println(p + " eats " + p.getEatingCount());
			}
		}
	}
}
