import java.util.*;
import java.awt.Point;

class Player {
    public static void main(String[] args) {
        Player game = new Player();
        game.play();
    }
    
    public void play() {
        Scanner in = new Scanner(System.in);
        int TX = in.nextInt();
        int TY = in.nextInt();
        
        while (true) {
            int H = in.nextInt();
            int N = in.nextInt();
            Point[] giants = new Point[N];
            for (int i = 0; i < N; i++) {
                int X = in.nextInt();
                int Y = in.nextInt();
                giants[i] = new Point(X,Y);
            }
            
            int inRange = inRange(TX,TY,giants);
            System.err.println("Giants in range: "+inRange);
            if (inRange==N) {System.out.println("STRIKE"); continue;}
            
            String move = nextMove(TX,TY,giants);
            if (move.indexOf("N")==0) {TY--;}
            else if (move.indexOf("S")==0) {TY++;}
            if (move.indexOf("W")>=0) {TX--;}
            else if (move.indexOf("E")>=0) {TX++;}
            
            System.out.println(move.toUpperCase());
        }
    }
    
    Point center(Point[] giants) {
        int cX = 0;
        int cY = 0;
        for (int i = 0; i < giants.length; i++) {
            cX += giants[i].x;
            cY += giants[i].y;
        }
        cX /= giants.length;
        cY /= giants.length;
        return new Point(cX,cY);
    }
    
    int inRange(int tx,int ty,Point[] giants) {
        int count = 0;
        for (int i = 0; i < giants.length; i++) {
            int xD = Math.abs(giants[i].x - tx);
            int yD = Math.abs(giants[i].y - ty);
            if (xD<=4 && yD<=4) {count++;}
        }
        return count;
    }
    
    boolean willDie(int tx,int ty,Point[] giants) {
        for (int i = 0; i < giants.length; i++) {
            int xD = Math.abs(giants[i].x - tx);
            int yD = Math.abs(giants[i].y - ty);
            if (xD<=1 && yD<=1) {System.err.println("WILL DIE");return true;}
        }
        return false;
    }
    
    String move(int tX,int tY,int cX,int cY) {
        String move = "";
        if (cY>tY) {move+="S";}
        else if (cY<tY) {move+="N";}
        if (cX>tX) {move+="E";}
        else if (cX<tX) {move+="W";}
        if (move.equals("")) {move="wait";}
        return move;
    }
    
    int distance(Point p1,Point p2) {
        int xD = Math.abs(p1.x - p2.x);
        int yD = Math.abs(p1.y - p2.y);
        return xD+yD;
    }
    
    String nextMove(int tx,int ty,Point[] giants) {
        Point center = center(giants);
        if (!willDie(tx,ty,giants)) {
            return move(tx,ty,center.x,center.y);
        }
        
        Move best = new Move();
        if (tx>0) {
            int x = tx-1;
            int y = ty;
            if (!willDie(x,y,giants)) {
                update("W",x,y,center,giants,best);
            }
        }
        if (ty>0) {
            int x = tx;
            int y = ty-1;
            if (!willDie(x,y,giants)) {
                update("N",x,y,center,giants,best);
            }
        }
        if (tx<40) {
            int x = tx+1;
            int y = ty;
            if (!willDie(x,y,giants)) {
                update("E",x,y,center,giants,best);
            }
        }
        if (ty<18) {
            int x = tx;
            int y = ty+1;
            if (!willDie(x,y,giants)) {
                update("S",x,y,center,giants,best);
            }
        }
        if (tx>0 && ty>0) {
            int x = tx-1;
            int y = ty-1;
            if (!willDie(x,y,giants)) {
                update("NW",x,y,center,giants,best);
            }
        }
        if (tx<40 && ty>0) {
            int x = tx+1;
            int y = ty-1;
            if (!willDie(x,y,giants)) {
                update("NE",x,y,center,giants,best);
            }
        }
        if (tx<40 && ty<18) {
            int x = tx+1;
            int y = ty+1;
            if (!willDie(x,y,giants)) {
                update("SE",x,y,center,giants,best);
            }
        }
        if (tx>0 && ty<18) {
            int x = tx-1;
            int y = ty+1;
            if (!willDie(x,y,giants)) {
                update("SW",x,y,center,giants,best);
            }
        }
        return best.move;
    }
    
    Move update(String move,int x,int y,Point center,Point[] giants,Move best) {
        int dist = distance(new Point(x,y),center);
        int giant = inRange(x,y,giants);
        Move cnt = new Move(move,dist,giant);
        best.update(cnt);
        return best;
    }
    
    class Move {
        String move;
        int dist;
        int giants;
        
        Move() {
            move = "strike";
            dist = 40+18;
            giants = 0;
        }
        
        Move(String move,int dist,int giants) {
            this.move = move;
            this.dist = dist;
            this.giants = giants;
        }
        
        void update(Move m) {
            int DIST = m.dist;
            int GIANTS = m.giants;
            if ((GIANTS>giants) || ((GIANTS==giants) && (DIST>=dist))) {
               move = m.move;
               dist = DIST;
               giants = GIANTS;
            }
        }
    }
}
