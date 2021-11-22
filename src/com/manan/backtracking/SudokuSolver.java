package com.manan.backtracking;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = {   {3, 0, 6, 5, 0, 8, 4, 0, 0},
                            {5, 2, 0, 0, 0, 0, 0, 0, 0},
                            {0, 8, 7, 0, 0, 0, 0, 3, 1},
                            {0, 0, 3, 0, 1, 0, 0, 8, 0},
                            {9, 0, 0, 8, 6, 3, 0, 0, 5},
                            {0, 5, 0, 0, 9, 0, 6, 0, 0},
                            {1, 3, 0, 0, 0, 0, 2, 5, 0},
                            {0, 0, 0, 0, 0, 0, 0, 7, 4},
                            {0, 0, 5, 2, 0, 6, 3, 0, 0} };

        if(solve(board)){
            display(board);
        }
        else System.out.println("Nope");
    }

    static boolean solve(int[][] board){
        int n = board.length;
        int row = -1;
        int col = -1;

        //We have to fill the EMPTY elements, thus find them
        boolean emptyLeft = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    //empty found
                    //storing its (r,c)
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
                if (!emptyLeft) break;
            }

            if(emptyLeft) return true; //Sudoku is solved

            //backtrack

                for (int number = 1; number <=9 ; number++) {
                    if(isSafe(board, row, col, number)){
                        board[row][col] = number;
                        if(solve(board)){
                            return true;
                        }
                        else board[row][col]=0; //backtrack

                    }
                }
        return false;
    }

    static void display(int[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean isSafe(int[][] board, int row, int col, int num){

        //Chk for the col
        for (int i = 0; i < board.length; i++) {
            if(board[i][col]==num) return false;
        }

        //Chk for the row
        for (int i = 0; i < board[0].length; i++) {
            if(board[row][i]==num) return false;
        }

        //Chk for the 3x3 box
        int sqrt = (int)(Math.sqrt(board.length));
        int rowStart = row - row%sqrt;
        int colStart = col - col%sqrt;

        for(int i=rowStart; i< rowStart+sqrt; i++){
            for (int j = colStart; j < colStart+3; j++) {
                if(board[i][j]==num) return false;
            }
        }
        return true;
    }
}
