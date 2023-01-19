package com.stpditon.lab4.configuration;

import com.stpditon.lab4.services.hit_detection.shapes.BatmanShape;
import com.stpditon.lab4.services.hit_detection.shapes.Lab3Shape;
import com.stpditon.lab4.services.hit_detection.shapes.Shape;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {

    @Bean(name="actualShape")
    public Shape getShape() {
        return new BatmanShape();
    }

}
