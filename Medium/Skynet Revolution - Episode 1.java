import java.util.*;
import java.io.*;
import java.math.*;

class Player {
    int N;
    int L;
    int E;
    boolean link[][];
    boolean gateway[];
    int SI;
    public static void main(String[] args) {
        Player p=new Player();
        p.evaluate();
    }

    public void evaluate() {
        //System.out.println("Skyent:");
        Scanner in = new Scanner(System.in);
        N = in.nextInt(); // the total number of nodes in the level, including the gateways
        L = in.nextInt(); // the number of links
        E = in.nextInt(); // the number of exit gateways
        link = new boolean[N][N];
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
            link[N1][N2]=link[N2][N1]=true;
        }
        gateway = new boolean[N];
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node
            gateway[EI]=true;
        }

        // Game loop:
        game:
        while (true) {
            boolean checked[]=new boolean[N];

            SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn

            Vector<Path> poss = new Vector<Path>(); // The set of positions to be checked
            
            for (int i = N-1; i >= 0; i--) {
                if (link[SI][i]) {
                    poss.add(new Path(SI,i,i));
                }
            }
            
            int node1=0; // First node to be removed
            int node2=0; // Second node to be removed
            
            for (int i = 0; i < poss.size(); i++) {
                Path p = poss.elementAt(i);
                if (gateway[p.cnt]) {
                    node1 = p.node1;
                    node2 = p.node2;
                    break;
                }
                for (int j = N-1; j >= 0; j--) {
                    if (link[p.cnt][j]) {
                        poss.add(new Path(p.node1,p.node2,j));
                    }
                }
            }
            
            
            link[node1][node2]=link[node2][node1]=false;
            System.out.println(node1+" "+node2);
        }
    }
    
    static class Path {
        int node1, node2;
        int cnt;
        Path(int N1,int N2,int CNT) {
            node1=N1;
            node2=N2;
            cnt=CNT;
        }
    }
}
