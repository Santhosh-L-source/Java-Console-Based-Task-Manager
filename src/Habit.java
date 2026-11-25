import java.time.LocalDate;
import java.time.temporal.*;

public class Habit {
    private String name;
    private int currStreak;
    private LocalDate lastCompletedDate;
    private int longestStreak;

    public Habit(String name) {
        this.name = name;
        this.currStreak = 0;
        this.longestStreak = 0;
        this.lastCompletedDate = null;
    }

    public Habit(String name, int currStreak, LocalDate lastCompletedDate, int longestStreak) {
        this.name = name;
        this.currStreak = currStreak;
        this.lastCompletedDate = lastCompletedDate;
        this.longestStreak = longestStreak;
    }

    public void markDoneToday() {
        LocalDate today = LocalDate.now();
        if (lastCompletedDate == null) {
            currStreak = 1;
        } else {
            long diff = ChronoUnit.DAYS.between(lastCompletedDate, today);

            if (diff == 0) {
                System.out.println("Already Completed Today!");
                return;
            } else if (diff == 1) {
                currStreak++;
            } else {
                currStreak = 1;
            }
        }
        lastCompletedDate = today;
        longestStreak = Math.max(longestStreak, currStreak);
        System.out.println("Habit Successfully Completed!");
    }

    public String getName() {
        return name;
    }

    public int getCurrentStreak() {
        return currStreak;
    }

    public LocalDate getLocalDate() {
        return lastCompletedDate;
    }

    public int getLongestStreak() {
        return longestStreak;
    }

}