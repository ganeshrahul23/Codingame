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
        double chances = Math.ceil((-1.0+Math.sqrt(8*N+1))/2.0);

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println((int)chances);
    }
}
