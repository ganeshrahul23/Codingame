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
        int a = in.nextInt();
        int b = in.nextInt();
        int k = in.nextInt();
        int m = in.nextInt();
        
        boolean found = false;
        Queue<Integer> tasks = new LinkedList<Integer>();
		HashMap<Integer, Integer> steps = new HashMap<>();
		tasks.add(k);
		steps.put(k, 0);
		while (tasks.size() > 0) {
			int next = tasks.poll();
			if (next == m) {
			    found = true;
			    break;
			}
			if (next + a <= n && !steps.containsKey(next + a)) {
				tasks.add(next + a);
				steps.put(next + a, steps.get(next) + 1);
			}
			if (next - b > 0 && !steps.containsKey(next - b)) {
				tasks.add(next - b);
				steps.put(next - b, steps.get(next) + 1);
			}
		}
		
		// Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(found ? steps.get(m) : "IMPOSSIBLE");
    }
}
