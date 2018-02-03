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
        in.useDelimiter(";|\n|\r\n+");
        
        double LON = Double.parseDouble(in.next().replace(',','.'));
        double LAT = Double.parseDouble(in.next().replace(',','.'));
        
        double minDist = Double.MAX_VALUE;
        String address = "";
        int N = in.nextInt();
        
        if (in.hasNextLine()) {
            in.nextLine();
        }
        
        for (int i = 0; i < N; i++) {
            int NUMBER = in.nextInt();
            String PLACE = in.next();
            String ADDRESS = in.next();
            in.next();
            double lon = Double.parseDouble(in.next().replace(',','.'));
            double lat = Double.parseDouble(in.next().replace(',','.'));
            double x = (lon-LON)*Math.cos((lat+LAT)/2.0);
            double y = (lat-LAT);
            double dist = Math.sqrt((x*x)+(y*y))*6371.0;
            if (dist<minDist) {
                minDist=dist;
                address=PLACE;
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(address);
    }
}
