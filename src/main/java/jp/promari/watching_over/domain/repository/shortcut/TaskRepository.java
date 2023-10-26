package jp.promari.watching_over.domain.repository.shortcut;

import java.util.List;

import jp.promari.watching_over.domain.model.shortcut.Task;

public interface TaskRepository {

    Task findById(String id);

    List<Task> getAllTasks();
}
