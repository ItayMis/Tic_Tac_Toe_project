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
    public String userMove(int x, int y){
        String[] images = {"blue_circle","square","blue_x"};
        logic.updateBoard(x,y);
        int index = logic.getPlayer() + 1;
        return images[index];
    }
    public boolean isGameOver(){
        return logic.getGameOver();
    }

    public void endGame(){
        logic.setPlayer(0);
    }
}
