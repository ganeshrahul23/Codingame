//IPL
import java.util.*;
public class Solution {
    static int[] v;
    static int consecutive=2;
    static int max[][];
    static int checks=0;
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        //System.out.println("ENTER:");
        int N=sc.nextInt();
        consecutive=sc.nextInt();
        v=new int[N];
        max = new int[N][consecutive];
        for (int i=0; i<N; i++) {
            v[i]=sc.nextInt();
        }
        System.out.println(Math.max(max(0,consecutive),max(1,consecutive)));
        System.err.println(checks);
    }

    public static int max(int index,int left) {
        left--;
        if (index>=v.length) {return 0;}
        else if (max[index][left]!=0) {return max[index][left];}
        checks++;
        int skip=Math.max(max(index+2,consecutive),max(index+3,consecutive));
        if (left>0) {skip=Math.max(max(index+2,consecutive),max(index+1,left));}
        max[index][left] = v[index]+skip;
        return v[index]+skip;
    }
}
