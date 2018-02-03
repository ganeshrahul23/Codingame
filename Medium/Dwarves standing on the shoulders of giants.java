import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
public class Solution {
    static int[] max = new int[10000];
    static int[] X;
    static int[] Y;
    static int N;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        X = new int[N];
        Y = new int[N];
        for (int i = 0; i < N; i++) {
            X[i] = in.nextInt();
            Y[i] = in.nextInt();
        }
        perform();
    }
    
    public static void perform() {
        int length = 0;
        for (int i = 0; i < N; i++) {
            int cnt = X[i];
            determine(cnt);
            boolean precede = false;
            for (int j = 0; j < N; j++) {
                if (Y[i] == cnt) {
                    precede = true;
                    break;
                }
            }
            if (!precede) {length = Math.max(max[cnt],length);}
        }
        System.out.println(length);
    }
    
    public static void determine(int V) {
        int maximum = 0;
        if (max[V]!=0) {return;}
        for (int i = 0; i < N; i++) {
            if (X[i] == V) {
                determine(Y[i]);
                maximum = Math.max(maximum,max[Y[i]]);
            }
        }
        max[V]=maximum+1;
    }
}
