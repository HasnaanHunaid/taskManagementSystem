package taskManagementSystem;
import java.io.Serializable;

public class Task implements Serializable {
    private String id;
    private String task;
    private String description;

    public Task(String task, String id, String description) {
        this.task = task;
        this.id = id;
        this.description = description;
    }

    public Task() {
	}

	public String getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public String getDescription() {
        return description;
    }
}