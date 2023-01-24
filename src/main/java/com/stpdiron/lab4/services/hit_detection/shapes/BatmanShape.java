package com.stpdiron.lab4.services.hit_detection.shapes;

import com.stpdiron.lab4.dtos.Coordinates;

public class BatmanShape extends Shape {

    @Override
    public boolean contain(Coordinates dot) {
        return inEllipse(dot.getX(), dot.getY(), dot.getR(), dot.getR()/2, 0, 0) &&
                !inLowerIndent(dot.getX(), dot.getY(), dot.getR()) &&
                !inLeftUpperIndent(dot.getX(), dot.getY(), dot.getR()) &&
                !inRightUpperIndent(dot.getX(), dot.getY(), dot.getR()) &&
                !inUpperIndent(dot.getX(), dot.getY(), dot.getR());

    }

    private boolean inLowerIndent(float x, float y, float r) {
        return inEllipse(x, y, r/5.9, r/4.5, -r/2.07, r/2.4) ||
                inEllipse(x, y, r/5.9, r/4.5, r/2.07, r/2.4) ||
                inRotatedEllipse(x, y, r/6.5, r/4.5, r/2.72, r/3, -6.8) ||
                inRotatedEllipse(x, y, r/6.5, r/4.5, -r/2.72, r/3, 6.8);
    }

    private boolean inLeftUpperIndent(float x, float y, float r) {
        return inEllipse(x, y, r/5.8, r/4.5, r/4.02, -r/2.5) &&
                (y > 10*x +r*1.66 || y > -10*x - r/1.8);
    }

    private boolean inRightUpperIndent(float x, float y, float r) {
        return inEllipse(x, y, r/5.8, r/4.5, -r/4.02, -r/2.5) &&
                (y > -10*x +r*1.66 || y > 10*x - r/1.8);
    }

    private boolean inUpperIndent(float x, float y, float r) {
        return y > r/2.72 && y > -10*x - r/1.8 && y > 10*x - r/1.8;
    }

}
