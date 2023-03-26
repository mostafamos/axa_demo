package jp.co.axa.apidemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity

public class SecurityConfig {
    //so ideally we need jwt and oauth 2.0 but for the interview purpose
    //lets permit authenticated users and allow them to use the endpoint posts 
    //use username: mos and password: 123
    //if i get the job i can implement oAuth2.0 wich is much safer
    //Protect controller end points
@Bean
public BCryptPasswordEncoder passwordEncoder() {
    
        return new BCryptPasswordEncoder();
    }

@Bean
public UserDetailsService userDetailsService() {
    return new InMemoryUserDetailsManager(
        User.withUsername("mos")
            .password(this.passwordEncoder().encode("123"))
            .roles("USER")
            .build()
    );
}


protected void configure(HttpSecurity http) throws Exception {
    
    http
        //application security
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/api/id/**", "/csrf","/swagger-resources/configuration/ui", "/swagger-resources", "/swagger-ui.html").permitAll()
        .anyRequest().authenticated().and().build();
  
}


}
