// Very poor solution, please don't mind ;)

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //System.out.println("ENTER:");
        int N = in.nextInt();
        double o1 = 0.0;
        double ologn = 0.0;
        double on = 0.0;
        double onlogn = 0.0;
        double on2 = 0.0;
        double on2logn = 0.0;
        double on3 = 0.0;
        double o2n = 0.0;
        double x[] = new double[N];
        double y[] = new double[N];
        double v1[] = new double[N];
        double vlogn[] = new double[N];
        double vn[] = new double[N];
        double vnlogn[] = new double[N];
        double vn2[] = new double[N];
        double vn2logn[] = new double[N];
        double vn3[] = new double[N];
        double v2n[] = new double[N];
        for (int i = 0; i < N; i++) {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
            double log = Math.log(x[i])/Math.log(10);
            v1[i] = 1.0;
            vlogn[i] = log;
            vn[i] = x[i];
            vnlogn[i] = x[i]*log;
            vn2[i] = x[i]*x[i];
            vn2logn[i] = x[i]*x[i]*log;
            vn3[i] = x[i]*x[i]*x[i];
            v2n[i] = Math.pow(2,x[i]);
            if (i<=N/2) continue;
            double expected = 0.0, found = y[i]/y[N/2];
            System.err.println("Found = "+found);
            expected = v1[i]/v1[N/2];
            System.err.println("O(1) = "+expected);
            double d1 = expected-found;
            System.err.println(d1);
            expected = vlogn[i]/vlogn[N/2];
            System.err.println("O(log n) = "+expected);
            double dlogn = expected-found;
            System.err.println(dlogn);
            expected = vn[i]/vn[N/2];
            System.err.println("O(n) = "+expected);
            double dn = expected-found;
            System.err.println(dn);
            expected = vnlogn[i]/vnlogn[N/2];
            System.err.println("O(n log n) = "+expected);
            double dnlogn = expected-found;
            System.err.println(dnlogn);
            expected = vn2[i]/vn2[N/2];
            System.err.println("O(n^2) = "+expected);
            double dn2 = expected-found;
            System.err.println(dn2);
            expected = vn2logn[i]/vn2logn[N/2];
            System.err.println("O(n^2 log n) = "+expected);
            double dn2logn = expected-found;
            System.err.println(dn2logn);
            expected = vn3[i]/vn3[N/2];
            System.err.println("O(n^3) = "+expected);
            double dn3 = expected-found;
            System.err.println(dn3);
            expected = v2n[i]/v2n[N/2];
            System.err.println("O(2^n) = "+expected);
            double d2n = expected-found;
            System.err.println(d2n);
            double min = d1;
            char answer = '1';
            if (Math.abs(dlogn)<Math.abs(min)) {min=dlogn;answer='2';} 
            if (Math.abs(dn)<Math.abs(min)) {min=dn;answer='3';} 
            if (Math.abs(dnlogn)<Math.abs(min)) {min=dnlogn;answer='4';} 
            if (Math.abs(dn2)<Math.abs(min)) {min=dn2;answer='5';} 
            if (Math.abs(dn2logn)<Math.abs(min)) {min=dn2logn;answer='6';} 
            if (Math.abs(dn3)<Math.abs(min)) {min=dn3;answer='7';} 
            if (Math.abs(d2n)<Math.abs(min)) {min=d2n;answer='8';} 
            switch (answer) {
                case '1': o1++; System.err.println("O(1)");
                    break;
                case '2': ologn++; System.err.println("O(log n)"); 
                    break;
                case '3': on++; System.err.println("O(n)");
                    break;
                case '4': onlogn++; System.err.println("O(n log n)");
                    break;
                case '5': on2++; System.err.println("O(n^2)");
                    break;
                case '6': on2logn++; System.err.println("O(n^2 log n)");
                    break;
                case '7': on3++; System.err.println("O(n^3)");
                    break;
                case '8': o2n++; System.err.println("O(2^n)");
                    break;
            }
            /*if (min==d1) {o1++;}
            else if (min==dlogn) {ologn++;System.err.println("O(log n)++");}
            else if (min==dn) {on++;System.err.println("O(n)++");}
            else if (min==dnlogn) {onlogn++;System.err.println("O(n log n)++");}
            else if (min==dn2) {on2++;System.err.println("O(n^2)++");}
            else if (min==dn2logn) {on2logn++;System.err.println("O(n^2 log n)++");}
            else if (min==dn3) {on3++;System.err.println("O(n^3)++");}
            else if (min==d2n) {o2n++;System.err.println("O(2^n)++");}*/
        }
        String answer = "O(1)";
        double min = o1;
        if ((ologn)>(min)) {answer = "O(log n)";min=ologn;} 
        if ((on)>(min)) {answer = "O(n)";min=on;} 
        if ((onlogn)>(min)) {answer = "O(n log n)";min=onlogn;} 
        if ((on2)>(min)) {answer = "O(n^2)";min=on2;} 
        if ((on2logn)>(min)) {answer = "O(n^2 log n)";min=on2logn;} 
        if ((on3)>(min)) {answer = "O(n^3)";min=on3;} 
        if ((o2n)>(min)) {answer = "O(2^n)";min=o2n;} 
        System.out.println(answer);
    }
}
