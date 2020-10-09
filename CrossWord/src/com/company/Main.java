package com.company;

import java.util.Arrays;

public class Main {
    static char[][] board= {{'0','1','2','3','4','5','6','7'},  //0
                            {'a','b','c','d','e','f','g','h'},  //1
                            {'a','b','l','a','p','o','g','h'},  //2
                            {'a','b','c','d','e','r','g','h'},  //3
                            {'a','p','e','e','m','a','g','h'},  //4
                            {'p','q','r','s','m','a','r','t'},  //5
                            {'a','b','c','d','e','f','g','h'},  //6
                            {'m','n','o','p','q','r','s','t'}}; //7
    static int ROW = board.length, COL=board[0].length;


    public static void main(String[] args) {
        int[] position = new int[2];
        position = searchPuzzle("rst");
        System.out.println(position[0]+" "+position[1]);
    }

    public static int[] searchPuzzle(String key){
        int[] position = {-1,-1};
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                //left to right
                int p = 0;
                while(col<= COL-key.length() && p<key.length() && board[row][col+p] == key.charAt(p)){
                    p++;
                }
                if(p == key.length()){
                    position[0] = row;
                    position[1] = col;
                    return position;
                }

                //right to left
                p=0;
                while(col>= key.length()-1 && p<key.length() && board[row][col-p] == key.charAt(p)){
                    p++;
                }
                if(p == key.length()){
                    position[0] = row;
                    position[1] = col;
                    return position;
                }

            }
        }
        return position;
    }
}
