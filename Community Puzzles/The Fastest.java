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
        int minTime = Integer.MAX_VALUE;
        String ans = "";
        for (int i = 0; i < N; i++) {
            String t = in.next();
            int hrs = Integer.valueOf(t.substring(0,2));
            int min = Integer.valueOf(t.substring(3,5));
            int sec = Integer.valueOf(t.substring(6,8));
            int time = hrs*3600+min*60+sec;
            if (time<minTime) {
                minTime = time;
                ans = t;
            }
        }
        
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(ans);
    }
}
