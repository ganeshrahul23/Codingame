import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.Point; // for storing coordinates of the nodes 

/**
 * The machines are gaining ground. Time to show them what we're really made of... 
 * [ Well, strictly speaking, the machines are gonna solve this one ;) ]
 **/
class Player {
    
    /*INITIALIZATION:-
    [Note: all variables have been explained later]
    */
    static String[] line;                               // explained in main
    static int N;                                       // explained in main
    static Point[] coordinate;                          // explained in main
    static int[][] node;                                // explained in main
    static int[] power;                                 // explained in main
    static int[] power_copy;                            // explained in main
    static int[][] bridges;                             // explained in main
    static int[][] bridges_copy;                        // explained in main
    static int[][] links;                               // explained in main
    static int[][] links_copy;                          // explained in main
    static Assumption assume;                           // explained in elimination, and in class definition
    static int saturated;                               // explained in main
    static boolean assuming = false;                    // check whether an assumption is being made
    static Vector<String> lines = new Vector<String>(); // list of all assumed lines

    /*MAIN:-
    the main method, which inputs the data
    then it calls the evaluate() method
    finally, it begins solving by calling the intersection() method
    rest of the solving is self-sustaining
     */
    public static void main(String args[]) {
        //System.out.println();
        
        Scanner in = new Scanner(System.in); // takes keyboard input

        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis

        if (in.hasNextLine()) {
            in.nextLine(); 
        }

        N = 0; // number of nodes
        
        line = new String[height]; // description of each line

        for (int i = 0; i < height; i++) {
            line[i] = in.nextLine(); // width characters, each either a number or a '.'
            N += line[i].replace(".","").length(); // number of coordiantes in the line
        } // end of loop(i)

        coordinate = new Point[N]; // coordinates of the N points

        power = new int[N]; // power of each coordinate
        power_copy = new int[N]; // power of each coordinate

        bridges = new int[N][4]; // stores the number of possible bridges in each direction
        bridges_copy = new int[N][4]; // stores the number of possible bridges in each direction
        // Note:- the value 4 in bridges is for all the cardinal directions, where N = 0, E = 1, S = 2, W = 3

        links = new int[N][4]; // stores the number of bridges in each direction
        links_copy = new int[N][4]; // stores the number of bridges in each direction
        // Note:- the value 4 in links is for all the cardinal directions, where N = 0, E = 1, S = 2, W = 3

        node = new int[N][4]; // stores the index of the node in a direction

        saturated = 0; // number of initial saturated nodes = 0

        evaluate(); // evaluate the given grid

        intersection(); // solving begins...

    } // end of main

    /*EVALUATE:-
    evaluates the grid to feed the variables
    the grid is interpreted as needed
     */
    public static void evaluate() { // evaluates the given grid
        int counter = 0; // stores the index of the current node

        for (int i = 0; i < line.length; i++) { // loop for all lines

            for (int j = 0; j < line[i].length(); j++) { // loop for all characters

                char current = line[i].charAt(j); // stores the current character

                if (current!='.') { // if current is a node

                    power[counter] = Integer.parseInt(""+current); // setting power of node
                    coordinate[counter] = new Point(j,i); // setting coordinates of node

                    int k = 0; //counter for all nodes before current node

                    node[counter][0]=node[counter][1]=node[counter][2]=node[counter][3]=-1; //setting default index as -1, if no nodes are present in a given direction

                    // Horizontal bridges:-
                    for (k = counter-1; k >= 0; k--) { // checking for connectivity

                        if (coordinate[k].y == i) { // if a node is horizontally to the left
                            int count = (power[k]>1&&power[counter]>1)?2:1; // if power is only 1, possible bridges is 1
                            bridges[counter][3] = count; // increasing count
                            node[counter][3] = k; // setting node index
                            bridges[k][1] = count; // increasing count
                            node[k][1] = counter; // setting node index
                            break; // objective is to find closest node, so we break
                        } // end of if
                        
                    } // end of loop (k)
                    
                    // Vertical bridges:-
                    for (k = counter-1; k >= 0; k--) { // checking for connectivity

                        if (coordinate[k].x == j) { // if a node is horizontally to the left
                            int count = (power[k]>1&&power[counter]>1)?2:1; // if power is only 1, possible bridges is 1
                            bridges[counter][0] = count; // increasing count
                            node[counter][0] = k; // setting node index
                            bridges[k][2] = count; // increasing count
                            node[k][2] = counter; // setting node index
                            break; // objective is to find closest node, so we break
                        } // end of if
                        
                    } // end of loop (k)
                    counter++; // incrementing counter
                } // end of if
            } // end of loop (j)
        } // end of loop(i)
    } // end of evaluate

