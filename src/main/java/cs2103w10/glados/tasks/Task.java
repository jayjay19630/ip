package cs2103w10.glados.tasks;

import cs2103w10.glados.enums.TaskType;

public abstract class Task {

    /* Description and boolean for task being done */
    protected String description;
    protected boolean isDone;

    /**
     * Constructs task and sets description.
     * By default not marked as done.
     * 
     * @param description
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Return task type icon.
     * 
     * @return Icon in the form [...].
     */
    public abstract String getTaskTypeIcon();

    /**
     * Return task type enum.
     * 
     * @return Task enum.
     */
    public abstract TaskType getTaskType();

    /**
     * Return task description.
     * 
     * @return Task description.
     */
    public abstract String getDescription();

    /**
     * Return task description to be saved in data file.
     * 
     * @return Task description in save format.
     */
    public abstract String getSaveFormat();

    /**
     * Returns status.
     * 
     * @return Current status of task.
     */
    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]"); 
    }

    /**
     * Returns whether task is done.
     * 
     * @return Task is done boolean.
     */
    public boolean getIsDone() {
        return this.isDone;
    }

    /**
     * Mark task as done. 
     */
    public void mark() {
        this.isDone = true;
    }

    /**
     * Unmark task as done. 
     */
    public void unmark() {
        this.isDone = false;
    }

    /**
     * Return string representation of task.
     */
    @Override
    public String toString() {
        return this.getTaskTypeIcon() + this.getStatusIcon() + " " + this.getDescription();
    }
}
