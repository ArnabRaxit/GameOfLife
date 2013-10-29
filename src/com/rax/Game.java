package com.rax;

import java.util.List;

public class Game {

	private List<Cell> board;
	public List<Cell> getBoard() {
		return board;
	}
	public void setBoard(List<Cell> board) {
		this.board = board;
	}
	private boolean ON=true;
	private long SPEED=500;
	private int SQRT_SIZE=10;
	
	
	public boolean isON() {
		return ON;
	}
	public void setON(boolean oN) {
		ON = oN;
	}
	public long getSPEED() {
		return SPEED;
	}
	public void setSPEED(long sPEED) {
		SPEED = sPEED;
	}
	
	public List<State> extractStates(){
		return null;
	}
	
	public Game() {
		
		board = DrawBoard.draw(SQRT_SIZE);
	}
	public Game(int sqrt_size,boolean on, int speed) {
		SQRT_SIZE=sqrt_size;
		ON=on;
		SPEED=speed;
		board = DrawBoard.draw(SQRT_SIZE);
	}
	public void play(){
		
		while(ON){
			try {
				Thread.sleep(SPEED);
				
				for (Cell current_cell : board) {
					makeMove(current_cell);
				}
				for (Cell current_cell : board) {
					current_cell.activateState();
				}
			} catch (InterruptedException e) {
				
			}
			
			
		}
	}
	public static void makeMove(Cell current_cell) {
		rule_survival(current_cell);
		rule_birth(current_cell);
		
	}
	static void rule_survival(Cell current_cell){
		if (current_cell.state == State.ALIVE){
			int live_neighbours = 0;		
			live_neighbours = (current_cell.north!= null && current_cell.north.state==State.ALIVE)?live_neighbours+1:live_neighbours;
			live_neighbours = (current_cell.northEast!= null && current_cell.northEast.state==State.ALIVE)?live_neighbours+1:live_neighbours;
			live_neighbours = (current_cell.east!= null && current_cell.east.state==State.ALIVE)?live_neighbours+1:live_neighbours;
			live_neighbours = (current_cell.southEast!= null && current_cell.southEast.state==State.ALIVE)?live_neighbours+1:live_neighbours;
			live_neighbours = (current_cell.south!= null && current_cell.south.state==State.ALIVE)?live_neighbours+1:live_neighbours;
			live_neighbours = (current_cell.southWest!= null && current_cell.southWest.state==State.ALIVE)?live_neighbours+1:live_neighbours;
			live_neighbours = (current_cell.west!= null && current_cell.west.state==State.ALIVE)?live_neighbours+1:live_neighbours;
			live_neighbours = (current_cell.northWest!= null && current_cell.northWest.state==State.ALIVE)?live_neighbours+1:live_neighbours;
	
			if (live_neighbours==2 || live_neighbours==3){				
					current_cell.pseudoState=State.ALIVE;
			}else{
					current_cell.pseudoState=State.DEAD;
			}
		}
	}
	 static void rule_birth(Cell current_cell){
			if (current_cell.state == State.DEAD){
				int live_neighbours = 0;		
				live_neighbours = (current_cell.north!= null && current_cell.north.state==State.ALIVE)?live_neighbours+1:live_neighbours;
				live_neighbours = (current_cell.northEast!= null && current_cell.northEast.state==State.ALIVE)?live_neighbours+1:live_neighbours;
				live_neighbours = (current_cell.east!= null && current_cell.east.state==State.ALIVE)?live_neighbours+1:live_neighbours;
				live_neighbours = (current_cell.southEast!= null && current_cell.southEast.state==State.ALIVE)?live_neighbours+1:live_neighbours;
				live_neighbours = (current_cell.south!= null && current_cell.south.state==State.ALIVE)?live_neighbours+1:live_neighbours;
				live_neighbours = (current_cell.southWest!= null && current_cell.southWest.state==State.ALIVE)?live_neighbours+1:live_neighbours;
				live_neighbours = (current_cell.west!= null && current_cell.west.state==State.ALIVE)?live_neighbours+1:live_neighbours;
				live_neighbours = (current_cell.northWest!= null && current_cell.northWest.state==State.ALIVE)?live_neighbours+1:live_neighbours;
		
				if (live_neighbours==3){				
						current_cell.pseudoState=State.ALIVE;
				}else{
						current_cell.pseudoState=State.DEAD;
				}
			}
		}
}
