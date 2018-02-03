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
        String input = in.nextLine();
        Vector<Integer> digits = new Vector<Integer>();
        boolean negative = false;
        boolean decimal = false;
        Scanner cnt = new Scanner(input);
        for (int i = 0; i < N; i++) {
            char ch = cnt.next().charAt(0);
            if (ch=='-') negative=true;
            else if (ch=='.') decimal=true;
            else digits.add(ch-48);
        }
        cnt.close();
        Collections.sort(digits);
        String ans = "";
        if (negative) {
            ans = findSmall(digits);
            if (decimal) ans = ans.substring(0,1)+"."+ans.substring(1);
            ans = "-"+ans;
        }
        else {
            ans = findBig(digits);
            if (decimal) ans = ans.substring(0,digits.size()-1)+"."+ans.substring(digits.size()-1);
        }
        if (decimal) {
            String after = "";
            boolean zeros = true;
            for (int i = ans.indexOf('.')+1; i < ans.length(); i++) {
                if (ans.charAt(i)!='0') {zeros = false; break;}
            }
            if (zeros) ans=ans.substring(0,ans.indexOf('.'));
        }
        if (ans.equals("-0")) ans="0";
        
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(ans);
    }
    
    static String findSmall(Vector<Integer> d) {
        String ans = "";
        for (int i = 0; i < d.size(); i++) {ans+=""+d.elementAt(i);}
        return ans;
    }
    
    static String findBig(Vector<Integer> d) {
        String ans = "";
        for (int i = d.size()-1; i >= 0; i--) {ans+=""+d.elementAt(i);}
        return ans;
    }
}
