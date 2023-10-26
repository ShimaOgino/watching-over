package jp.promari.watching_over.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties
public class PromariProperties {
    @Qualifier("app.auth.username")
    private String username;
    @Qualifier("app.auth.password")
    private String password;
    @Qualifier("shortcut.api.token")
    private String token;
    @Qualifier("shortcut.api.url")
    private String url;
}
