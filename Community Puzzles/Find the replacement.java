import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    static Vector<String> transform = new Vector<String>();
    static Map<Character,Character> used = new HashMap<Character,Character>();
    public static void main(String args[]) {
        //System.out.println("ENTER:");
        Scanner in = new Scanner(System.in);
        String X = in.nextLine();
        String Y = in.nextLine();
        if (X.equals(Y)) System.out.println("NONE");
        else {
            for (int i = 0; i < X.length(); i++) {
                char c1 = X.charAt(i);
                char c2 = Y.charAt(i);
                if (used.containsKey(c1)) {
                    if (used.get(c1)!=c2) {
                        System.out.println("CAN'T");
                        return;
                    }
                }
                else {
                    used.put(c1,c2);
                    if (c1!=c2) {transform.add(c1+"->"+c2);}
                }
            }
            for (int i = 0; i < transform.size(); i++) {System.out.println(transform.elementAt(i));}
        }
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        //System.out.println("anwser");
    }
}
