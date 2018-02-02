import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static Vector<Integer> p1deck = new Vector<Integer>();
    static Vector<Integer> p2deck = new Vector<Integer>();
    static Vector<Integer> p1down = new Vector<Integer>();
    static Vector<Integer> p2down = new Vector<Integer>();

    static String cards = "234567891JQKA";

    static int turns = 0;
    static int win = 0;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of cards for player 1
        for (int i = 0; i < n; i++) {
            String cardp1 = in.next(); // the n cards of player 1
            int val = cards.indexOf(cardp1.charAt(0));
            p1deck.add(val);
        }
        System.err.println();

        int m = in.nextInt(); // the number of cards for player 2
        for (int i = 0; i < m; i++) {
            String cardp2 = in.next(); // the m cards of player 2
            int val = cards.indexOf(cardp2.charAt(0));
            p2deck.add(val);
        }

        while(p1deck.size()>0 && p2deck.size()>0){
            play();
            turns++;
        }
        
        if(win == 0){System.out.println("PAT");}
        else{System.out.println(win+" "+turns);}
    }

    public static void play() {
        if (p1deck.size()>0 && p2deck.size()>0) {
        
            int p1 = p1deck.elementAt(0);
            p1deck.removeElementAt(0);
            p1down.add(p1);

            int p2 = p2deck.elementAt(0);
            p2deck.removeElementAt(0);
            p2down.add(p2);

            int winner = 0;
            if (p1 > p2) winner = 1;
            else if (p2 > p1) winner = 2;
            else {
                for (int i = 0; i < 3; i++) {
                    try {
                        p1down.add(p1deck.elementAt(0));
                        p1deck.removeElementAt(0);

                        p2down.add(p2deck.elementAt(0));
                        p2deck.removeElementAt(0);
                    }
                    catch (Exception e) {
                        p1deck.removeAllElements();
                        p2deck.removeAllElements();
                        return;
                    }
                }
                play();
                return;
            }
            getCards(winner);
        }
        if (p1deck.size()==0) win = 2;
        else if (p2deck.size()==0) win = 1;
    }

    public static void getCards(int winner) {
        switch (winner) {
            case 1:
            while (p1down.size()>0) {
                p1deck.add(p1down.elementAt(0));
                p1down.removeElementAt(0);
            }
            while (p2down.size()>0) {
                p1deck.add(p2down.elementAt(0));
                p2down.removeElementAt(0);
            }
            break;

            case 2:
            while (p1down.size()>0) {
                p2deck.add(p1down.elementAt(0));
                p1down.removeElementAt(0);
            }
            while (p2down.size()>0) {
                p2deck.add(p2down.elementAt(0));
                p2down.removeElementAt(0);
            }
            break;
        }
    }
}
