/*******************
 * Elana Masboob
 * CS 320
 * Project 1
 * -> Task
 *      -> TaskService.java
 * TaskService class maintains tasks and has capabilities to do the following:
 * add, update, and delete task
 *******************/
 
package Task;

import java.util.ArrayList;

public class TaskService {
    // Start with an ArrayList of contacts to hold the list of tasks
    private ArrayList<Task> taskList = new ArrayList<Task>();

    // Adds a new task to the taskList.
    public void addTask(Task task) {
        taskList.add(task);
    }

    // Using Task ID, return a task object
    // If a matching Task ID is not found, return null
    public Task getTask(String taskID) {
        for (Task task : taskList) {
            if (task.getTaskID().equals(taskID)) {
                return task;
            }
        }
        return null;
    }

    // Delete task.
    // Use the taskID to find the right task to delete from the list
    // If the task with the given ID is not found, do nothing
    public void deleteTask(String taskID) {
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getTaskID().equals(taskID)) {
                taskList.remove(i);
                break;
            }
        }
    }

    // Update the task name based on the taskID.
    public boolean updateTaskNameById(String taskID, String name) {
        for (Task task : taskList) {
            if (task.getTaskID().equals(taskID)) {
                task.setTaskName(name);
                return true;
            }
        }
        return false;
    }

    // Update the task description based on the taskID.
    public boolean updateTaskDescriptionById(String taskID, String description) {
        for (Task task : taskList) {
            if (task.getTaskID().equals(taskID)) {
                task.setTaskDesc(description);
                return true;
            }
        }
        return false;
    }
}
