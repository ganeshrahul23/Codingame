import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    
    static boolean empty[][];
    static int W, H;
    static int w, h;
    static int max = 0;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        W = in.nextInt();
        H = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        empty = new boolean[W][H];
        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine();
            for (int j = 0; j < W; j++) {
                empty[j][i] = ROW.charAt(j)=='.';
            }
        }
        w = 2;
        h = 2;
        for (int y = 0; y <= H - h; y++) {
            for (int x = 0; x <= W - w; x++) {
                if (place(x,y)) {
                    System.err.println("Found tile at "+x+","+y);
                    max = Math.max(max,filled(x,y));
                }
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(max);
    }
    
    public static boolean place(int x,int y) {
        for (int i = x; i < x+w; i++) {
            for (int j = y; j < y+h; j++) {
                if (!empty[i][j]) return false;
            }
        }
        return true;
    }
    
    public static int filled(int x,int y) {
        int filled = 0;
        row:
        for (int i = y; i < y+h; i++) {
            for (int j = 0; j < W; j++) {
                if ((j<x || j>=x+w) && empty[j][i]) continue row;
            }
            System.err.println("Filled row: "+i);
            filled++;
        }
        collumn:
        for (int i = x; i < x+w; i++) {
            for (int j = 0; j < H; j++) {
                if ((j<y || j>=y+h) && empty[i][j]) continue collumn;
            }
            System.err.println("Filled collumn: "+i);
            filled++;
        }
        return filled;
    }
}
