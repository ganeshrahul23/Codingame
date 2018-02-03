import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String alignment = in.nextLine();
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        int max = 0;
        String[] text = new String[N];
        for (int i = 0; i < N; i++) {
            text[i] = in.nextLine();
            max = Math.max(max,text[i].length());
        }
        switch (alignment.charAt(0)) {
            case 'L': left(text,max); break;
            case 'R': right(text,max); break;
            case 'C': centre(text,max); break;
            case 'J': justify(text,max); break;
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        //System.out.println("answer");
    }
    
    public static void right(String[] text,int max) {
        for (int i = 0; i < text.length; i++) {
            int diff = max - text[i].length();
            for (int j = 0; j < diff; j++) text[i] = " "+text[i];
            System.out.println(text[i]);
        }
    }
    
    public static void centre(String[] text,int max) {
        for (int i = 0; i < text.length; i++) {
            int diff = max - text[i].length();
            diff/=2;
            for (int j = 0; j < diff; j++) text[i] = " "+text[i];
            System.out.println(text[i]);
        }
    }
    
    public static void justify(String[] text,int max) {
        for (int i = 0; i < text.length; i++) {
            int diff = max - text[i].length();
            int spaces = text[i].replace(" ","").length();
            double space = (double)diff/(text[i].length()-spaces);
            double spc = space;
            double lastSpc = 0.0;
            for (int j = 0; j < text[i].length(); j++) {
                if (text[i].charAt(j)==' ') {
                    int added = (int)(spc)-(int)(lastSpc);
                    lastSpc=spc;
                    spc+=space;
                    String add = "";
                    for (int k = 0; k < added; k++) add+=" ";
                    text[i] = text[i].substring(0,j)+add+text[i].substring(j);
                    j+=added;
                }
            }
            System.out.println(text[i]);
        }
    }
    
    public static void left(String[] text,int max) {
        for (int i = 0; i < text.length; i++) {
            System.out.println(text[i]);
        }
    }
}
