package jp.promari.watching_over.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "shortcut.api")
public class ShortcutProperties {

    private String token;
    private String url;

    public ShortcutProperties() {}

    public ShortcutProperties(String token, String url) {
        this.token = token;
        this.url = url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShortcutProperties that = (ShortcutProperties) o;

        if (!token.equals(that.token)) return false;
        return url.equals(that.url);
    }

    @Override
    public int hashCode() {
        int result = token.hashCode();
        result = 31 * result + url.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ShortcutProperties{" +
                "token='" + token + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
