import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    
    static String[] line = new String[4];
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            line[i] = in.next();
        }
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String w = in.next();
            System.out.println(found(w));
        }
    }
    
    public static boolean found(String word) {
        char ch = word.charAt(0);
        boolean used[][] = new boolean[4][4];
        for (int i=0;i<4;i++) {
            for (int j=0;j<4;j++) {
                if (line[i].charAt(j)==ch) {
                    used[i][j]=true;
                    if(find(word,1,i,j,used)) return true;
                    used[i][j]=false;
                }
            }
        }
        return false;
    }
    
    public static boolean find(String word,int index,int i,int j,boolean[][] used) {
        if (index<word.length()) {
            char ch = word.charAt(index);
            boolean found = false;
            int X = j-1;
            int Y = i-1;
            for (int k=0;k<2;k++) {
                X++;
                try {
                    if (line[Y].charAt(X)==ch && !used[Y][X]) {
                        used[Y][X]=true;
                        if (find(word,index+1,Y,X,used)) return true;
                        used[Y][X]=false;
                    }
                } catch (Exception e) {}
            }
            for (int k=0;k<2;k++) {
                Y++;
                try {
                    if (line[Y].charAt(X)==ch && !used[Y][X]) {
                        used[Y][X]=true;
                        if (find(word,index+1,Y,X,used)) return true;
                        used[Y][X]=false;
                    }
                } catch (Exception e) {}
            }
            for (int k=0;k<2;k++) {
                X--;
                try {
                    if (line[Y].charAt(X)==ch && !used[Y][X]) {
                        used[Y][X]=true;
                        if (find(word,index+1,Y,X,used)) return true;
                        used[Y][X]=false;
                    }
                } catch (Exception e) {}
            }
            for (int k=0;k<2;k++) {
                Y--;
                try {
                    if (line[Y].charAt(X)==ch && !used[Y][X]) {
                        used[Y][X]=true;
                        if (find(word,index+1,Y,X,used)) return true;
                        used[Y][X]=false;
                    }
                } catch (Exception e) {}
            }
            return false;
        }
        else return true;
    }
}
