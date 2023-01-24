package com.stpdiron.lab4.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.stpdiron.lab4.dtos.Coordinates;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "points")
public class Point implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private long id;
    private long workTime;
    private ZonedDateTime processedAt;
    private boolean hit;
    private float x;
    private float y;
    private float r;

    public Point() {}

    public Point(Coordinates dot, long workTime, boolean hit) {
        setR(dot.getR());
        setX(dot.getX());
        setY(dot.getY());
        setHit(hit);
        setWorkTime(workTime);
        ZonedDateTime now = ZonedDateTime.now(ZoneId.systemDefault());
        setProcessedAt(now);
    }

    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
    public void setR(float r) {
        this.r = r;
    }
    public void setHit(boolean hit) {
        this.hit = hit;
    }
    public void setWorkTime(long workTime) {
        this.workTime = workTime;
    }
    public void setProcessedAt(ZonedDateTime processedAt) {
        this.processedAt = processedAt;
    }

    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public float getR() {
        return r;
    }
    public long getId() {
        return id;
    }

    @JsonIgnore
    public boolean isHit() {
        return hit;
    }

    @JsonIgnore
    public ZonedDateTime getProcessedAt() {
        return processedAt;
    }

    @JsonProperty("processingTime")
    public String getProcessedAtFormatted() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss");
        return processedAt.format(formatter);
    }

    @JsonProperty("hit")
    public String getHitFormatted() {
        return hit ? "+" : "-";
    }

    public long getWorkTime() {
        return workTime;
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", workTime=" + workTime +
                ", processedAt=" + processedAt +
                ", hit=" + hit +
                ", x=" + x +
                ", y=" + y +
                ", r=" + r +
                '}';
    }
}
