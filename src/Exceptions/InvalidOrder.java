package Exceptions;

import ardoise.PointPlan;

public class InvalidOrder extends Exception {
    PointPlan p1;
    PointPlan p2;
    public InvalidOrder(PointPlan p1, PointPlan p2) {
        super();
        this.p1 = p1;
        this.p2 = p2;
        }
    

    public String toString(){
        return this.p1 + " et " + this.p2 + " ne sont pas dans le bon ordre";
    }


}
