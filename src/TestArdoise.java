import Exceptions.LengthSegmentZero;
import ardoise.*;
import java.awt.*;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;

public class TestArdoise {
    public static void main(String[] args) {
        Ardoise ardoise = new Ardoise();
        PointPlan p1 = new PointPlan(50, 100);
        PointPlan p2 = new PointPlan(1, 50);
        PointPlan p3 = new PointPlan(100, 25);
        //porte :
        PointPlan p4 = new PointPlan(50, 200);
        PointPlan p5 = new PointPlan(70, 170);
        PointPlan p6 = new PointPlan(50, 100); //Même valeur que p1 pour tester l'exception LengthSegmentZero


        try {
            //Test des exceptions sur la classe Triangle :
            //Triangle t0 = new Triangle("Test Exception Length...",p1,p2,p6);
            //Triangle t = new Triangle("Jsp", p1,p2,p3);
            //System.out.println(t);
            //t.setPoint(1,p6);
            //System.out.println(t);
			/*
			Quadrilatere q = new Quadrilatere("Porte", p4, p5);
			ardoise.ajouterForme(q);
			ardoise.dessinerGraphique();
			System.out.println(t);
			t.dessiner();
			ardoise.ajouterForme(t);
			ardoise.dessinerGraphique();
			Thread.sleep(1000);// dessun disparait après 1s
			t.deplacer(10,10);
			System.out.println("Après déplacement de (10,10) : \n" +t);
			ardoise.dessinerGraphique();


			 */
/*
            Maison m = new Maison();
            ardoise.ajouterForme(m);
            System.out.println(m);

 */
			/*
			PointPlan t5 = new PointPlan(75,160);
			PointPlan t6 = new PointPlan(125, 200);
			Quadrilatere p = new Quadrilatere("Porte", t5,t6);
			ardoise.ajouterForme(q);
			ardoise.ajouterForme(c);
			ardoise.ajouterForme(p);
			*//*
			PointPlan t1 = new PointPlan(50,120);
			PointPlan t3 = new PointPlan(100, 120);
			PointPlan t4 = new PointPlan(75, 90);
			PointPlan t3b = new PointPlan(130, 145);
			PointPlan t4b = new PointPlan(100, 170);

			Chapeau c2 = new Chapeau("Toit", t3,t3b,t4b);
			Chapeau c3 = new Chapeau(c);
			c3.deplacer(0,50);
			c3.setPoint(1, new PointPlan(75, 200));
			ardoise.ajouterForme(c);
			ardoise.ajouterForme(c3);
			ardoise.ajouterForme(c2);
			*/
            //Thread.sleep(10000);
            //System.exit(1);
			/*
			ardoise.dessinerGraphique();
			Thread.sleep(5000);
			q.deplacer(10,0);

			 */
            //ardoise.dessinerGraphique();
            /*
            for (int i = 0; i < 15; i++) {
                Thread.sleep(20);// dessin disparait après 5s
                m.deplacer(10, 0);
                ardoise.dessinerGraphique();
            }

             *//*
            PointPlan t1 = new PointPlan(50,120);
			PointPlan t2 = new PointPlan(150, 200);
			Quadrilatere q = new Quadrilatere("Corps", t1,t2);
            System.out.println(q);
            q.setPoint(0, new PointPlan(160,20));
            System.out.println(q);
            ardoise.ajouterForme(q);
            */
            PointPlan t1 = new PointPlan(50,120);
            PointPlan t3 = new PointPlan(100, 120);
            PointPlan t4 = new PointPlan(75, 90);
            Chapeau c = new Chapeau("Toit", t1,t4,t3);
            System.out.println(c);

            //System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
