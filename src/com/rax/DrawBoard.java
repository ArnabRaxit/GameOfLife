package com.rax;

import java.util.ArrayList;
import java.util.List;

public  class DrawBoard {

	public static List<Cell> draw(int sqrt_size){
		
		List<Cell> board = new ArrayList<Cell>();
		int size = sqrt_size*sqrt_size;
		for(int i = 0; i <size; i++){
			board.add(new Cell());
			
		}
		for(int i = 0; i < size; i ++){
			Cell current_cell = board.get(i);
			int my_north = ((i-sqrt_size)<0)?0:(i-sqrt_size); 
			current_cell.north=board.get(my_north);
			
			int my_northEast = ((i-sqrt_size+1)<0)?0:(i-sqrt_size+1);
			current_cell.northEast=board.get(my_northEast);
			
			int my_east = ((i+1)>=size)?size-1:i+1;
			current_cell.east=board.get(my_east);
			
			int my_southEast = ((i+sqrt_size+1)>=size)?size-1:i+sqrt_size+1;
			current_cell.southEast=board.get(my_southEast);
			
			int my_south = ((i+sqrt_size)>=size)?size-1:i+sqrt_size;
			current_cell.south=board.get(my_south);
			
			int my_southWest = ((i+sqrt_size-1)>=size)?size-1:i+sqrt_size-1;
			current_cell.southWest=board.get(my_southWest);
			
			int my_west = ((i-1)<0)?0:i-1;
			current_cell.west=board.get(my_west);
			
			int my_northWest = ((i-sqrt_size-1)<0)?0:i-sqrt_size-1;
			current_cell.northWest=board.get(my_northWest);
		}
		
		// remove north links for top edge
		for (int i = 0; i < sqrt_size; i++){
			board.get(i).north=null;
		}
		// remove east links for right edge
		for (int i = 0+sqrt_size-1; i <= sqrt_size*sqrt_size-1; i=i+sqrt_size){
			board.get(i).east=null;
		}
		// remove south links for bottom edge
		for (int i = sqrt_size*sqrt_size-sqrt_size; i <= sqrt_size*sqrt_size-1; i++){
			board.get(i).south=null;
		}
		// remove west links for left edge
		for (int i = 0; i <=  sqrt_size*sqrt_size-sqrt_size; i=i+sqrt_size){
			board.get(i).west=null;
		}

	return board;
	}
}
