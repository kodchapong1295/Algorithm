package com.company;

public class Sudoku {
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
        printBoard();
        System.out.println("Solve");
        playSudoku();
        printBoard();
    }

    public static boolean checkValid(int val, int xRow, int yCol){

        //Check Row
        for (int i = 0; i < COL; i++) {
            if (val == BOARD[xRow][i]){
                return false;
            }
        }

        //Check Column
        for (int i = 0; i < ROW; i++) {
            if (val == BOARD[i][yCol]){
                return false;
            }
        }

        //check Box
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (BOARD[xRow - xRow % 3 + i][yCol - yCol % 3 + j] == val) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean checkValidForSure(int val, int xRow, int yCol){
        if (checkValid(val,xRow,yCol)){
            int possible = 0;
            for (int i = 0; i < 3; i++) {
                for (int j =0; j<3; j++){
                    if (BOARD[xRow-xRow%3+i][yCol - yCol % 3 + j] == 0 && checkValid(val,xRow-xRow%3+i, yCol-yCol%3+j)){
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

    public static int countNonZero(){
        int count = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (BOARD[i][j] != 0){
                    count++;
                }
            }
        }
        return count;
    }

    public static void playSudoku(){
        int nonZero = countNonZero();
        while (nonZero < CELL){
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COL; j++) {
                    if (BOARD[i][j] == 0){
                        for (int k = 1; k <= 9; k++) {
                            if (checkValidForSure(k,i,j)){
                                BOARD[i][j] = k;
                                nonZero++;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void printBoard(){
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.print(BOARD[i][j]+" ");
            }
            System.out.println();
        }
    }
}
