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
        String[] telephone = new String[N];
        for (int i = 0; i < N; i++) {
            telephone[i] = in.next();
        }
        Arrays.sort(telephone);
        
        int digits = 0;
        for (int i = 1; i < N; i++) {
            digits += telephone[i-1].length() - getCommon(telephone[i-1],telephone[i]);
        }
        digits += telephone[N-1].length();

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");


        // The number of elements (referencing a number) stored in the structure.
        System.out.println(digits);
    }
    
    static int getCommon(String s1, String s2) {
        System.err.println("Common between: "+s1+","+s2);
        int limit = Math.min(s1.length(),s2.length());
        int i;
        for (i = 0; i < limit; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {continue;}
            break;
        }
        System.err.println("Common is = "+i);
        return i;
    }
}
