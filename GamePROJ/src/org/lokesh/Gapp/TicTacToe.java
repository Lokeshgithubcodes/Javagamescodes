package org.lokesh.Gapp;

import java.util.Scanner;

public class TicTacToe {
 
	static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
	static int turn=0;
	private static char player;
	
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			while(true)
			{
				System.out.println("Current board:");
				PrintBoard();
				System.out.println("Player "+(turn % 2+1) + "turn. Enter row and column:");
				int row=input.nextInt();
				int col=input.nextInt();
				if(board[row][col]==' ')
				{
					board[row][col]=turn % 2 == 0 ? 'X' : 'O';
					turn++;
				}else {
					System.out.println("Invalid move, try again.");
				}
				if(checkWin('X')) {
					System.out.println("Player 1 wins!");
					break;
				}
				if(checkWin('O'))
				{
					System.out.println("Player 2 wins!");
					break;
				}
				if(turn==9)
				{
					System.out.println("It's a draw.");
					break;
				}
			}
		}
	}
	private static boolean checkWin(char c) {
		return false;
	}
	public static boolean PrintBoard() {
		for(int i=0;i<3;i++)
		{
			if(board[i][0]==player && board[i][1]==player && board[i][2]==player) {
				return true;
			}
			if(board[0][i]==player && board[1][i]==player && board[2][i]==player) {
				return true;
			}
		}
		if(board[0][0]==player && board[1][1]==player && board[2][2]==player) {
			return true;
		}
		if(board[0][2]==player && board[1][1]==player && board[2][0]==player) {
			return true;
		}
		return false;
	}
}
