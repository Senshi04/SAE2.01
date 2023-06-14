package Exceptions;

import ardoise.PointPlan;
import ardoise.Segment;

/**
 * Classe qui renvoie la phrase d'erreur si les coordonnées d'au moins deux points sont égaux
 */
public class LengthSegmentZero extends Exception {
    public LengthSegmentZero(){
        super();
    }

    public String toString(){
        return "Un ou plusieurs points sont égaux";
    }


}
