package vn.hoidanit.todo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.hoidanit.todo.entity.Todo;
import vn.hoidanit.todo.service.TodoService;

@RestController
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/create-todo")
    public String index() {
        Todo myTodo = new Todo("hoidanit", true);
        Todo newTodo = this.todoService.handleCreateTodo(myTodo);
        return "create todo with id " + newTodo.getId();
    }

    @GetMapping("/todos")
    public String getTodos() {
//        Todo myTodo = new Todo("hoidanit", true);
//        Todo newTodo = this.todoService.handleCreateTodo(myTodo);
        this.todoService.hanldeGetTodos();
        return "get todos";
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
