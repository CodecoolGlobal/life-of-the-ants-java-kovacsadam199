package com.codecool.ants;

import java.util.Scanner;

public class Simulator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AntColony antColony = new AntColony(9);
        antColony.display();
        String enter=" ";
        boolean run=true;
        System.out.println("Press enter to continue");
        while (run){
            enter=input.nextLine();
            if (enter.equals("quit") || enter.equals("q")){
                run=false;
                System.out.println("The program exits");
                continue;}
            antColony.update(9, antColony.getQueenPosition());
            antColony.display();
            System.out.println("Press enter to continue");
        }

//        System.out.println("You can use `mvn package; java -jar target/ants-1.0.jar` to run this app from the console");
    }

}
