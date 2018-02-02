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
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        String EXT[] = new String[N];
        String MT[] = new String[N];
        for (int i = 0; i < N; i++) {
            EXT[i] = in.next(); // file extension
            MT[i] = in.next(); // MIME type.
        }
        String FNAME[] = new String[Q];
        in.nextLine();
        for (int i = 0; i < Q; i++) {
            FNAME[i] = in.nextLine(); // One file name per line.
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        outer:
        for (int i = 0; i < Q; i++) {
            int index=FNAME[i].lastIndexOf('.');
            if (index>=0&&index<FNAME[i].length()) {
                String extension = FNAME[i].substring(index+1);
                inner:
                for (int j = 0; j < N; j++) {
                    if (EXT[j].equalsIgnoreCase(extension)) {
                        System.out.println(MT[j]);
                        continue outer;
                    }
                }
            }
            System.out.println("UNKNOWN");
        }

        // For each of the Q filenames, display on a line the corresponding MIME type. If there is no corresponding type, then display UNKNOWN.
        //System.out.println("UNKNOWN");
    }
}
