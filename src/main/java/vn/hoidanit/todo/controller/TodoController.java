package vn.hoidanit.todo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.hoidanit.todo.entity.Todo;
import vn.hoidanit.todo.service.TodoService;

import java.util.List;

@RestController
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        Todo todoData = this.todoService.getTodoById(id);
        return ResponseEntity.ok().body(todoData);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getTodos() {
        List<Todo> listTodo = this.todoService.hanldeGetTodos();
        return ResponseEntity.ok().body(listTodo);
    }
    @PostMapping("/todos")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo input) {
        Todo newTodo = this.todoService.handleCreateTodo(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }

    @GetMapping("/update-todo")
    public String updateTodo() {
        this.todoService.hanldeUpdateTodo();
        return "update a todo";
    }

    @GetMapping("/delete-todo")
    public String deleteTodo() {
        this.todoService.hanldeDeleteTodo();
        return "delete a todo";
    }
}
