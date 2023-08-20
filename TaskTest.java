/*******************
 * Elana Masboob
 * CS 320
 * Project 1
 * -> Task
 *      -> TaskTest.java
 * This is the test class for Task
 *******************/
 
package Task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    void testConstructorWithValidValues() {
        String taskID = "123";
        String taskName = "Task Name";
        String taskDesc = "Task Description";

        Task task = new Task(taskID, taskName, taskDesc);

        assertEquals(taskID, task.getTaskID());
        assertEquals(taskName, task.getTaskName());
        assertEquals(taskDesc, task.getTaskDesc());
    }

    @Test
    void testConstructorWithInvalidTaskID() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Task Name", "Task Description");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Task("", "Task Name", "Task Description");
        });
    }

    @Test
    void testConstructorWithLongTaskName() {
        String taskID = "123";
        String longTaskName = "This is a very long task name that exceeds the limit of 20 characters.";

        assertThrows(IllegalArgumentException.class, () -> {
            new Task(taskID, longTaskName, "Task Description");
        });
    }

    @Test
    void testConstructorWithLongTaskDesc() {
        String taskID = "123";
        String longTaskDesc = "This is a very long task description that exceeds the limit of 50 characters.";

        assertThrows(IllegalArgumentException.class, () -> {
            new Task(taskID, "Task Name", longTaskDesc);
        });
    }

    @Test
    void testSetTaskName() {
        String taskID = "123";
        String taskName = "Task Name";
        Task task = new Task(taskID, taskName, "Task Description");

        task.setTaskName("New Task Name");
        assertEquals("New Task Name", task.getTaskName());

        assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskName("This is a very long task name that exceeds the limit of 20 characters.");
        });
    }

    @Test
    void testSetTaskDesc() {
        String taskID = "123";
        String taskDesc = "Task Description";
        Task task = new Task(taskID, "Task Name", taskDesc);

        task.setTaskDesc("New Task Description");
        assertEquals("New Task Description", task.getTaskDesc());

        assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskDesc("This is a very long task description that exceeds the limit of 50 characters.");
        });
    }
}
