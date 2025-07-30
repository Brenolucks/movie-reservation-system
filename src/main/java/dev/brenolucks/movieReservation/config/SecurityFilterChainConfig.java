package dev.brenolucks.movieReservation.config;

import dev.brenolucks.movieReservation.jwt.JwtAuthenticationFilter;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityFilterChainConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    public SecurityFilterChainConfig(JwtAuthenticationFilter jwtAuthenticationFilter,
                                     AuthenticationProvider authenticationProvider) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.authenticationProvider = authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        manager -> manager
                                .requestMatchers(HttpMethod.POST, "/api/register").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/login").permitAll()
                                .requestMatchers(HttpMethod.PATCH, "/api/promote-user").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/api/movie/add").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PATCH, "/api/movie/update").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/movie/delete").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.GET, "/api/all-movies").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/reserve").hasRole("USER")
                                .anyRequest().authenticated()
                )
                .sessionManagement(sessionManager -> sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }
}
