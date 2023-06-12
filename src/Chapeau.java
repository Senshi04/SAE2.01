import java.util.ArrayList;

import Exceptions.InvalidDistanceChapeau;
import ardoise.Forme;
import ardoise.PointPlan;
import ardoise.Segment;

public class Chapeau extends Forme {
	private ArrayList<PointPlan> points;

	public Chapeau() {
		this.points = new ArrayList<PointPlan>(3);
	}
	

	public Chapeau(String arg0,PointPlan p1, PointPlan p2, PointPlan p3) throws InvalidDistanceChapeau {
		super(arg0);
		// TODO Auto-generated constructor stub

		int a = p1.getAbscisse();
		int b = p1.getOrdonnee();
		int c = p2.getAbscisse();
		int d = p2.getOrdonnee();
		int e = p3.getAbscisse();
		int f = p3.getOrdonnee();
		
		if(b==f){
			if(!((c-a)==(e-c) || (c-e)==(a-c))){
				System.out.println("c-a == e-c ="+ ((c-a)==(e-c)));
				System.out.println("c-e == a-c ="+ ((c-e)==(a-c)));
				throw new InvalidDistanceChapeau();
			}
		}
		if(a==e) {
			if(!((c-e)==(a-e)||(a-c)==(e-c))) {
				System.out.println("c-e == a-e ="+ ((c-e)==(a-e)));
				System.out.println("a-c == e-c ="+ ((a-c)==(e-c)));
				throw new InvalidDistanceChapeau();
			}
		}
		
		this.points = new ArrayList<PointPlan>(3);
		this.points.add(p1);
		this.points.add(p2);
		this.points.add(p3);		
	}
	public Chapeau(String nom, Chapeau c) {
		super(nom);
		this.points = new ArrayList<PointPlan>();
		PointPlan p1 = new PointPlan(c.getPoint(0).getAbscisse(),c.getPoint(0).getOrdonnee());
		PointPlan p2 = new PointPlan(c.getPoint(1).getAbscisse(),c.getPoint(1).getOrdonnee());
		PointPlan p3 = new PointPlan(c.getPoint(2).getAbscisse(),c.getPoint(2).getOrdonnee());
		
		this.points.add(p1);
		this.points.add(p2);
		this.points.add(p3);
	}
	
	public PointPlan getPoint(int index) {
		return this.points.get(index);
	}
	
	public void setPoint(int index, PointPlan p) {
		this.points.set(index,p);
	}

	public void deplacer(int arg0, int arg1) {
		this.points.get(0).deplacer(arg0, arg1);
		
		this.points.get(1).deplacer(arg0,arg1);
		
		this.points.get(2).deplacer(arg0,arg1);
		
	}


	public ArrayList<Segment> dessiner() {
		ArrayList<Segment> s = new ArrayList<Segment>(2);
		s.add(new Segment(this.points.get(0),this.points.get(1)));
		s.add(new Segment(this.points.get(1),this.points.get(2)));
		return s;
	}


	public String typeForme() {
		return "C";
	}
	
	public String toString() {
		if (this.points.size() == 0) return "Aucun point du chapeau n'existe, sorry";
		String msg = "";
		for (int i = 0; i < 2; i++) {
			msg += "Côté " + (i + 1) + ": " + this.dessiner().get(i) + "\n";
		}
		return msg;
	}

}

