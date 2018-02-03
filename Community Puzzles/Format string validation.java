import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String Text = in.nextLine();
        String Format = in.nextLine();
        boolean soFar[][] = new boolean[Text.length()+1][Format.length()+1];
        soFar[0][0] = true;
        for (int i = 0; i < soFar.length; i++) {
            for (int j = 0; j < soFar[i].length-1; j++) {
                if (soFar[i][j]) {
                    if (Format.charAt(j) == '~') {
                        for (int fill = 0; fill < soFar.length - i; fill++) {
                            soFar[i+fill][j+1] = true;
                        }
                    } else if (i < Text.length() && ((Text.charAt(i)+"?").indexOf(Format.charAt(j)) >= 0 )) { //(Format.charAt(j) == Text.charAt(i) || Text.charAt(i) == '?')) {
                        soFar[i+1][j+1] = true;
                    }
                }
            }
        }
        System.out.println(soFar[Text.length()][Format.length()]?"MATCH":"FAIL");
    }
}
