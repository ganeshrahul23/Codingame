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
        int L = in.nextInt();
        int C = in.nextInt();
        int N = in.nextInt();
        int pi[] = new int[N];
        int visit[] = new int[N];
        long amount[] = new long[N];
        int rounds[] = new int[N];
        long total = 0;
        int completed = 1;
        int index = 0;
        for (int i = 0; i < N; i++) {
            pi[i] = in.nextInt();
        }
        while (completed<=C) {
            int sofar = 0;
            int visits = 0;
            if (visit[index]>=1) {
                long amt = total - amount[index];
                int rnds = completed - rounds[index];
                int rndsLeft = (C-completed)/rnds;
                total += amt*rndsLeft;
                completed += rndsLeft*rnds;
                visit = new int[N];
                System.err.println("End of cycle: "+(pi[index])+" index is: "+index);
                System.err.println("Length of the cycle is: "+rnds);
                System.err.println("Amount for cycle: "+amt);
            }
            visit[index]++;
            amount[index]=total;
            rounds[index]=completed;
            while (true) {
                if (visits==N) {break;}
                else if (sofar+pi[index] <= L) {
                    sofar += pi[index];
                    total += pi[index];
                    visits++;
                    index = (index+1)%N;
                }
                else {break;}
            }
            completed++;
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(total);
    }
}
