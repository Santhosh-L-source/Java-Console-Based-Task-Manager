import java.util.*;

public class TaskList {
    static ArrayList<Task> task = new ArrayList<>();
    static int counter = 1;

    public static List<Task> getTasks() {
        return task;
    }

    public static void setTasks(List<Task> loadedTasks) {
        task = new ArrayList<>(loadedTasks);
        int maxId = 0;
        for (Task t : task) {
            if (t.getId() > maxId) {
                maxId = t.getId();
            }
        }
        counter = maxId + 1;
    }

    public static Priority parsePriority(String priorityInput) {
        try {
            return Priority.valueOf(priorityInput.trim().toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("Invalid priority. Please use LOW, MEDIUM, or HIGH.");
            return null;
        }
    }

    public static void addTask(String title, String priority, String category) {
        Priority parsed = parsePriority(priority);
        if (parsed == null) {
            return;
        }
        task.add(new Task(counter, title.trim(), parsed, category.trim(), false));
        counter++;
        System.out.println("Task added.");
    }

    public static void completeTask(int id) {
        boolean f = false;
        for (Task t : task) {
            if (t.getId() == id) {
                f = true;
                if (!t.isCompleted()) {
                    t.markCompleted(true);
                    System.out.println("Task Completed");
                } else {
                    System.out.println("Task Already Completed");
                }
            }
        }
        if (!f) {
            System.out.println("ID doesn't exist");
        }
    }

    public static void listTasks() {
        if (task.isEmpty()) {
            System.out.println("No tasks available");
            return;
        }
        task.sort(Comparator.comparing(Task::isCompleted));
        printTaskList("========= TASK LIST =========", task);
    }

    public static void filterByCategory(String category) {
        String target = category.trim();
        List<Task> filtered = new ArrayList<>();
        for (Task t : task) {
            if (t.getCategory().equalsIgnoreCase(target)) {
                filtered.add(t);
            }
        }
        if (filtered.isEmpty()) {
            System.out.println("No tasks found in category: " + target);
            return;
        }
        printTaskList("========= TASKS (" + target + ") =========", filtered);
    }

    public static void filterByPriority(String priorityInput) {
        Priority target = parsePriority(priorityInput);
        if (target == null) {
            return;
        }
        List<Task> filtered = new ArrayList<>();
        for (Task t : task) {
            if (t.getPriority() == target) {
                filtered.add(t);
            }
        }
        if (filtered.isEmpty()) {
            System.out.println("No tasks found with priority: " + target);
            return;
        }
        printTaskList("========= TASKS (" + target + ") =========", filtered);
    }

    private static void printTaskList(String header, List<Task> tasks) {
        System.out.println(header + "\n");
        for (Task t : tasks) {
            String status = t.isCompleted() ? "[ Completed ]" : "[ Pending ]";
            System.out.println(t.getId() + ". " + t.getTitle()
                    + " | " + t.getPriority()
                    + " | " + t.getCategory()
                    + " " + status);
        }
        System.out.println();
    }
}