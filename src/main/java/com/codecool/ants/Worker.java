package com.codecool.ants;

import com.codecool.ants.geometry.Position;

public class Worker extends Ant{
    private Position position;
    public Worker(Position position){
        this.position = position;

    }

    @Override
    void act() {

    }

    @Override
    public String getType() {
        return "W";
    }

    public int[] getPosition() {
        return position.getPosition();
    }
}
