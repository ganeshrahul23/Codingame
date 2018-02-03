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
        String cnt = "*";
        System.out.print(".");
        for (int i = 1; i <= N; i++) {
            for (int j = N*2; j > i+1; j--) {System.out.print(' ');}
            if (i!=1) {System.out.print(" ");}
            System.out.print(cnt);
            cnt+="**";
            System.out.println();
        }
        cnt="*";
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N-i; j++) {System.out.print(' ');}
            System.out.print(cnt);
            for (int j = 1; j <= N*2-cnt.length(); j++) {System.out.print(' ');}
            System.out.print(cnt);
            cnt+="**";
            System.out.println();
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        //System.out.println("answer");
    }
}
