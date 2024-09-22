package com.example.tictactoeproject;

public class Logic {

    private int player;
    private int counter;
    private int[][] board;

    public Logic() {

        //1 = x, -1 = 0
        player = 1;
        counter = 0;
        board = new int[3][3];
    }

    public void updateBoard(int x, int y){
        if(isEmpty(x,y)){
            System.out.println(x+" "+y);
            System.out.println(board[x][y]);

            counter++;
            board[x][y] = player;
            player*=-1;
        }
        int curr_state = checkWin(x,y);
        if(curr_state != 0){
           gameover(curr_state);
        }
        else if(counter == 9) {
            gameover(0);
        }

    }



    public boolean isEmpty(int x, int y){
        return board[x][y] == 0;
    }

    public int checkWin(int x, int y){
        int rowSum = 0;
        for (int j = 0; j < 3; j++) {
            rowSum += board[j][y];
        }
        int colSum = 0;
        for(int j = 0; j < 3; j++){
            colSum += board[x][j];
        }
        int alexson = 0;
        int i = 0;
        for(int j = 0; j<3; j++){
            alexson+=board[i][j];
            i++;
        }
        int alexson2 = 0;
        i = 2;
        for(int j = 2; j>=0; j--){
            alexson2+=board[i][j];
            i--;
        }
        if(rowSum == 3 || colSum == 3 || alexson == 3 || alexson2 == 3){
            return 1;
        }
        else if(rowSum == -3 || colSum == -3 || alexson == -3 || alexson2 == -3){
            return -1;
        }
        return 0;
    }
    public int gameover(int winner){
        return winner;
    }

    public int getPlayer() {
        return player;
    }
}
