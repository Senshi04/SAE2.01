import java.util.ArrayList;

import ardoise.*;

public class Etoile extends Forme {
	private ArrayList<Chapeau> pts_etoile;

	public Etoile() {
		// TODO Auto-generated constructor stub
		this.pts_etoile = new ArrayList<Chapeau>(4);
	}

	public Etoile(String arg0, Chapeau chap1) /*throws InvalidDistanceChapeau*/{
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
		PointPlan pTop = new PointPlan(e+(e-a),f+(e-c));
		PointPlan pRight = new PointPlan(e,f+(f-d));
		/*
		Chapeau c2 = new Chapeau("c-right",pLeft,pTop,pRight);
		Chapeau c3 = new Chapeau(chap1,"c-bottom");
		Chapeau c4 = new Chapeau(c2,"c-left");

		c3.deplacer(0,e-a);
		c3.setPoint(1,new PointPlan(c, f+2*(f-d)));		
		
		c4.deplacer(-(e-a),0);
		c4.setPoint(1, new PointPlan(a-(e-a),pTop.getOrdonnee()));
		
		this.pts_etoile.add(chap1);
		this.pts_etoile.add(c2);
		this.pts_etoile.add(c3);
		this.pts_etoile.add(c4);*/
	}

	@Override
	public void deplacer(int arg0, int arg1) {
		// TODO Auto-generated method stub

		this.pts_etoile.get(0).deplacer(arg0, arg1);
		this.pts_etoile.get(1).deplacer(arg0, arg1);
		this.pts_etoile.get(2).deplacer(arg0, arg1);
		this.pts_etoile.get(3).deplacer(arg0, arg1);
	}

	@Override
	public ArrayList<Segment> dessiner() {
		// TODO Auto-generated method stub
		ArrayList<Segment> s = new ArrayList<Segment>(8);
		for(int i=0;i<this.pts_etoile.size();i++) {
			ArrayList<Segment> sPt = this.pts_etoile.get(i).dessiner();
			s.add(sPt.get(0));
			s.add(sPt.get(1));
		}
		return s;
	}

	@Override
	public String typeForme() {
		// TODO Auto-generated method stub
		return "CF";
	}

}