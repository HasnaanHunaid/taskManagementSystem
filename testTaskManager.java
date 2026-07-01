package taskManagementSystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestTaskManager 
{
    TaskManager testing = new TaskManager();
    
    @Test
    void testingTaskAdd()
    {
        Task task1 = new Task("Say Hi to Isa", "50819", "Greet Isa");
        assertTrue(testing.addTask(task1));
    }
    
    @Test
    void testNotAddTask() 
    {
        Task task1 = new Task("Say Hi to Isa", "50819", "Greet Isa");
        testing.addTask(task1);
        Task task2 = new Task("Stab Aarij", "50819", "Hurt Aarij");
        assertFalse(testing.addTask(task2));
    }
    
    @Test
    void testRemoveTask() 
    {
        Task task1 = new Task("Say Hi to Isa", "50819", "Greet Isa");
        testing.addTask(task1);
       
    }
    
    @Test
    void testNotRemoveTask() 
    {
        Task task1 = new Task("Say Hi to Isa", "50819", "Greet Isa");
        testing.addTask(task1);
       
    }
}
