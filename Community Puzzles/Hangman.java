import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        String end[] = {"+--+\n|\n|\n|\\",
            "+--+\n|  o\n|\n|\\","+--+\n|  o\n|  |\n|\\",
            "+--+\n|  o\n| /|\n|\\","+--+\n|  o\n| /|\\\n|\\",
            "+--+\n|  o\n| /|\\\n|\\/","+--+\n|  o\n| /|\\\n|\\/ \\",
        };
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        String text2 = word.toUpperCase();
        int errors = 0;
        Map<Character,Boolean> map = new HashMap<Character,Boolean>();
        while (in.hasNext()) {
            char cnt = in.next().toUpperCase().charAt(0);
            if (map.containsKey(cnt)) {errors++;}
            else if (text2.indexOf(cnt)==-1) {errors++;}
            map.put(cnt,true);
        }
        for (int i = 0; i < text2.length(); i++) {
            char cnt = text2.charAt(i);
            if (cnt=='_'||cnt==' ') {continue;}
            if (!map.containsKey(cnt)) {
                word=word.replace((""+cnt),"_");
                word=word.replace((""+cnt).toLowerCase(),"_");
            }
        }
        System.out.println(end[errors]);
        System.out.println(word);
    }
}
