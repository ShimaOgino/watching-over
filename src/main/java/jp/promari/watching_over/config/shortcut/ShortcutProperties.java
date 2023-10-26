package jp.promari.watching_over.config.shortcut;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "shortcut.api")
public class ShortcutProperties {
    private String token;
    private String url;
}
