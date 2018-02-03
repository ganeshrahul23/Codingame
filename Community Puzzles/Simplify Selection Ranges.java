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
        String N = in.nextLine();
        N = N.substring(1,N.length()-1);
        N = N.replace(","," ");
        Scanner n = new Scanner(N);
        Vector<Integer> num = new Vector<Integer>();
        while (n.hasNext()) {
            num.add(n.nextInt());
        }
        Collections.sort(num);
        String res = "";
        int start = num.elementAt(0);
        int old = num.elementAt(0);
        for (int i = 1; i < num.size(); i++) {
            int cnt=num.elementAt(i);
            if (cnt-1!=old) {
                if (start <= old-2) {res+=","+start+"-"+old;}
                else {
                    for (int j=start; j<=old; j++) {res+=","+j;}
                }
                start = cnt;
            }
            old = cnt;
        }
        if (start <= old-2) {res+=","+start+"-"+old;}
        else {
            for (int j=start; j<=old; j++) {res+=","+j;}
        }
        
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(res.substring(1));
    }
}
