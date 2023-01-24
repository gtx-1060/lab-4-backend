package com.stpdiron.lab4.repositories;

import com.stpdiron.lab4.entities.Point;
import com.stpdiron.lab4.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PointsRepository extends JpaRepository<Point, Long> {
    List<Point> findPointsByUserOrderByProcessedAtDesc(User user);
}
