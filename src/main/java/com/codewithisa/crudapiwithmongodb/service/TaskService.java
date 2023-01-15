package com.codewithisa.crudapiwithmongodb.service;

import com.codewithisa.crudapiwithmongodb.entity.Task;

import java.util.List;

public interface TaskService {
    Task saveTask(Task task);
    List<Task> getAllTasks();
    Task getTaskById(String id);
    List<Task> getTaskBySeverity(int severity);
    List<Task> getTaskByAssignee(String assignee);
    Task updateTask(String id, Task task);
    void deleteTask(String id);
}
