package cookie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .securityMatcher("/**")
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/users/**").permitAll()
                .anyRequest().authenticated()
            )
            .csrf(csrf -> csrf.disable())       
            .httpBasic(httpBasic -> httpBasic.disable())
            .formLogin(form -> form.disable());   
        return http.build();
    }
}
