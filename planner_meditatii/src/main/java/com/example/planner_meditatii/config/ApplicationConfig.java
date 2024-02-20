package com.example.planner_meditatii.config;

import com.example.planner_meditatii.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Aceasta clasa configurează autentificarea utilizatorilor în aplicația Spring Boot, utilizând un serviciu personalizat
 * de detalii al utilizatorului, un furnizor de autentificare care utilizează acest serviciu și un encoder de parole
 * puternic.
 * Aceste configurații sunt esențiale pentru a asigura securitatea și autentificarea utilizatorilor în aplicație.
 */
@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UserRepository repository;
    //UserDetailsService se ocupa cu incarcarea datelor despre utilizator in baza de date

    /**
     * Această metodă este folosită pentru a obține detaliile unui utilizator atunci când se efectuează autentificarea
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService(){
        return username -> repository.findByEmail(username)
                .orElseThrow(() ->new  UsernameNotFoundException("User not found!"));
    }

    /**
     * Acest bean este folosit pentru a valida cererile de autentificare ale utilizatorilor în aplicație.
     * @return
     */
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    /**
     * Acest bean este folosit pentru a cripta parolele utilizatorilor
     * înainte de a le stoca în baza de date și pentru a valida parolele în timpul procesului de autentificare.
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * AuthenticationManager este o interfață din Spring Security care este folosită pentru autentificarea
     * utilizatorilor. Aceasta primește un obiect Authentication care conține informațiile de autentificare
     * ale utilizatorului.
     * @param config
     * @return Returnează un obiect Authentication autentificat, dacă autentificarea este reușită
     * @throws Exception
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

}
