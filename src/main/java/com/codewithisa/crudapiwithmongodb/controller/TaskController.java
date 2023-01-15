package com.codewithisa.crudapiwithmongodb.controller;

import com.codewithisa.crudapiwithmongodb.entity.Task;
import com.codewithisa.crudapiwithmongodb.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping
    public ResponseEntity<?> addTask(@RequestBody Task task){
        return new ResponseEntity<>(taskService.saveTask(task), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllTasks(){
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable("id") String id){
        return new ResponseEntity<>(taskService.getTaskById(id), HttpStatus.OK);
    }

    @GetMapping("/severity/{severity}")
    public ResponseEntity<?> getTaskBySeverity(@PathVariable("severity") Integer severity){
        return new ResponseEntity<>(taskService.getTaskBySeverity(severity), HttpStatus.OK);
    }

    @GetMapping("/assignee/{assignee}")
    public ResponseEntity<?> getTaskByAssignee(@PathVariable("assignee") String assignee){
        return new ResponseEntity<>(taskService.getTaskByAssignee(assignee), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable("id") String id, @RequestBody Task task){
        return new ResponseEntity<>(taskService.updateTask(id, task), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable("id") String id){
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
