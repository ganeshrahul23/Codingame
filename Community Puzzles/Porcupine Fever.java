import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        //System.out.println("ENTER:");
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int Y = in.nextInt();
        long total = 0;
        long S[] = new long[N];
        long H[] = new long[N];
        long A[] = new long[N];
        for (int i = 0; i < N; i++) {
            S[i] = in.nextInt();
            H[i] = in.nextInt();
            A[i] = in.nextInt();
            total += A[i];
        }
        for (int j = 0; j < Y; j++) {
            total = 0;
            for (int i = 0; i < N; i++) {
                A[i] -= S[i];
                S[i] *= 2;
                H[i] -= S[i];
                total += A[i]>0?A[i]:0;
            }
            System.out.println(total);
            if (total==0) return;
        }
    }
}
