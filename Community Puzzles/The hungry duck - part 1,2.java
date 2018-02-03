import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        //System.out.println("ENTER:");
        Scanner in = new Scanner(System.in);
        int W = in.nextInt();
        int H = in.nextInt();
        int[][] food = new int[W][H];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                food[j][i] = in.nextInt();
            }
        }
        ArrayList<Food> check = new ArrayList<Food>();
        long maxFood = 0;
        check.add(new Food(0,0,food[0][0]));
        while (check.size()>0) {
            System.err.println("Starting new depth...");
            
            ArrayList<Food> next = new ArrayList<Food>();
            Food[][] cnt = new Food[W][H];
            
            for (int i = 0; i < check.size(); i++) {
                Food p = check.get(i);
                
                maxFood = Math.max(p.food,maxFood);
                
                System.err.println("Currently at: "+p.x+","+p.y+" with food = "+p.food);
                int x = p.x;
                int y = p.y;
                
                if (x<W-1) {
                    System.err.println("Checking "+(x+1)+","+y);
                    int newFood = food[x+1][y]+p.food;
                    if (cnt[x+1][y] == null) {
                        cnt[x+1][y] = new Food(x+1,y,newFood);
                        next.add(cnt[x+1][y]);
                    } else {
                        System.err.println("Old food = "+cnt[x+1][y].food+", new Food = "+newFood);
                        if (cnt[x+1][y].food < newFood) {
                            cnt[x+1][y].food = newFood;
                        }
                    }
                }
                
                if (y<H-1) {
                    System.err.println("Checking "+x+","+(y+1));
                    int newFood = food[x][y+1]+p.food;
                    if (cnt[x][y+1] == null) {
                        cnt[x][y+1] = new Food(x,y+1,newFood);
                        next.add(cnt[x][y+1]);
                    } else {
                        System.err.println("Old food = "+cnt[x][y+1].food+", new Food = "+newFood);
                        if (cnt[x][y+1].food < newFood) {
                            cnt[x][y+1].food = newFood;
                        }
                    }
                }
            }
            
            check.clear();
            check.addAll(next);
        }
        System.out.println(maxFood);
    }

    static class Food extends Point{
        int food = 0;
        int index = 0;
        Food(int x,int y,int food) {
            super(x,y);
            this.food = food;
        }
    }
}
