import java.util.*;
import java.math.*;
import java.io.*;
import java.awt.*;
public class Solution { // Plight Of The Fellowship
    public static void main(String args[]) { // main method
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // the number of spots
        int M = sc.nextInt(); // the number of orcs
        int L = sc.nextInt(); // the number of portals
        Point spots[] = new Point[N]; // coordinates of the spots
        Point orcs[] = new Point[M]; // coordinates of the orcs
        boolean portal[][] = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt(); // the x-coordinate of the spot
            int y = sc.nextInt(); // the y-coordinate of the spot
            spots[i] = new Point(x,y);
        }
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt(); // the x-coordinate of the orcs
            int y = sc.nextInt(); // the y-coordinate of the orcs
            orcs[i] = new Point(x,y);
        }
        for (int i = 0; i < L; i++) {
            int N1 = sc.nextInt(); // the first node
            int N2 = sc.nextInt(); // the second node
            portal[N1][N2]=portal[N2][N1]=true;    
        }
        int S = sc.nextInt(); // the starting spot
        int E = sc.nextInt(); // the ending spot
        
        int time=0; // time taken
        Vector<Integer> oldPositions = new Vector<Integer>(); // list of positions being checked 
        Vector<Integer> newPositions = new Vector<Integer>(); // list of positions to be checked
        oldPositions.add(S); // first position to be checked is the starting point
        boolean checked[] = new boolean[N]; // list of checked positions
        Vector<Path> paths = new Vector<Path>(); // list of paths
        paths.add(new Path(S)); // all paths start at given spot
        
        route:
        for (int i = 0; i < N; i++) {
            time++;
            for (int j = 0; j < oldPositions.size(); j++) {
                int current = oldPositions.elementAt(j); // the current spot
                for (int k = 0; k < N; k++) {
                    if (portal[current][k]&&!checked[k]) { // if the spots have a valid portal
                        if (valid(spots[k],orcs,time)) { // if the movement is possible without getting caught by orcs
                            paths.add(new Path(paths.elementAt(0).path)); // adding a new path
                            paths.elementAt(paths.size()-1).add(k); // adding a new point to the path
                            if (k==E) {paths.elementAt(paths.size()-1).printPath() ;return;} // if the spot is the end point
                            else {newPositions.add(k);} // updating positions to be checked
                        }
                    }
                }
                checked[current] = true; // updating checked spots
                paths.removeElementAt(0); // removing the path leading to this point
            }
            oldPositions.removeAllElements();
            for (; 0 < newPositions.size();) { // refreshing the set of to-be-checked positions
                oldPositions.add(newPositions.elementAt(0));
                newPositions.removeElementAt(0);
            }
        }
        System.out.println("IMPOSSIBLE");
    }
    
    public static boolean valid(Point index, Point[] places, int time) { // method to check whether the move is possible
        for (int i = 0; i < places.length; i++) {
            double dist = Math.sqrt(Math.pow((index.x-places[i].x),2)+Math.pow((index.y-places[i].y),2)); //distance of the orc from the spot
            if (dist<=(double)(time)) {return false;} // if orc will reach the spot in time
        }
        return true;
    }
    
    public static class Path { // class holding a path of spots
        Vector<Integer> path = new Vector<Integer>(); // list of covered spots
        public Path(Vector<Integer> old) {
            for (int i = 0; i < old.size(); i++) {
                path.add(old.elementAt(i)); // add a new position
            }
        }
        public Path(int New) {
            path.add(New); // add a new position
        }
        public void add(int New) {
            path.add(New); // add a new position
        }
        public int size() {
            return path.size(); // return path length
        }
        public void printPath() {
            String PATH = "";
            for (int i = 0; i < path.size(); i++) {
                PATH+=" "+path.elementAt(i); // display the set of spots
            }
            System.out.println(PATH.substring(1));
        }
        public void add(Vector<Integer> old) {
            for (int i = 0; i < old.size(); i++) {
                path.add(old.elementAt(i)); // add a new position
            }
        }
    }
}
