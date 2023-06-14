import java.util.ArrayList;

import Exceptions.InvalidDistanceChapeau;
import ardoise.Forme;
import ardoise.PointPlan;
import ardoise.Segment;
/**
 * Classe Chapeau
 */
public class Chapeau extends Forme {
	private ArrayList<PointPlan> points;

	/**
	 * Constructeur par defaut
	 */
	public Chapeau() {
		this.points = new ArrayList<PointPlan>(3);
	}
	/**
	 * @param nom: nom donne a la forme
	 * @param p1: Point 1 gauche du chapeau
	 * @param p2: Point 2 milieu du chapeau
	 * @param p3: Point 3 droit du chapeau
	 *
	 * Initialise le chapeau
	 */
	public Chapeau(String nom,PointPlan p1, PointPlan p2, PointPlan p3) throws InvalidDistanceChapeau {
		super(nom);
		// TODO Auto-generated constructor stub

		int a = p1.getAbscisse();
		int b = p1.getOrdonnee();
		int c = p2.getAbscisse();
		int d = p2.getOrdonnee();
		int e = p3.getAbscisse();
		int f = p3.getOrdonnee();
		
		if(b==f){
			if(!((c-a)==(e-c) || (c-e)==(a-c))){
				System.out.println("abs p2 - abs p1 == abs p3 - abs p2 ="+ ((c-a)==(e-c)));
				System.out.println("abs p2 - abs p3 == abs p1 - abs p2 ="+ ((c-e)==(a-c)));
				throw new InvalidDistanceChapeau();
			}
		}
		if(a==e) {
			if(!((c-e)==(a-e)||(a-c)==(e-c))) {
				System.out.println("abs p2 - abs p3 == abs p1 - abs p3 ="+ ((c-e)==(a-e)));
				System.out.println("abs p1 - abs p2 == abs p3 - abs p2 ="+ ((a-c)==(e-c)));
				throw new InvalidDistanceChapeau();
			}
		}
		
		this.points = new ArrayList<PointPlan>(3);
		this.points.add(p1);
		this.points.add(p2);
		this.points.add(p3);		
	}

	/**
	 * @param nom: nom du nouveau chapeau
	 * @param c: Chapeau a copier
	 *
	 * Constructeur par copie
	 */
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
	
	/**
	 * @param index
	 *
	 * Renvoie le point demande
	 */
	public PointPlan getPoint(int index) {
		return this.points.get(index);
	}
	
	/**
	 * @param index: Point a modifier
	 * @param p: Point
	 */
	public void setPoint(int index, PointPlan p) {
		this.points.set(index,p);
	}

	/**
	 * Deplace la forme
	 */
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

