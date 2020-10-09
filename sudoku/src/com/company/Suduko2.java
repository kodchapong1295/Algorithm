package com.company;

public class Suduko2 {
    public static int[][] BOARD = {
            {7,0,0,5,8,3,0,0,6},
            {0,0,6,0,0,1,4,0,5},
            {0,5,2,0,0,6,0,8,3},
            {3,0,0,2,0,0,9,5,8},
            {5,0,0,0,7,8,0,6,0},
            {6,4,8,0,1,0,3,0,0},
            {0,6,0,8,0,2,5,0,0},
            {0,0,3,1,5,0,0,7,2},
            {2,1,5,6,0,0,0,3,0},
    };
    public static int ROW = 9;
    public static int COL = 9;
    public static int CELL = ROW*COL;

    public static void main(String[] args) {
        System.out.println(checkValidForSure(3,1,1));
    }

    public static boolean checkValid(int val, int xRow, int yCol){
        //check row
        for (int i = 0; i < COL; i++) {
            if (BOARD[xRow][i] == val){
                return false;
            }
        }

        //check col
        for (int i = 0; i < ROW; i++) {
            if (BOARD[i][yCol] == val){
                return false;
            }
        }

        //checkBox
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (BOARD[xRow - xRow%3 + i][yCol - yCol%3 + j] == val){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean checkValidForSure(int val, int xRow, int yCol){
        if (checkValid(val, xRow, yCol)){
            int possible = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (BOARD[xRow-xRow%3+i][yCol-yCol%3 + j] == 0 && checkValid(val,xRow-xRow%3+i,yCol-yCol%3 + j)){
                        possible++;
                    }
                }
            }
            if (possible == 1){
                return true;
            }
        }
        return false;
    }

    
}
