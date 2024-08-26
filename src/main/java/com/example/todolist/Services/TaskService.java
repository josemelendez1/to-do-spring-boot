package com.example.todolist.Services;

import com.example.todolist.Models.Task; 
import com.example.todolist.Repositories.TaskRepository; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
  
import java.util.List; 
  
@Service
public class TaskService { 
    @Autowired
    private TaskRepository taskRepository; 
      
    public Task createNewTask(Task task) { 
        return taskRepository.save(task); 
    } 
      
    public List<Task> getAllTask() { 
        return taskRepository.findAll(); 
    } 
      
    public Task findTaskById(Long id) { 
        return taskRepository.getById(id); 
    }
      
    public void deleteTask(Task task) { 
        taskRepository.delete(task); 
    } 
      
    public Task updateTask(Task task) { 
        return taskRepository.save(task); 
    } 
} 