import ardoise.*;

public class TestEtoile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PointPlan t1 = new PointPlan(70,20);
		PointPlan t4 = new PointPlan(75, 10);
		PointPlan t3 = new PointPlan(80, 20);

		Chapeau c = new Chapeau("Toit", t1,t4,t3);
		
		Etoile e = new Etoile("Test étoile",c);

		Ardoise ardoise = new Ardoise();
		ardoise.ajouterForme(e);

		ardoise.dessinerGraphique();
	}

}
