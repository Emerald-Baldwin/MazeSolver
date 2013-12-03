/*Name: Emerald Baldwin
  Assignment: Lab 7
  Title: Cell
  Course: CSCE 270
  Lab Section: 2
  Semester: Fall 2013
  Instructor: Kenneth Blaha
  Date: 11/10/13
  Sources consulted: Dr. Blaha
  Program description: This program is a small class that is used
  to store each cell's coordinate information in a maze
  */
public class Cell {
	protected int col;
	protected int row;
	
	/** Constructor
	  * @param row the row number of this cell
	  * @param col the column number of this cell
	  */
	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	/** Helper method that determines if two cells are equal
	  * @param o The cell to compare to this
	  * @return true if this cell is the same as o
	  */
	public boolean equals(Cell o) {
		if (row == o.row && col == o.col) {
			return true;
		}
		return false;
	}
 }
