public class Task {
    private int id;
    private String title;
    private String category;
    private boolean completed;
    private Priority priority;

    Task(int id, String title, Priority priority, String category, boolean completed) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.completed = completed;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getCategory() {
        return category;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted(boolean completed) {
        this.completed = completed;
    }

}