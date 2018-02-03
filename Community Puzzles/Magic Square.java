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
        int n = in.nextInt();
        int c[][] = new int[n][n];
        boolean[] used = new boolean[n*n];
        int reqd_sum = 0;
        for (int i = 0; i < n; i++) {
            reqd_sum = 0;
            for (int j = 0; j < n; j++) {
                int INT = in.nextInt();
                if (INT<=0) {System.out.println("MUGGLE"); return;}
                else if (INT>n*n) {System.out.println("MUGGLE"); return;}
                else if (used[INT-1]) {System.out.println("MUGGLE"); return;}
                c[j][i] = INT;
                reqd_sum += INT;
                used[INT-1] = true;
            }
        }
        int[] row = new int[n];
        int[] collumn = new int[n];
        int[] diagonal = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row[i] += c[j][i];
                collumn[j] += c[j][i];
                if (i==j) {diagonal[0]+=c[j][i];}
                if (i+j==n-1) {diagonal[1]+=c[j][i];}
            }
        }
        if (diagonal[0]!=reqd_sum || diagonal[1]!=reqd_sum) {System.out.println("MUGGLE"); return;}
        for (int i=0;i<n;i++) {
            if (collumn[i]!=reqd_sum || row[i]!=reqd_sum) {System.out.println("MUGGLE"); return;}
        }
        System.out.println("MAGIC");
    }
}
