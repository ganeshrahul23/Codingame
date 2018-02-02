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
        int n = in.nextInt();
        int loss = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int v = in.nextInt();
            max = Math.max(max,v);
            loss = Math.min(loss,v-max);
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(loss);
    }
}
