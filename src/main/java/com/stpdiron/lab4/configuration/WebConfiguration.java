package com.stpdiron.lab4.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Value("${allowed.origins}")
    private String allowedOrigins;

    @Value("${allowed.headers}")
    private String allowedHeaders;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                .allowedMethods("*")
//                .allowedHeaders(allowedHeaders)
                .allowedOrigins(allowedOrigins)
                .allowCredentials(true);
    }

}