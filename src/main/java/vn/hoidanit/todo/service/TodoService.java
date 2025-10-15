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

    public Todo handleCreateTodo(Todo todo){
        //do something
        Todo createdTodo = this.todoRepository.save(todo);
        return createdTodo;
    }

    public void hanldeGetTodos(){
//        List<Todo> todos = this.todoRepository.findAll();
//        System.out.println("todos: " + todos);
        Optional<Todo> todoOptional = this.todoRepository.findByUsername("hoidanit2");
        if(todoOptional.isPresent()){
            System.out.println(todoOptional.get().toString());
        }
    }

    public void hanldeUpdateTodo(){
        Optional<Todo> todoOptional = this.todoRepository.findById(2L);
        if(todoOptional.isPresent()){
            Todo currentTodo = todoOptional.get();

            currentTodo.setCompleted(false);
            currentTodo.setUsername("update hoidanit");

            this.todoRepository.save(currentTodo);
        }
    }

    public void hanldeDeleteTodo(){
        this.todoRepository.deleteById(4L);
    }
}
