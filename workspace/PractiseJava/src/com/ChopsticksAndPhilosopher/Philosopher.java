package com.ChopsticksAndPhilosopher;

import java.util.Random;

public class Philosopher implements Runnable {
	int id;
	Chopstick left;
	Chopstick right;
	Random random;
	private boolean isFull;
	private volatile int eatingCounter;

	public int getEatingCount() {
		return eatingCounter;
	}

	public void setIsFull(boolean isFull) {
		this.isFull = isFull;
	}

	public Philosopher(int id, Chopstick left, Chopstick right) {
		this.id = id;
		this.left = left;
		this.right = right;
		random = new Random();
	}

	public void eating() {
		try {
			System.out.println(this + " is Eating..");
			eatingCounter++;
			Thread.sleep(random.nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void thinking() {
		try {
			System.out.println(this + " is thinking...");
			Thread.sleep(random.nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Philosopher [id=" + id + "]";
	}

	@Override
	public void run() {
		try {
			while (!isFull) {
				thinking();
				if (left.pickup(this, State.LEFT)) {
					System.out.println(this + " Got left chopstick");
					if (right.pickup(this, State.RIGHT)) {
						eating();
						right.unlock();
					}
					left.unlock();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
