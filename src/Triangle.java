import Exceptions.LengthSegmentZero;
import ardoise.Forme;
import ardoise.PointPlan;
import ardoise.Segment;

import java.util.ArrayList;
import java.util.List;

public class Triangle extends Forme {
    private ArrayList<PointPlan> points;

    public Triangle() {
        new ArrayList<PointPlan>(3);
    }

    public Triangle(String nomForme, PointPlan p1, PointPlan p2, PointPlan p3) throws LengthSegmentZero {
        super(nomForme);
        if ((p1.getAbscisse() == p2.getAbscisse() && p1.getOrdonnee() == p2.getOrdonnee())
                || (p1.getAbscisse() == p3.getAbscisse() && p1.getOrdonnee() == p3.getOrdonnee())
                || (p2.getAbscisse() == p3.getAbscisse() && p2.getOrdonnee() == p3.getOrdonnee()))
            throw new LengthSegmentZero();
        this.points = new ArrayList<PointPlan>(3);
        this.points.add(p1);
        this.points.add(p2);
        this.points.add(p3);
    }

    public Triangle(Triangle t) {
        super(t.getNomForme());
        this.points = new ArrayList<PointPlan>(3);
        PointPlan p1 = new PointPlan(t.getPoint(0).getAbscisse(), t.getPoint(0).getOrdonnee());
        PointPlan p2 = new PointPlan(t.getPoint(1).getAbscisse(), t.getPoint(1).getOrdonnee());
        PointPlan p3 = new PointPlan(t.getPoint(2).getAbscisse(), t.getPoint(2).getOrdonnee());
        this.points.add(p1);
        this.points.add(p2);
        this.points.add(p3);
    }

    public PointPlan getPoint(int index) {
        return this.points.get(index);
    }

    public void setPoint(int index, PointPlan p) throws LengthSegmentZero {
        PointPlan p0 = this.getPoint(0);
        PointPlan p1 = this.getPoint(1);
        PointPlan p2 = this.getPoint(2);
        //Exception si le point en param a les mêmes coordonnées que les autres points
        //Vérification pour chaque possibilité d'indice en entrée
        if ((index == 0) && (
                (p.getAbscisse() == p1.getAbscisse() && p.getOrdonnee() == p1.getOrdonnee())
                        || (p.getAbscisse() == p2.getAbscisse() && p.getOrdonnee() == p2.getOrdonnee())
        )) throw new LengthSegmentZero();
        if ((index == 1) && (
                (p.getAbscisse() == p0.getAbscisse() && p.getOrdonnee() == p0.getOrdonnee())
                        || (p.getAbscisse() == p2.getAbscisse() && p.getOrdonnee() == p2.getOrdonnee())
        )) throw new LengthSegmentZero();
        if ((index == 2) && (
                (p.getAbscisse() == p0.getAbscisse() && p.getOrdonnee() == p0.getOrdonnee())
                        || (p.getAbscisse() == p1.getAbscisse() && p.getOrdonnee() == p1.getOrdonnee())
        )) throw new LengthSegmentZero();

        this.points.set(index, p);
    }

    public ArrayList<ardoise.Segment> dessiner() {
        if (this.points.size() == 0) return null;
        Segment segment1 = new Segment(this.getPoint(0), this.getPoint(1));
        Segment segment2 = new Segment(this.getPoint(1), this.getPoint(2));
        Segment segment3 = new Segment(this.getPoint(2), this.getPoint(0));
        return new ArrayList<Segment>(List.of(segment1, segment2, segment3));
    }

    public void deplacer(int x, int y) {
        this.points.get(0).deplacer(x, y);
        this.points.get(1).deplacer(x, y);
        this.points.get(2).deplacer(x, y);
    }

    public String typeForme() {
        return "T";
    }

    public String toString() {
        if (this.points.size() == 0) return "Aucun point du triangle n'existe, sorry";
        String msg = "";
        for (int i = 0; i < 3; i++) {
            msg += "Point " + (i + 1) + " de coordonées: " + this.points.get(i) + "\n";
        }
        return msg;
    }
}

