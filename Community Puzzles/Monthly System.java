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
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        int value = 0;
        for (int i = 0; i < N; i++) {
            String M = in.nextLine();
            int dig = M.length() / 3;
            for(int j = 0; j < M.length(); j+=3){
                String cnt = M.substring(j,j+3);
                int val = val(cnt);
                value += val * (int)Math.pow(12, dig-1-j/3);
            }
        }
        String result = Integer.toString(value, 12);
        String output = "";
        for(int i = 0; i < result.length(); i++){
            output += month(""+result.charAt(i));
        }
       
        System.out.println(output);
    }
    
    public static int val(String date){
        switch(date){
            case "Jan":
                return 0;
            case "Feb":
                return 1;
            case "Mar":
                return 2;
            case "Apr":
                return 3;
            case "May":
                return 4;
            case "Jun":
                return 5;
            case "Jul":
                return 6;
            case "Aug":
                return 7;
            case "Sep":
                return 8;
            case "Oct":
                return 9;
            case "Nov":
                return 10;
            case "Dec":
                return 11;
            default:
                return 0;
                
        }
    }
    
    public static String month(String value){
        switch (value){
            case "0":
                return "Jan";
            case "1":
                return "Feb";
            case "2":
                return "Mar";
            case "3":
                return "Apr";
            case "4":
                return "May";
            case "5":
                return "Jun";
            case "6":
                return "Jul";
            case "7":
                return "Aug";
            case "8":
                return "Sep";
            case "9":
                return "Oct";
            case "10":
                return "Nov";
            case "11":
                return "Dec";
            case "a":
                return "Nov";
            case "b":
                return "Dec";
        }
        return "t[-_-t]";
    }
    
}
