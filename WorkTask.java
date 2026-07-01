package taskManagementSystem;

public class WorkTask extends Task implements Remindable {

    public WorkTask(String task, String id, String description) {
        super(task, id, description);
    }

    @Override
    public void remindUser() {
        System.out.println("Reminder for Work Task: " + getTask());
    }
}
