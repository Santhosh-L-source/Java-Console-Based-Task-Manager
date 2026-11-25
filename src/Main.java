import java.util.*;

public class Main {
    public static void main(String[] args) {
        TaskList.setTasks(FileStorage.loadTasks());
        HabitTracker.setHabits(FileStorage.loadHabits());

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Filter Tasks");
            System.out.println("5. Add Habit");
            System.out.println("6. Mark Habit Done Today");
            System.out.println("7. List Habits");
            System.out.println("8. Exit\n");
            System.out.print("Enter the Choice: ");

            int input;
            try {
                input = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (input) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter priority (LOW, MEDIUM, HIGH): ");
                    String priority = sc.nextLine();
                    System.out.print("Enter category: ");
                    String category = sc.nextLine();
                    TaskList.addTask(title, priority, category);
                    break;
                case 2:
                    TaskList.listTasks();
                    break;
                case 3:
                    System.out.print("Enter the Task Id: ");
                    try {
                        int id = Integer.parseInt(sc.nextLine().trim());
                        TaskList.completeTask(id);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid numeric Task Id.");
                    }
                    break;
                case 4:
                    System.out.println("Filter by: 1. Category  2. Priority");
                    System.out.print("Choice: ");
                    String filterChoice = sc.nextLine().trim();
                    if (filterChoice.equals("1")) {
                        System.out.print("Enter category: ");
                        TaskList.filterByCategory(sc.nextLine());
                    } else if (filterChoice.equals("2")) {
                        System.out.print("Enter priority (LOW, MEDIUM, HIGH): ");
                        TaskList.filterByPriority(sc.nextLine());
                    } else {
                        System.out.println("Invalid filter choice.");
                    }
                    break;
                case 5:
                    System.out.print("Enter habit name: ");
                    HabitTracker.addHabit(sc.nextLine());
                    break;
                case 6:
                    HabitTracker.listHabits();
                    System.out.print("Enter habit number or name: ");
                    HabitTracker.markHabitDoneToday(sc.nextLine());
                    break;
                case 7:
                    HabitTracker.listHabits();
                    break;
                case 8:
                    FileStorage.saveTasks(TaskList.getTasks());
                    FileStorage.saveHabits(HabitTracker.getHabits());
                    System.out.println("Data saved. Thank you for using Task Manager!");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
