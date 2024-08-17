public class Deadline extends Task{
    public Deadline(String description) {
        super(description);
    }

    @Override
    public String getTaskTypeIcon() {
        return "[D]";
    }

    @Override
    public TaskType getTaskType() {
        return TaskType.DEADLINE;
    }
}
