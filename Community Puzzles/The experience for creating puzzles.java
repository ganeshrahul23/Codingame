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
        int level = in.nextInt();
        int xp = in.nextInt();
        xp = (int)(level*Math.sqrt(level)*10.0)-xp;
        int N = in.nextInt();
        int xpgain = N*300;
        xp += xpgain;
        int xpReqd = 0;
        while (true) {
            xpReqd = (int)(level*Math.sqrt(level)*10.0);
            if (xp>=xpReqd) {level++; xp-=xpReqd;}
            else {break;}
        }
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(level);
        System.out.println(xpReqd-xp);
    }
}
