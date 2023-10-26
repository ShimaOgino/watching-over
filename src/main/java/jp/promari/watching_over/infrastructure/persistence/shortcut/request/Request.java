package jp.promari.watching_over.infrastructure.persistence.shortcut.request;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.promari.watching_over.config.shortcut.ShortcutProperties;

@Component
public class Request {

    private final HttpClient client = HttpClients.createDefault();

    @Autowired
    private ShortcutProperties properties;

    public JSONArray execute(String url) {
        try {
            HttpGet request = new HttpGet(properties.getUrl() + "/" + url);
            request.setHeader("Shortcut-Token", properties.getToken());
            HttpResponse response = client.execute(request);
            String responseBody = EntityUtils.toString(response.getEntity());
            return new JSONArray(responseBody);
        } catch (Exception e) {
            throw new RuntimeException("APIリクエストに失敗しました。", e);
        }
    }
}
