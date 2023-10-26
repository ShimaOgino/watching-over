package jp.promari.watching_over.application.service.shortcut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.promari.watching_over.domain.model.shortcut.Task;
import jp.promari.watching_over.domain.repository.shortcut.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task getTaskById(String id) {
        return taskRepository.findById(id);
    }
}
