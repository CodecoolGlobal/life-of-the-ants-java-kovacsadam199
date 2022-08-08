package com.codecool.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Drone extends Ant {
    private Position position;
    private Direction direction;

    public Drone(Position position) {
        this.position = position;
        direction = Direction.getRandomDirection();//TODO:faceQueen;

    }

    @Override
    public void act(int width) {
        //TODO: check if mating
        Direction directionToBeKicked= Direction.getRandomDirection();
        int[] middle = {(width - 1) / 2, (width - 1) / 2};
        boolean queenIsLeft=position.getY()>middle[1];
        boolean queenIsUp=position.getX()>middle[0];
        boolean queenIsVertical= position.getY()==middle[1];
        boolean queenIsHorizontal= position.getX()==middle[0];
        if(Arrays.equals(position.getPosition(),middle)) {

            switch (directionToBeKicked) {
                case NORTH:
                    position.setX(0);
                    position.setRandomY(width);
                    break;
                case SOUTH:
                    position.setX(width-1);
                    position.setRandomY(width);
                    break;
                case EAST:
                    position.setY(width-1);
                    position.setRandomX(width);
                    break;
                case WEST:
                    position.setY(0);
                    position.setRandomX(width);
                    break;
            }
            return;
        }
        if(queenIsLeft && queenIsUp)
            direction= Direction.NORTH;
        else if(queenIsLeft && queenIsHorizontal)
            direction= Direction.WEST;
        else if(queenIsLeft)
            direction=Direction.SOUTH;
        else if(queenIsUp)
            direction=Direction.NORTH;
        else if(queenIsHorizontal)
            direction=Direction.EAST;
        else{direction=Direction.SOUTH;}




        switch (direction) {
            case NORTH:
                position.setX(position.getX() - 1);
                if (position.getX() < 0)
                    position.setX(0);
                break;
            case SOUTH:
                position.setX(position.getX() + 1);
                if (position.getX() > width - 1)
                    position.setX(width - 1);
                break;
            case EAST:
                position.setY(position.getY() + 1);
                if (position.getY() > width - 1)
                    position.setY(width - 1);
                break;
            case WEST:
                position.setY(position.getY() - 1);
                if (position.getY() < 0)
                    position.setY(0);
                break;
        }
    }

    @Override
    public String getType() {
        return "\uD83D\uDC45  ";
    }

    public void succesfulMeet() {
        System.out.println("HALLELUJAH");
    }

    public void rejectedMeet() {
        System.out.println(":(");
    }

    public int[] getPosition() {
        return position.getPosition();
    }

    public void setRandomX(int width) {
        position.setRandomX(width);
    }

    public void setRandomY(int width) {
        position.setRandomY(width);
    }

    public void goToEdge(int width) {
        this.direction = Direction.getRandomDirection();
        switch (direction) {
            case NORTH:
                position.setX(0);
                break;
            case SOUTH:
                position.setX(width - 1);
                break;
            case EAST:
                position.setY(width - 1);
                break;
            case WEST:
                position.setY(0);
                break;
        }
    }
}
