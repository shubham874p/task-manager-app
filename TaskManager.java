import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    static class Task {
        private final int id;
        private final String title;
        private boolean done;

        Task(int id, String title) {
            this.id = id;
            this.title = title;
            this.done = false;
        }

        public int getId() { return id; }
        public String getTitle() { return title; }
        public boolean isDone() { return done; }
        public void setDone(boolean done) { this.done = done; }

        @Override
        public String toString() {
            return "Task{id=" + id + ", title='" + title + "', done=" + done + "}";
        }
    }

    private final List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public Task addTask(String title) {
        Task task = new Task(nextId++, title);
        tasks.add(task);
        return task;
    }

    public boolean deleteTask(int taskId) {
        return tasks.removeIf(t -> t.getId() == taskId);
    }

    public boolean markDone(int taskId) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                task.setDone(true);
                return true;
            }
        }
        return false;
    }

    public List<Task> listTasks() {
        return new ArrayList<>(tasks);
    }

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.addTask("Learn Codzee");
        manager.addTask("Submit assignment");
        System.out.println(manager.listTasks());
    }
}
