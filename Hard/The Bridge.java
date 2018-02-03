import java.util.*;

/*        SOLUTION TO SKYNET - THE BRIDGE
 * ||=========================================||
 * ||  My program uses a simple DFS technique ||
 * ||=========================================||
 */
class Player {

    String[] lane = new String[4]; // the lanes of the bridge
    int bikes; // number of bikes I can simulate
    int min; // minimum bikes I must get to safety
    int last; // last position of a hole

    /* ||====================================================||
     * || MAIN METHOD - DOES NOTHING, BUT HAS TO BE THERE :( ||
     * ||====================================================||
     */
    public static void main(String[] args) {
        Player bridge = new Player();
        Scanner in = new Scanner(System.in);
        bridge.input(in);
        while (true) {
            System.err.println("Do next turn:");
            bridge.play(in);
        }
    }

    /* ||================================||
     * || TAKES THE INITIALIZATION INPUT ||
     * ||================================||
     */
    void input(Scanner in) { // takes initialization input
        bikes = in.nextInt();
        min = in.nextInt();
        in.nextLine();
        System.err.println(bikes+" "+min);
        for (int i = 0; i < 4; i++) {
            lane[i] = in.nextLine();
            System.err.println(lane[i]);
            last = Math.max(last,lane[i].lastIndexOf('0'));
            lane[i] += "............................................"; // safety precaution to prevent StringIndexOutOfBounds (See JBM's comment in forum)
        }
    }

    /* ||=======================||
     * || PLAYS OUT A GAME TURN ||
     * ||=======================||
     */
    void play(Scanner in) { // plays the game
        int speed = in.nextInt(); // speed of the bikes
        Stage cnt = new Stage(); // creating a new Stage of the game
        cnt.speed = speed; // set speed of cnt
        for (int i = 0; i < bikes; i++) {
            int X = in.nextInt(); // x position of bike
            int Y = in.nextInt(); // y position of bike
            int active = in.nextInt(); // activation coefficient of bike
            if (active==1) { // if bike is active
                cnt.x = X; // set x value of bikes in bridge
                cnt.y.add(Y); // add a new bike at 'Y'
            }
        }
        String move = decide(cnt);
        System.out.println(move);
    }

    /* ||=======================================================||
     * || CHECKS MOVES IN THIS ORDER:                           ||
     * ||  (1) SPEED (speed++)                                  ||
     * ||  (2) SLOW (speed--)                                   ||
     * ||  (3) JUMP                                             ||
     * ||  (4) UP (y--)                                         ||
     * ||  (5) DOWN (y++)                                       ||
     * || WAIT is not calculated (no one likes to sit still ;)) ||
     * ||=======================================================||
     */
    String decide(Stage cnt) {
        if (cnt.x>=last) {return "SPEED";} // if all holes crossed, Bridge crossed! :D
        else if (cnt.speed==0) {return "SPEED";} // if speed is 0, unconditionally return (we HAVE TO MOVE)
        
        String move = "SPEED";

        int best = DFS(cnt.getClone(),"SPEED"); // best = maximum number of survivors
        if (best == cnt.y.size()) return "SPEED";

        int next = DFS(cnt.getClone(),"JUMP");
        if (next == cnt.y.size()) return "JUMP";
        else if (next>best) {move = "JUMP"; best = next;}

        if (cnt.movable(0)) {
            next = DFS(cnt.getClone(),"UP");
            if (next == cnt.y.size()) return "UP";
            else if (next>best) {move = "UP"; best = next;}
        }

        if (cnt.movable(3)) {
            next = DFS(cnt.getClone(),"DOWN");
            if (next == cnt.y.size()) return "DOWN";
            else if (next>best) {move = "DOWN"; best = next;}
        }

        if (cnt.speed>1) {
            next = DFS(cnt.getClone(),"SLOW"); // next = survivors if next turn is "<MOVE>"
            if (next == cnt.y.size()) return "SLOW";
            else if (next>best) {move = "SLOW"; best = next;}
        }
        
        return move;
    }

    /* ||===============================||
     * || THE DEPTH FIRST SEARCH METHOD ||
     * ||===============================||
     */
    int DFS(Stage cnt,String MOVE) {

        switch (MOVE) {
            case "SPEED": cnt.SPEED(lane); break;
            case "SLOW": cnt.SLOW(lane); break;
            case "JUMP": cnt.JUMP(lane); break;
            case "UP": cnt.UP(lane); break;
            case "DOWN": cnt.DOWN(lane); break;
        }

        if (cnt.x>=last) {return cnt.y.size();} // if all holes crossed, Bridge crossed! :D
        else if (cnt.speed==0) {return cnt.y.size();} // if speed is 0, unconditionally return (we HAVE TO MOVE)
        else if (cnt.y.size()<min) {return cnt.y.size();}

        int survivors = 0;

        survivors = Math.max(survivors,DFS(cnt.getClone(),"SPEED"));
        if (survivors == cnt.y.size()) return cnt.y.size();

        survivors = Math.max(survivors,DFS(cnt.getClone(),"JUMP"));
        if (survivors == cnt.y.size()) return cnt.y.size();

        if (cnt.movable(0)) survivors = Math.max(survivors,DFS(cnt.getClone(),"UP"));
        if (survivors == cnt.y.size()) return cnt.y.size();

        if (cnt.movable(3)) survivors = Math.max(survivors,DFS(cnt.getClone(),"DOWN"));
        if (survivors == cnt.y.size()) return cnt.y.size();

        if (cnt.speed>1) survivors = Math.max(survivors,DFS(cnt.getClone(),"SLOW"));
        if (survivors == cnt.y.size()) return cnt.y.size();

        return survivors;
    }

