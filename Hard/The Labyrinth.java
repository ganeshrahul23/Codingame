import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.Point;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    int R;
    int C;
    int A;
    char map[][];
    boolean[][] checked;
    boolean found = false;
    boolean ticking = false;
    
    public static void main(String args[]) {
        Player game = new Player();
        game.play();
    }
    
    void play() {
        Scanner in = new Scanner(System.in);
        R = in.nextInt();
        C = in.nextInt();
        A = in.nextInt();
        map = new char[C][R];
        while (true) {
            int KY = in.nextInt();
            int KX = in.nextInt();
            in.nextLine();
            Point kirk = new Point(KX,KY);
            for (int i = 0; i < R; i++) {
                String line = in.nextLine();
                System.err.println(line);
                for (int j = 0; j < C; j++) {
                    map[j][i] = line.charAt(j);
                    if (line.charAt(j)=='C') {found = true;}
                }
            }
            if (map[KX][KY]=='C') {ticking = true;}
            if (ticking) {System.out.println(computeMove(kirk,'T'));}
            else if (found) {
                String move = computeMove(kirk,'C');
                System.err.println("FINAL MOVE = "+move);
                if (move.equals("FART")) {
                    System.err.println("Move is FART!");
                    System.out.println(computeMove(kirk,'?'));
                }
                else {System.out.println(move);}
            }
            else {System.out.println(computeMove(kirk,'?'));}
        }
    }
    
    ArrayList<Move> getMoves(Point test) {
        ArrayList<Move> points = new ArrayList<Move>();
        if (map[test.x][test.y]!='?') {
            if (map[test.x][test.y-1]!='#' && !checked[test.x][test.y-1]) {points.add(new Move("UP",test.x,test.y-1,1));}
            if (map[test.x-1][test.y]!='#' && !checked[test.x-1][test.y]) {points.add(new Move("LEFT",test.x-1,test.y,1));}
            if (map[test.x][test.y+1]!='#' && !checked[test.x][test.y+1]) {points.add(new Move("DOWN",test.x,test.y+1,1));}
            if (map[test.x+1][test.y]!='#' && !checked[test.x+1][test.y]) {points.add(new Move("RIGHT",test.x+1,test.y,1));}
        }
        return points;
    }
    
    ArrayList<Move> getMoves(Move MOVE) {
        Point test = new Point(MOVE.x,MOVE.y);
        String move = MOVE.move;
        int dist = MOVE.distance;
        ArrayList<Move> points = new ArrayList<Move>();
        if (map[test.x][test.y]!='?') {
            if (map[test.x][test.y-1]!='#' && !checked[test.x][test.y-1]) {points.add(new Move(move,test.x,test.y-1,dist+1));}
            if (map[test.x-1][test.y]!='#' && !checked[test.x-1][test.y]) {points.add(new Move(move,test.x-1,test.y,dist+1));}
            if (map[test.x][test.y+1]!='#' && !checked[test.x][test.y+1]) {points.add(new Move(move,test.x,test.y+1,dist+1));}
            if (map[test.x+1][test.y]!='#' && !checked[test.x+1][test.y]) {points.add(new Move(move,test.x+1,test.y,dist+1));}
        }
        return points;
    }
     
    String computeMove(Point start,char check) {
        checked = new boolean[C][R];
        String bestDistance = "FART";
        ArrayList<Move> search = new ArrayList<Move>();
        search.addAll(getMoves(start));
        while (search.size()>0) {
            Move cnt = search.get(0);
            if (checked[cnt.x][cnt.y]) {search.remove(0); continue;}
            checked[cnt.x][cnt.y] = true;
            //System.err.print("Set "+cnt.x+","+cnt.y+" as checked! ");
            //System.err.println("Searching for: "+check+" at "+cnt.x+","+cnt.y+", which is: "+map[cnt.x][cnt.y]);
            if (map[cnt.x][cnt.y]==check) {
                return cnt.move;
            }
            search.addAll(getMoves(cnt));
            search.remove(0);
        }
        return bestDistance;
    }

    class Move extends Point {
        String move = "";
        int distance = 0;
        Move(String move,int x,int y,int distance) {
            super(x,y);
            this.move = move;
            this.distance = distance;
        }
        Move(String move,Point p,int distance) {
            super(p.x,p.y);
            this.move = move;
            this.distance = distance;
        }
    }
}
