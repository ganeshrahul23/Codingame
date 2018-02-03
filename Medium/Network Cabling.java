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
        
        int N = in.nextInt();
        
        int X[] = new int[N];
        int Y[] = new int[N];
        
        X[0] = in.nextInt();
        Y[0] = in.nextInt();
        
        long min, max;
        min=max=X[0];
        
        long avg = Y[0];
        
        for (int i = 1; i < N; i++) {
            
            X[i] = in.nextInt();
            if (X[i]<min) {min = X[i];}
            else if (X[i]>max) {max = X[i];}
            
            Y[i] = in.nextInt();
            avg += Y[i];
        }
        
        avg /= N;
        
        long positive = 0, negative = 0, zeros = 0;
        long cable = 0;
        
        while (true) {
            long minDiff = Math.abs(Y[0] - avg);
            for (int i = 0; i < N; i++) {
                long diff = Y[i] - avg;
                if (Math.abs(diff)<minDiff) {minDiff=Math.abs(diff);}
                if (diff>0) {positive++; cable += diff;}
                else if (diff<0) {negative++; cable += -diff;}
                else {zeros++;}
            }                
            if (positive>(negative+zeros)) {avg+=minDiff;}
            else if (negative>(positive+zeros)) {avg-=minDiff;}
            else {break;}
            
            positive=negative=zeros=cable=0;
        }
        
        cable += (max-min);

        System.out.println(cable);
    }
}
