import Exceptions.InvalidTriangle;
import Exceptions.LengthSegmentZero;
import ardoise.*;

import java.awt.*;
import java.util.Calendar;

public class TestArdoise {
	public static void main(String []args) {
		Ardoise ardoise = new Ardoise();
		PointPlan p1 = new PointPlan(50,100);
		PointPlan p2 = new PointPlan(1,50);
		PointPlan p3 = new PointPlan(100,25);
		//porte :
		PointPlan p4 = new PointPlan(50,200);
		PointPlan p5 = new PointPlan(70,170);

		try {
			/*
			Triangle t = new Triangle("Jsp", p1,p2,p3);
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

			Maison m = new Maison();
			ardoise.ajouterForme(m);

			/*
			PointPlan t1 = new PointPlan(50,120);
			PointPlan t2 = new PointPlan(150, 200);
			Quadrilatere q = new Quadrilatere("Corps", t1,t2);
			PointPlan t3 = new PointPlan(150, 120);
			PointPlan t4 = new PointPlan(100, 100);
			Chapeau c = new Chapeau("Toit", t1,t4,t3);
			PointPlan t5 = new PointPlan(75,160);
			PointPlan t6 = new PointPlan(125, 200);
			Quadrilatere p = new Quadrilatere("Porte", t5,t6);
			ardoise.ajouterForme(q);
			ardoise.ajouterForme(c);
			ardoise.ajouterForme(p);
			*/

			ardoise.dessinerGraphique();
			Thread.sleep(5000);// dessun disparait après 5s
			System.exit(1);
		//}catch (InvalidTriangle e){
			//e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
