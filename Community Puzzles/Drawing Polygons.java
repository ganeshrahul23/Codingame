import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Point p[] = new Point[N];
        double avgX = 0.0, avgY = 0.0;
        for (int i = 0; i < N; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            avgX += x;
            avgY += y;
            p[i] = new Point(x,y);
        }
        avgX /= (double)N;
        avgY /= (double)N;
        String s = "CLOCKWISE";
        System.err.println("Centre at: "+avgX+" "+avgY);
        for (int i = 0; i < N; i++) {
            System.err.println("Check Set:");
            int x1 = p[i].x;
            int y1 = p[i].y;
            System.err.println(x1+" "+y1);
            int x2 = p[(i+1)%N].x;
            int y2 = p[(i+1)%N].y;
            System.err.println(x2+" "+y2);
            double firstCentre = Math.toDegrees(Math.atan2((x1-avgX),(y1-avgY)));
            double secondCentre = Math.toDegrees(Math.atan2((x2-avgX),(y2-avgY)));
            double difference = secondCentre-firstCentre;
            if (difference>0) {s="CLOCKWISE";}
            if (difference<0) {s="COUNTERCLOCKWISE";}
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(s);
    }
}
