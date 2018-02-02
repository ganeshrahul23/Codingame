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
        int L = in.nextInt();
        int H = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String T = in.nextLine();
        T=T.toUpperCase();
        String[] ROW = new String[H];
        for (int i = 0; i < H; i++) {
            ROW[i] = in.nextLine()+" ";
        }
        int length = ROW[0].length()/27;
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < T.length(); j++) {
                char c = T.charAt(j);
                int index=0;
                if (c>=65&&c<=90) {
                    index=c-65;
                }
                else {
                    index=26;
                }
                System.out.print(ROW[i].substring(index*length,index*length+length));
            }
            System.out.println();
        }
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
    }
}
