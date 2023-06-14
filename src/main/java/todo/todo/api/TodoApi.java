package todo.todo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import todo.todo.model.Todo;
import todo.todo.request.CreateTodoRequest;
import todo.todo.request.SetDoneRequest;
import todo.todo.request.UpdateTodoRequest;
import todo.todo.service.TodoService;

@RestController
@RequestMapping("/todo")
public class TodoApi {
  @Autowired
  private TodoService todoService;

  @GetMapping("")
  public List<Todo> getTodos() {
    List<Todo> todos = todoService.getTodos();
    return todos;
  }

  @GetMapping("/{id}")
  public Todo getTodo(@PathVariable("id") String id) {
    Todo todo = todoService.getTodoById(id);
    return todo;
  }

  @PostMapping("")
  public Todo addTodo(@RequestBody CreateTodoRequest payload) {
    String title = payload.getTitle();
    Todo item = new Todo(title);
    todoService.addTodo(item);
    return item;
  }

  @PutMapping("/{id}")
  public Todo updateTodo(
    @PathVariable("id") String id,
    @RequestBody UpdateTodoRequest payload) {
    return todoService.updateTodo(id, payload);
  }

  @PatchMapping("/{id}/done")
  public Todo setTodoDone(
    @PathVariable("id") String id,
    @RequestBody SetDoneRequest payload) {
    return todoService.setDone(id, payload);
  }

  @DeleteMapping("/{id}")
  public boolean deleteTodo(@PathVariable String id) {
    return todoService.deleteTodo(id);
  }
}
