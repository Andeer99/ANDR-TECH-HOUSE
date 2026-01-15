package com.andrtechhouse.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class CorsConfig {
    private final List<String> allowedOrigins;

    public CorsConfig(@Value("${SPRING_CORS_ORIGINS:}") String corsOrigins) {
        if (corsOrigins == null || corsOrigins.isBlank()) {
            this.allowedOrigins = List.of(
                    "https://andr-tech-house.up.railway.app",
                    "http://localhost:5173",
                    "http://localhost:3000"
            );
        } else {
            this.allowedOrigins = Arrays.stream(corsOrigins.split(","))
                    .map(String::trim)
                    .filter(origin -> !origin.isEmpty())
                    .collect(Collectors.toList());
        }
    }
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowedOrigins(allowedOrigins);

        config.setAllowedOrigins(List.of(
                "https://andr-tech-houseup.railway.app",
                "http://localhost:5173",
                "http://localhost:3000"
        ));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowCredentials(true);
        config.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
