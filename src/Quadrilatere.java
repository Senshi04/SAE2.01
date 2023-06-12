import Exceptions.InvalidOrder;
import ardoise.Forme;
import ardoise.PointPlan;
import ardoise.Segment;

import java.util.ArrayList;


public class Quadrilatere extends Forme {
    private ArrayList<PointPlan> points;

    Quadrilatere() {
        this.points = new ArrayList<PointPlan>();
    }

    Quadrilatere(String nomForme, PointPlan p1, PointPlan p2) throws Exceptions.InvalidOrder {
        super(nomForme);
        this.points = new ArrayList<PointPlan>();
        if (p1.getOrdonnee() > p2.getOrdonnee() || p2.getAbscisse() < p1.getAbscisse())
            throw new InvalidOrder(p1, p2);
        this.points.add(p1);
        this.points.add(p2);
        PointPlan p3 = new PointPlan(p2.getAbscisse(), p1.getOrdonnee());
        PointPlan p4 = new PointPlan(p1.getAbscisse(), p2.getOrdonnee());
        this.points.add(p3);
        this.points.add(p4);
        /*  Voici comment les points sont agencés:
         *  HAUT GAUCHE: p1         HAUT DROITE: p3
         *  BAS GAUCHE:  p4         BAS DROITE:  p2
         */
    }

    Quadrilatere(Quadrilatere q) {
        super(q.getNomForme());
        this.points = new ArrayList<PointPlan>();
        PointPlan p1 = new PointPlan(q.getPoint(0).getAbscisse(), q.getPoint(0).getOrdonnee());
        PointPlan p2 = new PointPlan(q.getPoint(1).getAbscisse(), q.getPoint(1).getOrdonnee());
        PointPlan p3 = new PointPlan(q.getPoint(2).getAbscisse(), q.getPoint(2).getOrdonnee());
        PointPlan p4 = new PointPlan(q.getPoint(3).getAbscisse(), q.getPoint(3).getOrdonnee());
        this.points.add(p1);
        this.points.add(p2);
        this.points.add(p3);
        this.points.add(p4);
    }

    public void setPoint(int i, PointPlan p) throws InvalidOrder {
        if (i == 0 || i == 1) {
            if (i==0 && (p.getOrdonnee() >= this.points.get(1).getOrdonnee() || p.getAbscisse() >= this.points.get(1).getAbscisse()))
                throw new InvalidOrder(this.points.get(1), p);
            if (i==1 && (p.getAbscisse() <= this.points.get(0).getAbscisse() || p.getOrdonnee() <= this.points.get(0).getOrdonnee()))
                throw new InvalidOrder(this.points.get(0), p);
            this.points.set(i, p);
            this.points.set(2, new PointPlan(this.points.get(1).getAbscisse(), this.points.get(0).getOrdonnee()));
            this.points.set(3, new PointPlan(this.points.get(0).getAbscisse(), this.points.get(1).getOrdonnee()));
        }
    }

    public PointPlan getPoint(int i) {
        if (this.points.size() == 0) return null;
        return this.points.get(i);
    }

    public String toString() {
        return this.dessiner().toString();
    }

    public ArrayList<Segment> dessiner() {
        ArrayList<Segment> segments = new ArrayList<Segment>();
        Segment s1 = new Segment(this.getPoint(0), this.getPoint(2));
        Segment s2 = new Segment(this.getPoint(2), this.getPoint(1));
        Segment s3 = new Segment(this.getPoint(1), this.getPoint(3));
        Segment s4 = new Segment(this.getPoint(3), this.getPoint(0));
        segments.add(s1);
        segments.add(s2);
        segments.add(s3);
        segments.add(s4);
        return segments;
        /*
         *                     s1
         *          p1---------------------p3
         *           |                      |
         *       s4  |                      | s2
         *           |                      |
         *          p4---------------------p2
         *                      s3
         */
    }

    public void deplacer(int x, int y) {
        this.points.get(0).deplacer(x, y);
        this.points.get(1).deplacer(x, y);
        this.points.get(2).deplacer(x, y);
        this.points.get(3).deplacer(x, y);
    }

    public String typeForme() {
        return "Q";
    }
}
