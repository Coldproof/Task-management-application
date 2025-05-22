package com.meritek.task.management.app.controller;

import com.meritek.task.management.app.model.TaskEnum;
import com.meritek.task.management.app.model.Task;
import com.meritek.task.management.app.service.TaskService;//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAll());
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping
    public ResponseEntity addTask(@RequestBody Task task) {

        if(task.getStatus()==null){
            task.setStatus(TaskEnum.TODO);
        }
        return ResponseEntity.ok(taskService.addTask(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return ResponseEntity.ok(taskService.updateTask(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity <Task> updateTaskStatus(
        @PathVariable Long id,
        @RequestBody TaskEnum status){
        return ResponseEntity.ok(taskService.updateTaskStatus(id,status));
    }
}
