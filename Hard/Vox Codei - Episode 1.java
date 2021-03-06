import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {
    
    static char map[][];
    static int count[][];
    static int max[];
    static Vector<Task> tasks;
    static int counter;
    static int nodes;
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // width of the firewall grid
        int height = in.nextInt(); // height of the firewall grid
        if (in.hasNextLine()) {
            in.nextLine();
        }
        map = new char[width][height];
        count = new int[width][height];
        max = new int[13];
        tasks = new Vector<Task>();
        for (int i = 0; i < height; i++) {
            String mapRow = in.nextLine(); // one line of the firewall grid
            System.err.println(mapRow);
            for (int j = 0; j < width; j++) {
                map[j][i] = mapRow.charAt(j);
                if (map[j][i]=='@') nodes++;
            }
        }
        
        //evaluate:
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (map[x][y]=='@') {
                    //up:
                    updateFork(x,y,0,-1,1);
                    //down:
                    updateFork(x,y,0,1,1);
                    //left:
                    updateFork(x,y,-1,0,1);
                    //right:
                    updateFork(x,y,1,0,1);
                }
            }
        }
        
        counter = 0;

        gameloop:
        while (true) {
            counter ++;
            int rounds = in.nextInt(); // number of rounds left before the end of the game
            int bombs = in.nextInt(); // number of bombs left
            int power = 0;
            for (int i = 12; i > 0; i--) {
                if (max[i]>0) {power = i; break;}
            }
            if (nodes==8&&power==4) {power=3;}
            try {
                while (tasks.elementAt(0).time==counter) {
                    Task t = tasks.elementAt(0);
                    //count[t.x][t.y]--; 
                    max[count[t.x][t.y]]++;
                    map[t.x][t.y]='.';
                    tasks.removeElementAt(0);
                    nodes--;
                }
            } catch (Exception e) {}
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    if (count[x][y]==power && map[x][y]=='.') {
                        tasks.add(new Task(counter+3,x,y));
                        placeBomb(x,y);
                        //update:
                        System.out.println(x+" "+y);          
                        continue gameloop;
                    }
                }
            }
            System.out.println("WAIT");
        }
    }
    
    public static void placeBomb(int x,int y) {
        //up:
        updateDirections(x,y,0,-1);
        //down:
        updateDirections(x,y,0,1);
        //left:
        updateDirections(x,y,-1,0);
        //right:
        updateDirections(x,y,1,0);
    }
    
    public static void updateDirections(int x,int y,int xsp,int ysp) {
        for (int i = 1; i <= 3; i++) {
            int xC = x+xsp*i;
            int yC = y+ysp*i;
            try {
                if (map[xC][yC]=='#') break;
                if (map[xC][yC]=='@') {
                    tasks.add(new Task(counter+3,xC,yC));
                    //up:
                    updateFork(xC,yC,0,-1,-1);
                    //down:
                    updateFork(xC,yC,0,1,-1);
                    //left:
                    updateFork(xC,yC,-1,0,-1);
                    //right:
                    updateFork(xC,yC,1,0,-1);
                }
            }
            catch (Exception e) {break;}
        }
    }
    
    public static void updateFork(int x,int y,int xsp,int ysp,int add) {
        for (int i = 1; i <= 3; i++) {
            int xC = x+xsp*i;
            int yC = y+ysp*i;
            try {
                if (map[xC][yC]=='#') break;
                max[count[xC][yC]]--;
                count[xC][yC]+=add; 
                max[count[xC][yC]]++;
            }
            catch (Exception e) {break;}
        }
    }
    
    public static class Task {
        int time, x, y;
        public Task(int T,int X,int Y) {
            time=T;
            x=X;
            y=Y;
        }
    }
}
