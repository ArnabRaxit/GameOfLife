package com.rax;

import java.awt.*;
import java.applet.*;

import java.util.List;

public class Checkerboard extends Applet {
  
   /*  This applet draws a red-and-black checkerboard.
       It is assumed that the size of the applet is 160
       by 160 pixels.
   */

	Game game;
	@Override
		public void init() {
			super.init();
			game = new Game(20,true,500);
				Cell acell = game.getBoard().get(23);
				 acell.north.state=State.ALIVE;acell.state=State.ALIVE;acell.south.state=State.ALIVE; acell.south.west.state=State.ALIVE;acell.south.west.northWest.state=State.ALIVE;
				 
				 Cell bcell = game.getBoard().get(60);
				 bcell.north.state=State.ALIVE;bcell.state=State.ALIVE;bcell.south.state=State.ALIVE;
				 
				 Cell ccell = game.getBoard().get(34);
				 ccell.north.state=State.ALIVE;ccell.state=State.ALIVE;ccell.south.state=State.ALIVE;
				 
		}
	
	@Override
		public void start() {
			// TODO Auto-generated method stub
			super.start();
			
			
		}
   public void paint(Graphics g) {
	   System.out.println();
	   
	
		int row;   // Row number, from 0 to 7
		int col;   // Column number, from 0 to 7
		int x,y;   // Top-left corner of square
		
		
		while(game.isON()){
			
				
		List<Cell> board = game.getBoard();
		int size = board.size(); 
		double width = Math.sqrt(size);
		double height = width;
		int z = 0;
		for(int i = 0 ;i<height;i++){
			for(int j = 0 ;j<width; j++){ 
					x = i * 20;
		            y = j * 20;
		  			State s = board.get(z++).state;  
		  			 if (State.ALIVE==s) 
		                 g.setColor(Color.green);
		              else
		                 g.setColor(Color.black);
		              g.fillRect(x, y, 20, 20);
		  		}	
		  	
		}   
		try {
			Thread.sleep(game.getSPEED());
			
			for (Cell current_cell : game.getBoard()) {
				game.makeMove(current_cell);
			}
			for (Cell current_cell : game.getBoard()) {
				current_cell.activateState();
			}
		} catch (InterruptedException e) {
			
		}
		}
     
	   /*int row;   // Row number, from 0 to 7
		int col;   // Column number, from 0 to 7
		int x,y;   // Top-left corner of square
      for ( row = 0;  row < 8;  row++ ) {
    	  for ( col = 0;  col < 8;  col++) {
            x = col * 20;
            y = row * 20;
            if ( (row % 2) == (col % 2) )
               g.setColor(Color.red);
            else
               g.setColor(Color.black);
            g.fillRect(x, y, 20, 20);
         } 
      
      } // end for row
*/   
   }  // end paint()

}  // end class