import java.util.*;

public class Solution {
    public static void main(String[] args) {
        //System.out.println("ENTER:");
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        display("",N,M);
    }    
    
    public static void display(String text,int left,int max) {
        if (left == 0) {System.out.println(text.substring(1)); return;}
        int range = Math.min(left,max);
        for (int i = 1; i <= range; i++) {
            display(text+" "+i,left-i,max);
        }
    }
}
