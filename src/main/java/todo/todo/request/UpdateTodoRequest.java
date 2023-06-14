package todo.todo.request;

public class UpdateTodoRequest {
  private String title;
  private boolean done;

  public String getTitle() {
    return title;
  }

  public boolean getDone() {
    return done;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDone(boolean done) {
    this.done = done;
  }
}
