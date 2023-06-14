import Exceptions.*;
import ardoise.*;

import java.awt.*;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;

public class TestArdoise {
    public static void main(String[] args) {
        Ardoise ardoise = new Ardoise();
        //PointPlan du poto à gauche
        PointPlan p1_poto = new PointPlan(5, 100);
        PointPlan p2_poto = new PointPlan(15, 200);
        //PointPlan du nuage en haut à gauche
        PointPlan p1_nuage1 = new PointPlan(2, 10);
        PointPlan p2_nuage1 = new PointPlan(35, 2);
        PointPlan p3_nuage1 = new PointPlan(110, 10);
        //PointPlan du nuage en haut à droite
        PointPlan p1_nuage2 = new PointPlan(150, 5);
        PointPlan p2_nuage2 = new PointPlan(160, 2);
        PointPlan p3_nuage2 = new PointPlan(165, 5);
        //PointPlan de l'oiseau le plus à gauche
        PointPlan p1_oiseau1 = new PointPlan(113, 9);
        PointPlan p2_oiseau1 = new PointPlan(115, 14);
        PointPlan p3_oiseau1 = new PointPlan(117, 9);
        //PointPlan de l'oiseau de droite
        PointPlan p1_oiseau2 = new PointPlan(127, 10);
        PointPlan p2_oiseau2 = new PointPlan(129, 12);
        PointPlan p3_oiseau2 = new PointPlan(131, 10);
        //PointPlan de l'oiseau du milieu bas
        PointPlan p1_oiseau3 = new PointPlan(119, 30);
        PointPlan p2_oiseau3 = new PointPlan(121, 32);
        PointPlan p3_oiseau3 = new PointPlan(123, 30);
        //PointPlan de Etoile
        PointPlan p1_etoile = new PointPlan(158, 50);
        PointPlan p2_etoile = new PointPlan(159, 47);
        PointPlan p3_etoile = new PointPlan(160, 50);


        try {
            Maison m = new Maison("Maison");
            Quadrilatere poto = new Quadrilatere("Poto", p1_poto, p2_poto);
            Triangle nuage1 = new Triangle("Nuage 1", p1_nuage1, p2_nuage1, p3_nuage1);
            Triangle nuage2 = new Triangle("Nuage 2", p1_nuage2, p2_nuage2, p3_nuage2);
            Chapeau oiseau1 = new Chapeau("Oiseau 1", p1_oiseau1, p2_oiseau1, p3_oiseau1);
            Chapeau oiseau2 = new Chapeau("Oiseau 2", p1_oiseau2, p2_oiseau2, p3_oiseau2);
            Chapeau oiseau3 = new Chapeau("Oiseau 3", p1_oiseau3, p2_oiseau3, p3_oiseau3);
            Chapeau c_etoile = new Chapeau("Etoile", p1_etoile, p2_etoile,p3_etoile);
            Etoile etoile = new Etoile("Etoile", c_etoile);

            System.out.println(m);
            System.out.println(etoile);

            ardoise.ajouterForme(m);
            ardoise.ajouterForme(poto);
            ardoise.ajouterForme(nuage1);
            ardoise.ajouterForme(nuage2);
            ardoise.ajouterForme(oiseau1);
            ardoise.ajouterForme(oiseau2);
            ardoise.ajouterForme(oiseau3);
            ardoise.ajouterForme(etoile);
            ardoise.dessinerGraphique();

            //Déplacement des oiseaux après 500ms
            for(int i=0; i<4; i++){
                Thread.sleep(500);
                oiseau1.deplacer(10,20);
                oiseau2.deplacer(10,20);
                oiseau3.deplacer(10,20);
                ardoise.ajouterForme(oiseau1);
                ardoise.ajouterForme(oiseau2);
                ardoise.ajouterForme(oiseau3);
                ardoise.dessinerGraphique();
            }
            Thread.sleep(5000);
            System.exit(0);

        } catch (InvalidOrder e) {
            e.printStackTrace();
        } catch (InvalidDistanceChapeau e) {
            e.printStackTrace();
        } catch (LengthSegmentZero e) {
            e.printStackTrace();
        } catch (InvalidOrd e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
