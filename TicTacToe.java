//Name: Royce Lim
//Due date: 2/20
//Title: TicTacToe
//Description: Allows 2 people to play Tic Tac Toe
package hw3_1;
import java.util.*;
public class TicTacToe {
	public static void main(String[] args) {
		
		int [][] board = new int [3][3];	//Creates a 2d array with 3 rows and 3 columns
		Scanner sc = new Scanner(System.in);		//Initializes scanner
		int numMoves = 0;					//Initializes the move count variable
		
		System.out.println("Welcome to Tic Tac Toe! We have a 3x3 board.");
		while(numMoves < 9 && !checkWinner(board)) {		//Game will keep going until there is a draw or winner
			printBoard(board);						//Prints board
			System.out.println("It's player " + playersTurn(numMoves) + "'s turn");		//Indicates player turn
			makeMove(board, sc, playersTurn(numMoves));	   //Takes user input and puts it in the array
			numMoves++;							//Increases move count
			}
		
		printBoard(board);				//Prints board after game is finished
		
		int x = playersTurn(numMoves) - 1;	//Subtracts 1 from the current player turn number
		int y = playersTurn(numMoves) + 1;	//Adds 1 from the current player turn number
		
		if (checkWinner(board)) {			//Prints message if there is a winner
			
			//If player 2 is up next but player 1 already won, game will show that player 1 wins
			if (playersTurn(numMoves) == 2) {	
				System.out.println("Player " + x + " won! Congratulations!");
			
			}else {			//If player 1 is next but player 2 already won, game will show that player 2 wins
				System.out.println("Player " + y + " won! Congratulations!" );
			}
		
		}else {			//If the board has been filled but no one won, it's a draw and game ends
			System.out.println("It's a draw.");
		}
		
		
	}
	
	 public static void printBoard(int[][] board) {		//Prints the board and player positions using the array
		    for (int i = 0; i < 3; i++) {
		      System.out.print(" ");
		      printCell(board[i][0]); 
		      System.out.print(" | ");
		      printCell(board[i][1]); 
		      System.out.print(" | ");
		      printCell(board[i][2]); 
		      System.out.println();
		      if (i != 2) {
		        System.out.println("---|---|---");
		      }
		    }
		  }
	 public static void printCell(int cell) {			//Determines which symbol to print depending on player turn
			  switch (cell) {
			  case 0:					//If no player has filled the space, it is empty
			  	System.out.print(" ");
			  	break;
			  case 1:					//If it's player 1's turn, x is printed
				  System.out.print("x");
				  break;
			  case 2:					//If it's player 2's turn, o is printed
				  System.out.print("o");
				  break;
			  }
		  }
	 
	//Inputs a symbol into the board, based on user input and player turn
	 public static void makeMove(int[][] board, Scanner sc, int player) { 
		 	System.out.print("Enter a number from 1 - 9: ");    //Prompts user
			String userInput = sc.nextLine();
			switch(userInput) {
			/*In each board space, 1 or 2 will go in the space, based on turn, which results in x or o being printed. 
			Determines where to print the symbol. */
			case "1":
				board [0][0] = player;
				break;
			case "2":
				board [0][1] = player;
				break;
			case "3":
				board [0][2] = player;
				break;
			case "4":
				board [1][0] = player;
				break;
			case "5":
				board [1][1] = player;
				break;
			case "6":
				board [1][2] = player;
				break;
			case "7":
				board [2][0] = player;
				break;
			case "8":
				board [2][1] = player;
				break;
			case "9":
				board [2][2] = player;
				break;
				//If user makes invalid input, they are prompted again
			default:
				System.out.println("Input not recognized. Please try again");	
				makeMove(board, sc, player);
				break;
			}
		  }
	 
	 public static int playersTurn(int moveCount) {
		    //Determines which player goes based on move count.
		    if(moveCount % 2 ==0) {		//If the move count is even, player 1 goes.
		    	return 1;
		    } else {				//If the move count is odd, player 2 goes.
		    	return 2;
		    }
		  }
	
	 public static boolean checkWinner(int [][] board) {		//Determines if there is a winner
		 for (int i = 0; i < 3; i++) {		//Checks rows
			 if(board [i][0] != 0 && 
					 board [i][0] == board [i][1] && 
					 board [i][1] == board [i][2] && 
					 board[i][0]== board [i][2]) {
				 return true;
			 }
			 }
		 for (int i = 0; i < 3; i++) {		//Checks columns
			 if(board[0][i] != 0 &&
				board[0][i] == board [1][i] &&
				board[1][i] == board [2][i] &&
				board[0][i] == board [2][i]) {
				 return true;
			 }
		 }
		if(board[0][0] != 0 &&				//Checks diagonal
		   board[0][0] == board[1][1] &&
		   board[1][1] == board[2][2] &&
		   board[0][0] == board [2][2]) {
			return true;
			}
		if(board[0][2] != 0 &&				//Checks opposite diagonal
		   board[0][2] == board [1][1] &&
		   board[1][1] == board [2][0] &&
		   board[0][2] == board [2][0]) {
			return true;
		}
		return false;			//If none of the above statements are true, the game keeps going
	 }

}
