import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LotterySimulator {
    public static void main(String[] args) {
        try (Scanner S = new Scanner(System.in)) {
            // Getting the range From User
            System.out.println("Welcome to the Lottery Simulator!");
            System.out.print("Enter the minimum number of the range: ");
            int Min_No = S.nextInt();
            System.out.print("Enter the maximum number of the range: ");
            int Max_No = S.nextInt();

            // If the Given Range is Vald or Not
            if (Min_No >= Max_No) {
                System.out.println("Invalid range! Minimum number should be less than the maximum number.");
                return;
            }

            // How many rounds the lottery is picked
            System.out.print("Enter the number of picks: ");
            int Lottery_picks = S.nextInt();
            int[] User_Lottery = new int[Lottery_picks];

            // Checks the Users picks
            System.out.println("Pick " + Lottery_picks + " numbers between " + Min_No + " and " + Max_No + ":");
            for (int i = 0; i < Lottery_picks; i++) {
                System.out.print("Enter pick #" + (i + 1) + ": ");
                User_Lottery[i] = S.nextInt();
                if (User_Lottery[i] < Min_No || User_Lottery[i] > Max_No) {
                    System.out.println("Invalid pick. Pick a number between " + Min_No + " and " + Max_No + ".");
                    i--; 
                }
            }

            // Sort the User picks in acending Order
            Arrays.sort(User_Lottery);

            // Generate random lottery
            Random numbers = new Random();
            int[] Lottery = new int[Lottery_picks];
            for (int i = 0; i < Lottery_picks; i++) {
                Lottery[i] = numbers.nextInt(Max_No - Min_No + 1) + Min_No;
            }

            // Sort the generaated lottery
            Arrays.sort(Lottery);

            // Display User and Lottery Picked Number
            System.out.println("\nYour picks: " + Arrays.toString(User_Lottery));
            System.out.println("Lottery numbers: " + Arrays.toString(Lottery));

            // Check for matching
            int Match_No = 0;
            for (int i = 0; i < Lottery_picks; i++) {
                if (Arrays.binarySearch(Lottery, User_Lottery[i]) >= 0) {
                    Match_No++;
                }
            }

            // Displaying the result of the Lottery
            System.out.println("\nYou matched " + Match_No + " number(s)!");
            if (Match_No == Lottery_picks) {
                System.out.println("Congratulations! You've won the lottery!");
            } else {
                System.out.println("Better luck next time!");
            }
        }
    }
}
