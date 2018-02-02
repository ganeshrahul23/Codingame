import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    
    static String[][] letters;
    static Vector<String> ANSWER = new Vector<String>();

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        int L = in.nextInt();
        int H = in.nextInt();
        
        letters = new String[20][H];
        
        for (int i = 0; i < H; i++) {
            String numeral = in.next();
            for (int j = 0; j < numeral.length(); j+= L) {
                letters[j/L][i] = numeral.substring(j,j+L);
            }
        }
        
        int DIGITS;
        
        String[] num1 = new String[H];  
        
        int S1 = in.nextInt();
        long N1 = 0;
        DIGITS = S1/H;
        for (int i = 0; i < S1; i++) {
            num1[i%H] = in.next();
            if (i%H == H-1) {
                int dig = getDig(num1);
                N1 += dig * Math.pow(20,DIGITS-(i+1)/H);
            }
        }
        
        String[] num2 = new String[H];  
        
        int S2 = in.nextInt();
        long N2 = 0;
        DIGITS = S2/H;
        for (int i = 0; i < S2; i++) {
            num2[i%H] = in.next();
            if (i%H == H-1) {
                int dig = getDig(num2);
                N2 += dig * Math.pow(20,DIGITS-(i+1)/H);
            }
        }
        
        char operation = in.next().charAt(0);
        long RESULT = 0;
        
        switch (operation) {
            case '*': RESULT = N1*N2; break;
            case '/': RESULT = N1/N2; break;
            case '+': RESULT = N1+N2; break;
            case '-': RESULT = N1-N2; break;
        }
        
        if (RESULT==0) convert(0);
        
        while (RESULT > 0) {
            long CURRENT = RESULT%20;
            RESULT/=20;
            convert((int)CURRENT);
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        for (int i = 0; i < ANSWER.size(); i++) {
            System.out.println(ANSWER.elementAt(i));        
        }
    }
    
    public static int getDig(String num[]) {
        number:
        for (int i = 0; i < 20; i++) {
            line:
            for (int j = 0; j < letters[i].length; j++) {
                if (!num[j].equals(letters[i][j])) continue number; 
            }
            return i;
        }
        return 0;
    }
    
    public static void convert(int n) {
        for (int i = letters[n].length-1; i >= 0; i--) {
            ANSWER.add(0,letters[n][i]);
        }
    }
}
