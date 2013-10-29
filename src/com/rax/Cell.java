package com.rax;

public class Cell {
	
	public Cell north;
	public Cell northEast;
	public Cell east;
	public Cell southEast;
	public Cell south;
	public Cell southWest;
	public Cell west;
	public Cell northWest;
	
	public State state=State.DEAD;
	public State pseudoState;
	
	
	
	void activateState(){
		state=pseudoState;
		pseudoState=State.DEAD;
	}
}