    /* ||=======================================================================||
     * ||               THE PIVOTAL CLASS OF THE SOLUTION                       ||
     * ||    IT SIMULATES A GAME TURN, AND RETURNS THE NUMBER OF CASUALTIES     ||
     * || IT HAS AN ADDITIONAL METHOD "CLONE" WHICH RETURNS A COPY OF THE STAGE || 
     * ||     THIS IS TO PREVENT CALL BY REFERENCE (VERY DISGUSTING :/ )        ||
     * ||=======================================================================||
     */
    class Stage {
        int speed; // speed of bikes
        int x; // x position of all bikes
        ArrayList<Integer> y = new ArrayList<Integer>(); // y-coordinates of all bikes

        /* ||=================||
         * || RETURNS A CLONE ||
         * ||=================||
         */
        Stage getClone() { // returns a clone of the stage for further simulations
            Stage clone = new Stage();
            clone.speed = speed;
            clone.x = x;
            clone.y.addAll(y);
            return clone;
        }

        // NOTE THAT WE SHALL NOT SIMULATE "WAIT" MOVE AS IT IS SAME AS "JUMP" (READ FORUM)

        /* ||===================||
         * || SIMULATES "SPEED" ||
         * ||===================||
         */
        void SPEED(String[] game) {
            System.err.println("At position "+x+" with speed "+speed+"...");
            System.err.println("SPEED");
            speed++;
            for (int i = 0; i < y.size(); i++) {
                for (int j = x+1; j <= x+speed; j++) {
                    if (game[y.get(i)].charAt(j)=='0') {
                        y.remove(i);
                        i--;
                        System.err.println("OOPS! A bike died");
                        break;
                    }
                }
            }
            x += speed;
        }

        /* ||==================||
         * || SIMULATES "SLOW" ||
         * ||==================||
         */
        void SLOW(String[] game) {
            System.err.println("At position "+x+" with speed "+speed+"...");
            System.err.println("SLOW");
            speed--;
            for (int i = 0; i < y.size(); i++) {
                for (int j = x+1; j <= x+speed; j++) {
                    if (game[y.get(i)].charAt(j)=='0') {
                        y.remove(i);
                        i--;
                        System.err.println("OOPS! A bike died");
                        break;
                    }
                }
            }
            x += speed;
        }

        /* ||==================||
         * || SIMULATES "JUMP" ||
         * ||==================||
         */
        void JUMP(String[] game) {
            System.err.println("At position "+x+" with speed "+speed+"...");
            System.err.println("JUMP");
            x += speed;
            for (int i = 0; i < y.size(); i++) {
                if (game[y.get(i)].charAt(x)=='0') {
                    y.remove(i);
                    i--;
                    System.err.println("OOPS! A bike died");
                }
            }
        }

        /* ||================||
         * || SIMULATES "UP" ||
         * ||================||
         */
        void UP(String[] game) {
            System.err.println("At position "+x+" with speed "+speed+"...");
            System.err.println("UP");
            outer:
            for (int i = 0; i < y.size(); i++) {
                int Y = y.get(i);
                if (game[Y-1].charAt(x+speed)=='0') {
                    y.remove(i);
                    i--;
                    continue;
                }
                for (int j = x; j < x+speed; j++) {
                    if (game[Y-1].charAt(j)=='0' || game[Y].charAt(j)=='0') {
                        y.remove(i);
                        i--;
                        continue outer;
                    }
                }
                y.set(i,Y-1);
            }
            x += speed;
        }

        /* ||==================||
         * || SIMULATES "DOWN" ||
         * ||==================||
         */
        void DOWN(String[] game) {
            System.err.println("At position "+x+" with speed "+speed+"...");
            System.err.println("DOWN");
            outer:
            for (int i = 0; i < y.size(); i++) {
                int Y = y.get(i);
                if (game[Y+1].charAt(x+speed)=='0') {
                    y.remove(i);
                    i--;
                    continue;
                }
                for (int j = x; j < x+speed; j++) {
                    if (game[Y+1].charAt(j)=='0' || game[Y].charAt(j)=='0') {
                        y.remove(i);
                        i--;
                        continue outer;
                    }
                }
                y.set(i,Y+1);
            }
            x += speed;
        }

        /* ||================================================||
         * || RETURNS WHETHER THERE IS A BIKE AT INDEX CHECK ||
         * ||   PURPOSE: CHECK FOR "UP" OR "DOWN" VALIDITY   ||
         * ||================================================||
         */
        boolean movable(int check) {
            for (int i = 0; i < y.size(); i++) {
                if (y.get(i)==check) {return false;}
            }
            return true;
        }
    }
}
