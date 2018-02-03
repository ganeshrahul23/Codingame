import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.Point;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    
    static int L, C;
    static boolean breaker = false;
    static String row[];
    static int DIR=0;
    static int pref=+1; 
    static int X, Y;
    static Vector<String> moves;
    static Point T[];
    static boolean visited[][];
    static boolean modified[][];
    static int direction[][];

    public static void main(String args[]) {
        //System.out.println("ENTER:");

        moves = new Vector<String>();

        T = new Point[2];

        Scanner in = new Scanner(System.in);
        L = in.nextInt();
        C = in.nextInt();

        if (in.hasNextLine()) {
            in.nextLine();
        }

        row = new String[L];
        X=0; Y=0;
        int teleportals=0;
        for (int i = 0; i < L; i++) {
            row[i] = in.nextLine();
            int pos = row[i].indexOf('@');
            if (pos != -1) {X=pos; Y=i;}
            pos = row[i].indexOf('T');
            if (pos != -1) {T[teleportals] = new Point(pos,i); teleportals++;}
        }
        
        visited = new boolean[C][L];
        direction = new int[C][L];
        modified = new boolean[C][L];
        
        maze();
    }
    
    public static void maze() {
        int nX = X;
        int nY = Y;
        
        switch (DIR) {
            case 0: nY++; break;
            case 1: nX++; break;
            case 2: nY--; break;
            case 3: nX--; break;
        }
        
        String DIRECTION = getDir();
        
        switch (row[nY].charAt(nX)) {
            case '@': 
                break;
            case '$': 
                moves.add(getDir());
                display();
                return;
            case '#': 
                move();
                maze(); 
                return;
            case 'X':
                if (breaker) {row[nY] = row[nY].substring(0,nX)+" "+row[nY].substring(nX+1); modify();}
                else {move(); maze(); return;}
                break;
            case 'S':
                DIR = 0;
                break;
            case 'E': 
                DIR = 1;
                break;
            case 'N': 
                DIR = 2;
                break;
            case 'W': 
                DIR = 3;
                break;
            case 'I':
                pref *= -1;
                break;
            case 'B': 
                breaker = !breaker;
                modify();
                break;
            case 'T': 
                if (nX == T[0].x && nY == T[0].y) {X = T[1].x; Y = T[1].y; moves.add(DIRECTION); maze(); return;}
                else {X = T[0].x; Y = T[0].y; moves.add(DIRECTION); maze(); return;}
            case ' ': 
                break;
        }
        
        X = nX;
        Y = nY;
        
        if (visited[X][Y]) {
            if (direction[X][Y]==DIR) {System.out.println("LOOP"); return;}
            direction[X][Y] = DIR;
        }
        
        visited[X][Y] = true;
        direction[X][Y] = DIR;
        
        moves.add(DIRECTION);
        
        maze();
    }
    
    public static void modify() {
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < L; j++) {
                visited[i][j] = false;
            }
        }
    }
    
    public static void display() {
        for (int i = 0; i < moves.size(); i++) {
            System.out.println(moves.elementAt(i));
        }
    }

    public static void move() {
        int newDir = (pref>0)?0:3;
        Game:
        while (true) {
            int nX = X;
            int nY = Y;
            switch (newDir%4) {
                case 0: nY++; break;
                case 1: nX++; break;
                case 2: nY--; break;
                case 3: nX--; break;
            }
            newDir += pref;
            switch (row[nY].charAt(nX)) {
                case '#': continue Game;
                case 'X': if (!breaker) continue Game;
            }
            break Game;
        }
        DIR = newDir-pref;
    }

    public static String getDir() {
        switch (DIR) {
            case 0: return "SOUTH";
            case 1: return "EAST";
            case 2: return "NORTH";
            case 3: return "WEST";
        }
        return "NONE";
    }
}
