import java.util.*;
class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); //number of Oods
        int C = in.nextInt(); //total cost of gift
        int B[] = new int[N]; //budget of every ood
        int soln[] = new int[N]; //amount to be contributed by each ood
        int total=0; //total amount the oods can contribute
        int contribution=0; //total amount being contributed
        for (int i = 0; i < N; i++) {
            B[i] = in.nextInt(); //inputting value of budget
            total += B[i]; //updating total
        }
        if (total<C) {System.out.println("IMPOSSIBLE"); return;} //checking if gift CAN be contrubuted
        Arrays.sort(B); //sorting in ascending order (as per question)
        for (int i=0; i<N; i++) {
            int cont=((C-contribution)/(N-i)); //amount to be contributed
            soln[i]=(cont<=B[i])?cont:B[i]; //amount being contributed (equal to budget if amout to be contributed is greater than budget)
            contribution+=soln[i]; //updating total contribution
        }
        for (int i=0; i<N; i++) { 
            System.out.println(soln[i]); //displaying result
        }
    }
}
