import java.util.ArrayList;

import javax.swing.text.Segment;

public class Quadrilatere extends Forme {
    private ArrayList<PointPlan> points;

    Quadrilatere() {
        this.points = new ArrayList<PointPlan>();
    }

    Quadrilatere(PointPlan p1, PointPlan p2) {
        this.points = new ArrayList<PointPlan>();
        this.points.add(p1);
        this.points.add(p2);
        PointPlan p3 = new PointPlan(p2.getAbcisse(),p1.getOrdonnee());
        PointPlan p4 = new PointPlan(p1.getAbcisse(),p2.getOrdonnee());
        this.points.add(p3);
        this.points.add(p4);
    /*  Voici comment les points sont agencés:
     *  HAUT GAUCHE: p1         HAUT DROITE: p3
     *  BAS GAUCHE:  p4         BAS DROITE:  p2
     */
    }

    Quadrilatere(Quadrilatere q) {
        this.points = new ArrayList<PointPlan>();
        this.points.add(q.get(0));
        this.points.add(q.get(1));
        this.points.add(q.get(2));
        this.points.add(q.get(3));
    }

    public void setPoint(int i,PointPlan p) {
        this.points.set(i,p);
    }

    public PointPlan getPoint(int i){
        return this.points.get(i);
    }

    public String toString() {
        return this.dessiner().toString();
    }

    public ArrayList<Segment> dessiner(){
        ArrayList<Segment> segments = new ArrayList<Segment>();
        Segment s1 = new Segment(this.getPoint(0),this.getPoint(2));
        Segment s2 = new Segment(this.getPoint(2),this.getPoint(1));
        Segment s3 = new Segment(this.getPoint(1),this.getPoint(3));
        Segment s4 = new Segment(this.getPoint(3),this.getPoint(0));
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

    public void deplacer(int x, int y){
        this.points.get(0).deplacer(x,y);
        this.points.get(1).deplacer(x,y);
        this.points.get(2).deplacer(x,y);
        this.points.get(3).deplacer(x,y);
    }

    public String typeForme(){
        return "Q";
    }
}