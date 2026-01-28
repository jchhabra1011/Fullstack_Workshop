package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Mono<Task> createTask(Task task) {
        return repository.save(task);
    }

    // READ ALL
    public Flux<Task> getAllTasks() {
        return repository.findAll();
    }

    // READ BY ID
    public Mono<Task> getTaskById(Long id) {
        return repository.findById(id);
    }

    // UPDATE
    public Mono<Task> updateTask(Long id, String title, String desc) {
        return repository.findById(id)
                .flatMap(task -> {
                    task.setTitle(title);
                    task.setDescription(desc);
                    return repository.save(task);
                });
    }

    // DELETE
    public Mono<Void> deleteTask(Long id) {
        return repository.deleteById(id);
    }
}
