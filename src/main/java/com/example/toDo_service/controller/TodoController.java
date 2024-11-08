package com.example.toDo_service.controller;

import com.example.toDo_service.Exception.TodoNotFoundException;
import com.example.toDo_service.model.Todo;
import com.example.toDo_service.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TodoController {
    private final TodoService todoService;

    public static final Logger LOG = LoggerFactory.getLogger(TodoController.class);

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    //add a task to the database
    @PostMapping
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo){
        try{
            Todo savedTodo = todoService.add(todo);
            return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
        }catch (Exception e){
            LOG.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //get all the tasks
    @GetMapping
    public ResponseEntity<List<Todo>> getAll(){
        try{
            List<Todo> allTasks = todoService.getAll();
            return new ResponseEntity<>(allTasks, HttpStatus.OK);
        }catch (Exception e) {
            LOG.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //Retrieve details of a specific task by ID.
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTaskById(@PathVariable Long id){
        try{
            Todo person = todoService.getById(id);
            return new ResponseEntity<>(person, HttpStatus.OK);
        }
        catch (TodoNotFoundException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            LOG.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Delete a task by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable Long id){
        try{
            todoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            LOG.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Update a task by ID



}
