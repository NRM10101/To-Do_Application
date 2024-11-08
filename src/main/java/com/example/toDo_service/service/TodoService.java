package com.example.toDo_service.service;

import com.example.toDo_service.Exception.TodoNotFoundException;
import com.example.toDo_service.model.Todo;
import com.example.toDo_service.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    //functions
    public  Todo add(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    public Todo getById(Long id) {
        Optional<Todo> existingPersonOpt = todoRepository.findById(id);
        if(existingPersonOpt.isPresent())
        {
            return existingPersonOpt.get();
        }
        else{
            throw new TodoNotFoundException("Todo not found");
        }
    }

    public void deleteById(Long id) {
        Optional<Todo> existingPersonOpt = todoRepository.findById(id);
        if(existingPersonOpt.isPresent())
        {
            todoRepository.deleteById(id);
        }
        else{
            throw new TodoNotFoundException("Todo not found");
        }
    }
}