    /*ALGORITHM:-
    The game works on 2 sets of algorithms:-
    1. intersection - checks for 100% sure moves
    2. elimination - when no more intersections are possible, the elimination method assumes a move to be true
    Note:- the contradiction method immediately returns whether a move by elimination method is wrong
     */

    /*1. INTERSECTION:-
    intersection method works as long as there is new information
    for this it is feeded by the boolean perform which returns true only if a bridge is created
    intersection recursively calls itself as long as new information is available
    if new information is not available, it calls elimination, whose functioning is described later
     */
    public static void intersection() {
        boolean newInfo = false; // whether new information is available
        for (int i = 0; i < N; i++) {
            if (perform(i)) {newInfo = true;} // if a bridge has been severed
        } // end of loop(i)
        if (newInfo) {intersection();} // if new information available, recall intersection
        else {elimination();} // else, go on to elimination
    } // end of intersection

    /*(A) PERFORM:- 
    checks all possible moves for given index
    if bridges are 100% sure, it draws the bridges
     */
    public static boolean perform(int i) {
        boolean drawn = false; // whether a bridge has been drawn

        int sum = bridges[i][0]+bridges[i][1]+bridges[i][2]+bridges[i][3]; // total number of bridges possible

        if (power[i] > sum) { // occurs only if there is a wrong assumption
            revert(); // then revert to original conditions
            contradict(); // contradict the assumption
            return true; // true returned because new information is available
        } // end of if

        for (int j = 0; j < 4; j++) { // loop for all the directions
            int cnt = node[i][j]; // index of node in given direction

            if (cnt == -1) continue; // if no nodes in given direction

            int difference = power[i] - (sum - bridges[i][j]); // min strength of a direction

            if (difference > 0) { // if a bridge is 100% possible!
                drawLink(i,cnt,difference,j); // draw the link
                sum = bridges[i][0]+bridges[i][1]+bridges[i][2]+bridges[i][3]; // sum is updated

                drawn =  true; // a bridge has been drawn, so set true
            } // end of if
        } // end of loop(j)

        return drawn; // returns whether new bridge was drawn (feeds newInfo)

    } // end of check

    /*(B) DRAW LINK:-
    this method draws a link based on the given input
    the input are:-
    (i) int i = index of first node
    (ii) int cnt = index of second node
    (iii) int difference = power of the link
    (iv) int j = direction of bridge (required for analysis after bridge formation)
     */
    public static boolean drawLink(int i, int cnt, int difference, int j) { // i = index of node 1, cnt = index of node 2, difference = power of bridge, j = direction
        power[i] -= difference; // power of current node updated
        power[cnt] -= difference; // power of connected node is connected

        bridges[cnt][(j+2)%4] -= difference; // bridges for connected node is updated
        bridges[i][j] -= difference; // bridges for current node is updated

        links[cnt][(j+2)%4] += difference; // links for connected node is updated
        links[i][j] += difference; // links for current node is updated
        
        if (power[i] == 1) { // if power is 1, all connected bridges are assigned value 1, to prevent overloading
            for (int k = 0; k < 4; k++) { // loop for all directions
                if (node[i][k] != -1 && bridges[i][k] != 0) {bridges[i][k] = bridges[node[i][k]][(k+2)%4] = 1;}
            } // end of loop(k)
        } // end of if
        
        if (power[cnt] == 1) {  // if power is 1, all connected bridges are assigned value 1, to prevent overloading
            for (int k = 0; k < 4; k++) { // loop for all directions
                if (node[cnt][k] != -1 && bridges[cnt][k] != 0) {bridges[cnt][k] = bridges[node[cnt][k]][(k+2)%4] = 1;}
            } // end of loop(k)
        } // end of if
        
        String bridge = ""+coordinate[i].x+" "+coordinate[i].y+" "+coordinate[cnt].x+" "+coordinate[cnt].y+" "+difference; // string describing the bridge
        if (!assuming) {System.out.println(bridge);} // display severed bridge
        else {lines.add(bridge);} // add bridge to assumed lines

        if (power[i] == 0) { // checking if current node is saturated
            if (!saturate(i)) {return false;} 
        } // end of if
        if (power[cnt] == 0) { // checking if connected node is saturated
            if (!saturate(cnt)) {return false;}
        } // end of if
        
        analyse(i,cnt,j); // analyse the node
        
        return true;
    } // end of draw link

