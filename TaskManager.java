package taskManagementSystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager extends Task {
    private static final String FILE_PATH = "tasks.dat";
    ArrayList<Task> taskList = new ArrayList<>();

    public TaskManager() {
    	super();
        try {
            taskList = readTasksFromFile();
        } catch (Exception e) {
            System.out.println("Error loading tasks from file: " + e.getMessage());
        }

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                saveTasksToFile(taskList);
            } catch (IOException e) {
                System.out.println("Error saving tasks to file: " + e.getMessage());
            }
        }));
    }

    public ArrayList<Task> readTasksFromFile() throws IOException, ClassNotFoundException {
        ArrayList<Task> tasks = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            tasks = (ArrayList<Task>) inputStream.readObject();
            System.out.println("Tasks loaded successfully from file: " + FILE_PATH);
        }
        return tasks;
    }

    public void saveTasksToFile(ArrayList<Task> tasks) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            outputStream.writeObject(tasks);
            System.out.println("Tasks saved successfully to file: " + FILE_PATH);
        }
    }

    public boolean addTask(Task task) {
        boolean uniqueId = true;
        for (Task t : taskList) {
            if (task.getId().equals(t.getId())) {
                System.out.println("ERROR! The Operation was unsuccessful.");
                System.out.println("Task with the same ID exists.");
                uniqueId = false;
                break;
            }
        }
        if (uniqueId) {
            taskList.add(task);
            System.out.println("Task added successfully.");
        }
        return uniqueId;
    }

    public ArrayList<Task> removeTask(String removeTaskId) {
        boolean removeFound = false;
        for (Task task : taskList) {
            if (task.getId().equals(removeTaskId)) {
                taskList.remove(task);
                removeFound = true;
                System.out.println("Task with ID: " + removeTaskId + " has been successfully removed.");
                break;
            }
        }
        if (!removeFound) {
            System.out.println("There is no task with the matching ID: " + removeTaskId);
        }
        return taskList;
    }

    public ArrayList<Task> displayList() {
        return taskList;
    }

    public void printTasksAndReminders() {
        System.out.println("List of Tasks:");
        for (Task task : taskList) {
            System.out.println(task.getTask() + " | " + task.getId() + " | " + task.getDescription());
            if (task instanceof Remindable) {
                ((Remindable) task).remindUser();
            }
        }
    }

	public void TaskRemove(String removeID) {
		
	}
}