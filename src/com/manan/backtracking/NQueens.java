package com.manan.backtracking;

public class NQueens {
    public static void main(String[] args) {

        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println( "The total number of ways for this n is " + queens(board, 0));

    }

    static int queens(boolean[][] board, int r){

        //print when row number exceeds the limit
        if(r==board.length){
            display(board);
            System.out.println();
            return 1;
        }

        //Maintain a count of total number of ways.
        int count =0;

        //placing the queen and checking
        for (int col = 0; col < board[0].length; col++) {
            if(isSafe(board, r, col)){
                board[r][col] = true;
                count+= queens(board, r+1);
                board[r][col] = false;
            }
        }
        return count;

    }

    static void display(boolean[][] board){
        for (boolean[] row : board) {
            for (boolean element : row) {
                if(element){
                    System.out.print("Q ");
                }
                else System.out.print("X ");
            }
            System.out.println();
        }
    }

    static boolean isSafe(boolean[][] board, int row, int col){
        //Now we check if placing a Q is safe at this (r,c)
        //Remember: true indicates a placed queen

        //Check vertically UP
        for (int i = 0; i <row; i++) {
            if(board[i][col]) return false;
        }

        //Check left diagonal
        int maxLeft = Math.min(row,col);
        for (int i = 1; i <= maxLeft; i++) {
            if(board[row-i][col-i]) return false;
        }

        //Check right diagonal
        int maxRight = Math.min(row,board[0].length-col-1);
        for (int i = 1; i <= maxRight; i++) {
            if(board[row-i][col+i]) return false;
        }

        //else
        return true;
    }

}
