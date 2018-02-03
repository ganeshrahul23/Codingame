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
        in.nextLine();
        String tmp = in.nextLine();
        String res = tmp;
        res = res.replace(" ","");
        res = res.replace("0","");
        int one = res.length();
        if (one==0) {
            System.out.println("0"); return;
        }
        System.err.println("ones = "+one);
        Scanner k = new Scanner(tmp);
        int swaps = 0;
        int ones = 0;
        for (int i = 0; i < n; i++) {
            int x = k.nextInt();
            ones++;
            if (x!=1) {swaps++;}
            if (ones==one) {break;}
        }
        System.out.println(swaps);
    }
}
