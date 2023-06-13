package todo.todo.core.model;

import java.util.Date;
import java.util.UUID;

public class Todo {
  private final String id;
  private String title;
  private boolean done = false;
  private final Date createdAt;

  public Todo(String title) {
    this.id = UUID.randomUUID().toString();
    this.title = title;
    this.createdAt = new Date();
  }

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public boolean getDone() {
    return done;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDone(boolean done) {
    this.done = done;
  }
}
