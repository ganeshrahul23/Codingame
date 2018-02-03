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
        String MESSAGE = in.nextLine();
        String result="";
        for (int i = 0; i < MESSAGE.length(); i++) {
            String add = Integer.toBinaryString(MESSAGE.charAt(i));
            for (int j=add.length(); j<7; j++) {add="0"+add;}
            result+=add;
        }
        String encoded="";
        char current=' ';
        for (int j = 0; j < result.length(); j++) {
            char c = result.charAt(j);
            if (c!=current) {
                current=c;
                encoded+=" "+(c=='0'?"00":"0")+" ";
            }
            encoded+="0";
        }
        System.out.println(encoded.substring(1));
    }
}
