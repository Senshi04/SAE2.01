import Exceptions.*;
import ardoise.PointPlan;

public class TestException {
    public static void main(String[] args){
        /**
         * Test des Exceptions des formes simples
         */
        //PointPlan d'un quadrilatere
        PointPlan p1_quad = new PointPlan(15, 200);
        PointPlan p2_quad = new PointPlan(5, 100);
        //PointPlan d'un triangle
        PointPlan p1_tri = new PointPlan(2, 10);
        PointPlan p2_tri = new PointPlan(35, 2);
        PointPlan p3_tri = new PointPlan(2, 10);
        //PointPlan d'un chapeau
        PointPlan p1_chap = new PointPlan(113, 9);
        PointPlan p2_chap = new PointPlan(115, 14);
        PointPlan p3_chap = new PointPlan(113, 9);

        try {
            Quadrilatere test_quad = new Quadrilatere("Test Quadrilatere", p1_quad, p2_quad);

        }catch (InvalidOrder e){
            System.out.println("InvalidOrder de Quadrilatere:");
            System.out.println(e);
            System.out.println("\n");
        }
        try{
            Triangle test_tri = new Triangle("Test Triangle", p1_tri, p2_tri, p3_tri);
        }catch (LengthSegmentZero e){
            System.out.println("LengthSegmentZero de Triangle:");
            System.out.println(e);
            System.out.println("\n");
        }
        try {
            Chapeau test_chap = new Chapeau("Test Chapeau", p1_chap, p2_chap, p3_chap);
        }catch(InvalidDistanceChapeau e){
            System.out.println("InvalidDistanceChapeau de Chapeau:");
            System.out.println(e);
            System.out.println("\n");
        }

        /**
         * Test des Exceptions de la forme Etoile
         */
        PointPlan t1 = new PointPlan(35,50);
        PointPlan t2 = new PointPlan(40, 40);
        PointPlan t3 = new PointPlan(46, 51);

        try{
            Chapeau chap1 = new Chapeau("Toit", t1,t2,t3);
            Etoile etoile = new Etoile("Test Etoile",chap1);
        } catch (InvalidOrd e){
            System.out.println(e);
        } catch (InvalidAbs e){
            System.out.println(e);
        } catch (InvalidDistanceChapeau e){
            e.printStackTrace();
        }
    }
}
