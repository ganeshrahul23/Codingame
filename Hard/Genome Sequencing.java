import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    
    static int shortest=0;
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        //System.out.println("ENTER:");
        int N = in.nextInt();
        Vector<String> strips = new Vector<String>();
        for (int i = 0; i < N; i++) {
            String subseq = in.next();
            shortest += subseq.length();
            strips.add(subseq);
        }
        getDNA(strips,N);
        System.out.println(shortest);
    }
    
    public static void getDNA(Vector<String> strips,int N) {
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                String merged = merge(strips.elementAt(i),strips.elementAt(j));
                if (!merged.equals("")) {
                    Vector<String> check = new Vector<String>();
                    check.addAll(0,strips);
                    findSmall(merged,i,j,check,N-1);
                }
            }
        }
    }
    
    public static void findSmall(String LAST,int I,int J,Vector<String> strips,int N) {
        if (N==1) {shortest=Math.min(LAST.length(),shortest);return;}
        strips.set(I,LAST);
        strips.removeElementAt(J);
        if (I>J) I--;
        for (int i = 0; i < N; i++) {
            if (i==I) continue;
            String merged = merge(LAST,strips.elementAt(i));
            if (!merged.equals("")) {
                Vector<String> check = new Vector<String>();
                check.addAll(0,strips);
                findSmall(merged,I,i,check,N-1);
            }
            else {
                Vector<String> check = new Vector<String>();
                check.addAll(0,strips);
                findSmall(LAST+strips.elementAt(i),I,i,check,N-1);
                findSmall(strips.elementAt(i)+LAST,I,i,check,N-1);
            }
        }
    }
    
    public static String merge(String s1,String s2) {
        if (s1.length()<s2.length()) {
            String tmp = s2;
            s2 = s1;
            s1 = tmp;
        }
        if (s1.indexOf(s2)!=-1) return s1;
        for (int i = s2.length()-1; i > 0; i--) {
            String sub1 = s2.substring(0,i);
            String sub2 = s2.substring(s2.length()-i);
            if (s1.substring(0,i).equals(sub2)) {
                try {
                    String result = s2.substring(0,s2.length()-i)+s1;
                    return result;
                }
                catch (Exception e) {return s1;}
            }
            if (s1.substring(s1.length()-i).equals(sub1)) {
                String result = s1+s2.substring(i);
                return result;
            }
        }
        return "";
    }
}
