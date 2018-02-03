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
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String B = in.nextLine();
        int empty = 0;
        int maxDist = 0;
        for (int i = 0; i < N; i++) {
            if (B.charAt(i)=='U') {
                int lower = (B.substring(0,i).lastIndexOf('!'));
                int upper = (B.substring(i).indexOf('!'))+i;
                System.err.println("For "+i+", lower = "+lower+" and upper = "+upper);
                int distance = Math.min(i-lower,upper-i);
                if (upper==i-1) distance = i-lower;
                else if (lower==-1) distance = upper-i;
                System.err.println("distance = "+distance);
                if (maxDist<distance) {
                    maxDist = distance;
                    empty = i;
                }
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(empty);
    }
}
