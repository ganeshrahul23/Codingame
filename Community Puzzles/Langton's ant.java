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
        int W = in.nextInt();
        int H = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        char direction = in.next().charAt(0);
        
        int T = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        
        int dir=0;
        switch (direction) { //converting direction to integer
            case 'N': dir=1+4*T; break;
            case 'E': dir=2+4*T; break;
            case 'S': dir=3+4*T; break;
            case 'W': dir=4+4*T; break;
        }
        
        String C[] = new String[H];
        for (int i = 0; i < H; i++) {
            C[i] = in.nextLine();
        }
        
        for (int i = 0; i < T; i++) {
            char add=' '; //the character to be changed
            if (C[y].charAt(x)=='.') {
                add='#';
                dir--; //anticlockwise
            }
            else {
                add='.';
                dir++; //clockwise
            }
            
            C[y]=C[y].substring(0,x)+add+C[y].substring(x+1); //upadting the expression
                
            switch (dir%4) { //updating the coordinates
                case 0: x--; break; 
                case 1: y--; break;
                case 2: x++; break;
                case 3: y++; break;
            }
        }

        for (int i = 0; i < H; i++) {
            System.out.println(C[i]);
        }
    }
}
