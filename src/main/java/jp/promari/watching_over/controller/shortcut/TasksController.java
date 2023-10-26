package jp.promari.watching_over.controller.shortcut;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jp.promari.watching_over.application.service.shortcut.TaskService;
import jp.promari.watching_over.domain.model.shortcut.Task;

@RestController
public class TasksController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable String id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.retrieveAllTasks();
    }
}
