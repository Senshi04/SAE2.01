import Exceptions.InvalidTriangle;
import Exceptions.LengthSegmentZero;
import ardoise.*;

public class TestArdoise {
	public static void main(String []args) {
		Ardoise ardoise = new Ardoise();
		PointPlan p1 = new PointPlan(50,100);
		PointPlan p2 = new PointPlan(1,50);
		PointPlan p3 = new PointPlan(100,25);
		try {
			Triangle t = new Triangle("Jsp", p1,p2,p3);
			System.out.println(t);
			t.dessiner();
			ardoise.ajouterForme(t);
			ardoise.dessinerGraphique();
			Thread.sleep(5000);// quitte après 3s
			System.exit(1);// quitte sans executer le reste
			t.deplacer(10,10);
			System.out.println("Après déplacement de (10,10) : \n" +t);
		}catch (InvalidTriangle e){
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
