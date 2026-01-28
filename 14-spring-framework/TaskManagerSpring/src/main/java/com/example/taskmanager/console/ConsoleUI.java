package com.example.taskmanager.console;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.taskmanager.entity.Task;
import com.example.taskmanager.service.TaskService;

@Component
public class ConsoleUI implements CommandLineRunner {

    private final TaskService taskService;

    public ConsoleUI(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public void run(String... args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== TASK MANAGER =====");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. View Task By ID");
            System.out.println("4. Update Task");
            System.out.println("5. Delete Task");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addTask(sc);
                case 2 -> viewAllTasks();
                case 3 -> viewTaskById(sc);
                case 4 -> updateTask(sc);
                case 5 -> deleteTask(sc);
                case 0 -> {
                    System.out.println("Exiting Task Manager...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private void addTask(Scanner sc) {
        System.out.print("Enter task title: ");
        String title = sc.nextLine();

        System.out.print("Enter task status: ");
        String status = sc.nextLine();

        Task task = new Task();
        task.setTitle(title);
        task.setStatus(status);

        taskService.saveTask(task);
        System.out.println("Task added successfully!");
    }

    private void viewAllTasks() {
        List<Task> tasks = taskService.getAllTasks();

        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }

        System.out.println("\n--- All Tasks ---");
        for (Task task : tasks) {
            System.out.println(task.getId() + " | " + task.getTitle() + " | " + task.getStatus());
        }
    }

    private void viewTaskById(Scanner sc) {
        System.out.print("Enter task ID: ");
        Long id = sc.nextLong();

        Task task = taskService.getTaskById(id);

        if (task == null) {
            System.out.println("Task not found!");
        } else {
            System.out.println(task.getId() + " | " + task.getTitle() + " | " + task.getStatus());
        }
    }

    private void updateTask(Scanner sc) {
        System.out.print("Enter task ID: ");
        Long id = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter new title: ");
        String title = sc.nextLine();

        System.out.print("Enter new status: ");
        String status = sc.nextLine();

        Task task = new Task();
        task.setTitle(title);
        task.setStatus(status);

        try {
            taskService.updateTask(id, task);
            System.out.println("Task updated successfully!");
        } catch (Exception e) {
            System.out.println("Task not found!");
        }
    }

    private void deleteTask(Scanner sc) {
        System.out.print("Enter task ID: ");
        Long id = sc.nextLong();

        taskService.deleteTask(id);
        System.out.println("Task deleted successfully!");
    }
}
