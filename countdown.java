import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Countdown {
    private Timer stopwatch; // stopwatch object for scheduling tasks sotopwatch
    private long countDuration; // Duration of the countDuration timer in milliseconds

    /**
     * Constructor to initialize the Countdown object with the specified duration.
     * 
     * @param countDuration The duration of the countdown timer in milliseconds.
     */
    public Countdown(long countDuration) {
        this.countDuration = countDuration;
        this.stopwatch = new Timer(); // Initialize Timer object
    }

    /**
     * Method to start the countdown timer.
     */
    public void start() {
        // Schedule a task to be executed repeatedly after a delay of 0 milliseconds
        // and with a fixed period of 1000 milliseconds (1 second)
        stopwatch.schedule(new CountdownTask(), 0, 1000);
        System.out.println("Countdown started. Waiting for " + countDuration / 1000 + " seconds...");
    }

    /**
     * Inner class representing the task to be executed during the countdown.
     */
    private class CountdownTask extends TimerTask {
        @Override
        public void run() {
            countDuration -= 1000; // Decrement the remaining time by 1 second

            if (countDuration <= 0) {
                System.out.println("Time's up! Timer expired.");
                stopwatch.cancel(); // Cancel the timer when the countdown is finished
            } else {
                // Calculate remaining minutes and seconds
                long minutes = countDuration / (60 * 1000);
                long seconds = (countDuration % (60 * 1000)) / 1000;
                // Print the remaining time in the format "mm:ss"
                System.out.printf("Time remaining: %02d:%02d%n", minutes, seconds);
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the minutes: ");
            int minutes = scanner.nextInt();

            System.out.print("Enter the seconds: ");
            int seconds = scanner.nextInt();

            // Convert minutes and seconds to milliseconds and calculate the total duration
            long durationInMillis = (minutes * 60 + seconds) * 1000;

            // Create a new Countdown object with the specified duration and start the countdown
            Countdown countdownTimer = new Countdown(durationInMillis);
            countdownTimer.start();
        }
    }
}
