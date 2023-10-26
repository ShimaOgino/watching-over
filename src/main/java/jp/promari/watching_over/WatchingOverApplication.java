package jp.promari.watching_over;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import jp.promari.watching_over.config.shortcut.ShortcutProperties;

@SpringBootApplication
@EnableConfigurationProperties(ShortcutProperties.class)
public class WatchingOverApplication {

	public static void main(String[] args) {
		SpringApplication.run(WatchingOverApplication.class, args);
	}
}
