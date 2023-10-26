package jp.promari.watching_over.infrastructure.repository.shortcut;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import jp.promari.watching_over.config.shortcut.ShortcutProperties;
import jp.promari.watching_over.domain.model.shortcut.Task;
import jp.promari.watching_over.domain.repository.shortcut.TaskRepository;

@Repository
public class ShortcutTaskRepository implements TaskRepository {

    @Autowired
    @Qualifier("shortcutProperties")
    private ShortcutProperties properties;

    @Override
    public Task findById(String id) {
        try {

            String apiToken = properties.getToken();
            String apiUrl = properties.getUrl();

            HttpClient client = HttpClients.createDefault();
            HttpGet request = new HttpGet(apiUrl + id);

            // ヘッダーにAPIトークンを追加
            request.setHeader("Shortcut-Token", apiToken);
            HttpResponse response = client.execute(request);
            String responseBody = EntityUtils.toString(response.getEntity());
            JSONObject jsonObject = new JSONObject(responseBody);

            // JSONオブジェクトからタスクの情報を取得
            Task task = new Task();
            task.setId(jsonObject.getString("id"));
            task.setName(jsonObject.getString("name"));
            task.setDescription(jsonObject.getString("description"));

            return task;
        } catch (Exception e) {
            throw new RuntimeException("タスクの取得に失敗しました。", e);
        }
    }
}
