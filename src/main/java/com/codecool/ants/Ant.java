package com.codecool.ants;

import com.codecool.ants.geometry.Direction;

public abstract class Ant {
    abstract void act(int width);
    abstract String getType();
    abstract int[] getPosition();
}
