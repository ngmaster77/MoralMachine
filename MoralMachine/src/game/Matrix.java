package game;

import java.util.Random;

public class Matrix {
	

	private int[][] board; 
	private int rows; 
	private int columns; 
		
	public Matrix(int rows, int columns) {
			
		
		this.rows = rows; 
		this.columns = columns; 
		board = new int[rows][columns]; 
		
		this.initialize_matrix(); 
	}
	
	public void initialize_matrix() { 
		
		for(int i = 0; i < this.get_rows(); i++) {
			for(int j = 0; j < this.get_columns(); j++) {
				board[i][j] = 0; 
			}
		}
	}
	
		
	public int get_value(int row, int column) { 
		return board[row][column];
	}
		
	public void set_value(int row, int column, int element) { 
		board[row][column] = element;
	}
		
	public int get_rows() { 
		return rows;
	}

	public void set_rows(int rows) {
		this.rows = rows;
	}

	public int get_columns() { 
		return columns;
	}

	public void set_columns(int columns) {
		this.columns = columns;
	}

}
