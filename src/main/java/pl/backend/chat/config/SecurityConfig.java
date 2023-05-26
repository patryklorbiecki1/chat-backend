package pl.backend.chat.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
import static org.springframework.security.core.context.SecurityContextHolder.MODE_INHERITABLETHREADLOCAL;
import static org.springframework.security.core.context.SecurityContextHolder.setStrategyName;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(
        jsr250Enabled = true
)
public class SecurityConfig {

    public SecurityConfig() {
        setStrategyName(MODE_INHERITABLETHREADLOCAL);
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http,
                                           final JwtTokenFilter authJwtTokenFilter,
                                           final JwtEntryPoint unauthorizedHandler)
            throws Exception {

        final var authWhitelist = new String[]{
                "/api/user"};

        http
                .cors(withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(customizer -> customizer.sessionCreationPolicy(STATELESS))
                .exceptionHandling(exceptionHandling -> exceptionHandling.authenticationEntryPoint(unauthorizedHandler))
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/db-console/**").permitAll())
                .headers(headers ->
                        headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin).disable())

                .authorizeHttpRequests(auth ->
                        auth.requestMatchers(authWhitelist).permitAll())

                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/api/chat/**", "/api/messages/**")
                                .hasAuthority("USER"))
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .addFilterBefore(authJwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
