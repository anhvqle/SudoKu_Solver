import java.util.*;
import java.io.*;

public class MainSudoku {
	public static final int EMPTY = 0;
	public static final int SIZE = 9;
	
	public static void main(String[] args) {
		System.out.println( "Please enter a file name: " );
		Scanner input = new Scanner(System.in);
		String fileName = input.nextLine();
		input.close();
		FileReader f = null;
		try {
			f = new FileReader(fileName);
		}
		catch(FileNotFoundException e) {
			System.out.println("Invalid file");
			System.exit(1);
		}
		Scanner reader = new Scanner(f);
		
		//Read in the file as a 2D array
		int[][] board = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = reader.nextInt();
			}
		}
		
		//Show the initial Sudoku puzzles board
		System.out.println("The Initial Sudoku Puzzles: ");
		displayBoard(board);
		System.out.println(isInRow(8,9,board));
		
	}
	
	//Method to print out the sudoku puzzles
	public static void displayBoard(int[][] board) {
		System.out.println("-------------------");
		for (int i = 0; i < 9; i++) {
			if (i == 3 || i == 6)
				System.out.println("-------------------");
			for(int j = 0; j < 9; j++) {
				if (j == 3 || j == 6)
					System.out.print("|");
				System.out.print(board[i][j] + " ");
			}
			System.out.println(); 
		}
		System.out.println("-------------------");
	}

	
	//Method to check if a number is already in a row
	public static boolean isInRow(int row, int number, int[][] board) {
		for(int i = 0; i < SIZE; i++) {
			if(board[row][i] == number)
				return true;
		}
		return false;
	}
	
	//Method to check if a number is already in a columnn
	public static boolean isInCol(int col, int number, int[][] board) {
		for(int i = 0; i < SIZE; i++) {
			if(board[i][col] == number)
				return true;
		}
		return false;
	}
	
	//Method to check if a number is already in a 3x3 grid
	public static boolean isInSmallGrid (int row, int col, int number, int[][] board) {
		return true;
	}
}
