import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int nbFloors = in.nextInt(); // number of floors
        int width = in.nextInt(); // width of the area
        int nbRounds = in.nextInt(); // maximum number of rounds
        int exitFloor = in.nextInt(); // floor on which the exit is found
        int exitPos = in.nextInt(); // position of the exit on its floor
        int nbTotalClones = in.nextInt(); // number of generated clones
        int nbAdditionalElevators = in.nextInt(); // ignore (always zero)
        int nbElevators = in.nextInt(); // number of elevators
        int elevatorFloor[] = new int[nbElevators+1];
        int elevatorPos[] = new int[nbElevators+1];
        for (int i = 0; i < nbElevators; i++) {
            elevatorFloor[i] = in.nextInt(); // floor on which this elevator is found
            elevatorPos[i] = in.nextInt(); // position of the elevator on its floor
        }
	   elevatorFloor[nbElevators] = exitFloor;

	   elevatorPos[nbElevators] = exitPos;

        // game loop
        outer:
        while (true) {
            int cloneFloor = in.nextInt(); // floor of the leading clone
            int clonePos = in.nextInt(); // position of the leading clone on its floor
            String direction = in.next(); // direction of the leading clone: LEFT or RIGHT

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            /*if (cloneFloor==exitFloor) { // Check if the clone is on Exit Floor
                int posDiff=clonePos-exitPos;
                    String reqd="";
                    if (posDiff < 0) {reqd="RIGHT"; }
                    else {reqd="LEFT";}
                    if (reqd.equals(direction)) {
                        System.out.println("WAIT");
                        continue outer;
                    }
                    else {
                        System.out.println("BLOCK");
                        continue outer;
                    }
            }*/
            
            inner:
            for (int i=0 ;i < nbElevators+1; i++) {
                if (elevatorFloor[i]==cloneFloor) {
                    int posDiff=clonePos-elevatorPos[i];
                    String reqd="";
                    if (posDiff < 0) {reqd="RIGHT"; }
                    else if (posDiff > 0) {reqd="LEFT";}
                    else {
                        System.out.println("WAIT");
                        continue outer;
                    }
                    if (reqd.equals(direction)) {
                        System.out.println("WAIT"); //WAIT and let the leader pass
                        continue outer;
                    }
                    else {
                        System.out.println("BLOCK"); // BLOCK the leader
                        continue outer;
                    }
                }
            }
            
            System.out.println("WAIT"); // action: WAIT or BLOCK
        }
    }
}
