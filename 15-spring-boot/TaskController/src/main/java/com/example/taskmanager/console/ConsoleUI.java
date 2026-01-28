package com.example.taskmanager.console;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleUI implements CommandLineRunner {

    private final TaskService taskService;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleUI(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public void run(String... args) {

        while (true) {
            System.out.println("\n=== TASK MANAGER ===");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> updateTask();
                case 4 -> deleteTask();
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void addTask() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter description: ");
        String desc = scanner.nextLine();

        taskService.createTask(new Task(title, desc)).block();

        System.out.println("Task added!");
    }

    private void viewTasks() {
        taskService.getAllTasks()
                .doOnNext(System.out::println)
                .blockLast();
    }

    private void updateTask() {
        System.out.print("Enter task id: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Enter new title: ");
        String title = scanner.nextLine();

        System.out.print("Enter new description: ");
        String desc = scanner.nextLine();

        taskService.updateTask(id, title, desc).block();
        System.out.println("Task updated!");
    }

    private void deleteTask() {
        System.out.print("Enter task id: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        taskService.deleteTask(id).block();
        System.out.println("Task deleted!");
    }
}
