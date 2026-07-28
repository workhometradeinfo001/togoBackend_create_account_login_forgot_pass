package com.togo.login_rf.config;

import org.jspecify.annotations.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration(proxyBeanMethods = false)
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigure(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NonNull CorsRegistry registry) {
                WebMvcConfigurer.super.addCorsMappings(registry);
                registry.addMapping("/**")
                        //Frontend side
                        .allowedOrigins("http://localhost:5173")
                        //Api Call
                        .allowedMethods("GET", "POST", "DELETE", "UPDATE", "OPTION")
                        //Auth of JWT
                        .allowedHeaders("*")
                        //For cookie or HttpSecure session
                        .allowCredentials(true);
            }
        };
    }

}
