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
        Scanner in = new Scanner(System.in);
        int c = 0;
        boolean checked[][];
        boolean info = false;
        LinkedList<Point> water;
        int L = in.nextInt();
        int H = in.nextInt();
        char loc[][] = new char[L][H];
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < H; i++) {
            String row = in.nextLine();
            for(int j = 0; j < row.length(); j++)
            {
                loc[j][i] = row.charAt(j);   
            }
        }
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            c = 0;
            int X = in.nextInt();
            int Y = in.nextInt();
            checked = new boolean[L][H];
            water = new LinkedList<Point>();
            if(loc[X][Y] == 'O')
            {
                c++;
                checked[X][Y] = true;
                water.add(new Point(X, Y));
                for(int j = 0; j < water.size(); j++)
                {
                    Point p = water.get(j);
                    int x = p.x;
                    int y = p.y;
                    try {
                        if (loc[x-1][y]=='O' && !checked[x-1][y]) {
                            checked[x-1][y] = true;
                            water.add(new Point(x-1,y));
                            c++;
                        }
                    }
                    catch (Exception e) {}
                    try {
                        if (loc[x+1][y]=='O' && !checked[x+1][y]) {
                            checked[x+1][y] = true;
                            water.add(new Point(x+1,y));
                            c++;
                        }
                    }
                    catch (Exception e) {}
                    try {
                        if (loc[x][y-1]=='O' && !checked[x][y-1]) {
                            checked[x][y-1] = true;
                            water.add(new Point(x,y-1));
                            c++;
                        }
                    }
                    catch (Exception e) {}
                    try {
                        if (loc[x][y+1]=='O' && !checked[x][y+1]) {
                            checked[x][y+1] = true;
                            water.add(new Point(x,y+1));
                            c++;
                        }
                    }
                    catch (Exception e) {}
                    /*try{
                        if(loc[water.get(j).x + 1][water.get(j).y] == 'O' && !checked[water.get(j).x + 1][water.get(j).y]){
                            checked[water.get(j).x + 1][water.get(j).y] = true;
                            water.add(new Point(water.get(j).x + 1, water.get(j).y));
                            c++;
                        }
                    }catch(Exception e){}
                    try{
                        if(loc[water.get(j).x + 1][water.get(j).y + 1] == 'O' && !checked[water.get(j).x + 1][water.get(j).y + 1]){ // (x+1,y+1) = diagonally down
                            checked[water.get(j).x + 1][water.get(j).y + 1] = true;
                            water.add(new Point(water.get(j).x + 1, water.get(j).y + 1));
                            c++;
                        }
                    }catch(Exception e){}
                    try{
                        if(loc[water.get(j).x - 1][water.get(j).y] == 'O' && !checked[water.get(j).x - 1][water.get(j).y]){
                            checked[water.get(j).x - 1][water.get(j).y] = true;
                            water.add(new Point(water.get(j).x - 1, water.get(j).y));
                            c++;
                        }
                    }catch(Exception e){}
                    try{
                        if(loc[water.get(j).x - 1][water.get(j).y - 1] == 'O' && !checked[water.get(j).x - 1][water.get(j).y - 1]){ // (x-1,y-1) = diagonally up
                            checked[water.get(j).x - 1][water.get(j).y - 1] = true;
                            water.add(new Point(water.get(j).x - 1, water.get(j).y - 1));
                            c++;
                        }
                    }catch(Exception e){}*/
                }
            }
            System.out.println(c);
        }
    }
}
