package jp.promari.watching_over.domain.repository.shortcut;

import java.util.List;

import org.springframework.stereotype.Repository;

import jp.promari.watching_over.domain.model.shortcut.Task;

@Repository
public interface TaskRepository {

    Task findById(String id);

    List<Task> getAllTasks();
}
