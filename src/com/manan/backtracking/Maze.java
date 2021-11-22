package com.manan.backtracking;

//Purpose: Finding ways in a Maze => Given a matrix, find number of ways to reach the end
//         Printing the path

public class Maze {

    public static void main(String[] args) {

        System.out.println("The number of ways to reach (1,1) is " + ways(3, 3));
        printWay("", 3, 3);
    }

    public static int ways(int r, int c) {
        if (r == 1 || c == 1) return 1; //Coz as soon as r or c is 1; only 1 way exists from there
        int down = ways(r - 1, c);
        int right = ways(r, c - 1);
        return down + right;
    }

    public static void printWay(String p, int r, int c){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }
//      if(r>1 && c>1) printWay(p + 'Di', r-1, c-1);   // For moving diagonally
        if(r>1) printWay(p + 'D', r-1, c);
        if(c>1) printWay(p + 'R', r, c-1);

        return;

    }
}
