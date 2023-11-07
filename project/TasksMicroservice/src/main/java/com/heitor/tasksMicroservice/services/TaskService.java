package com.heitor.tasksMicroservice.services;

import com.heitor.tasksMicroservice.domain.Task.Task;
import com.heitor.tasksMicroservice.domain.Task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long taskId) {
        return taskRepository.findById(taskId);
    }

    public Task createTask(Task task) {
        // Additional logic before saving the task can be added here if necessary
        return taskRepository.save(task);
    }

    public Task updateTask(Long taskId, Task updatedTask) {
        return taskRepository.findById(taskId)
            .map(task -> {
                // Copy properties from updatedTask to the existing entity
                task.setSubject(updatedTask.getSubject());
                task.setDetailedDescription(updatedTask.getDetailedDescription());
                task.setPriority(updatedTask.getPriority());
                task.setStartDate(updatedTask.getStartDate());
                task.setEndDate(updatedTask.getEndDate());
                task.setEstimatedHours(updatedTask.getEstimatedHours());
                task.setActualHours(updatedTask.getActualHours());
                task.setActivityId(updatedTask.getActivityId());
                return taskRepository.save(task);
            })
            .orElseGet(() -> {
                // Handle the case where the task does not exist
                // Depending on the business logic, you could throw an exception here
                // Or perhaps return a new task if that fits the requirements
                return null;
            });
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    // Additional task-related methods can be added here
}
