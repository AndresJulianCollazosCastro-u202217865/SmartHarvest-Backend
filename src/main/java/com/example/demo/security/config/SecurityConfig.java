package com.example.demo.security.config;



import com.example.demo.security.filters.JwtRequestFilter;
import com.example.demo.security.services.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;
    private final JwtRequestFilter jwtRequestFilter;

    public SecurityConfig(CustomUserDetailsService userDetailsService, JwtRequestFilter jwtRequestFilter) {
        this.userDetailsService = userDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/SmartHarvest/authenticate").permitAll()
                        .requestMatchers(HttpMethod.POST, "/SmartHarvest/user").permitAll()
                        .requestMatchers(HttpMethod.GET, "/SmartHarvest/dashboard").permitAll()

                        // Costos
                        .requestMatchers(HttpMethod.POST, "/SmartHarvest/costos").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/SmartHarvest/costos/**").hasAnyRole("USER", "ADMIN")

                        // Cultivos
                        .requestMatchers(HttpMethod.POST, "/SmartHarvest/cultivos").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/SmartHarvest/cultivos/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/SmartHarvest/cultivos/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/SmartHarvest/cultivos/**").hasAnyRole("USER", "ADMIN")

                        .requestMatchers(HttpMethod.POST, "/SmartHarvest/historical-data").hasAnyRole("USER", "ADMIN")

                        .requestMatchers(HttpMethod.POST, "/SmartHarvest/learning-resources").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/SmartHarvest/learning-resources/**").hasAnyRole("USER", "ADMIN")

                        // Recommendations
                        .requestMatchers(HttpMethod.POST, "/SmartHarvest/recommendations").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/SmartHarvest/recommendations").hasAnyRole("USER", "ADMIN")

                        // Supplies
                        .requestMatchers(HttpMethod.GET, "/SmartHarvest/supplies/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/SmartHarvest/supplies").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/SmartHarvest/supplies/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/SmartHarvest/supplies/**").hasAnyRole("USER", "ADMIN")

                        // Support
                        .requestMatchers(HttpMethod.POST, "/SmartHarvest/support").hasAnyRole("USER", "ADMIN")

                        // Alertas
                        .requestMatchers(HttpMethod.GET, "/SmartHarvest/alertas/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/SmartHarvest/alertas").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/SmartHarvest/alertas/logical-delete/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/SmartHarvest/alertas/**").hasAnyRole("USER", "ADMIN")

                        // Rol de asignación
                        .requestMatchers(HttpMethod.POST, "/SmartHarvest/assign-role/**").hasRole("ADMIN")

                        // Todas las demás deben estar autenticadas
                        .requestMatchers("/SmartHarvest/**").authenticated()
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}
