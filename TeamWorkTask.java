package taskManagementSystem;

public class TeamWorkTask extends WorkTask {

    private String teamName;

    public TeamWorkTask(String task, String id, String description, String teamName) {
        super(task, id, description);
        this.teamName = teamName;
    }
    public void remindUser() {
        System.out.println("Reminder for Team Work Task: " + getTask() + " (Team: " + teamName + ")");
    }
}
