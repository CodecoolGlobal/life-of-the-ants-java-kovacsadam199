package com.codecool.ants.geometry;

import java.util.Random;

public enum Direction {
        NORTH, EAST, SOUTH, WEST;

        public static Direction getRandomDirection(){
            Random random = new Random();
            int number = random.nextInt(4);
            Direction direction=Direction.NORTH;
            switch (number){
                case 0:
                    direction=Direction.NORTH;
                    break;
                case 1:
                    direction=Direction.SOUTH;
                    break;
                case 2:
                    direction=Direction.EAST;
                    break;
                case 3:
                    direction=Direction.WEST;
                    break;
            }
            return direction;
        }

    }
