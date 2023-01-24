package com.stpdiron.lab4.repositories;

import com.stpdiron.lab4.entities.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointsRepository extends JpaRepository<Point, Long> {
}
