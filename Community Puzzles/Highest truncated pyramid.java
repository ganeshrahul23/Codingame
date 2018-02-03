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
        int MIN = (int)((-1+Math.sqrt(1+8*N))/2.0);
        for (int end = MIN; end <= 13; end++) {
            for (int j = 0; j <= end; j++) {
                int cnt = end*(end+1)/2 - j*(j+1)/2;
                if (cnt == N) {display(j,end); return;}
                else if (cnt < N) {break;}
            }
        }
    }
    
    public static void display(int start,int end) {
        for (int j = start+1; j <= end; j++) {
            for (int i = 0; i < j; i++) {System.out.print("*");}
            System.out.println();
        }
    }
}
