import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    static char location[][];
    public static void main(String args[]) {
        location = new char[4][4];
        Scanner in = new Scanner(System.in);
        boolean checked[][] = new boolean[4][4];
        
        String line1 = in.next();
        for(int i = 0; i < 4; i++)
        {
            char ch = line1.charAt(i);
            location[i][0] = ch;
        }
        String line2 = in.next();
        for(int i = 0; i < 4; i++)
        {
            char ch = line2.charAt(i);
            location[i][1] = ch;
        }
        String line3 = in.next();
        for(int i = 0; i < 4; i++)
        {
            char ch = line3.charAt(i);
            location[i][2] = ch;
        }
        String line4 = in.next();
        for(int i = 0; i < 4; i++)
        {
            char ch = line4.charAt(i);
            location[i][3] = ch;
        }
        int n = in.nextInt();
        outest:
        for (int s = 0; s < n; s++) {
            String w = in.next();
            for(int i = 0; i < 4; i++)
            {
                for(int j = 0; j < 4; j++)
                {
                    if(location[i][j]==w.charAt(0))
                    {
                        checked[i][j] = true;
                        if(checkLettar(w, 1, checked, i, j))
                        {
                            System.out.println(true);
                            continue outest;
                        } 
                        else
                        {
                            for(int k = 0; k < 4; k++)
                            {
                                for(int l = 0; l < 4; l++)
                                {
                                    checked[k][l] = false;   
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(false);
            for(int k = 0; k < 4; k++)
            {
                for(int l = 0; l < 4; l++)
                    {
                        checked[k][l] = false;   
                    }
            }
        }
    }
    
    public static boolean checkLettar(String word, int index, boolean c[][], int s1, int s2)
    {
         if(s1 != 0)
         {
            if(location[s1 - 1][s2]==word.charAt(index))
            {
                c[s1 - 1][s2] = true;
                if(index == word.length() - 1)
                {
                    return true;   
                }
                if(checkLettar(word, index + 1, c, s1 - 1, s2))
                {
                    return true;   
                }
                else
                {
                    c[s1 - 1][s2] = false;   
                }
            }
         }
         if(s1 != 3)
         {
            if(location[s1 + 1][s2]==word.charAt(index))
            {
                 c[s1 + 1][s2] = true;
                if(index == word.length() - 1)
                {
                    return true;   
                }
                if(checkLettar(word, index + 1, c, s1 + 1, s2))
                {
                    return true;   
                }
                else
                {
                    c[s1 + 1][s2] = false;   
                }
            }
         }
         if(s2 != 0)
         {
            if(location[s1][s2 - 1]==word.charAt(index))
            {
                 c[s1][s2-1] = true;
                if(index == word.length() - 1)
                {
                    return true;   
                }
                if(checkLettar(word, index + 1, c, s1, s2-1))
                {
                    return true;   
                }
                else
                {
                    c[s1][s2-1] = false;   
                }
            }
         }
         if(s2 != 3)
         {
            if(location[s1][s2+1]==word.charAt(index))
            {
                 c[s1][s2+1] = true;
                if(index == word.length() - 1)
                {
                    return true;   
                }
                if(checkLettar(word, index + 1, c, s1, s2+1))
                {
                    return true;   
                }
                else
                {
                    c[s1][s2+1] = false;   
                }
            }
         }
         if(s1 != 0 && s2 != 0)
         {
            if(location[s1 - 1][s2 - 1]==word.charAt(index))
            {
                 c[s1 - 1][s2 - 1] = true;
                if(index == word.length() - 1)
                {
                    return true;   
                }
                if(checkLettar(word, index + 1, c, s1 - 1, s2 - 1))
                {
                    return true;   
                }
                else
                {
                    c[s1 - 1][s2 - 1] = false;   
                }
            }
         }
         if(s1 != 0 && s2 != 3)
         {
            if(location[s1 - 1][s2 + 1]==word.charAt(index))
            {
                 c[s1 - 1][s2 + 1] = true;
                if(index == word.length() - 1)
                {
                    return true;   
                }
                if(checkLettar(word, index + 1, c, s1 - 1, s2 + 1))
                {
                    return true;   
                }
                else
                {
                    c[s1 - 1][s2 + 1] = false;   
                }
            }
         }
         if(s1 != 3 && s2 != 0)
         {
            if(location[s1+1][s2-1]==word.charAt(index))
            {
                 c[s1 + 1][s2 - 1] = true;
                if(index == word.length() - 1)
                {
                    return true;   
                }
                if(checkLettar(word, index + 1, c, s1 + 1, s2 - 1))
                {
                    return true;   
                }
                else
                {
                    c[s1 + 1][s2 - 1] = false;   
                }
            }
         }
          if(s1 != 3 && s2 != 3)
         {
            if(location[s1+1][s2+1]==word.charAt(index))
            {
                 c[s1 + 1][s2 + 1] = true;
                if(index == word.length() - 1)
                {
                    return true;   
                }
                if(checkLettar(word, index + 1, c, s1 + 1, s2 + 1))
                {
                    return true;   
                }
                else
                {
                    c[s1 + 1][s2 + 1] = false;   
                }
            }
         }
         return false;
    }
}
