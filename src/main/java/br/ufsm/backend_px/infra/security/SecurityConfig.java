package br.ufsm.backend_px.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final AutenticacaoFilter autenticacaoFilter;
    public SecurityConfig(AutenticacaoFilter filtro){
        this.autenticacaoFilter = filtro;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(crsf-> crsf.disable())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth->
                        auth.requestMatchers(HttpMethod.POST,"/login").permitAll()
                                .requestMatchers(HttpMethod.GET,"/home").permitAll()
                                .requestMatchers(HttpMethod.GET,"/projeto").permitAll()

                                .requestMatchers(HttpMethod.GET,"/linguagem").hasAuthority("Admin")
                                .requestMatchers(HttpMethod.POST,"/linguagem").hasAuthority("Admin")
                                .requestMatchers(HttpMethod.GET,"/tipoLinguagem").hasAuthority("Admin")
                                .requestMatchers(HttpMethod.POST,"/tipoLinguagem").hasAuthority("Admin")
                                .requestMatchers(HttpMethod.GET,"/usuario").hasAuthority("Admin")
                                .requestMatchers(HttpMethod.POST,"/usuario").hasAuthority("Admin")

                                .requestMatchers(HttpMethod.GET,"/minharede").hasAnyAuthority("Normal","Admin")
                                .requestMatchers(HttpMethod.POST,"/projeto").hasAnyAuthority("Normal","Admin")
                                .anyRequest().authenticated())
                .addFilterBefore(this.autenticacaoFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
        /*return http
                .csrf(csrf-> csrf.disable())
                .sessionManagement(sm-> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();*/
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)
            throws Exception{
        return configuration.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }}
