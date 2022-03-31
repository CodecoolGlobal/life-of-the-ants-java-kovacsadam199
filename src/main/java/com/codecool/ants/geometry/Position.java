package com.codecool.ants.geometry;

import java.util.Arrays;
import java.util.Random;

public class Position {

    public final int x;
    public final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Position(int width, int[] queenPosition){
        int[] position = generatePosition(width,queenPosition);
        this.x = position[0];
        this.y = position[1];
    }

    public int[] generatePosition(int width, int[] queenPosition){
        int[] numbers = new int[2];
        Random random = new Random();
        do{numbers[0] = random.nextInt(width);
            numbers[1]= random.nextInt(width);
        }
        while (queenPosition[0]==numbers[0] && queenPosition[1]==numbers[1]);
        return numbers;
    }
    public int[] getPosition(){
        return new int[]{x,y};
    }

}