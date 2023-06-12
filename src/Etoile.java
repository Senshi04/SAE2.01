import java.util.ArrayList;

import ardoise.*;

public class Etoile extends Forme {
	private ArrayList<Chapeau> pts_etoile;

	public Etoile() {
		// TODO Auto-generated constructor stub
		this.pts_etoile = new ArrayList<Chapeau>(4);
	}

	public Etoile(String arg0, Chapeau chap1) throws InvalidDistanceChapeau{
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
		PointPlan pTop = new PointPlan(e+(f-d),f+(e-c));
		PointPlan pRight = new PointPlan(e,f+(e-a));
		
		Chapeau c2 = new Chapeau("c-right",pLeft,pTop,pRight);
		Chapeau c3 = new Chapeau("c-bottom",chap1);
		Chapeau c4 = new Chapeau("c-left",c2);
		
		c3.deplacer(0,e-a);
		c3.setPoint(1,new PointPlan(c, pRight.getOrdonnee()+(f-d)));
		
		c4.deplacer(-(e-a),0);
		c4.setPoint(1, new PointPlan(a-(f-d),pTop.getOrdonnee()));
		
		this.pts_etoile.add(chap1);
		this.pts_etoile.add(c2);
		this.pts_etoile.add(c3);
		this.pts_etoile.add(c4);
	}

	public Etoile(Etoile e) {
		this.pts_etoile.set(0,e.getChapeau(0));
		this.pts_etoile.set(1,e.getChapeau(1));
		this.pts_etoile.set(2,e.getChapeau(2));
		this.pts_etoile.set(3,e.getChapeau(3));
	}

	public Chapeau getChapeau(int index) {
		return this.pts_etoile.get(index);
	}

	public void setChapeau(int index, Chapeau c) {
		this.pts_etoile.set(index, c);
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

	public String toString() {
		return "L'�toile est compos�e de 4 chapeaux :\n Chapeau 1 :"+ this.pts_etoile.get(0).toString() + "\n Chapeau 2 :"+ this.pts_etoile.get(1).toString() + "\n Chapeau 3 :" + this.pts_etoile.get(2).toString() + "\n Chapeau 4 :"+ this.pts_etoile.get(3).toString();
	}

}