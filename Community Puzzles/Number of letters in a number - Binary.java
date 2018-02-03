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
        long start = in.nextLong();
        long n = in.nextLong();
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            String binRep = Long.toBinaryString(start);
            String nxt = binRep.replace("1","");
            long next = nxt.length()*4 + (binRep.length()-nxt.length())*3;
            if (start == next) {System.out.println(start);return;}
            start = next;
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(start);
    }
    
}
