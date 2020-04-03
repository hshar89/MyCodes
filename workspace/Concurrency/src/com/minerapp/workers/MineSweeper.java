package com.minerapp.workers;

import java.util.Random;

import com.minerapp.constants.Constants;
import com.minerapp.view.Board;

public class MineSweeper implements Runnable {

	private int id;
	private Board board;
	private volatile boolean sweeperRunning;

	public MineSweeper(int id, Board board) {
		this.id = id;
		this.board = board;
		this.sweeperRunning = true;
	}

	@Override
	public void run() {

		Random random = new Random();
		//System.out.println("Running sweepers###" + sweeperRunning);
		while (sweeperRunning) {

			if (Thread.currentThread().isInterrupted()) {
				return;
			}

			int index = random.nextInt(Constants.BOARD_ROWS * Constants.BOARD_COLUMNS);
			board.sweepMine(index);

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void setLayerRunning(boolean b) {
		// TODO Auto-generated method stub
		this.sweeperRunning = b;
	}

}
