package com.stpditon.lab4.repositories;

import com.stpditon.lab4.entities.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointsRepository extends JpaRepository<Point, Long> {
}
