import java.util.Scanner;
import java.awt.Point;

class Player {
    
    static int landingGround = 0;
    
    static final float GRAVITY = -3.711f;
    static final int MAX_XSP = 20;
    static final int MAX_YSP = 40;
    static final int SAFETY_CATCH = 5;
    static final int SAFE_DISTANCE = 50;
    
    static Point land[];
    
    public static void main(String args[]) {
        
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the number of points used to draw the surface of Mars.
        
        land = new Point[N];
        
        for (int i = 0; i < N; i++) {
            int LAND_X = in.nextInt(); // X coordinate of a surface point. (0 to 6999)
            int LAND_Y = in.nextInt(); // Y coordinate of a surface point. By linking all the points together in a sequential fashion, you form the surface of Mars.
            land[i] = new Point(LAND_X,LAND_Y);
            
            if (i == 0 || landingGround != 0) {continue;}
            
            if (land[i-1].y == land[i].y) {
                landingGround = i-1;
            }
        }
        
        // game loop
        while (true) {
            
            int X = in.nextInt();
            int Y = in.nextInt();
            int HS = in.nextInt(); // the horizontal speed (in m/s), can be negative.
            int VS = in.nextInt(); // the vertical speed (in m/s), can be negative.
            int FUEL = in.nextInt(); // the quantity of remaining fuel in liters.
            int ROTATION = in.nextInt(); // the rotation angle in degrees (-90 to 90).
            int POWER = in.nextInt(); // the thrust power (0 to 4).

            if (overLandingGround(X)) {
                if (willLand(Y)) {
                    ROTATION = 0;
                    POWER = 3;
                } 
                else if (speedWithinLimit(HS, VS)) {
                    ROTATION = 0;
                    POWER = 2;
                } 
                else {
                    ROTATION = calcAngle(HS, VS);
                    POWER = 4;
                }
            } 
            else {
                if (wrongDir(X, HS) || tooFast(HS)) {
                    ROTATION = calcAngle(HS, VS);
                    POWER = 4;
                } 
                else if (tooSlow(HS)) {
                    ROTATION = calcAngle(X);
                    POWER = 4;
                } 
                else {
                    ROTATION = 0;
                    POWER = calcThrust(VS);
                }                
            }
            
            System.out.println(ROTATION + " " + POWER); // R P. R is the desired rotation angle. P is the desired thrust power.
        }
        
    }
    
    static boolean overLandingGround(int x) {
        return x >= land[landingGround].x && x <= land[landingGround+1].x;
    }
    
    static boolean willLand(int y) {
        return y < land[landingGround].y + SAFE_DISTANCE;
    }
    
    static boolean speedWithinLimit(int hs,int vs) {
        return Math.abs(hs) <= (MAX_XSP - SAFETY_CATCH) && Math.abs(vs) <= (MAX_YSP - SAFETY_CATCH);
    }
    
    static int calcAngle(int hs,int vs) {
        double speed = Math.sqrt(hs*hs + vs*vs);
        double angle = Math.asin((double) hs / speed); // swap hs and vs and apply force in that direction
        return (int)Math.toDegrees(angle);
    }
    
    static boolean wrongDir(int x,int hs) {
        return (x < land[landingGround].x && hs < 0) || (x > land[landingGround+1].x && hs > 0) ;
    }
    
    static boolean tooFast(int hs) {
        return Math.abs(hs) > (MAX_XSP*4);
    }
    
    static boolean tooSlow(int hs) {
        return Math.abs(hs) < (MAX_XSP*2);
    }
    
    static int calcAngle(int x) {
        if (x < land[landingGround].x) {return -(int)Math.toDegrees(Math.acos(-GRAVITY/4.0));}
        else if (x > land[landingGround+1].x) {return +(int)Math.toDegrees(Math.acos(-GRAVITY/4.0));}
        return 0;
    }
    
    static int calcThrust(int vs) {
        return vs >= 0 ? 3 : 4;
    }
}
