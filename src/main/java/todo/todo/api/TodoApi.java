package todo.todo.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import todo.todo.core.model.CreateTodoParam;
import todo.todo.core.model.SetDoneParam;
import todo.todo.core.model.Todo;
import todo.todo.core.model.UpdateTodoParam;
import todo.todo.core.service.TodoService;

@RestController
public class TodoApi {
  private TodoService todoService = new TodoService();

  @GetMapping("/todo")
  public List<Todo> getTodos() {
    List<Todo> todos = todoService.getTodos();
    return todos;
  }

  @GetMapping("/todo/{id}")
  public Todo getTodo(@PathVariable("id") String id) {
    Todo todo = todoService.getTodoById(id);
    return todo;
  }

  @PostMapping("/todo")
  public Todo addTodo(@RequestBody CreateTodoParam payload) {
    String title = payload.getTitle();
    Todo item = new Todo(title);
    todoService.addTodo(item);
    return item;
  }

  @PutMapping("/todo/{id}")
  public Todo updateTodo(
    @PathVariable("id") String id,
    @RequestBody UpdateTodoParam payload) {
    return todoService.updateTodo(id, payload);
  }

  @PatchMapping("/todo/{id}/done")
  public Todo setTodoDone(
    @PathVariable("id") String id,
    @RequestBody SetDoneParam payload) {
    return todoService.setDone(id, payload);
  }

  @DeleteMapping("/todo/{id}")
  public boolean deleteTodo(@PathVariable String id) {
    return todoService.deleteTodo(id);
  }
}
