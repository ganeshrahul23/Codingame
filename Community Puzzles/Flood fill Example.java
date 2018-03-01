import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.awt.Point;

class Solution {
    static int W, H;
    static int[][] voronoi;
    static char[][] owner;
    static boolean[][] grid;

    static class Entity extends Point{
        char id;
        int area = 0;
        Entity(int x,int y,char cnt) {
            super(x,y);
            id = cnt;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        W = in.nextInt();
        H = in.nextInt();
        
        grid = new boolean[W][H];
        voronoi = new int[W][H];
        owner = new char[W][H];
        ArrayList<Entity> entities = new ArrayList<Entity>();
        
        in.nextLine();
        
        for (int y = 0; y < H; y++) {
            String line = in.nextLine();
            for (int x = 0; x < W; x++) {
                if (line.charAt(x) != '#') {grid[x][y] = true;}
                if (line.charAt(x) != '.' && line.charAt(x) != '#') {entities.add(new Entity(x,y,line.charAt(x)));}
            }
        }
        
        initBoard();
        for (int i = 0; i < entities.size(); i++) {BFS(entities.get(i));}
        
        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                if (!grid[x][y]) System.out.print("#");
                else System.out.print(owner[x][y]);
            }
            System.out.println();
        }
    }

    static void initBoard() {
        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                voronoi[x][y] = W+H+1;
                owner[x][y] = '.';
            }
        }
    }

    static void BFS(Entity cnt) {
        ArrayList<Point> then = new ArrayList<Point>();
        
        boolean visited[][] = new boolean[W][H];
        
        int[] dx = {0,0,-1,+1};
        int[] dy = {-1,+1,0,0};
        
        int time = 0;
        
        then.add(cnt);
        visited[cnt.x][cnt.y] = true;
        
        while (then.size() > 0) {
            ArrayList<Point> next = new ArrayList<Point>();
        
            while (then.size() > 0) {
                Point now = then.get(0);
            
                if (voronoi[now.x][now.y] == time) {
                    owner[now.x][now.y] = '+';
                } else {
                    voronoi[now.x][now.y] = time;
                    owner[now.x][now.y] = cnt.id;
                }
                
                for (int i = 0; i < 4; i++) {
                    int x = now.x + dx[i];
                    int y = now.y + dy[i];
                    if (x == -1 || x == W || y == -1 || y == H || visited[x][y] || voronoi[x][y] < time+1 || !grid[x][y]) {continue;}
                    next.add(new Point(x,y));
                    visited[x][y] = true;
                }
                
                then.remove(0);
            }
            
            time++;
            then.addAll(next);
        }
    }
}
