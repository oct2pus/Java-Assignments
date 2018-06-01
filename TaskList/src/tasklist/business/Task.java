/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tasklist.business;

/**
 *
 * @author Austin LaBerta
 */
public class Task {
	private final int taskId;
	private final String description;
	private final boolean completed;
	
	public Task (int taskId, String description, boolean completed) {
		this.taskId = taskId;
		this.description = description;
		this.completed = completed;
	}
	
	public int getTaskId() {
		return taskId;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean getCompleted() {
		return completed;
	}
	
	@Override
	public String toString() {
		String output = taskId + ". " + description;
		if(completed)
			output += " (DONE!)";
		return output;
	}
}
