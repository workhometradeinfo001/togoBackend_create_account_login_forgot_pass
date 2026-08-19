package com.togo.login_rf.config;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration(proxyBeanMethods = false)
public class CorsConfig {

    @Value("${app.value.link}")
    private String frontEndOrigin;

    @Bean
    public WebMvcConfigurer corsConfigure(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NonNull CorsRegistry registry) {
                WebMvcConfigurer.super.addCorsMappings(registry);
                registry.addMapping("/**")
                        //Frontend side
                        .allowedOrigins("http://localhost:5173", frontEndOrigin)
                        //Api Call
                        .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS")
                        //Auth of JWT
                        .allowedHeaders("*")
                        //For cookie or HttpSecure session
                        .allowCredentials(true);
            }
        };
    }

}
