package jp.promari.watching_over.infrastructure.persistence.shortcut;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jp.promari.watching_over.domain.model.shortcut.Task;
import jp.promari.watching_over.domain.repository.shortcut.TaskRepository;
import jp.promari.watching_over.infrastructure.persistence.shortcut.request.Request;

@Repository
public class TaskPersistence implements TaskRepository {

    @Autowired
    private Request request;

    @Override
    public List<Task> getAllTasks() {
        JSONArray jsonArray = request.execute("tasks");
        List<Task> tasks = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Task task = new Task();
            task.setId(jsonObject.getString("id"));
            task.setName(jsonObject.getString("name"));
            task.setDescription(jsonObject.getString("description"));
            tasks.add(task);
        }
        return tasks;
    }

    @Override
    public Task findById(String id) {
        JSONObject jsonObject = request.execute(id).getJSONObject(0); // 0番目の要素を取得
        Task task = new Task();
        task.setId(jsonObject.getString("id"));
        task.setName(jsonObject.getString("name"));
        task.setDescription(jsonObject.getString("description"));
        return task;
    }
}
