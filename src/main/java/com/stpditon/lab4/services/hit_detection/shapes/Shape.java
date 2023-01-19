package com.stpditon.lab4.services.hit_detection.shapes;

import com.stpditon.lab4.dtos.Coordinates;

import java.io.Serializable;


public abstract class Shape {
    public abstract boolean contain(Coordinates dot);

    protected boolean upperL(Coordinates dot) {
        return dot.getY() >= 0 && dot.getX() < 0;
    }

    protected boolean upperR(Coordinates dot) {
        return dot.getY() >= 0 && dot.getX() >= 0;
    }

    protected boolean lowerR(Coordinates dot) {
        return dot.getY() < 0 && dot.getX() >= 0;
    }

    protected boolean lowerL(Coordinates dot) {
        return dot.getY() < 0 && dot.getX() < 0;
    }

    protected boolean inEllipse(double x, double y, double a, double b, double offsetX, double offsetY) {
        return Math.pow(x+offsetX, 2) / Math.pow(a, 2)
                + Math.pow(y+offsetY, 2) / Math.pow(b, 2) < 1;
    }

    protected boolean inRotatedEllipse(double x, double y, double a, double b, double offsetX, double offsetY, double angle) {
        return inEllipse((float) (x*Math.cos(angle)-y*Math.sin(angle)),
                (float) (x*Math.sin(angle)+y*Math.cos(angle)), a, b, offsetX, offsetY);
    }
}
