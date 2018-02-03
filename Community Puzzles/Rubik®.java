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
        int L = (N>=2)?N-2:0;

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(N*N*N-L*L*L);
    }
}
