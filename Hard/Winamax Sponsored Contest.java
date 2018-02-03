import java.util.*;

public class Solution {
    int width, height;
    char[][] grid;
    ArrayList<Ball> balls = new ArrayList<Ball>();
    int current = 0;
    
    public static void main(String[] args) {
        Solution sln = new Solution();
        sln.input();
    }
    
    void input() {
        //System.out.println("ENTER:");
        Scanner in = new Scanner(System.in);
        
        width = in.nextInt();
        height = in.nextInt();
        in.nextLine();
        
        grid = new char[width][height];
        char[][] soln = new char[width][height];
        
        for (int i = 0; i < height; i++) {
            String row = in.nextLine();
            for (int j = 0; j < width; j++) {
                char cnt = row.charAt(j);
                grid[j][i] = cnt;
                soln[j][i] = '.';
                if (cnt>='1' && cnt <='9') {balls.add(new Ball(j,i,cnt-48));}
            }
        }
        
        find(soln,balls.get(current),0);
    }
    
    char[][] clone(char[][] soln) {
        char temp[][] = new char[width][height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {temp[j][i] = soln[j][i];}
        }
        return temp;
    }
    
    void find(char[][] soln, Ball cnt,int current) {
        if (cnt.left==0) {
            System.err.println("Ball's moves are over. It reached "+cnt.x+","+cnt.y+". On the grid, it is = "+grid[cnt.x][cnt.y]);
            current++;
            if (grid[cnt.x][cnt.y]=='H') {
                if (current>=balls.size()) {displayAnswer(soln); return;}
                find(soln,balls.get(current),current);
            }
            return;
        }
        System.err.println("Currently at: "+cnt.x+","+cnt.y+". Shots left: "+cnt.left);
        System.err.println("Simulating ball "+current+" of "+balls.size());
        
        char[][] temp;
        
        Ball copy = new Ball(cnt.x,cnt.y,cnt.left);
        temp = clone(soln);
        //temp = soln.clone();
        if (possible(temp,copy,0,-1,'^')) {find(temp,copy,current);}
        copy = new Ball(cnt.x,cnt.y,cnt.left);
        temp = clone(soln);
        //temp = soln.clone();
        if (possible(temp,copy,0,+1,'v')) {find(temp,copy,current);}
        copy = new Ball(cnt.x,cnt.y,cnt.left);
        temp = clone(soln);
        //temp = soln.clone();
        if (possible(temp,copy,-1,0,'<')) {find(temp,copy,current);}
        copy = new Ball(cnt.x,cnt.y,cnt.left);
        temp = clone(soln);
        //temp = soln.clone();
        if (possible(temp,copy,+1,0,'>')) {find(temp,copy,current);}
    }
    
    boolean possible(char[][] temp,Ball cnt,int xD,int yD,char MOVE) {
        int X = cnt.x;
        int Y = cnt.y;
        int left = cnt.left;
        for (int i = 1; i <= left; i++) {
            temp[X][Y] = MOVE;
            X += xD;
            Y += yD;
            cnt.x = X;
            cnt.y = Y;
            if (X<0 || Y<0 || X>=width || Y>=height) {return false;}
            else if (temp[X][Y] != '.') {return false;}
            else if (grid[X][Y] == 'H') {
                if (i==left) {temp[X][Y] = 'H';cnt.left = 0; return true;}
                return false;
            }
            else if (!((grid[X][Y] == 'X' || grid[X][Y] == '.'))) {return false;}
        }
        if (grid[X][Y] == 'X') {return false;}
        cnt.left--;
        return true;
    }
    
    void displayAnswer(char[][] soln) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (soln[x][y]!='H') System.out.print(soln[x][y]);
                else System.out.print('.');
            }
            System.out.println();
        }
    }
    
    class Ball {
        int x, y, left;
        Ball(int x,int y,int left) {
            this.x = x;
            this.y = y;
            this.left = left;
        }
    }
}
