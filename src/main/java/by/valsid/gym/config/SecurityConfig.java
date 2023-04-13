package by.valsid.gym.config;

import by.valsid.gym.security.AccessDeniedAuthEntryPoint;
import by.valsid.gym.security.AuthEntryPoint;
import by.valsid.gym.security.AuthFilter;
import by.valsid.gym.service.GymUserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SecurityConfig {

    GymUserService gymUserService;

    AuthEntryPoint authEntryPoint;

    AccessDeniedAuthEntryPoint accessDeniedAuthEntryPoint;

    AuthFilter filter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .cors()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedAuthEntryPoint)
                .authenticationEntryPoint(authEntryPoint)
                .and()
                //.authenticationManager(new CustomAuthenticationManager(userService))
                .authorizeHttpRequests()
                .antMatchers("/auth/**", "/test/**", "/swagger-ui/**", "/swagger-ui**", "/api-docs/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, @Qualifier("major") PasswordEncoder encoder) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(gymUserService)
                .passwordEncoder(encoder)
                .and().build();
    }

    @Bean
    @Qualifier("major")
    public PasswordEncoder majorPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Qualifier("alternate")
    public PasswordEncoder alternativePasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


}



/*@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .cors()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests()
                .anyRequest()
                .permitAll()
                .and()
                .build();
    }
}*/
