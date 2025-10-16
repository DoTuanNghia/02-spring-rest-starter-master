package vn.hoidanit.todo.service;

import org.springframework.stereotype.Service;
import vn.hoidanit.todo.entity.Todo;
import vn.hoidanit.todo.repository.TodoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo getTodoById(Long id){
        Optional<Todo> todoOptional = this.todoRepository.findById(id);
        return todoOptional.isPresent() ? todoOptional.get() : null;
    }

    public Todo handleCreateTodo(Todo todo){
        //do something
        Todo createdTodo = this.todoRepository.save(todo);
        return createdTodo;
    }

    public List<Todo> hanldeGetTodos(){
        return this.todoRepository.findAll();
    }

    public void hanldeUpdateTodo(Long id, Todo inputTodo){
        Optional<Todo> todoOptional = this.todoRepository.findById(id);
        if(todoOptional.isPresent()){
            Todo currentTodo = todoOptional.get();

            currentTodo.setCompleted(inputTodo.isCompleted());
            currentTodo.setUsername(inputTodo.getUsername());

            this.todoRepository.save(currentTodo);
        }
    }

    public void hanldeDeleteTodo(Long id){
        this.todoRepository.deleteById(id);
    }
}
