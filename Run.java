package taskManagementSystem;

import java.io.IOException;

public class Run {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        TaskManager taskManager = new TaskManager();

        try {
           taskManager.readTasksFromFile(); // Correct method call
        } catch (IOException e) {
            System.out.println("Error loading tasks from file: " + e.getMessage());
        } catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
               taskManager.saveTasksToFile(taskManager.taskList); // Correct method call
            } catch (IOException e) {
                System.out.println("Error saving tasks to file: " + e.getMessage());
            }
        }));

        TextGUI textGUI = new TextGUI(taskManager);
        textGUI.TextInterface();
    }
}
