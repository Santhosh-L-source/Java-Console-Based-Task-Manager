import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.Add Task");
            System.out.println("2.List Task");
            System.out.println("3.Complete Task");
            System.out.println("4.Exit\n");
            System.out.print("Enter the Choice:");
            int input = sc.nextInt();
            sc.nextLine();
            switch (input) {
                case 1:
                    System.out.print("Enter task title:");
                    String title = sc.nextLine();
                    System.out.print("Enter priority:");
                    String priority = sc.nextLine();
                    TaskList.addTask(title, priority);
                    break;
                case 2:
                    TaskList.listTasks();
                    break;
                case 3:
                    System.out.print("Enter the Task Id:");
                    int id = sc.nextInt();
                    TaskList.completeTask(id);
                    break;
                case 4:
                    System.out.println("Thank you for using Task Manager!");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
