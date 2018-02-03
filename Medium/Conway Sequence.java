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
        int R = in.nextInt();
        int L = in.nextInt();
        Vector<Integer> line=new Vector<Integer>();
        line.add(R);
        for (int i=1; i<L; i++) {
            Vector<Integer> next=new Vector<Integer>();
            int current=line.elementAt(0);
            int length=0;
            for (int j=0; j<line.size(); j++) {
                if (line.elementAt(j)==current) {length++;}
                else {
                    next.add(length);
                    next.add(current);
                    current=line.elementAt(j);
                    length=1;
                }
            }
            next.add(length);
            next.add(current);
            line=get(next);
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        String result="";
        for (int i=0; i<line.size(); i++) {
            result=result+" "+line.elementAt(i);
        }
        System.out.println(result.substring(1));
    }

    public static Vector<Integer> get(Vector<Integer> n2) {
        Vector<Integer> n1=new Vector<Integer>();
        for (int i=0; i<n2.size(); i++) {
            int k=new Integer(n2.elementAt(i));
            n1.add(k);
        }
        return n1;
    }
}
