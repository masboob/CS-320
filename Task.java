/*******************
 * Elana Masboob
 * CS 320
 * Project 1
 * -> Task
 *      -> Task.java
 * This is the task class that creates and stores [task] information
 *******************/
 
package Task;

import java.util.concurrent.atomic.AtomicLong;

public class Task {
    private final String taskID;
    private String taskName;
    private String taskDesc;
    private static AtomicLong idGenerator = new AtomicLong();

    // CONSTRUCTORS
    public Task(String taskName, String taskDesc) {
        this(String.valueOf(idGenerator.getAndIncrement()), taskName, taskDesc);
    }

    public Task(String taskID, String taskName, String taskDesc) {
        if (taskID == null || taskID.isEmpty()) {
            throw new IllegalArgumentException("Invalid Task ID");
        }
        // Add other verifications for taskID

        if (taskName == null || taskName.isEmpty()) {
            this.taskName = "NULL";
        } else if (taskName.length() > 20) {
            throw new IllegalArgumentException("Task name cannot exceed 20 characters in length.");
        } else {
            this.taskName = taskName;
        }

        if (taskDesc == null || taskDesc.isEmpty()) {
            this.taskDesc = "NULL";
        } else if (taskDesc.length() > 50) {
            throw new IllegalArgumentException("Task description cannot exceed 50 characters in length.");
        } else {
            this.taskDesc = taskDesc;
        }
    }

    // GETTERS
    public String getTaskID() {
        return taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    // SETTERS
    public void setTaskName(String taskName) {
        if (taskName == null || taskName.isEmpty()) {
            this.taskName = "NULL";
        } else if (taskName.length() > 20) {
            throw new IllegalArgumentException("Task name cannot exceed 20 characters in length.");
        } else {
            this.taskName = taskName;
        }
    }

    public void setTaskDesc(String taskDesc) {
        if (taskDesc == null || taskDesc.isEmpty()) {
            this.taskDesc = "NULL";
        } else if (taskDesc.length() > 50) {
            throw new IllegalArgumentException("Task description cannot exceed 50 characters in length.");
        } else {
            this.taskDesc = taskDesc;
        }
    }
}
