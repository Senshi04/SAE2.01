import java.util.ArrayList;

import ardoise.*;

public class Etoile extends Forme {
	private ArrayList<Chapeau> pts_etoile;

	public Etoile() {
		// TODO Auto-generated constructor stub
		this.pts_etoile = new ArrayList<Chapeau>(4);
	}

	public Etoile(String arg0, Chapeau chap1) {
		super(arg0);
		// TODO Auto-generated constructor stub
		this.pts_etoile = new ArrayList<Chapeau>(4);
		
		Chapeau ch = chap1;
		int a = ch.getPoint(0).getAbscisse();
		int b = ch.getPoint(0).getOrdonnee();
		int c = ch.getPoint(1).getAbscisse();
		int d = ch.getPoint(1).getOrdonnee();
		int e = ch.getPoint(2).getAbscisse();
		int f = ch.getPoint(2).getOrdonnee();
		
		PointPlan pLeft = new PointPlan(e,f);
		PointPlan pTop = new PointPlan(e+(b-d),(e-a)/2+e);
		PointPlan pRight = new PointPlan(e,f+(e-a));
		
		Chapeau c2 = new Chapeau("c-right",pLeft,pTop,pRight);
		Chapeau c3 = new Chapeau(chap1,"c-bottom");
		c3.deplacer(0,e-a);
		c3.setPoint(1,new PointPlan(c, b+(2*(d-b)+(e-a))));
		
		Chapeau c4 = new Chapeau(c2,"c-left");
		c4.deplacer(-(e-a),0);
		c4.setPoint(1, new PointPlan(c,c2.getPoint(1).getAbscisse()-(2*(d-b)+(e-a))));
		
		this.pts_etoile.add(chap1);
		this.pts_etoile.add(c2);
		this.pts_etoile.add(c3);
		this.pts_etoile.add(c4);
	}

	@Override
	public void deplacer(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Segment> dessiner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String typeForme() {
		// TODO Auto-generated method stub
		return null;
	}

}