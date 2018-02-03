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
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String A = in.next();
            int xA = in.nextInt();
            int yA = in.nextInt();
            Point a = new Point(xA,yA);
            String B = in.next();
            int xB = in.nextInt();
            int yB = in.nextInt();
            Point b = new Point(xB,yB);
            String C = in.next();
            int xC = in.nextInt();
            int yC = in.nextInt();
            Point c = new Point(xC,yC);
            String D = in.next();
            int xD = in.nextInt();
            int yD = in.nextInt();
            Point d = new Point(xD,yD);
            String NAME = A+B+C+D+" is a ";
            determine(a,b,c,d,NAME);
        }

    }
    
    public static void determine(Point A,Point B,Point C,Point D,String NAME) {
        int parallels = 0;
        int equal_sides = 0;
        parallels = testParallels(A,B,C,D);
        if (parallels==0) NAME+="quadrilateral.";
        else if (parallels==1) NAME+="trapezium.";
        else if (parallels==2) {
            if (testSides(A,B,C,D)) {
                if (testAngle(A,B,C,D)) NAME+="square.";
                else NAME+="rhombus.";
            }
            else if (testAngle(A,B,C,D)) {
                NAME+="rectangle.";
            }
            else {
                NAME+="parallelogram.";
            }
        }
        System.out.println(NAME);
    }
    
    public static boolean testAngle(Point A,Point B,Point C,Point D) {
        int ABx = A.x-B.x;
        int ABy = A.y-B.y;
        int BCx = B.x-C.x;
        int BCy = B.y-C.y;
        return (ABy*BCy==-1*ABx*BCx); 
    }
    
    public static boolean testSides(Point A,Point B,Point C,Point D) {
        int AB = (int)Math.pow((A.x-B.x),2)+(int)Math.pow((A.y-B.y),2);
        int BC = (int)Math.pow((C.x-B.x),2)+(int)Math.pow((C.y-B.y),2);
        return AB==BC;
    }
    
    public static int testParallels(Point A,Point B,Point C,Point D) {
        int p = 0;
        int y1 = (A.y-B.y);
        int y2 = (D.y-C.y);
        int x1 = (A.x-B.x);
        int x2 = (D.x-C.x);
        System.err.println(y1+"/"+x1+":"+y2+"/"+x2);
        if (y1==y2&&x2==x1) p++;
        y1 = (A.y-D.y);
        y2 = (B.y-C.y);
        x1 = (A.x-D.x);
        x2 = (B.x-C.x);
        System.err.println(y1+"/"+x1+":"+y2+"/"+x2);
        if (y1==y2&&x2==x1) p++;
        return p;
    }
}
