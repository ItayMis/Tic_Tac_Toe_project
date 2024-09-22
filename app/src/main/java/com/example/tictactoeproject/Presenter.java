package com.example.tictactoeproject;

public class Presenter {

    private Iview view;
    private Logic logic;

    public Presenter(Iview view) {
        this.view = view;
        this.logic = new Logic();
    }

    public Logic getLogic(){
        return logic;
    }
    public int userMove(int x, int y){
        logic.updateBoard(x,y);
        return  logic.getPlayer();
    }
    public boolean isGameOver(){
        return logic.getGameOver();
    }
}
