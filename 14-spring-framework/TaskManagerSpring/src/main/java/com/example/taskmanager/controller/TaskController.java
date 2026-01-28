package com.example.taskmanager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.taskmanager.entity.Task;
import com.example.taskmanager.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController
{

    private final TaskService service;

    public TaskController(TaskService service)
    {
        this.service = service;
    }

    @PostMapping
    public Task addTask(@RequestBody Task task)
    {
        return service.saveTask(task);
    }

    // Get all tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }

    // Get task by id
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id)
    {
        return service.getTaskById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id)
    {
        service.deleteTask(id);
        return "Task deleted successfully";
    }
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask)
    {
        return service.updateTask(id, updatedTask);
    }

}
