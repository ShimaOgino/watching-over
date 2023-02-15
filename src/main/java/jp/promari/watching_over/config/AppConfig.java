package jp.promari.watching_over.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@EnableAspectJAutoProxy
@PropertySource("classpath:application.properties")
public class AppConfig {

    /**
     *
     * プレースホルダーの登録
     * これを明示的に書かないとプロパティのプレースホルダーが使えない
     *
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
