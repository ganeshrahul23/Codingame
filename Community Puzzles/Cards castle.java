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
        int H = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String[] S = new String[H];
        for (int i = 0; i < H; i++) {
            S[i] = in.nextLine();
            if (!valid(S[i])){System.out.println("UNSTABLE");return;}
            if (i==0) continue;
            if (!valid(S[i-1],S[i])){System.out.println("UNSTABLE");return;}
        }
        System.out.println("STABLE");
    }
    
    public static boolean valid(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '/') {
                if (i == str.length()-1) return false;
                if (!(str.charAt(i+1) == '\\')) return false;
                i++;
            } else if (str.charAt(i) == '\\') {return false;}
        }
        return true;
    }
    
    public static boolean valid(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != '.' && (str1.charAt(i) == str2.charAt(i) || str2.charAt(i) == '.')) return false;
        }
        return true;
    }
}
