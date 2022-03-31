package com.codecool.ants;

import com.codecool.ants.geometry.Position;

public class Soldier extends Ant{
    private Position position;
    public Soldier(Position position){
        this.position = position;

    }
    @Override
    void act() {

    }

    @Override
    public String getType() {
        return "S";
    }
    public int[] getPosition(){
        return  position.getPosition();
    }
}
