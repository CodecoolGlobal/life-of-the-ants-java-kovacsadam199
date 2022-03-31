package com.codecool.ants;

import java.util.Scanner;

public class Simulator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AntColony antColony = new AntColony(9);
        antColony.display();
//        System.out.println("You can use `mvn package; java -jar target/ants-1.0.jar` to run this app from the console");
    }

}
