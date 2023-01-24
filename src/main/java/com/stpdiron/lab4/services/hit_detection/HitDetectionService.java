package com.stpdiron.lab4.services.hit_detection;

import com.stpdiron.lab4.dtos.Coordinates;
import com.stpdiron.lab4.entities.Point;
import com.stpdiron.lab4.services.hit_detection.shapes.Shape;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class HitDetectionService {
    private final Shape shape;

    public HitDetectionService(@Qualifier("actualShape") Shape shape) {
        this.shape = shape;
    }

    public Point process(Coordinates coordinates) {
        long startProc = System.currentTimeMillis();
        boolean hit = shape.contain(coordinates);
        return new Point(coordinates, System.currentTimeMillis()-startProc, hit);
    }

    private static boolean inRange(float start, float stop, float num) {
        return num >= start && num <= stop;
    }

}
