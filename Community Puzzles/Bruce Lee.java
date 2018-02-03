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
        String soFar = "";
        while (in.hasNext()) {
            try {
                String type = in.next();
                int num = in.next().length();
                int bin = type.equals("0") ? 1 : 0;
                if (type.equals("000")) {System.out.println("INVALID"); return;}
                for (int i = 0; i < num; i++) {soFar += ""+bin;}
            }
            catch (Exception e) {System.out.println("INVALID"); return;}
        }
        if (soFar.length() % 7 != 0) {System.out.println("INVALID"); return;}
        String result = "";
        while (soFar.length() > 0) {
            String current = soFar.substring(0,7);
            soFar = soFar.substring(7);
            System.err.println("0"+current);
            char cnt = (char)Integer.parseInt("0"+current,2);
            result += cnt;
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(result);
    }
}
