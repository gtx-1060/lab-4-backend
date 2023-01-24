package com.stpdiron.lab4.services;

import com.stpdiron.lab4.dtos.Coordinates;
import com.stpdiron.lab4.entities.Point;
import com.stpdiron.lab4.services.hit_detection.HitDetectionService;
import com.stpdiron.lab4.services.hit_detection.shapes.Shape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointsService extends HitDetectionService {
    private final JpaRepository<Point, Long> repository;

    public PointsService(@Autowired JpaRepository<Point, Long> repository, @Qualifier("actualShape") Shape shape) {
        super(shape);
        this.repository = repository;
    }

    public Point processAndSave(Coordinates coordinates) {
        return repository.save(super.process(coordinates));
    }

    public List<Point> getSorted(Sort sort) {
        return repository.findAll(sort);
    }

}
