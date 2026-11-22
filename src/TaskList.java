import java.util.*;

public class TaskList {
    static ArrayList<Task> task = new ArrayList<>();
    static int counter = 1;

    public static void addTask(String title, String priority) {
        task.add(new Task(counter, title, priority, false));
        counter++;
    }

    public static void completeTask(int id) {
        boolean f = false;
        for (Task t : task) {
            if (t.getId() == id) {
                f = true;
                if (!t.getCompleted()) {
                    t.markCompleted();
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
            System.out.print("No tasks available");
        } else {
            task.sort(Comparator.comparing(Task::getCompleted));
            System.out.println("========= TASk LIST =========\n");
            for (Task t : task) {
                System.out.print(t.getId() + " " + t.getTitle() + " " + t.getPriority() + " ");
                if (t.getCompleted())
                    System.out.println("[ Completed ]\n\n");
                else
                    System.out.println("[ Pending ]\n\n");
            }
        }
    }
}