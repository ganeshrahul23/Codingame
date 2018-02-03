import java.util.*;
import java.awt.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    
    static boolean[][] maze;
    static boolean[][] checked;
    static boolean[][] exit;
    static ArrayList<Point> discover;
    
    public static void main(String args[]) {
        //System.out.println("ENTER:");
        Scanner in = new Scanner(System.in);
        int W = in.nextInt();
        int H = in.nextInt();
        int X = in.nextInt();
        int Y = in.nextInt();
        in.nextLine();
        
        maze = new boolean[W][H];
        checked = new boolean[W][H];
        exit = new boolean[W][H];
        for (int i = 0; i < H; i++) {
            String R = in.nextLine();
            for (int j = 0; j < W; j++) {
                maze[j][i] = R.charAt(j)=='.';
            }
        }
        
        discover = new ArrayList<Point>();
        ArrayList<Point> exits = new ArrayList<Point>();
        discover.add(new Point(X,Y));
        
        while (discover.size()>0) {
            Point p = discover.get(0);
            int x = p.x;
            int y = p.y;
            if ((x==0 || x==W-1 || y==0 || y==H-1) && !checked[x][y]) {
                exits.add(p);
                exit[x][y] = true;
            }
            checked[x][y] = true;
            check(x,y-1);
            check(x,y+1);
            check(x-1,y);
            check(x+1,y);
            discover.remove(0);
        }
        
        System.out.println(exits.size());
        /*for (int i = 0; i < exits.size(); i++) {
            Point p = exits.get(i);
            System.out.println(p.x+" "+p.y);
        }*/
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                if (exit[i][j]) {System.out.println(i+" "+j);}
            }
        }
    }
    
    public static void check(int x,int y) {
        try {
            if (maze[x][y] && !checked[x][y]) {discover.add(new Point(x,y));}
        } catch (Exception e) {}
    }
    
}
