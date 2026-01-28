package com.example.taskmanager.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.taskmanager.entity.Task;
import com.example.taskmanager.repository.TaskRepository;

@Service
public class TaskService
{

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task saveTask(Task task)
    {
        return repository.save(task);
    }

    public List<Task> getAllTasks()
    {
        return repository.findAll();
    }

    public Task getTaskById(Long id)
    {
        return repository.findById(id).orElse(null);
    }

    public void deleteTask(Long id)
    {
        repository.deleteById(id);
    }
    public Task updateTask(Long id, Task updatedTask)
    {
        Task existingTask = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setStatus(updatedTask.getStatus());

        return repository.save(existingTask);
    }

}
