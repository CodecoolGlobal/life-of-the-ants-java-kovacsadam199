package com.codecool.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

import java.util.Random;

public class Queen extends Ant{
    private boolean readyToMate=false;
    private int matingMood;
    private final Position position;
    public Queen(int x, int y){
        position = new Position(x,y);
        matingMood=generateMood();

    }

    private int generateMood() {
        Random random = new Random();
        int number = random.nextInt(51)+50;
        int testNumber= random.nextInt(10);
        // TODO:          set to    number after testing
        return testNumber;
    }

    @Override
    public void act(int width) {
        matingMood--;
        if (matingMood== 0){
            readyToMate= true;
            System.out.println("Queen is ready");
        }

    }

    @Override
    public String getType() {
        return "\uD83D\uDC51  ";
    }

    public int[] getPosition(){
        return position.getPosition();
    }
    public void printMood(){
        System.out.println(matingMood);
    }
}
