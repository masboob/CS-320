/*******************
 * Elana Masboob
 * CS 320
 * Project 1
 * -> Task
 *      -> TaskServiceTest.java
 * This is the test class for TaskService
 *******************/
 
package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import Task.Task;
import Task.TaskService;

class TaskServiceTest {
	
	private static TaskService taskService = new TaskService();

	@Test
	@DisplayName("Test to Update task name")
	@Order(1)
	void testUpdateTaskName() {
		taskService.addTask(new Task("Task Name", "Description"));
		taskService.updateTaskNameById("3", "Updated Task Name");
		assertEquals("Updated Task Name", taskService.getTask("3").getTaskName(), "Task name was not updated.");
	}

	@Test
	@DisplayName("Test to Update task description.")
	@Order(2)
	void testUpdateTaskDesc() {
		taskService.addTask(new Task("Task Name", "Description"));
		taskService.updateTaskDescById("1", "Updated Description");
		assertEquals("Updated Description", taskService.getTask("1").getTaskDesc(), "Task description was not updated.");
	}

	@Test
	@DisplayName("Test to ensure that service correctly deletes tasks.")
	@Order(5)
	void testDeleteTask() {
		taskService.addTask(new Task("Task Name", "Description"));
		taskService.deleteTask("0");
		// Ensure that the taskList is now empty
		assertNull(taskService.getTask("0"), "The task was not deleted.");
	}

	@Test
	@DisplayName("Test to ensure that service can add a task.")
	@Order(6)
	void testAddTask() {
		Task task = new Task("Task Name", "Description");
		taskService.addTask(task);
		assertNotNull(taskService.getTask("0"), "Task was not added correctly.");
	}
}
