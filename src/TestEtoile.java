import Exceptions.InvalidAbs;
import Exceptions.InvalidDistanceChapeau;
import Exceptions.InvalidOrd;
import ardoise.*;

public class TestEtoile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ardoise ardoise = new Ardoise();
		PointPlan t1 = new PointPlan(35,50);
		PointPlan t2 = new PointPlan(40, 40);
		PointPlan t3 = new PointPlan(45, 50);

		try{
			Chapeau chap1 = new Chapeau("Toit", t1,t2,t3);

			Etoile etoile = new Etoile("Test �toile",chap1);
			ardoise.ajouterForme(etoile);
		} catch (InvalidOrd e){
			e.printStackTrace();
		} catch (InvalidAbs e){
			e.printStackTrace();
		} catch (InvalidDistanceChapeau e){
			e.printStackTrace();
		}


		ardoise.dessinerGraphique();
	}

}
