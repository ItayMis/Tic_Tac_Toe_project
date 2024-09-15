package com.example.tictactoeproject;

public class Logic {

    private int player;
    private  int[][] board;

    public Logic() {
        player = 1;
        board = new int[3][3];
    }

    public void userInput(int x, int y){
        if(board[x][y] == 0){
            board[x][y] = player;

        }
    }
}
