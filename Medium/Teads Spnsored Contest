// Another dirty solution :/

import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    static Map<Integer,Boolean> checked;
    static Map<Integer,Boolean> corner;
    static Map<Integer,Integer> index;
    static Map<Integer,Person> paths;
    static Vector<Integer> person;
    static Vector<Integer> to_be_put;
    static int min = 0;
    static int people = 0;
    static int seen = 0;
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of adjacency relations
        checked = new HashMap<Integer,Boolean>();
        corner = new HashMap<Integer,Boolean>();
        index = new HashMap<Integer,Integer>();
        paths = new HashMap<Integer,Person>();
        person = new Vector<Integer>();
        to_be_put = new Vector<Integer>();
        person.add(200000);
        int start = 1;
        for (int i = 0; i < n; i++) {
            int xi = in.nextInt(); // the ID of a person which is adjacent to yi
            int yi = in.nextInt(); // the ID of a person which is adjacent to xi
            start = xi;
            try {
                paths.get(xi).add(yi);
                corner.put(index.get(xi),false);
            } catch (Exception e) {
                people++;
                paths.put(xi,new Person());
                paths.get(xi).add(yi);
                corner.put(people,true);
                index.put(xi,people);
                person.add(xi);
            }
            try {
                paths.get(yi).add(xi);
                corner.put(index.get(yi),false);
            } catch (Exception e) {
                people++;
                paths.put(yi,new Person());
                paths.get(yi).add(xi);
                corner.put(people,true);
                index.put(yi,people);            
                person.add(yi);
            }
            checked.put(xi,false);
            checked.put(yi,false);
        }
        
        while (seen<people-1) find();
        
        System.out.println(min);
    }
    
    public static void find() {
        System.err.println("Find:");
        for (int i = 1; i <= people; i++) {
            int guy = person.elementAt(i); 
            if (corner.get(i) && !checked.get(guy)) {
                System.err.println("Checking corner: "+guy);
                checked.put(guy,true);
                seen++;
                System.err.println("Seen = "+seen+" of "+people);
                Person him = paths.get(guy);
                for (int j = 0; j < him.size(); j++) {
                    int cnt = him.elementAt(j);
                    paths.get(cnt).remove((Integer)guy);
                    System.err.println("updating person "+cnt);
                    if (paths.get(cnt).size()==1) {
                        System.err.println("person "+cnt+" becomes a corner");
                        to_be_put.add(index.get(cnt));
                    }
                }
            }
        }
        put();
        min++;
        System.err.println("Time becomes "+min);
    }
    
    public static void put() {
        for (int i = 0; i < to_be_put.size(); i++) {
            int cnt = to_be_put.elementAt(i);
            corner.put(cnt,true);
        }
        to_be_put.removeAllElements();
    }
    
    public static class Person extends Vector<Integer>{} 
}
