package rtv.pl.rtvshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(authorizeHttpRequest -> {
            authorizeHttpRequest.requestMatchers("/cart/**").authenticated();
            authorizeHttpRequest.requestMatchers("/**").permitAll();
        });

        httpSecurity.csrf(csrf -> {
            csrf.ignoringRequestMatchers(toH2Console()).disable();
        });

        httpSecurity.formLogin(login -> {
            login.loginPage("/login");
        });

        httpSecurity.logout(logout -> {
            logout.logoutUrl("/logout");
            logout.logoutSuccessUrl("/");
        });

        httpSecurity.headers(headers -> {
            headers.frameOptions().disable();
        });

        return httpSecurity.build();
    }
}
