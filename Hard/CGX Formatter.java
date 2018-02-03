import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        //System.out.println("ENTER:");
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String cGXLine = "";
        for (int i = 0; i < N; i++) {
            cGXLine += in.nextLine();
        }
        
        String result = "";
        String temp = "";
        int indents = 0;
        String indentation = "    ";
        boolean opened = false;
        boolean newLine = false;
        for (int i = 0; i < cGXLine.length(); i++) {
            char c = cGXLine.charAt(i);
            if (newLine&&c!=' '&&c!='\t') for (int j = 0; j < indents; j++){temp+=indentation;}
            if (c=='\'') {opened=!opened;}
            if (opened) {
                newLine=false;
                temp += c;
                continue;
            }
            switch (c) {
                case ';': 
                temp+=";\n"; 
                newLine=true; 
                break;
                
                case '(': 
                if (!newLine){
                    temp+="\n";
                    for (int j = 0; j < indents; j++){temp+=indentation;}
                }
                newLine=true; 
                int tmp=i;
                char ch=' ';
                while (cGXLine.charAt(++tmp)==' '||cGXLine.charAt(tmp)=='\t') {}
                ch=cGXLine.charAt(tmp);
                //if(cGXLine.charAt(i+1)!=')'){temp+="(\n";}
                if(ch!=')'){temp+="(\n";}
                else{
                    temp+="("; newLine=false;
                }; 
                indents++; 
                break;
                
                case ')':
                newLine=false;
                indents--;
                temp += "\n";
                for (int j = 0; j < indents; j++){temp+=indentation;}
                temp += c;
                break;
                default:
                if (opened) {}
                else if (c!=' '&&c!='\t') {
                    temp += c;
                    newLine=false;
                }
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        if (temp.charAt(0)=='\n') temp=temp.substring(1); 
        System.out.println(temp);
    }
}
