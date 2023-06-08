package Exceptions;

import ardoise.PointPlan;
import ardoise.Segment;

public class LengthSegmentZero extends Exception {
    public LengthSegmentZero(){
        super();
    }

    public String toString(){
        return "Un ou plusieurs points sont égaux";
    }


}
