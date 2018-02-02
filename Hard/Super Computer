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
        int[] F = new int[N];
        int[] getStart = new int[1001000];
        int max = 1;
        for (int i = 0; i < N; i++) {
            int J = in.nextInt();
            int D = in.nextInt();
            F[i] = J+D-1;
            getStart[F[i]] = Math.max(getStart[F[i]],J);
        }
        Arrays.sort(F);
        int index = 0;
        for (int i = 0; i < N; i++) {
            System.err.println(getStart[F[i]]);
            if (getStart[F[i]] > F[index]) {
                max++;
                index=i;
            }
        }
        System.out.println(max);
    }    
}
