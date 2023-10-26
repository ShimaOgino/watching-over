package jp.promari.watching_over.domain.repository.shortcut;

import jp.promari.watching_over.domain.model.shortcut.Task;

public interface TaskRepository {

    Task findById(String id);

}
