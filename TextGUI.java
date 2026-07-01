package taskManagementSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextGUI {
    private TaskManager taskManager;
    private ArrayList<Task> taskList = new ArrayList<>();

    public TextGUI(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    public void TextInterface() throws ClassNotFoundException, IOException {
        ArrayList<Task> tasks = taskManager.readTasksFromFile();
        taskList.addAll(tasks);

        boolean close = false;
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to your Task Managing System!");

        while (!close) {
            System.out.println("*****************************************");
            System.out.println("To Add task, please press [ A ]");
            System.out.println("To Remove an existing task, please press [ R ]");
            System.out.println("To View all your Tasks, please press [ V ]");
            System.out.println("To Close the program, please select [ E ]");

            String input = scan.nextLine();

            switch (input.toUpperCase()) {
                case "A":
                    System.out.println("Enter task details:");
                    System.out.print("Task: ");
                    String task = scan.nextLine();
                    System.out.print("ID: ");
                    String id = scan.nextLine();
                    System.out.print("Description: ");
                    String description = scan.nextLine();
                    Task newTask = new Task(task, id, description);
                    taskManager.addTask(newTask);
                    taskList.add(newTask); // Add the new task to the list
                    break;

                case "R":
                    System.out.println("Enter the I.D. of the Task you want to remove");
                    String removeID = scan.nextLine();
                    taskManager.TaskRemove(removeID);
                    // Update the task list after removal
                    taskList = taskManager.displayList();
                    break;

                case "V":
                    System.out.println("Task List:");
                    for (Task t : taskList) {
                        System.out.println(t.getTask() + " | " + t.getId() + " | " + t.getDescription());
                    }
                    break;

                case "E":
                    taskManager.saveTasksToFile(taskList);
                    System.out.println("Thank you for using the Task Managing System!");
                    System.out.println("******** Program Exited ********");
                    close = true;
                    break;

                default:
                    System.out.println("ERROR! Invalid Input.");
            }
        }
        scan.close();
    }
}
