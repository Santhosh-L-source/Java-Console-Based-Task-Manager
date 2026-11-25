import java.util.ArrayList;
import java.util.List;

public class HabitTracker {
    private static List<Habit> habits = new ArrayList<>();

    public static List<Habit> getHabits() {
        return habits;
    }

    public static void setHabits(List<Habit> loadedHabits) {
        habits = new ArrayList<>(loadedHabits);
    }

    public static void addHabit(String name) {
        String trimmed = name.trim();
        if (trimmed.isEmpty()) {
            System.out.println("Habit name cannot be empty.");
            return;
        }
        for (Habit h : habits) {
            if (h.getName().equalsIgnoreCase(trimmed)) {
                System.out.println("Habit already exists.");
                return;
            }
        }
        habits.add(new Habit(trimmed));
        System.out.println("Habit added: " + trimmed);
    }

    public static void markHabitDoneToday(String input) {
        if (habits.isEmpty()) {
            System.out.println("No habits available.");
            return;
        }

        String trimmed = input.trim();
        Habit target = null;

        try {
            int index = Integer.parseInt(trimmed) - 1;
            if (index >= 0 && index < habits.size()) {
                target = habits.get(index);
            }
        } catch (NumberFormatException ignored) {
            for (Habit h : habits) {
                if (h.getName().equalsIgnoreCase(trimmed)) {
                    target = h;
                    break;
                }
            }
        }

        if (target == null) {
            System.out.println("Habit not found.");
            return;
        }

        target.markDoneToday();
        System.out.println("Current Streak: " + target.getCurrentStreak()
                + " | Longest Streak: " + target.getLongestStreak());
    }

    public static void listHabits() {
        if (habits.isEmpty()) {
            System.out.println("No habits available.");
            return;
        }
        System.out.println("========= HABIT LIST =========");
        for (int i = 0; i < habits.size(); i++) {
            Habit h = habits.get(i);
            String lastDone = (h.getLocalDate() == null) ? "Never" : h.getLocalDate().toString();
            System.out.println((i + 1) + ". " + h.getName()
                    + " | Streak: " + h.getCurrentStreak()
                    + " | Best: " + h.getLongestStreak()
                    + " | Last Done: " + lastDone);
        }
        System.out.println();
    }
}
