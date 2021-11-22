package com.manan.backtracking;

public class AllPaths {

    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        printAllPaths("", board, 0,0);
    }

    public static void printAllPaths(String p, boolean[][] maze, int r, int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
//      if(r>1 && c>1) printWay(p + 'Di', r-1, c-1);   // For moving diagonally

        if(!maze[r][c]) return;

        //We don't want to go back in this call itself => Would lead to Stack overflow : Infinite calls
        maze[r][c] = false;

        if(r<maze.length-1) printAllPaths(p + 'D',maze, r+1, c);
        if(c<maze[0].length-1) printAllPaths(p + 'R',maze, r, c+1);
        if(r>0) printAllPaths(p + 'U', maze,r-1, c);
        if(c>0) printAllPaths(p + 'L', maze, r, c-1);

        //Now that this recursion call is over, restore the array to its previous state
        //Else some paths will not be considered.
        //This restoration is called BACKTRACKING i.e. What if this path was not taken, find else.
        maze[r][c] = true;

        return;

    }

}
