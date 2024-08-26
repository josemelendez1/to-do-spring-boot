package com.example.todolist.Controllers;

import com.example.todolist.Models.Task; 
import com.example.todolist.Services.TaskService; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.ResponseEntity; 
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.*; 
  
import java.util.List; 
  
@Controller
@RequestMapping("/api/v1/tasks") 
public class TaskController { 
  
    @Autowired
    private TaskService taskService; 
    @GetMapping("/") 
    public ResponseEntity<List<Task>> getAllTasks() { 
        return ResponseEntity.ok(taskService.getAllTask()); 
    } 
    @PostMapping("/") 
    public ResponseEntity<Task> createTask(@RequestBody Task task) { 
        return ResponseEntity.ok(taskService.createNewTask(task)); 
    } 
    @PutMapping("/{id}") 
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) { 
        task.setId(id); 
        return ResponseEntity.ok(taskService.updateTask(task)); 
    } 
    @DeleteMapping("/{id}") 
    public ResponseEntity<Boolean> getAllTasks(@PathVariable Long id) { 
        taskService.deleteTask(taskService.findTaskById(id)); 
        return ResponseEntity.ok(true); 
    } 
}