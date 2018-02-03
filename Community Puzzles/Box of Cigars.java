import java.util.*;
public class Solution {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        //System.out.println("ENTER:");
        int N=sc.nextInt();
        int b[]=new int[N];
        for (int i=0; i<N; i++) {
            b[i]=sc.nextInt();
        }
        System.out.print(length(b,N));
    }
    public static int length(int b[], int N) { //accepting a sorted array
        int L[][]=new int[N][N]; //creating a 2D array, for which L[m][n] is the length of the longest AP with first 2 elements as m and n
        int llap=2; //length of the longest AP, always >= 2
        for (int i=0; i<N; i++) {
            L[i][N-1]=2; //always length of AP with last element is 2 (no ther elements beyond N-1, so AP cannot extend) 
        }
        for (int j=N-2; j>=0; j--) { //the middle point of an AP
            int i=j-1, k=j+1; //the points on the 2 sides of j
            while (i>=0&&k<=N-1) {
                if (b[i]+b[k]<2*b[j]) {k++;} // if sum is less, then k will be increased
                else if (b[i]+b[k]>2*b[j]) { // if sum is more...
                    L[i][j]=2; // AP with current points cannot be longer, since the sum will only increase further right
                    i--; // find longest AP for next value of i, k is not updated because i will grow lesser, so sum will naturally decrease 
                }
                else { // if an AP is found
                    L[i][j]=L[j][k]+1; // the length of the AP increases by 1 for the AP of L[j][k] (never null, because we are filling up from right to left)
                    llap=Math.max(L[i][j],llap); // updating value of llap
                    System.err.println("AP found! with: "+b[i]+","+b[j]+","+b[k]);
                    i--; // changing the value of i for next AP
                    k++; // sum is the same, so k is also incremented
                }
            }
            while (i>=0) {
                L[i][j]=2; // all other values of L[i][j] will be 2, as loop has terminated because k>=N (meaning the sum is too small, for other values of i to have an AP with j)
                i--; // decrementing 
            }
        }
        return llap;
    }
}
