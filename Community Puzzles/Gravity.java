import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt();
        int height = in.nextInt();
        String line[] = new String[height];
        String fallen[] = new String[height];
        for (int i = 0; i < height; i++) {
            line[i] = in.next();
            fallen[i] = "";
        }
        for (int i = 0; i < width; i++) {
            int boxes = 0;
            for (int j = 0; j < height; j++) {boxes += (line[j].charAt(i)=='#')?1:0;}
            for (int j = height-boxes; j < height; j++) fallen[j]+="#";
            for (int j = 0; j < height-boxes; j++) fallen[j]+=".";
        }
        for (int i = 0; i < height; i++) {
            System.out.println(fallen[i]);
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        //System.out.println("answer");
    }
}
