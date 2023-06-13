package todo.todo.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import todo.todo.core.model.SetDoneParam;
import todo.todo.core.model.Todo;
import todo.todo.core.model.UpdateTodoParam;

@Service
public class TodoService {
  private List<Todo> data = new ArrayList<Todo>();

  public List<Todo> getTodos() {
    return data;
  }

  public Todo getTodoById(String id) {
    for (Todo todo : data) {
      if (todo.getId().equals(id)) {
        return todo;
      }
    }
    return null;
  }

  public int addTodo(Todo item) {
    data.add(item);
    return data.size();
  }

  public Todo updateTodo(String id, UpdateTodoParam payload) {
    for (int i = 0; i < data.size(); i++) {
      Todo current = data.get(i);
      if (current.getId().equals(id)) {
        Todo found = data.get(i);
        found.setTitle(payload.getTitle());
        found.setDone(payload.getDone());
        return found;
      }
    }
    return null;
  }

  public Todo setDone(String id, SetDoneParam payload) {
    for (int i = 0; i < data.size(); i++) {
      Todo current = data.get(i);
      if (current.getId().equals(id)) {
        Todo found = data.get(i);
        found.setDone(payload.getDone());
        return found;
      }
    }
    return null;
  }

  public boolean deleteTodo(String id) {
    return data.removeIf(t -> t.getId().equals(id));
  }
}
