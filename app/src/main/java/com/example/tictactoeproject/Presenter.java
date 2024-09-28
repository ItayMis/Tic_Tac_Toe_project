package com.example.tictactoeproject;

public class Presenter {

    private Iview view;
    private Logic logic;
    private String[] images;

    public Presenter(Iview view) {
        this.view = view;
        this.logic = new Logic();
        this.images = new String[]{"blue_circle","square","blue_x"};
        ;
    }

    public Logic getLogic(){
        return logic;
    }
    public String userMove(int x, int y){
        logic.updateBoard(x,y);
        int index = logic.getPlayer() + 1;
        return images[index];
    }
    public boolean isGameOver(){
        return logic.getGameOver();
    }


    public String[] getImages() {
        return images;
    }
    public String getPlayerName(int index){
        return images[index].replace("_"," ");
    }
    public String getWinMsg() {
        if (logic.getCounter() == 9) {
            return "Game Over, it's a Draw!";
        }
        return "Game Over, "+ getPlayerName( logic.getPlayer() + 1) + " Wins!";
    }

    public String getTurnMsg() {
        return getPlayerName(logic.getPlayer() + 1) + "'s Turn";
    }

    public void resetGame() {
        logic = new Logic();
    }
}