    /*(C) SATURATE:-
    saturates a given node by severing all of its bridges
    called when the power of a node becomes 0 (i.e. no further bridges possible)
     */
    public static boolean saturate(int i) {
        for (int j = 0; j < 4; j++) {
            if (node[i][j] == -1) continue; // if no nodes in given direction
            bridges[i][j] = bridges[node[i][j]][(j+2)%4] = 0; // setting possible bridges as 0 
            // node[i][j] = node[node[i][j]][(j+2)%4] = -1;
        } // end of loop(j)
        saturated++; // increasing number of saturated nodes
        if (separate(i)) {return false;} // could not saturate node
        return true; // node was saturated
    } // end of saturate

    /*(D) SEPARATE:-
     * tests whether a saturated node is not isolated
     * called by saturate() method, to enforce contradiction, if a wrong move is done
     */
    public static boolean separate(int i) {
        boolean checked[] = new boolean[N]; // boolean for whether the node has been checked already
        Vector<Integer> pos = new Vector<Integer>(); // list of positions to be checked
        pos.add(i); // adding starting point
        int explored = 0; // number of points explored
        for (int l = 0; l < pos.size(); l++) {
            int cnt = pos.elementAt(l); // current index
            if (checked[cnt]) continue; // if node is already checked
            explored++; // incrementing explored nodes
            for (int j = 0; j < 4; j++) {
                if (node[cnt][j] == -1) continue; // if no nodes in given direction
                if (links[cnt][j] < 1 && bridges[cnt][j] < 1) continue; // no finalised links or possible links
                if (checked[node[cnt][j]]) continue; // if nodes is already checked
                pos.add(node[cnt][j]); // adding a position
            } // end of loop(j)
            checked[cnt] = true; // checking off current node
        } // end of loop(l)
        if (explored==N) {return false;} // if all points have been explored, return false
        revert(); // reverting to original grid
        contradict(); // if the saturated node is isolated
        return true; // the node is separate, which means a wrong assumption was made
    } // end of separate

    /*(E) ANALYSE:-
    this method analyses a link after it has been drawn
    analysis includes severing of links to prevent crossing over
    The method makes use of 2 sub-methods, vertical and horizontal, for the respective arrangements of the link
     */
    public static void analyse(int N1, int N2, int j) {
        int X1 = coordinate[N1].x; // setting coordinates
        int Y1 = coordinate[N1].y; // setting coordinates
        int X2 = coordinate[N2].x; // setting coordinates
        int Y2 = coordinate[N2].y; // setting coordinates
        switch (j) {
            case 0: vertical(X2,Y2,X1,Y1); break; // analyse vertical link
            case 1: horizontal(X1,Y1,X2,Y2); break; // analyse horizontal link
            case 2: vertical(X1,Y1,X2,Y2); break; // analyse vertical link
            case 3: horizontal(X2,Y2,X1,Y1); break; // analyse horizontal link
        } // end of switch(j)
    } // end of analyse

    /*(i) VERTICAL:-
    Analyses vertical links
    the necessary links will be within the y-range, and on 2 sides of the x-value
     */
    public static void vertical(int x1,int y1,int x2,int y2) {
        for (int i = 0; i < N-1; i++) {
            if (coordinate[i].y>y2) {break;} // once nodes have gone out of range, no other node needs to be analysed
            if ((coordinate[i].x < x1) && (coordinate[i].y > y1 && coordinate[i].y < y2) && (coordinate[i+1].x > x1) && (coordinate[i+1].y > y1 && coordinate[i+1].y < y2)) { // if link lies midway between 2 points...
                bridges[i][1] = bridges[i+1][3] = 0; // update impossible nodes
                node[i][1] = node[i+1][3] = -1; // update impossible nodes
            } 
        } // end of loop(i)
    } // end of vertical

