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

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        //System.out.println("tries transformations penalties");
        divide5(N);
    }
    
    static void divide5(int N) {
        int tries = N / 5;
        for (int i = 0; i <= tries; i++) {
            divide2( N - i * 5, i);
        }
    }
    
    static void divide2(int N,int sofar) {
        int tries = Math.min(sofar , N/2);
        for (int i = 0; i <= tries; i++) {
            divide3( N - i * 2, sofar+" "+i+" ");
        }
    }
    
    static void divide3(int N,String sofar) {
        if (N%3 != 0) return;
        System.out.println(sofar+N/3);
    }
}
