package com.biblioteca.emprestimo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*") // ✅ permite qualquer origem (como http://localhost:5173, 5174, etc)
                .allowedMethods("*")       // GET, POST, PUT, DELETE...
                .allowedHeaders("*")
                .allowCredentials(true);   // se usar cookies/autenticação
    }
}
