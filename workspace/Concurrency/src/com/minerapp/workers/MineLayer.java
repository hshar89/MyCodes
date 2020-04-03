package com.minerapp.workers;

import java.util.Random;

import com.minerapp.constants.Constants;
import com.minerapp.view.Board;

public class MineLayer implements Runnable{
    private int id;
    private Board board;
    private volatile boolean layerRunning;
    
    public MineLayer(int id, Board board) {
    	this.id = id;
    	this.board = board;
    	this.layerRunning = true;
    }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random random = new Random();
		//System.out.println("Running mines###"+layerRunning);
		while(layerRunning) {
			
			if(Thread.currentThread().isInterrupted()) {
				return;
			}
			
			int index = random.nextInt(Constants.BOARD_ROWS*Constants.BOARD_COLUMNS);
			board.setMine(index);
			try {
				Thread.sleep(200);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void setLayerRunning(boolean b) {
		// TODO Auto-generated method stub
		this.layerRunning = b;
	}

}
