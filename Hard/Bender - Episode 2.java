import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    
    static int N; // number of rooms
    static int paths[][]; // possible paths from 1 room
    static int money[]; // money in a room
    static boolean end[]; // connection to outside
    static int max[];
    static int maxRev = 0; // maximum revenue
    static Vector<Integer> check = new Vector<Integer>(); // set of rooms to be checked

    public static void main(String args[]) throws IOException{
        Scanner in = new Scanner(System.in);
        //System.out.println("ENTER:");
        N = in.nextInt(); // initializing
        if (in.hasNextLine()) {
            in.nextLine();
        }
        paths = new int[N][2]; // initializing
        money = new int[N]; // initializing
        end = new boolean[N]; // initializing
        max = new int[N]; // initializing
        for (int i = 0; i < N; i++) {
            int room = in.nextInt(); // index of the room
            int value = in.nextInt(); // money in the room
            money[i] = value; // setting money
            String room1 = in.next(); // index of first connection
            String room2 = in.next(); // index of second connection
            try {
                int index = Integer.parseInt(room1); // index of room
                paths[room][0] = index; // set path as true
            }catch (Exception e) {end[room] = true; paths[room][0] = -1;} // if not index, connected to outside
            try {
                int index = Integer.parseInt(room2); // index of room
                paths[room][1] = index; // set path as true
            }catch (Exception e) {end[room] = true; paths[room][1] = -1;} // if not index, connected to outside
        }
        boolean visitable[] = new boolean[N];
        visitable[0] = true;
        for (int i = 0; i < N; i++) {
            System.err.println("Checking room: "+i);
            int cost = money[i];
            int room1 = paths[i][0];
            int room2 = paths[i][1];
            System.err.println("Room1: "+room1+"\nRoom2: "+room2);
            System.err.println("Cost: "+(max[i]+cost));
            try {
                if (visitable[i]) visitable[room1]=true;
                if (max[room1]<cost+max[i] && visitable[room1]) {
                    max[room1] = cost+max[i];
                    System.err.println("Set value of room "+room1+" as "+(max[i]+cost));
                }
            }
            catch (Exception e) {}
            try {
                if (visitable[i]) visitable[room2]=true;
                if (max[room2]<cost+max[i] && visitable[room2]) {
                    max[room2] = cost+max[i];
                    System.err.println("Set value of room "+room2+" as "+(max[i]+cost));
                }
            }
            catch (Exception e) {}
            if (end[i]) maxRev = Math.max(max[i]+cost,maxRev);
        }
        //int checkInd = 0;
        //for (int i = 0; i < N; i++) if (end[i]) {if(maxRev<max[i]+money[i])checkInd = i; maxRev = Math.max(max[i]+money[i],maxRev);}
        
        //System.err.println(checkInd);
        System.out.println(maxRev);
    }
    
}
