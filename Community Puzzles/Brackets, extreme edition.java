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
        String expression = in.next();
        Vector<Character> opens = new Vector<Character>();
        opens.add('#');
        for (int i = 0; i < expression.length(); i++) {
            char cnt = expression.charAt(i);
            if (cnt=='('||cnt=='{'||cnt=='[') opens.add(0,cnt);
            else if (cnt==')'||cnt=='}'||cnt==']'){
                char open = opens.elementAt(0);
                String brack = open+""+cnt;
                System.err.println(brack);
                if (!brack.equals("()")&&!brack.equals("{}")&&!brack.equals("[]")) {System.out.println("false");return;}
                opens.removeElementAt(0);
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(opens.size()==1);
    }
}
