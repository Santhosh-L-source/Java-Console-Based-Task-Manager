import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileStorage {
    private static final String TASKS_FILE = "tasks.txt";
    private static final String HABITS_FILE = "habits.txt";

    public static void saveTasks(List<Task> tasks) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(TASKS_FILE))) {
            for (Task t : tasks) {
                String safeTitle = t.getTitle().replace("|", "/");
                String safeCategory = t.getCategory().replace("|", "/");
                bw.write(t.getId() + "|" + safeTitle + "|" + t.getPriority().name()
                        + "|" + safeCategory + "|" + t.isCompleted());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not save tasks: " + e.getMessage());
        }
    }

    public static List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        File file = new File(TASKS_FILE);
        if (!file.exists()) {
            return tasks;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                try {
                    String[] data = line.split("\\|", -1);
                    if (data.length < 5) {
                        continue;
                    }
                    int id = Integer.parseInt(data[0].trim());
                    String title = data[1];
                    Priority priority = Priority.valueOf(data[2].trim().toUpperCase());
                    String category = data[3];
                    boolean completed = Boolean.parseBoolean(data[4].trim());
                    tasks.add(new Task(id, title, priority, category, completed));
                } catch (RuntimeException e) {
                    System.out.println("Skipping corrupted task entry.");
                }
            }
        } catch (IOException e) {
            System.out.println("Could not load tasks (starting empty): " + e.getMessage());
            return new ArrayList<>();
        }
        return tasks;
    }

    public static void saveHabits(List<Habit> habits) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(HABITS_FILE))) {
            for (Habit h : habits) {
                String safeName = h.getName().replace("|", "/");
                String lastDate = (h.getLocalDate() == null) ? "" : h.getLocalDate().toString();
                bw.write(safeName + "|" + h.getCurrentStreak() + "|" + lastDate + "|" + h.getLongestStreak());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not save habits: " + e.getMessage());
        }
    }

    public static List<Habit> loadHabits() {
        List<Habit> habits = new ArrayList<>();
        File file = new File(HABITS_FILE);
        if (!file.exists()) {
            return habits;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                try {
                    String[] data = line.split("\\|", -1);
                    if (data.length < 4) {
                        continue;
                    }
                    String name = data[0];
                    int currStreak = Integer.parseInt(data[1].trim());
                    LocalDate lastDate = data[2].trim().isEmpty() ? null : LocalDate.parse(data[2].trim());
                    int longestStreak = Integer.parseInt(data[3].trim());
                    habits.add(new Habit(name, currStreak, lastDate, longestStreak));
                } catch (RuntimeException e) {
                    System.out.println("Skipping corrupted habit entry.");
                }
            }
        } catch (IOException e) {
            System.out.println("Could not load habits (starting empty): " + e.getMessage());
            return new ArrayList<>();
        }
        return habits;
    }
    }
