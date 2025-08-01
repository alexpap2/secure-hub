package authproject.secure_backend.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	http.csrf(csrf -> csrf.disable())
    	    .exceptionHandling((exception) -> exception.authenticationEntryPoint(null))
    	    .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
    	    .authorizeHttpRequests(auth -> 
    	    auth.requestMatchers("/babis/test/**").permitAll()
    	        .requestMatchers("/api/test/**").permitAll()
    	        .anyRequest().authenticated());
		return http.build();
	}
	
}
