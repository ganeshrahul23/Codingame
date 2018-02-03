import java.util.*;
import java.math.*;
import java.io.*;
import java.awt.*;
class Solution
{
    public static void main(String args[]) { // main method
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String compound[] = new String[N];
        in.nextLine();
        for (int i = 0; i < N; i++) {
            compound[i] = in.nextLine().toUpperCase();
        }
        Vector<Integer> terminals = new Vector<Integer>();
        for (int i = 0; i < N; i++) {
            if (compound[i].indexOf('C')==-1) {continue;}
            for (int j = 0; j < compound[i].length()-2; j++) {
                if (compound[i].substring(j,j+2).equals("CH")) {
                    int bonds = Integer.parseInt(""+compound[i].charAt(j+2));
                    try {
                        bonds += Integer.parseInt(""+compound[i-1].charAt(j+1)); //up
                    } catch (Exception e) {}
                    try {
                        bonds += Integer.parseInt(""+compound[i+1].charAt(j+1)); //down
                    } catch (Exception e) {}
                    try {
                        bonds += Integer.parseInt(""+compound[i].charAt(j-2)); //left
                    } catch (Exception e) {}
                    try {
                        bonds += Integer.parseInt(""+compound[i].charAt(j+4)); //right
                    } catch (Exception e) {}
                    if (bonds!=4) {System.out.println("INVALID"); return;}
                    j+=5;
                }
            }
        }
        System.out.print("VALID");
    }
}
