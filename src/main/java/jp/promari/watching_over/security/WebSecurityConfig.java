// package jp.promari.watching_over.security;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// //import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// //import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// import jp.promari.watching_over.security.jwt.AuthEntryPointJwt;
// import jp.promari.watching_over.security.jwt.AuthTokenFilter;
// import jp.promari.watching_over.security.services.UserDetailsServiceImpl;

// @Configuration
// @EnableMethodSecurity(
//     // securedEnabled = true, Secured アノテーションを有効にする
//     // jsr250Enabled = true,  JSR-250 アノテーションを有効にする
//     prePostEnabled = true) //Spring Security の PreAuthorize、PostAuthorize、PreFilter、PostFilter アノテーションを有効にする
// public class WebSecurityConfig { // SecurityFilterChain をBean定義してセキュリティ設定
//     @Autowired
//     UserDetailsServiceImpl userDetailService;

//     @Autowired
//     private AuthEntryPointJwt unauthorizedHandler;

//     @Bean
//     public AuthTokenFilter authenticationJwtTokenFilter() {
//         return new AuthTokenFilter();
//     }

//     @Bean
//     public DaoAuthenticationProvider authenticationProvider() {
//         DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

//         authProvider.setUserDetailsService(userDetailsService);
//         authProvider.setPasswordEncoder(passwordEncoder());

//         return authProvider;
//     }

//     @Bean
//     public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
//         return authConfig.getAuthenticationManager();
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         http.cors().and().csrf().disable()
//             .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//             .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//             .authorizeRequests().antMatchers("/api/auth/**").permitAll()
//             .antMatcher("/api/test/**").permitAll()
//             .anyRequest().authenticated();

//         http.authenticationProvider(authenticationProvider());

//         http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

//         return http.build();

//     }
// }
