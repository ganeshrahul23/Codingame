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
        int n = in.nextInt(); // the number of temperatures to analyse
        if (n==0) {System.out.println(0); return;}
        int min=5526;
        for (int i=0; i<n; i++) {
            int cnt=in.nextInt();
            min=(Math.abs(cnt)<Math.abs(min))?cnt:((Math.abs(cnt)==Math.abs(min)&&cnt>0)?Math.abs(min):min);
        }
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(min);
    }
}
