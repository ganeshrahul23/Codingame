import java.util.*;
import java.io.*;
import java.math.*;

class Player {
    int N; //number of nodes
    int L; //number of links
    int E; //number of gateways
    boolean link[][]; //boolean for whether 2 nodes are connected
    int danger[]; //number of exit nodes connected to a node
    boolean gateway[]; //boolean for whether the node is a gateway
    int SI; //position of the skynet agent
    
    public static void main(String[] args) {
        Player p=new Player(); //creating object of the class
        p.play(); //calling the play method
    }

    public void play() {
        Scanner in = new Scanner(System.in);
        N = in.nextInt(); // the total number of nodes in the level, including the gateways
        L = in.nextInt(); // the number of links
        E = in.nextInt(); // the number of exit gateways
        
        link = new boolean[N][N]; //initializing links
        
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
            link[N1][N2]=link[N2][N1]=true; //setting both links true, since they are 2-sided
        }
        
        gateway = new boolean[N]; //initializing gateway
        danger = new int[N]; //initializing danger
        
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node
            gateway[EI]=true; //setting boolean gateway as true
            for (int j = 0; j < N; j++) { 
                if (link[EI][j]) {danger[j]++;} //updating danger of a node
            }
        }
        
        GAME:
        while (true) {
            SI = in.nextInt(); //position of agent
            evaluate(); //evaluating next move of the virus    
        }
    }
    
    /*
    The algorithm tries to predict the path of the skynet agent
    First it checks for urgent nodes.
    Urgent nodes are those which are directly connected to the agent, or
    Which are connected to 2 gateways, across a path of continuous nodes with danger = 1
    If no dangerous nodes exist, then the virus simply removes any exit gateway node
    */
    public void evaluate() {
        
        Links positions[] = new Links[2]; //list of positions to be checked
            positions[0] = new Links(); //initializing
            positions[1] = new Links(); //initializing
            positions[0].add(SI); //checking starts from position of agent
            
            boolean checked[] = new boolean[N]; //to check if position has been checked
            
            int node1=0, node2=0; //nodes of the link to be severed
            
            DangerousNodes:
            for (int distance = 1; distance < N; distance++) {
                int cnt = (distance+1)%2; //list of positions to be checked
                for (int i = 0; i < positions[cnt].size(); i++) {
                    int node = positions[cnt].elementAt(i); //current position
                    if (checked[node]||(danger[node]==0&&distance>1)) {continue;} //if node is not dangerous
                    for (int j = 0; j < N; j++) { //checking for links
                        if (link[node][j] && !checked[j]) { //if there is an unchecked link
                            if (gateway[j]) { 
                                if (danger[node]==2||distance==1) { //if it is a dangerous gateway
                                    System.out.println(node+" "+j); //display
                                    link[node][j] = false; //severing link
                                    danger[node]--; //reducing danger of the node
                                    return; //continue with GAME loop
                                }
                                //else {node1 = node; node2 = j;}
                            }
                            else {positions[distance%2].add(j);} //adding link to be checked
                        }
                    }
                    checked[node] = true; //checking the current node (to prevent repeating)
                }
                if (positions[distance%2].size()==0) {break DangerousNodes;} //if no nodes are to be checked
                positions[cnt].removeAllElements(); //clearing for next iteration
            }
            
            Excess:
            for (int i = 0; i < N; i++) {
                if (danger[i]>0) { //if there is at least 1 gateway connected
                    for (int j = 0; j < N; j++) {
                        if (link[i][j]&&gateway[j]) {node1 = i; node2 = j; break Excess;} //gateway FOUND!
                    }
                }
            }
            
            System.out.println(node1+" "+node2); //in case there are no dangerous nodes
            link[node1][node2] = false; //severing link
            danger[node1]--; //reducing danger of the node
    }
    
    class Links extends Vector<Integer> {}
}
