package jp.promari.watching_over.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // @formatter:off

        // アクセス権限に関する設定
        http
            .authorizeHttpRequests(
                // /はアクセス制限をかけない
                // // /adminはADMINロールを持つユーザだけアクセス可能
                (requests) -> {
                    requests.requestMatchers("/login").permitAll();
                    requests.requestMatchers("/login").permitAll();
                });
                // // /userはUSERロールを持つユーザだけアクセス可能
                // .requestMatchers("/user").hasRole("USER")
                // それ以外のページは認証が必要
                //.anyRequest().authenticated()
            // ).formLogin((form) -> form
            //     // ログインを実行するページを指定。
            //     // この設定だと/にPOSTするとログイン処理を行う
            //     .loginProcessingUrl("/")
            //     // ログイン画面の設定
            //     .loginPage("/")
            //     // ログインに失敗した場合の遷移先
            //     .failureUrl("/")
            //     // ユーザIDとパスワードのname設定
            //     .usernameParameter("username")
            //     .passwordParameter("password")
            //     // ログインに成功した場合の遷移先
            //     .defaultSuccessUrl("/common", true)
            // ).logout((form) -> form
            //     // ログアウト処理を行うページ指定、ここにPOSTするとログアウトする
            //     .logoutUrl("/logout")
            //     // ログアウトした場合の遷移先
            //     .logoutSuccessUrl("/")
            // );

        // @formatter:on
        return http.build();
    }

    /**
     * パスワードのハッシュ化を行うアルゴリズムを返す
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
