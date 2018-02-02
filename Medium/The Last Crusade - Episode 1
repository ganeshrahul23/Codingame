import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // number of columns.
        int H = in.nextInt(); // number of rows.
        if (in.hasNextLine()) {
            in.nextLine();
        }
        
        int LINE[][] = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                try {LINE[i][j] = in.nextInt();} // represents a line in the grid and contains W integers. Each integer represents one room of a given type.
                catch (Exception e) {}
            }
        }
        int EX = in.nextInt(); // the coordinate along the X axis of the exit (not useful for this first mission, but must be read).

        // game loop
        while (true) {
            int XI = in.nextInt();
            int YI = in.nextInt();
            String POS = in.next();
            char DIR = getDir(POS,LINE[YI][XI]);
                
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            switch (DIR) {
                case 'D': YI++; break;
                case 'L': XI--; break;
                case 'R': XI++; break;
            }

            // One line containing the X Y coordinates of the room in which you believe Indy will be on the next turn.
            System.out.println(XI+" "+YI);
        }
    }
    
    public static char getDir(String POS, int CNT) {
        switch (CNT) {
            case 0: return 'N'; 
            case 1: return 'D';
            case 2: if (POS.equals("LEFT")) return 'R';
                    else return 'L';
            case 3: return 'D';
            case 4: if (POS.equals("TOP")) return 'L';
                    else return 'D';
            case 5: if (POS.equals("TOP")) return 'R';
                    else return 'D';
            case 6: if (POS.equals("LEFT")) return 'R';
                    else return 'L';
            case 7: return 'D';
            case 8: return 'D';
            case 9: return 'D';
            case 10: return 'L';
            case 11: return 'R';
            case 12: return 'D';
            case 13: return 'D';
        }
        return 'N';
    }
}
