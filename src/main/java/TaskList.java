import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskList = new ArrayList<>();  
    private int listIndex = 0;

    public TaskList() {
        this.taskList = Storage.loadTasks();
        this.listIndex = this.taskList.size();
    }

    public String[] add(TaskType taskType, String input) throws GladosException {
        switch (taskType) {
        case TODO:
            String[] parsedTodoInputs = Parser.parseTask(taskType, input);
            taskList.add(new Todo(parsedTodoInputs[0]));
            break;
        case EVENT:
            String[] parsedEventInputs = Parser.parseTask(taskType, input);
            taskList.add(new Event(parsedEventInputs[0], parsedEventInputs[1], parsedEventInputs[2]));
            break;
        case DEADLINE:
            String[] parsedDeadlineInputs = Parser.parseTask(taskType, input);
            taskList.add(new Deadline(parsedDeadlineInputs[0], parsedDeadlineInputs[1]));
            break;
        default:
            break;
        }
        listIndex++;
        Storage.saveTasks(taskList);
        return new String[]{taskList.get(listIndex - 1).toString(), String.valueOf(listIndex)};
    }

    public String[] delete(int index) throws TaskNotFoundException{
        if (index - 1 < 0 || index - 1 >= listIndex) {
            throw new TaskNotFoundException();
        }
        Task task = taskList.remove(index - 1);
        listIndex--;
        Storage.saveTasks(taskList);
        return new String[]{task.toString(), String.valueOf(listIndex)};
    }

    public ArrayList<Task> list() {
        return this.taskList;
    }

    public String mark(int index) {
        Task task = taskList.get(index - 1);
        task.mark();
        Storage.saveTasks(taskList);
        return task.toString();
    }

    public String unmark(int index) {
        Task task = taskList.get(index - 1);
        task.unmark();
        Storage.saveTasks(taskList);
        return task.toString();
    }
}
