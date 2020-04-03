package com.minerapp.app;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import com.minerapp.constants.Constants;
import com.minerapp.view.Board;
import com.minerapp.view.ButtonListner;
import com.minerapp.view.Toolbar;
import com.minerapp.workers.MineLayer;
import com.minerapp.workers.MineSweeper;

public class MainFrame extends JFrame implements ButtonListner{
   
	private static final long serialVersionUID = 1L;
	
	private Toolbar toolbar;
	private Board board;
	private ExecutorService layersExecutor;
	private ExecutorService sweepersExecutor;
	private MineLayer[] mineLayers;
	private MineSweeper[] mineSweepers;
	
	public MainFrame() {
		super(Constants.APP_NAME);
		
		toolbar = new Toolbar();
		board = new Board();
		
		initializeVariables();
		
		toolbar.setButtonListner(this);
		
		add(toolbar,BorderLayout.NORTH);
		add(board, BorderLayout.CENTER);
		
		setSize(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void add(Board board2, Component center) {
		board2.add(center);
	}

	private void add(Toolbar toolbar2, Component north) {
		toolbar2.add(north);
	}

	private void initializeVariables() {
	mineLayers = new MineLayer[Constants.NUMBER_OF_LAYERS];
	mineSweepers = new MineSweeper[Constants.NUMBER_OF_SWEEPERS];
	}
	@Override
	public void startClicked() {
		this.layersExecutor = Executors.newFixedThreadPool(Constants.NUMBER_OF_LAYERS);
		this.sweepersExecutor = Executors.newFixedThreadPool(Constants.NUMBER_OF_SWEEPERS);
		System.out.println("Starting layer and mines");
		try {
			for(int i=0;i<Constants.NUMBER_OF_LAYERS;i++) {
				mineLayers[i] = new MineLayer(i,board);
				layersExecutor.execute(mineLayers[i]);
			}
			for(int i=0;i<Constants.NUMBER_OF_SWEEPERS;i++) {
				mineSweepers[i] = new MineSweeper(i,board);
				sweepersExecutor.execute(mineSweepers[i]);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			layersExecutor.shutdown();
			sweepersExecutor.shutdown();
		}
	}
	@Override
	public void stopClicked() {
		for(MineLayer minelayer: mineLayers) {
			minelayer.setLayerRunning(false);
		}
		for(MineSweeper minesweeper: mineSweepers) {
			minesweeper.setLayerRunning(false);
		}
		
		layersExecutor.shutdown();
		sweepersExecutor.shutdown();
		
		try {
			layersExecutor.awaitTermination(1, TimeUnit.MINUTES);
			sweepersExecutor.awaitTermination(1, TimeUnit.MINUTES);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		layersExecutor.shutdownNow();
		sweepersExecutor.shutdownNow();
		
		this.board.clearBoard();
	}
}
