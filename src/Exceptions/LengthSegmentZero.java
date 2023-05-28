package Exceptions;

import ardoise.PointPlan;

public class LengthSegmentZero extends Exception {
    PointPlan point;
    public LengthSegmentZero(PointPlan point){
        super();
        this.point = point;
    }

    public String toString(){
        return "Les points : " + this.point + " forment un segment de longueur 0";
    }


}
