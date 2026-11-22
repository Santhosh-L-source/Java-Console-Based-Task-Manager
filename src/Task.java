public class Task {
    int id;
    String title;
    String priority;
    boolean completed;

    Task(int id, String title, String priority, boolean completed) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.completed = completed;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPriority() {
        return this.priority;
    }

    public boolean getCompleted() {
        return this.completed;
    }

    public void markCompleted() {
        this.completed = true;
    }

}