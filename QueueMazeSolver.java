/*Name: Emerald Baldwin
  Assignment: Lab 7
  Title: QueueMazeSolver
  Course: CSCE 270
  Lab Section: 2
  Semester: Fall 2013
  Instructor: Kenneth Blaha
  Date: 11/10/13
  Sources consulted: Dr. Blaha, Java API for JOptionPane
  Program description: This program runs an algorithm to solve
  a given maze. It provides the ability to choose between solving
  the maze with ArrayQueue or with a Stack
  */
import java.util.Stack;

import javax.swing.JOptionPane;


public class QueueMazeSolver implements MazeSolver {
	private MazeGui gui;
	
	public QueueMazeSolver() {
		gui = new MazeGui(this);
	}
	
	/**
	 * This method is called when the start button is
	 * clicked in the MazeGUI.  This method should solve the maze.
	 * This method may call MazeGUI.drawMaze(...) whenever the
	 * GUI display should be updated (after each step of the solution).
	 * 
	 * The maze is provided as the first parameter.  It is a 2D array containing
	 * characters that represent the spaces in the maze.  The following 
	 * characters will be found in the array:
	 *    '#' - This represents a wall.
	 *    ' ' - This represents an open space (corridor)
	 *    
	 * When calling MazeGUI.drawMaze(...) to update the display, the GUI
	 * will recognize the '#' and ' ' characters as well as the following:
	 *    '@' - Means the cell is a space that has been explored
	 *    '%' - Means that the cell is part of the best path to the goal.
	 * 
	 * @param maze the maze (see above).
	 * @param startR the row of the start cell.
	 * @param startC the column of the start cell.
	 * @param endR the row of the end (goal) cell.
	 * @param endC the column of the end (goal) cell.
	 */
	@Override
	public void solve(char[][] maze, int startR, int startC, int endR, int endC) {
		
		/* Provide the options to use in the JOptionPane and show the JOptionPane 
		 * The JOptionPane takes their choice and stores it in n
		 */
		Object[] options = {"Solve by Queue", "Solve by Stack"};
		int n = JOptionPane.showOptionDialog(gui, "How would you like to solve the maze?", 
				"Solve", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		boolean foundIt = false; // the flag to tell if we have found the last cell
		
		// If they choose to solve by Queue, n equals 1
		if (n == 0) {
			
			// create the ending cell (red cell) using the coordinates we are passed in
			Cell endCell = new Cell(endR, endC);
			
			// create a new ArrayQueue of Cells
			ArrayQueue<Cell> mazeQ = new ArrayQueue<Cell>();
			mazeQ.offer(new Cell(startR, startC));
			
			Cell newCell = null;
			Cell temp;
			// while we still have Cells in the ArrayQueue and we have not found the endCell
			while (!mazeQ.isEmpty() && foundIt == false) {
				// get the first Cell in mazeQ
				temp = mazeQ.poll();
				// mark the first cell as already looked at
				maze[temp.row][temp.col] = '@';
				
				// if the top cell is the endCell, we have found the endCell and are done
				if (endCell.equals(temp)) {
					foundIt = true;
				} else { // look at the Cells surrounding temp and see if they can
					// be put in the ArrayQueue. If they can, do so.
					if (maze[temp.row - 1][temp.col] == ' ') {
						newCell = new Cell(temp.row - 1, temp.col);
						mazeQ.offer(newCell);
					}
					if (maze[temp.row + 1][temp.col] == ' ') {
						newCell = new Cell(temp.row + 1, temp.col);
						mazeQ.offer(newCell);
					}
					if (maze[temp.row][temp.col - 1] == ' ') {
						newCell = new Cell(temp.row, temp.col - 1);
						mazeQ.offer(newCell);
					}
					if (maze[temp.row][temp.col + 1] == ' ') {
						newCell = new Cell(temp.row, temp.col + 1);
						mazeQ.offer(newCell);
					}
				}
				
				// redraw the maze
				gui.drawMaze(maze);
				
				// make the program sleep so we can see what it is doing
				// if we fail, throw an exception
				try { Thread.sleep(100); }
				catch( InterruptedException e ) {
				  System.err.println("Thread interrupted!");
				} 
			} // while
			
		} else {
			// create the ending cell (red cell) using the coordinates we are passed in
			Cell endCell = new Cell(endR, endC);
			
			// create a new Stack of Cells
			Stack<Cell> mazeQ = new Stack<Cell>();
			
			// push the starting cell onto the Stack
			mazeQ.push(new Cell(startR, startC));
			Cell newCell = null;
			Cell temp;
			
			// while the Stack
			while (!mazeQ.isEmpty() && foundIt == false) {
				// get the first Cell in mazeQ
				temp = mazeQ.pop();
				maze[temp.row][temp.col] = '@';
				if (endCell.equals(temp)) {
					foundIt = true;
				} else {
					if (maze[temp.row - 1][temp.col] == ' ') {
						newCell = new Cell(temp.row - 1, temp.col);
						mazeQ.push(newCell);
					}
					if (maze[temp.row + 1][temp.col] == ' ') {
						newCell = new Cell(temp.row + 1, temp.col);
						mazeQ.push(newCell);
					}
					if (maze[temp.row][temp.col - 1] == ' ') {
						newCell = new Cell(temp.row, temp.col - 1);
						mazeQ.push(newCell);
					}
					if (maze[temp.row][temp.col + 1] == ' ') {
						newCell = new Cell(temp.row, temp.col + 1);
						mazeQ.push(newCell);
					}
				}
				// redraw the maze
				gui.drawMaze(maze);
				
				// make the program sleep so we can see what it is doing
				// if we fail, throw an exception
				try { Thread.sleep(100); }
				catch( InterruptedException e ) {
				  System.err.println("Thread interrupted!");
				}
			} // while
		} // if else statement
		
		// if we found the last cell, display that we can solve the maze
		if (foundIt == true) {
			gui.setStatusText("Maze is solvable.");
		} else {
			gui.setStatusText("Maze is not solvable.");
		}
	}
}
