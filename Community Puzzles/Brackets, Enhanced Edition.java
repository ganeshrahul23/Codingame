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
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < N; i++) {
            String expression = in.nextLine();
            System.out.println(valid(expression));
        }
    }
    
    public static boolean valid(String expr) {
        ArrayList<Integer> brackets = new ArrayList<Integer>();
        for (int i = 0; i < expr.length(); i++) {
            int brc = getType(expr.charAt(i));
            if (brc == -1) continue;
            if (brackets.size() == 0 || brackets.get(0) != brc) {brackets.add(0,brc);}
            else if (brackets.get(0) == brc) {brackets.remove(0);}
        }
        return brackets.size() == 0;
    }
    
    static int getType(char cnt) {
        if (cnt == '(' || cnt == ')') return 0;
        if (cnt == '[' || cnt == ']') return 1;
        if (cnt == '{' || cnt == '}') return 2;
        if (cnt == '<' || cnt == '>') return 3;
        return -1;
    }
}
