package com.stpditon.lab4.services.hit_detection.shapes;

import com.stpditon.lab4.dtos.Coordinates;


public class Lab3Shape extends Shape {
    @Override
    public boolean contain(Coordinates dot) {
        return  upperL(dot) && Math.pow(dot.getX(), 2) + Math.pow(dot.getY(), 2) <= Math.pow(dot.getR(), 2) ||
                upperR(dot) && dot.getY() <= dot.getR() && dot.getX() <= dot.getR()/2 ||
                lowerL(dot) && dot.getY() >= -2*dot.getX() - dot.getR() / 2;
    }

}
