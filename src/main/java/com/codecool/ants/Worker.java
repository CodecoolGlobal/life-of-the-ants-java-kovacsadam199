package com.codecool.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

public class Worker extends Ant{
    private Position position;
    private Direction direction;
    public Worker(Position position){
        this.position = position;

    }

    @Override
   public void act(int width) {
        this.direction=Direction.getRandomDirection();
        switch (direction){
            case NORTH:
                position.setX(position.getX()-1);
                if(position.getX()<0)
                    position.setX(0);
                break;
            case SOUTH:
                position.setX(position.getX()+1);
                if(position.getX()>width-1)
                    position.setX(width-1);
                break;
            case EAST:
                position.setY(position.getY()+1);
                if(position.getY()>width-1)
                    position.setY(width-1);
                break;
            case WEST:
                position.setY(position.getY()-1);
                if(position.getY()<0)
                    position.setY(0);
                break;
        }

    }

    @Override
    public String getType() {
        return "\uD83D\uDC1C  ";
    }

    public int[] getPosition() {
        return position.getPosition();
    }
}
