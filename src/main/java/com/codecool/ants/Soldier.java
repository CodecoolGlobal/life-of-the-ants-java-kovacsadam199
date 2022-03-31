package com.codecool.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

public class Soldier extends Ant {
    private Position position;
    private Direction direction;

    public Soldier(Position position) {
        this.position = position;
        direction=Direction.getRandomDirection();
    }

    @Override
    public String getType() {
        return "\uD83D\uDC55  ";
    }

    public int[] getPosition() {
        return position.getPosition();
    }

    @Override
    public void act(int width) {

        switch (direction) {
            case NORTH:
                position.setX(position.getX() - 1);
                if (position.getX() < 0)
                    position.setX(0);
                if (position.getY() > width - 1)
                    position.setY(width - 1);
                direction = Direction.WEST;
                break;
            case SOUTH:
                position.setX(position.getX() + 1);
                if (position.getX() > width - 1)
                    position.setX(width - 1);
                if (position.getY() > width - 1)
                    position.setY(width - 1);
                direction = Direction.EAST;
                break;
            case EAST:
                position.setY(position.getY() + 1);
                if (position.getX() > width - 1)
                    position.setX(width - 1);
                if (position.getY() > width - 1)
                    position.setY(width - 1);
                direction = Direction.NORTH;
                break;
            case WEST:
                position.setY(position.getY() - 1);
                if (position.getX() > width - 1)
                    position.setX(width - 1);
                if (position.getY() < 0)
                    position.setY(0);
                direction = Direction.SOUTH;
                break;

        }
    }
}
