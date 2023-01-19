package com.stpditon.lab4.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.io.Serializable;

public class Coordinates implements Serializable {

    @Min(value = -3, message = "X должен быть не меньше -3.")
    @Max(value = 5, message = "X должен быть не больше 5.")
    private float x;
    @Min(value = -3, message = "Y должен быть не меньше -3.")
    @Max(value = 3, message = "Y должен быть не больше 3.")
    private float y;
    @Min(value = 0, message = "Y должен быть не меньше 0.")
    @Max(value = 5, message = "R должен быть не больше 5.")
    private float r;

    public Coordinates() {}
    public Coordinates(float x, float y, float r) {
        this.x = x;
        this.y = y;
        this.r = r;
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

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getR() {
        return r;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                '}';
    }
}
