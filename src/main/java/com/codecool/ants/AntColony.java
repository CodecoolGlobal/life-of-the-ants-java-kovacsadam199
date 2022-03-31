package com.codecool.ants;

import com.codecool.ants.geometry.Position;

public class AntColony {
    private final Ant[][] colony;
    private final int width;

    public AntColony(int width) {
        this.width = width;
        colony = new Ant[width][width];
        generateAnts(5, 5, 5, width);



    }

    public void update() {
        //ants act
    }

    public void display() {
        for (int i = 0; i < colony.length; i++) {
            for (int j = 0; j < colony[i].length; j++) {
                if(colony[i][j]== null){
                    System.out.print(".  ");


                    continue;

                }

                switch (colony[i][j].getType()){
                    case "Q":
                        System.out.print("Q  ");
                        break;
                    case "W":
                        System.out.print("W  ");
                        break;
                    case "D":
                        System.out.print("D  ");
                        break;
                    case "S":
                        System.out.print("S  ");
                        break;
                }

            }
            System.out.print("\n");

        }

        //shows map SDWQ
    }

    public void generateAnts(int soldierCount, int droneCount, int workerCount, int width) {
        Queen queen = new Queen((width - 1) / 2, (width - 1) / 2);
        colony[queen.getPosition()[0]][queen.getPosition()[1]]=queen;
        placeSoldiers(soldierCount, width, queen);
        placeWorkers(workerCount,width,queen);
        placeDrones(droneCount,width,queen);

    }

    private void placeSoldiers(int soldierCount, int width, Queen queen) {
        for (int i = 0; i < soldierCount; i++) {
            Position position = new Position(width, queen.getPosition());
            Soldier soldier = new Soldier(position);
            colony[soldier.getPosition()[0]][soldier.getPosition()[1]]=soldier;
        }
    }
    private void placeWorkers(int workerCount, int width, Queen queen) {
        for (int i = 0; i < workerCount; i++) {
            Position position = new Position(width, queen.getPosition());
            Worker worker = new Worker(position);
            colony[worker.getPosition()[0]][worker.getPosition()[1]] = worker;
        }
    }

    private void placeDrones(int droneCount, int width, Queen queen) {
        for (int i = 0; i < droneCount; i++) {
            Position position = new Position(width, queen.getPosition());
            Drone drone = new Drone(position);
            colony[drone.getPosition()[0]][drone.getPosition()[1]] = drone;
        }
    }
}