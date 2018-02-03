import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    
    static int stones = 0;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int cnt[] = new int[1000];
        for (int i = 0; i < N; i++) {
            stones++;
            int level = in.nextInt();
            cnt[level]++;
            tryCopy(cnt,level);
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(stones);
    }
    
    public static void tryCopy(int[] cnt,int lvl) {
        if (cnt[lvl]==2) {
            stones--;
            cnt[lvl]=0;
            cnt[lvl+1]++;
            tryCopy(cnt,lvl+1);
        }
    }
}
