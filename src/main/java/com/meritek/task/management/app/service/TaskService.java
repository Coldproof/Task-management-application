package com.meritek.task.management.app.service;

import com.meritek.task.management.app.model.Task;
import com.meritek.task.management.app.repository.TaskRepository;
import org.springframework.stereotype.Service;

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

    public Task addTask(Task task) {
        return this.taskRepository.save(task);
    }
}
