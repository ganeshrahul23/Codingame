import java.util.*;

public class Solution {
    static Map<Integer,Integer> score = new HashMap<Integer,Integer>(); // stores the score for a particular value
    public static void main(String[] args) {
        //System.out.println("ENTER:");
        Scanner in = new Scanner(System.in);
        score.put(0,0); // initial values
        score.put(2,0); // initial values
        int[][] grid = new int[4][4]; // grid of values
        int score = 0; // total score
        int turns = 0; // number of turns played
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[j][i] = in.nextInt(); // value of grid
                score += get(grid[j][i]); // total score required to reach the value
                turns += grid[j][i]/2; // turns required to reach tile
            }
        }
        int FOURS = in.nextInt(); // number of 4s generated
        score -= 4*FOURS; // updating score
        turns -= (2+FOURS); // updating turns
        System.out.println(score);
        System.out.println(turns);
    }
    
    public static int get(int VALUE) {
        if (!score.containsKey(VALUE)) {score.put(VALUE,2*get(VALUE/2)+VALUE);} // set maximum score
        return score.get(VALUE);
    }
    
    // READ THE COMMENTS BELOW ONLY IF YOU WANT TO KNOW HOW THE SOLUTION WORKS...
    
    /*
     * THE TRICKY PART OF THIS PUZZLE IS PREDICTING THE NUMBER OF TURNS
     * THE NUMBER OF TURNS IS EQUAL TO THE NUMBER OF TILES GENERATED - 2 (SINCE WE START WITH 2 TILES)
     * NUMBER OF TILES GENERATED FOR A VALUE = VALUE/2
     * EXPLANATION:
     * 2 MEANS ONLY 1 TILE REQUIRED
     * 4 MEANS 2 TILES OF VALUE 2 = 2 * VALUE[2] = 2 * 1 = 2
     * 8 MEANS 2 TILES OF VALUE 4 = 2 * VALUE[4] = 2 * 2 = 4
     * NOW, FOR EACH FOUR GENERATED, INSTEAD OF NEEDING 2 TILES OF VALUE 2, WE NEED ONLY 1 TILE OF VALUE 4
     * SO, TOTAL TILES GENERATED = TILES OF VALUE[2] GENERATED - NUMBER OF FOURS 
     */
    
    /*
     * PREDICTING THE SCORE IS COMPARATIVELY EASIER
     * FOR EVERY ADDITION, WE GET SCORE += 2*VALUE[TILE]
     * TO GET A 4, WE NEED 2 2S = 2 * SCORE[2] + 4 = 2 * 0 + 4 = 4
     * TO GET A 8, WE NEED 2 4S = 2 * SCORE[4] + 8 = 2 * 4 + 8 = 16
     * TO GET A 16, WE NEED 2 8S = 2 * SCORE[8] + 16 = 2 * 16 + 16 = 48
     * FINALLY, TOTAL SCORE = CALCULATED SCORE - 4*FOURS (SINCE VALUE OF 4 IS 4)
     */
}
