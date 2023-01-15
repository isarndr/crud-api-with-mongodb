package com.codewithisa.crudapiwithmongodb.service;

import com.codewithisa.crudapiwithmongodb.entity.Task;
import com.codewithisa.crudapiwithmongodb.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    TaskRepository taskRepository;

    public Task saveTask(Task task){
        task.setId(UUID.randomUUID().toString().split("-")[0]);
        return taskRepository.save(task);
    };

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(String id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public List<Task> getTaskBySeverity(int severity) {
        return taskRepository.findBySeverity(severity);
    }

    @Override
    public List<Task> getTaskByAssignee(String assignee) {
        return taskRepository.getTasksByAssignee(assignee);
    }

    @Override
    public Task updateTask(String id, Task task) {
        Task existingTask = taskRepository.findById(id).get();

        existingTask.setAssignee(task.getAssignee());
        existingTask.setDescription(task.getDescription());
        existingTask.setSeverity(task.getSeverity());
        existingTask.setStoryPoint(task.getStoryPoint());

        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }


}
