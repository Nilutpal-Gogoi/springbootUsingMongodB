package com.learning.springbootmongodb.controller;

import com.learning.springbootmongodb.model.Task;
import com.learning.springbootmongodb.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getTasks(){
        return taskService.findAllTask();
    }

    @GetMapping("/{taskId}")
    public Task getTask(@PathVariable String taskId){
        return taskService.getTaskByTaskId(taskId);
    }

    @GetMapping("/severity/{severity}")
    public List<Task> findTaskBySeverity(@PathVariable int severity){
        return taskService.getTaskBySeverity(severity);
    }

    @GetMapping("/assignee/{assignee}")
    public List<Task> findTaskByAssignee(@PathVariable String assignee){
        return taskService.getTaskByAssignee(assignee);
    }

    @PutMapping
    public Task modifyTask(@RequestBody Task task){
        return taskService.updateTask(task);
    }

    @DeleteMapping("/{taskId}")
    public String deleteTask(@PathVariable String taskId){
        return taskService.deleteTask(taskId);
    }
}
