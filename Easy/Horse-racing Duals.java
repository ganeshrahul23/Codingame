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
        int[] pi = new int[N];
        pi[0]=in.nextInt();
        int min=pi[0];
        for (int i = 1; i < N; i++) {
            pi[i] = in.nextInt();
        }
        Arrays.sort(pi);
        for (int i=1; i<N; i++) {
            min=Math.min(min,pi[i]-pi[i-1]);
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(min);
    }
}
