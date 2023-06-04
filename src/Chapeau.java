import java.util.ArrayList;

import ardoise.Forme;
import ardoise.PointPlan;
import ardoise.Segment;

public class Chapeau extends Forme {
	private PointPlan p1;
	private PointPlan p2;
	private PointPlan p3;

	public Chapeau() {
	}
	

	public Chapeau(String arg0,PointPlan p1, PointPlan p2, PointPlan p3) {
		super(arg0);
		// TODO Auto-generated constructor stub
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;		
	}
	public Chapeau(Chapeau c) {
		super(c.getNomForme());
		this.p1 = c.p1;
		this.p2 = c.p2;
		this.p3 = c.p3;
	}
	
	public PointPlan getP1() {
		return this.p1;
	}
	
	public PointPlan getP2() {
		return this.p2;
	}
	
	public PointPlan getP3() {
		return this.p3;
	}
	
	public void setP1(PointPlan p) {
		this.p1 = p;
	}
	
	public void setP2(PointPlan p) {
		this.p2 = p;
	}
	
	public void setP3(PointPlan p) {
		this.p3 = p;
	}
	@Override
	public void deplacer(int arg0, int arg1) {
		// TODO Auto-generated method stub
		this.p1.setAbscisse(arg0);
		this.p1.setOrdonnee(arg1);
		
		this.p2.setAbscisse(arg0);
		this.p2.setOrdonnee(arg1);
		
		this.p3.setAbscisse(arg0);
		this.p3.setOrdonnee(arg1);
	}

	@Override
	public ArrayList<Segment> dessiner() {
		ArrayList<Segment> s = new ArrayList<Segment>();
		s.add(new Segment(p1,p2));
		s.add(new Segment(p2,p3));
		return s;
	}

	@Override
	public String typeForme() {
		return "C";
	}

}
