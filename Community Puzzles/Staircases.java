import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static long[][] combos;
    static long checks;

    public static void main(String args[]) {
        //System.out.println("ENTER:");
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        combos = new long[N][N];
        System.out.println(stairs(0,N));
        System.err.println(checks);
    }

    public static long stairs(int sofar,int left) {
        if (left < combos[0].length && combos[sofar][left] > 0) {return combos[sofar][left];}
        checks++;
        long soln = (sofar!=0)?1:0;
        int min = sofar+1;
        int max = (left-1)/2;
        if (min==max) return soln+1;
        for (int i = min; i <= max; i++) {soln += stairs(i,left-i);}
        try {combos[sofar][left] = soln;} 
        catch(Exception e) {}
        return soln;
    }
}
