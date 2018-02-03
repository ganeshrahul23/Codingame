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
        int n = in.nextInt();
        String label[] = new String[n];
        for (int i = 0; i < n; i++) {
            label[i] = in.next();
        }
        for (int i = 0; i < n; i++) {
            index(label[i]);
            if (i!=n-1) {System.out.print(" ");}
        }
    }

    public static void index(String label) {
        try {
            long n = Long.parseLong(label)-1;
            String result="";
            do {
                result=(char)(n%26+65)+result;
                n = n/26-1;
            } while (n>=0);
            System.out.print(result);
        }
        catch (Exception e) {
            long n = 0;
            StringBuffer sb = new StringBuffer(label);
            sb.reverse();
            label=sb.toString();
            for (int i = 0; i < label.length(); i++) {
                long dig = (label.charAt(i)-64)*(long)(Math.pow(26,i));
                n += dig;
            }
            System.out.print(n);
        }
    }
}
