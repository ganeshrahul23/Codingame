import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static int[] score=new int[26]; 
    
    public static void main(String args[]) {
        update();
        
        Scanner in = new Scanner(System.in);
        
        int N = in.nextInt();
        
        if (in.hasNextLine()) {
            in.nextLine();
        }
        
        String W[]=new String[N];
        for (int i = 0; i < N; i++) {
            W[i] = in.nextLine();
        }
        
        String LETTERS = in.nextLine();
        
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(getMax(LETTERS,W));
    }
    
    public static String getMax(String letters, String[] W) {
        int max=0;
        int index=0;
        outer:
        for (int i=0; i<W.length; i++) {
            String copy=letters;
            inner:
            for (int j=0; j<W[i].length(); j++) {
                int in=copy.indexOf(W[i].charAt(j));
                if (in==-1) {continue outer;} 
                copy=copy.substring(0,in)+" "+copy.substring(in+1);
            }
            int value=getScore(W[i]);
            if (value>max) {
                index=i;
                max=value;
            }
        }
        return W[index];
    }
    
    public static int getScore(String w) {
        int s=0;
        for (int i=0; i<w.length(); i++) {
            s+=score[w.charAt(i)-97];
        }
        return s;
    }
    
    public static void update() {
        for (int i=97; i<=122; i++) {
            int s=0;
            char c=(char)i;
            if (c=='k') {s=5;}
            else if (c=='d'||c=='g') {s=2;}
            else if (c=='j'||c=='x') {s=8;}
            else if (c=='q'||c=='z') {s=10;}
            else if (c=='b'||c=='c'||c=='m'||c=='p') {s=3;}
            else if (c=='f'||c=='h'||c=='v'||c=='w'||c=='y') {s=4;}
            else {s=1;}
            score[i-97]=s;
        }
    }    
}
