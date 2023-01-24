package com.stpdiron.lab4.configuration;

import com.stpdiron.lab4.services.hit_detection.shapes.BatmanShape;
import com.stpdiron.lab4.services.hit_detection.shapes.Shape;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {

    @Bean(name="actualShape")
    public Shape getShape() {
        return new BatmanShape();
    }

}
