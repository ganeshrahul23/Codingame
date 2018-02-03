import java.util.*;
import java.awt.Point;

class Player {

    int W, H, EX;
    int[][] grid;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Player game = new Player();
        game.init(in);
        while (true) {game.play(in);}
    }

    /*
     * Stores a move
     */
    class Move {
        int x, y;
        String move;
        Move(int x,int y,String move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
        void display() {
            if (move.equals("WAIT")) System.out.println("WAIT");
            else System.out.println(x+" "+y+" "+move);
        }
    }

    /*
     * Room stores the x and y coordinates of a room, its type, direction of entry, and all the steps so far
     */
    class Room {
        int x, y;
        int type;
        String entry;
        ArrayList<Move> steps;
        Room(int x,int y,int type,String entry,ArrayList<Move> steps) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.entry = entry;
            this.steps = steps;
        }
    }

    /*
     * Rock stores x and y coordinates of the rock, and direction of entry
     */
    class Rock {
        int x, y;
        String entry;
        Rock(int x,int y,String entry) {
            this.x = x;
            this.y = y;
            this.entry = entry;
        }
    }

    /*
     * Initialization input
     */
    void init(Scanner in) {
        W = in.nextInt();
        H = in.nextInt();
        in.nextLine();
        grid = new int[W][H];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                grid[j][i] = in.nextInt();
            }
        }
        EX = in.nextInt();
    }

    /*
     * Play a game turn
     */
    void play(Scanner in) {
        int XI = in.nextInt();
        int YI = in.nextInt();
        String POSI = in.next();
        int R = in.nextInt(); // the number of rocks currently in the grid.
        ArrayList<Rock> rocks = new ArrayList<Rock>();
        for (int i = 0; i < R; i++) {
            int XR = in.nextInt();
            int YR = in.nextInt();
            String POSR = in.next();
            rocks.add(new Rock(XR,YR,POSR));
        }
        Move move = play(XI,YI,POSI,rocks);
        execute(move);
        move.display();
    }

    /*
     * Executes the final move i.e. updates the grid
     */
    void execute(Move MOVE) {
        if (MOVE.move.equals("RIGHT")) {
            int X = MOVE.x;
            int Y = MOVE.y;
            grid[X][Y] = clockwise(grid[X][Y]);
        }
        else if (MOVE.move.equals("LEFT")) {
            int X = MOVE.x;
            int Y = MOVE.y;
            grid[X][Y] = counterClockwise(grid[X][Y]);
        }
    }

    /*
     * Returns the immediately next move
     */
    Move play(int X,int Y,String ENTRY,ArrayList<Rock> rocks) {
        ArrayList<Move> moves = getSteps(X,Y,ENTRY);
        //System.err.println(moves.get(1).move);
        if (moves.size()<=1) {return new Move(X,Y,"WAIT");}
        else if (!(moves.get(1).move.equals("WAIT"))) {return moves.get(1);}
        
        simulate:
        for (int i = 0; i < moves.size()-1; i++) {
            String cnt = moves.get(i).move;
            if (!cnt.equals("WAIT")) {
                for (int j = 0; j < rocks.size(); j++) {
                    Point p = new Point(rocks.get(j).x,rocks.get(j).y);
                    String exit = exit(grid[p.x][p.y],rocks.get(j).entry);
                    Point nxt = nextPoint(exit,p);
                    if ((nxt.x == p.x && nxt.y == p.y)) {
                        rocks.remove(j);
                        j--;
                    }
                    else {
                        rocks.set(j,new Rock(nxt.x,nxt.y,exit));
                    }
                }
            }
            else { //if (!(moves.get(i).x == rocks.get(j).x && moves.get(i).y == rocks.get(j).y)) {
                for (int j = 0; j < rocks.size(); j++) {
                    Point p = new Point(rocks.get(j).x,rocks.get(j).y);
                    if (p.x == X && p.y == Y) {continue;}
                    if (grid[p.x][p.y]>= 2) {
                        String exit = exit(clockwise(grid[p.x][p.y]),rocks.get(j).entry);
                        Point nxt = nextPoint(exit,p);
                        if (moves.get(1).x == nxt.x && moves.get(1).y == nxt.y) {continue;}
                        if ((nxt.x == p.x && nxt.y == p.y)) {
                            moves.set(i,new Move(p.x,p.y,"RIGHT"));
                            return moves.get(i);
                        }
                    }
                    if (grid[p.x][p.y]>= 6) {
                        String exit = exit(counterClockwise(grid[p.x][p.y]),rocks.get(j).entry);
                        Point nxt = nextPoint(exit,p);
                        if (moves.get(1).x == nxt.x && moves.get(1).y == nxt.y) {continue;}
                        if ((nxt.x == p.x && nxt.y == p.y)) {
                            moves.set(i,new Move(p.x,p.y,"LEFT"));
                            return moves.get(i);
                        }
                    }
                }
            }
        }
        return moves.get(1);
    }

    /*
     * Returns a safe path for Indy 
     */
    ArrayList<Move> getSteps(int x,int y,String entry) {
        boolean[][][] visits = new boolean[W][H][4];
        visits[x][y][dir(entry)] = true;
        String next = exit(grid[x][y],entry);
        Point first = nextPoint(next,new Point(x,y));
        ArrayList<Room> bfs = new ArrayList<Room>();
        bfs.add(new Room(first.x,first.y,grid[first.x][first.y],next,new ArrayList<Move>()));
        bfs.get(0).steps.add(new Move(x,y,"First"));
        visits[first.x][first.y][dir(next)] = true;
        while (bfs.size()>0) {
            Room cnt = bfs.get(0);
            if (cnt.x == EX && cnt.y == H-1) {return cnt.steps;}
            bfs.addAll(analyse(cnt,visits));
            bfs.remove(0);
        }
        return new ArrayList<Move>();
    }

    /*
     * returns to-be-checked rooms given the current room
     */
    ArrayList<Room> analyse(Room cnt,boolean[][][] visits) {
        System.err.println("Immediate room = "+cnt.x+","+cnt.y+". FROM: "+cnt.entry);
        ArrayList<Room> nxt = new ArrayList<Room>();
        //NEXT ROOM
        String nextEntry = exit(grid[cnt.x][cnt.y],cnt.entry);
        Point next = nextPoint(nextEntry,new Point(cnt.x,cnt.y));
        System.err.println("Next point is "+next.x+","+next.y+". FROM: "+nextEntry);
        if (!(cnt.x == next.x && cnt.y == next.y) && !visits[next.x][next.y][dir(nextEntry)]) {
            ArrayList<Move> nextRoom = new ArrayList<Move>();
            nextRoom.addAll(cnt.steps);
            nextRoom.add(new Move(cnt.x,cnt.y,"WAIT"));
            visits[next.x][next.y][dir(nextEntry)] = true;
            nxt.add(new Room(next.x,next.y,grid[next.x][next.y],nextEntry,nextRoom));
        }
        if (cnt.type>=2) {
            //CLOCKWISE:
            nextEntry = exit(clockwise(grid[cnt.x][cnt.y]),cnt.entry);
            next = nextPoint(nextEntry,new Point(cnt.x,cnt.y));
            System.err.println("Next point clockwise is "+next.x+","+next.y+". FROM: "+nextEntry);
            if (!(cnt.x == next.x && cnt.y == next.y)  && !visits[next.x][next.y][dir(nextEntry)]) {
                ArrayList<Move> nextRoom = new ArrayList<Move>();
                nextRoom.addAll(cnt.steps);
                nextRoom.add(new Move(cnt.x,cnt.y,"RIGHT"));
                visits[next.x][next.y][dir(nextEntry)] = true;
                nxt.add(new Room(next.x,next.y,grid[next.x][next.y],nextEntry,nextRoom));
            }
        }
        if (cnt.type>=6) {
            //COUNTERCLOCKWISE:
            nextEntry = exit(counterClockwise(grid[cnt.x][cnt.y]),cnt.entry);
            next = nextPoint(nextEntry,new Point(cnt.x,cnt.y));
            System.err.println("Next point counterclockwise is "+next.x+","+next.y+". FROM: "+nextEntry);
            if (!(cnt.x == next.x && cnt.y == next.y) && !visits[next.x][next.y][dir(nextEntry)]) {
                ArrayList<Move> nextRoom = new ArrayList<Move>();
                nextRoom.addAll(cnt.steps);
                nextRoom.add(new Move(cnt.x,cnt.y,"LEFT"));
                visits[next.x][next.y][dir(nextEntry)] = true;
                nxt.add(new Room(next.x,next.y,grid[next.x][next.y],nextEntry,nextRoom));
            }

            //2 ROTATIONS:
            ArrayList<Move> steps = cnt.steps;
            int i = 0;
            for (i = steps.size()-1; i >= 0; i--) {
                if (steps.get(i).move.equals("WAIT")) {break;}
            }
            if (i>=0) {
                nextEntry = exit(clockwise(clockwise(grid[cnt.x][cnt.y])),cnt.entry);
                next = nextPoint(nextEntry,new Point(cnt.x,cnt.y));
                System.err.println("Next point double is "+next.x+","+next.y+". FROM: "+nextEntry);
                if (!(cnt.x == next.x && cnt.y == next.y)  && !visits[next.x][next.y][dir(nextEntry)] ) {
                    cnt.steps.set(i,new Move(cnt.x,cnt.y,"RIGHT"));
                    ArrayList<Move> nextRoom = new ArrayList<Move>();
                    nextRoom.addAll(cnt.steps);
                    nextRoom.add(new Move(cnt.x,cnt.y,"RIGHT"));
                    visits[next.x][next.y][dir(nextEntry)] = true;
                    nxt.add(new Room(next.x,next.y,grid[next.x][next.y],nextEntry,nextRoom));
                }
            }
        }
        return nxt;
    }

    /*
     * returns next room
     */
    Point nextPoint(String entry,Point cnt) {
        int nextX = cnt.x;
        int nextY = cnt.y;
        switch (entry) {
            case "TOP":
            if (cnt.y < H-1) {nextY++;}
            break;
            case "LEFT":
            if (cnt.x < W-1) {nextX++;}
            break;
            case "RIGHT":
            if (cnt.x > 0) {nextX--;}
            break;
        }
        return new Point(nextX,nextY);
    }

    /*
     * return the direction of entry to next room when given the current room type, and entry into the current room
     */
    String exit(int room,String dir) {
        switch (Math.abs(room)) {
            case 0: return "";
            case 1: return "TOP";
            case 2: 
            switch (dir) {
                case "LEFT": return "LEFT";
                case "RIGHT": return "RIGHT";
                default: return "";
            }    
            case 3: 
            switch (dir) {
                case "TOP": return "TOP";
                default: return "";
            }    
            case 4: 
            switch (dir) {
                case "TOP": return "RIGHT";
                case "RIGHT": return "TOP";
                default: return "";
            }    
            case 5:
            switch (dir) {
                case "TOP": return "LEFT";
                case "LEFT": return "TOP";
                default: return "";
            }    
            case 6: 
            switch (dir) {
                case "LEFT": return "LEFT";
                case "RIGHT": return "RIGHT";
                default: return "";
            }    
            case 7: 
            switch (dir) {
                case "TOP": return "TOP";
                case "RIGHT": return "TOP";
                default: return "";
            }    
            case 8: 
            switch (dir) {
                case "LEFT": return "TOP";
                case "RIGHT": return "TOP";
                default: return "";
            }    
            case 9: 
            switch (dir) {
                case "TOP": return "TOP";
                case "LEFT": return "TOP";
                default: return "";
            }    
            case 10: 
            switch (dir) {
                case "TOP": return "RIGHT";
                default: return "";
            }
            case 11: 
            switch (dir) {
                case "TOP": return "LEFT";
                default: return "";
            }
            case 12: 
            switch (dir) {
                case "RIGHT": return "TOP";
                default: return "";
            }
            case 13: 
            switch (dir) {
                case "LEFT": return "TOP";
                default: return "";
            }
        }
        return "";
    }

    /*
     * Returns room type when rotated clockwise
     */
    int clockwise(int type) {
        switch (type) {
            case 2: return 3;
            case 3: return 2;
            case 4: return 5;
            case 5: return 4;
            case 6: return 7;
            case 7: return 8;
            case 8: return 9;
            case 9: return 6;
            case 10: return 11;
            case 11: return 12;
            case 12: return 13;
            case 13: return 10;
        }
        return 1;
    }

    /*
     * Returns room type when rotated anticlockwise
     */
    int counterClockwise(int type) {
        switch (type) {
            case 2: return 3;
            case 3: return 2;
            case 4: return 5;
            case 5: return 4;
            case 6: return 9;
            case 7: return 6;
            case 8: return 7;
            case 9: return 8;
            case 10: return 13;
            case 11: return 10;
            case 12: return 11;
            case 13: return 12;
        }
        return 1;
    }

    /*
     * converts direction to integer
     */
    static int dir(String dir) {
        switch (dir) {
            case "TOP": return 0; 
            case "LEFT": return 1;
            case "RIGHT": return 2;
        }
        return 3;
    }
}
