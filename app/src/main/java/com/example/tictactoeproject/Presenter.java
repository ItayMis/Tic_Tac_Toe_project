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

    //userMove
    //checkWin or GameOver
}
