package Exceptions;

import ardoise.PointPlan;
import ardoise.Segment;

public class LengthSegmentZero extends Exception {
    public LengthSegmentZero(){
        super();
    }

    public String toString(){
        return "L'un des segements a sont abscisse égal à son ordonnée";
    }


}
