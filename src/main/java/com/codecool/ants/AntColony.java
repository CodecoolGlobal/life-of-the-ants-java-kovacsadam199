package com.codecool.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

import java.util.ArrayList;
import java.util.Arrays;

public class AntColony {
    private final String[][] map;
    private ArrayList<Ant> ants ;
    private final int width;
    private int[] queenPosition;

    public AntColony(int width) {
        this.width = width;
        map=new String[width][width];
        ants= new ArrayList<>();
        generateAnts(3, 3, 3, width);
    }

    public void update(int width, int[] queenPosition) {
        for(Ant ant: ants)
            ant.act(width);
    }

    public void display() {
        for (int i = 0; i < map.length ; i++) {
            for (int j = 0; j <map[0].length ; j++) {
                map[i][j]=".   ";
                int[] coordinates= {i,j};
                for (Ant ant:ants){
                    if (Arrays.equals(coordinates,ant.getPosition())){
                        map[i][j]=ant.getType();
                    }
                }
            }
        }
        for (int i = 0; i < map.length ; i++) {
            for (int j = 0; j < map[0].length ; j++) {
                System.out.print(map[i][j]);
            }
            System.out.print("\n");
        }
        System.out.println(" ");
    }

    public void generateAnts(int soldierCount, int droneCount, int workerCount, int width) {
        Queen queen = new Queen((width - 1) / 2, (width - 1) / 2);
        ants.add(queen);
        queenPosition=queen.getPosition();
        placeSoldiers(soldierCount, width, queen);
        placeWorkers(workerCount,width,queen);
        placeDrones(droneCount,width,queen);

    }

    private void placeSoldiers(int soldierCount, int width, Queen queen) {
        for (int i = 0; i < soldierCount; i++) {
            Position position = new Position(width, queen.getPosition());
            Soldier soldier = new Soldier(position);
            ants.add(soldier);
        }
    }
    private void placeWorkers(int workerCount, int width, Queen queen) {
        for (int i = 0; i < workerCount; i++) {
            Position position = new Position(width, queen.getPosition());
            Worker worker = new Worker(position);
            ants.add(worker);
        }
    }

    private void placeDrones(int droneCount, int width, Queen queen) {
        for (int i = 0; i < droneCount; i++) {
            Position position = new Position(width, queen.getPosition());
            Drone drone = new Drone(position);
            ants.add(drone);
        }
    }

    public ArrayList<Ant> getAnts() {
        return ants;
    }

    public int[] getQueenPosition() {
        return queenPosition;
    }
}