    /*(ii) HORIZONTAL:-
    Analyses vertical links
    the necessary links will be within the x-range, and on 2 sides of the y-value
     */
    public static void horizontal(int x1,int y1,int x2,int y2) {
        for (int i = 0; i < N-1; i++) {
            try {
                if ((coordinate[i].y > y1) && (coordinate[i].x > x1 && coordinate[i].x < x2) && (coordinate[node[i][0]].y < y1) && (coordinate[node[i][0]].x > x1 && coordinate[node[i][0]].x < x2)) { // if link lies midway between 2 points...
                    bridges[i][0] = bridges[node[i][0]][2] = 0; // update impossible nodes
                    node[i][0] = node[node[i][0]][2] = -1; // update impossible nodes
                }
            } catch (ArrayIndexOutOfBoundsException e) {} // index of node may be -1
        } //end of loop(i)
    } // end of horizontal

    /*2. ELIMINATION:-
    elimination method is called only when intersection cannot obtain new information
    elimination assumes a bridge is true, and then again calls intersection
    if assumption is wrong (determined in boolean perform), then we get new information:-
    that the drawn bridge is not possible. So we again call intersection with this new information
     */
    public static void elimination() {
        for (int i = 0; i < lines.size(); i++) { // before an assumption, all links for the previous assumption is displayed
            System.out.println(lines.elementAt(i)); // displaying link
        } // end of loop(i)
        lines.removeAllElements(); // resetting lines for next assumption
        save(); // first we save the grid
        for (int i = 0; i < N; i++) { // loop for all nodes
            if (power[i] == 0) continue; // if power is 0, no assumption required
            for (int j = 0; j < 4; j++) { // loop for all directions
                int cnt = node[i][j]; // current node
                if (cnt == -1 || bridges[i][j] == 0) continue; // if no nodes in given direction
                assuming = true; // set assuming as true
                assume = new Assumption(i,cnt,1,j); // create assumption
                drawLink(i,cnt,1,j); // draw the given link
                intersection(); // when an assumption is made, new information is available
                return; // once a link is drawn, assumption has been made
            } // end of loop(j)
        } // end of loop(i)
    } // end of elimination

    /*(A) CONRADICT:-
    when a particular asssumption comes out to be false, this method is called
    the inference is that the drawn bridge is never possible, so the values are updated accordingly
    this method gets its information from the assumption object
     */
    public static void contradict() {
        int N1 = assume.n1; // first node
        int N2 = assume.n2; // second node
        int power = assume.power; // power of link
        int direction = assume.direction; // direction of link
        bridges[N1][direction] -= power; // updating
        bridges[N2][(direction+2)%4] -= power; // updating
    } // end of contradict

    /*(B) SAVE DATA:-
    There are 2 methods to help elimination:-
    i.  revert - once a move has been proven wrong, it returns the grid to the state it was in before an assumption
    ii. save - saves the current state of the grid
     */

    /*i. REVERT:-
    this method returns the grid to the state it was in before an assumption was made
    useful when an assumption is proved false
     */
    public static void revert() { // method reverts the grid back to its original status before a wrong move was performed
        lines.removeAllElements(); // since we are reverting, old lines have no meaning
        for (int i = 0; i < N; i++) {
            power[i] = power_copy[i]; // reverting to the value of copy variable
            for (int j = 0; j < 4; j++) {
                bridges[i][j] = bridges_copy[i][j]; // reverting to the value of copy variable
                links[i][j] = links_copy[i][j]; // reverting to the value of copy variable
            } // end of loop (j)
        } // end of loop(i)
    } // end of revert

    /*ii. SAVE:-
    this method saves the current grid state before making an assumption
    useful when an assumption becomes false, and we need the state of the grid before the assumption
     */
    public static void save() { // saves the current status of the grid before making an unsure move
        for (int i = 0; i < N; i++) {
            power_copy[i] = power[i]; // setting the value of copy variable
            for (int j = 0; j < 4; j++) {
                bridges_copy[i][j] = bridges[i][j]; // setting the value of copy variable
                links_copy[i][j] = links[i][j]; // setting the value of copy variable
            } // end of loop(j)
        } // end of loop(i)
    } // end of save

    /*(C) ASSUMPTION:-
    stores data about the current assumption
    useful if assumption is wrong, and contradiction is necessary
     */
    public static class Assumption {
        int n1, n2, power, direction; 
        public Assumption(int N1, int N2, int POWER, int DIRECTION) { // constrcutor
            n1 = N1; // index of first node
            n2 = N2; // index of second node
            power = POWER; // strength of assumed bridge
            direction = DIRECTION; // direction of node with respect to node1
        } // end of constructor
    } // end of Assumption
} // end of Player
