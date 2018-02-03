import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String line[] = new String[height];
        for (int i = 0; i < height; i++) {
            line[i] = in.nextLine(); // width characters, each either 0 or .
        }
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (line[i].charAt(j)=='0') {
                    System.out.print(j+" "+i+" ");
                    Player.printNeighbours(line,i,j);
                    System.out.println();
                }
            }
        }
    }

    public static void printNeighbours(String[] line, int y, int x) {
        boolean neighbour=false;
        for (int i = x+1; i < line[y].length(); i++) {
            if (line[y].charAt(i)=='0') {
                System.out.print(i+" "+y+" ");
                neighbour=true;
                break;
            }
        }
        if (!neighbour) {
            System.out.print("-1 -1 ");
        }
        else {
            neighbour=false;
        }
        for (int j = y+1; j < line.length; j++) {
            if (line[j].charAt(x)=='0') {
                System.out.print(x+" "+j+" ");
                neighbour=true;
                break;
            }
        }
        if (!neighbour) {
            System.out.print("-1 -1 ");
        }
        else {
            neighbour=false;
        }
    }
}
