import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static Map<String,Integer> index = new HashMap<String,Integer>();
    static String[] name;
    static double lat[];
    static double lon[];
    static double[] distance;
    static boolean[] checked;
    static Path[] paths;
    static Path[] route;
    static double[][] length;
    static Vector<Integer> checkable = new Vector<Integer>();
    static int end;
    static int seen = 0;
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String startPoint = in.next();
        String endPoint = in.next();
        int N = in.nextInt();
        name = new String[N];
        lat = new double[N];
        lon = new double[N];
        distance = new double[N];
        checked = new boolean[N];
        paths = new Path[N];
        route = new Path[N];
        length = new double[N][N];
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < N; i++) {
            String description = in.nextLine();
            Scanner cnt = new Scanner(description);
            cnt.useDelimiter(",|\n|\r\n+");
            paths[i] = new Path();
            route[i] = new Path();
            String identifier = cnt.next();
            index.put(identifier,i);
            name[i] = cnt.next().replace("\"","");
            cnt.next();
            lat[i] = Math.toRadians(cnt.nextDouble());
            lon[i] = Math.toRadians(cnt.nextDouble());
            checked[i] = false;
            cnt.close();
        }
        int M = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < M; i++) {
            //String route = in.nextLine();
            String stop1 = in.next();
            int st1 = index.get(stop1);
            String stop2 = in.next();
            int st2 = index.get(stop2);
            paths[st1].add(st2);
            //paths[st2].add(st1);
            double dist = getDist(lat[st1],lon[st1],lat[st2],lon[st2]);
            //length[st1][st2] = length[st2][st1] = dist;
            length[st1][st2] = dist;
        }
        
        int start = index.get(startPoint);
        end = index.get(endPoint);

        route[start].add(start);
        find(start);
        
        //System.out.println("IMPOSSIBLE");
    }
    
    public static void find(int start) {
        checked[start] = true;
        seen++;

        if (start==end) {
            display(); 
            return;
        }

        for (int i = 0; i < paths[start].size(); i++) {
            int cnt = paths[start].elementAt(i);
            if (checked[cnt]) {continue;}
            double dist = distance[start]+length[start][cnt];
            if (distance[cnt]==0) {
                distance[cnt] = dist;
                checkable.add(cnt);
                route[cnt].addAll(route[start]);
                route[cnt].add(cnt);
            }
            else if (dist<distance[cnt]) {
                distance[cnt] = dist;
                route[cnt].removeAllElements();
                route[cnt].addAll(route[start]);
                route[cnt].add(cnt);
                checkable.remove(new Integer(cnt));
                checkable.add(cnt);
            }
        }
        
        if (seen==name.length || checkable.size()==0) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        int index = checkable.elementAt(0);
        for (int i = 1; i < checkable.size(); i++) {
            int cnt = checkable.elementAt(i);
            if (distance[cnt]<distance[index]) index=cnt;
        }

        checkable.remove(new Integer(index));
        find(index);
    }

    public static void display() {
        for (int i = 0; i < route[end].size(); i++) {
            System.out.println(name[route[end].elementAt(i)]);
        }
    }
    
    public static double getDist(double LAT1,double LON1,double LAT2,double LON2) {
        double x = (LON2-LON1)*Math.cos((LAT1+LAT2)/2.0);
        double y = (LAT2-LAT1);
        double d = Math.sqrt(x*x+y*y)*6371.0;
        return d;
    }
    
    public static class Path extends Vector<Integer> {}
}
