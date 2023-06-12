import Exceptions.InvalidDistanceChapeau;
import ardoise.*;

public class TestEtoile {

	public static void main(String[] args) throws InvalidDistanceChapeau {
		// TODO Auto-generated method stub

		PointPlan t1 = new PointPlan(35,50);
		PointPlan t2 = new PointPlan(40, 40);
		PointPlan t3 = new PointPlan(45, 50);

		Chapeau chap1 = new Chapeau("Toit", t1,t2,t3);
		
		Etoile etoile = new Etoile("Test �toile",chap1);
		Ardoise ardoise = new Ardoise();
		ardoise.ajouterForme(etoile);

		ardoise.dessinerGraphique();
	}

}
