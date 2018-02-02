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
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();

        // game loop
        int UXL=0;
        int LXL=W-1;
        int UYL=0;
        int LYL=H-1;
        while (true) {
            String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)
            if (bombDir.indexOf('R')!=-1) { UXL=X0+1; }
            else if (bombDir.indexOf('L')!=-1) { LXL=X0; }
            if (bombDir.indexOf('U')!=-1) { LYL=Y0; }
            else if (bombDir.indexOf('D')!=-1) { UYL=Y0+1; }
            X0=(UXL+LXL)/2;
            Y0=(UYL+LYL)/2;
            System.out.println(X0+" "+Y0);
        }
    }
}
