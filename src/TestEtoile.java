import ardoise.*;

public class TestEtoile {

	public static void main(String[] args) throws InvalidAbs, InvalidOrd, InvalidDistanceChapeau {
		// TODO Auto-generated method stub

		PointPlan t1 = new PointPlan(50,30);
		PointPlan t4 = new PointPlan(55, 10);
		PointPlan t3 = new PointPlan(60, 30);

		Chapeau chap1 = new Chapeau("Toit", t1,t4,t3);
		
		Chapeau ch = chap1;
//		int a = ch.getPoint(0).getAbscisse();
//		int b = ch.getPoint(0).getOrdonnee();
//		int c = ch.getPoint(1).getAbscisse();
//		int d = ch.getPoint(1).getOrdonnee();
//		int e = ch.getPoint(2).getAbscisse();
//		int f = ch.getPoint(2).getOrdonnee();
//		
//		PointPlan pLeft = new PointPlan(e,f);
//		PointPlan pTop = new PointPlan(e+(e-a),f+(e-c));
//		PointPlan pRight = new PointPlan(e,f+(f-d));
//		
//		Chapeau c2 = new Chapeau("c-right",pLeft,pTop,pRight);
//		Chapeau c3 = new Chapeau(chap1,"c-bottom");
//		Chapeau c4 = new Chapeau(c2,"c-left");
//		
//		c3.deplacer(0,e-a);
//		c3.setPoint(1,new PointPlan(c, f+2*(f-d)));		
//		
//		c4.deplacer(-(e-a),0);
//		c4.setPoint(1, new PointPlan(a-(e-a),pTop.getOrdonnee()));
//		
		Etoile e = new Etoile("Test étoile",chap1);

		Ardoise ardoise = new Ardoise();
		ardoise.ajouterForme(ch);
//		ardoise.ajouterForme(c2);
//		ardoise.ajouterForme(c3);
//		ardoise.ajouterForme(c4);
//		ardoise.ajouterForme(e);

		ardoise.dessinerGraphique();
	}

}
