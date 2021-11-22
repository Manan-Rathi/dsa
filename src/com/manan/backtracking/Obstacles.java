package com.manan.backtracking;
//Generic maze with obstacles
//THIS IS NOT BACKTRACKING
//Just stop the recursion when obstacle is hit => i.e. return; simply
public class Obstacles {

    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        printRestrictions("", board, 0,0);
    }

    public static void printRestrictions(String p, boolean[][] maze, int r, int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
//      if(r>1 && c>1) printWay(p + 'Di', r-1, c-1);   // For moving diagonally

        if(!maze[r][c]) return;

        if(r<maze.length-1) printRestrictions(p + 'D',maze, r+1, c);
        if(c<maze[0].length-1) printRestrictions(p + 'R',maze, r, c+1);

        return;

    }

}
