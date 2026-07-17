import java.util.*;

class Task {
    int id;
    String title;
    String priority;
    boolean completed;

    Task(int id, String title, String priority) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.completed = false;
    }

    public String toString() {
        return "ID: " + id +
                " | Task: " + title +
                " | Priority: " + priority +
                " | Status: " + (completed ? "Completed" : "Pending");
    }
}

public class TaskManagementSystem {

    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== TASK MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Search Task");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");

            int choice;

            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid Input!");
                sc.nextLine();
                continue;
            }

            switch (choice) {

                case 1:
                    addTask();
                    break;

                case 2:
                    viewTasks();
                    break;

                case 3:
                    completeTask();
                    break;

                case 4:
                    deleteTask();
                    break;

                case 5:
                    searchTask();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    static void addTask() {

        System.out.print("Task ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Task Title: ");
        String title = sc.nextLine();

        System.out.print("Priority (High/Medium/Low): ");
        String priority = sc.nextLine();

        tasks.add(new Task(id, title, priority));

        System.out.println("Task Added Successfully.");
    }

    static void viewTasks() {

        if (tasks.isEmpty()) {
            System.out.println("No Tasks Available.");
            return;
        }

        for (Task t : tasks)
            System.out.println(t);
    }

    static void completeTask() {

        System.out.print("Enter Task ID: ");
        int id = sc.nextInt();

        for (Task t : tasks) {

            if (t.id == id) {

                t.completed = true;
                System.out.println("Task Marked Completed.");
                return;
            }
        }

        System.out.println("Task Not Found.");
    }

    static void deleteTask() {

        System.out.print("Enter Task ID: ");
        int id = sc.nextInt();

        Iterator<Task> it = tasks.iterator();

        while (it.hasNext()) {

            Task t = it.next();

            if (t.id == id) {

                it.remove();
                System.out.println("Task Deleted.");
                return;
            }
        }

        System.out.println("Task Not Found.");
    }

    static void searchTask() {

        System.out.print("Enter Task Title: ");
        String name = sc.nextLine();

        boolean found = false;

        for (Task t : tasks) {

            if (t.title.equalsIgnoreCase(name)) {

                System.out.println(t);
                found = true;
            }
        }

        if (!found)
            System.out.println("Task Not Found.");
    }
}
