package com.codecool.ants;

import com.codecool.ants.geometry.Position;

public class Drone extends Ant{
    private Position position;
    public Drone(Position position){
        this.position=position;

    }
    @Override
    public void act() {

    }

    @Override
    public String getType() {
        return "D";
    }

    public void succesfulMeet(){
        System.out.println("HALLELUJAH");
    }
    public void rejectedMeet(){
        System.out.println(":(");
    }

    public int[] getPosition() {
        return position.getPosition();
    }
}
