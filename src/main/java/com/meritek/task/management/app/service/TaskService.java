package com.meritek.task.management.app.service;

import com.meritek.task.management.app.model.Task;
import com.meritek.task.management.app.model.TaskEnum;
import com.meritek.task.management.app.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAll() {
        return this.taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task with id " + id + " not found"));
    }

    public Task addTask(Task task) {
        if(task.getStatus()==null) {
             task.setStatus(TaskEnum.TODO);
        }
        taskRepository.save(task);
        return taskRepository.findById(task.getId()).get();
    }

    public Task updateTask(Task task) {
        Task existingTask = getTaskById(task.getId());
        existingTask.setName(task.getName());
        existingTask.setDescription(task.getDescription());
        existingTask.setStatus(task.getStatus());
        existingTask.setAuthors(task.getAuthors());
        existingTask.setCategory(task.getCategory());

        return taskRepository.save(existingTask);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task updateTaskStatus(Long id, TaskEnum status) {
        Task task = getTaskById(id);
        task.setStatus(status);
        return taskRepository.save(task);
    }
}
