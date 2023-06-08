import Exceptions.InvalidTriangle;
import Exceptions.LengthSegmentZero;
import Exceptions.SegmentGreaterThanSumOfOther;
import ardoise.Forme;
import ardoise.PointPlan;
import ardoise.Segment;

import java.util.ArrayList;
import java.util.List;

public class Triangle extends Forme {
    private ArrayList<PointPlan> points;

    public Triangle(){
        new ArrayList<PointPlan>(3);
    }
    public Triangle(String nomForme, PointPlan p1, PointPlan p2, PointPlan p3) throws InvalidTriangle{
        super(nomForme);
        this.points = new ArrayList<PointPlan>(3);
        this.points.add(p1);
        this.points.add(p2);
        this.points.add(p3);
        if(this.dessiner()==null){
            this.points.removeAll(this.points);
            throw new InvalidTriangle();
        }
    }
    public Triangle(Triangle t) throws InvalidTriangle {
        super(t.getNomForme());
        this.points = new ArrayList<PointPlan>(3);
        PointPlan p1 = new PointPlan(t.getPoint(0).getAbscisse(), t.getPoint(0).getOrdonnee());
        PointPlan p2 = new PointPlan(t.getPoint(1).getAbscisse(), t.getPoint(1).getOrdonnee());
        PointPlan p3 = new PointPlan(t.getPoint(2).getAbscisse(), t.getPoint(2).getOrdonnee());
        this.points.add(p1);
        this.points.add(p2);
        this.points.add(p3);
        if(this.dessiner()==null) {
            this.points.removeAll(this.points);
            throw new InvalidTriangle();
        }
    }

    public PointPlan getPoint(int index) {
        return this.points.get(index);
    }
    public void setPoint(int index, PointPlan p) {
        this.points.set(index, p);
    }

    public void SegmentsValides(Segment segment1, Segment segment2, Segment segment3) throws SegmentGreaterThanSumOfOther, LengthSegmentZero{
        // Calculs intermédiaires
        double coteA1 = segment1.getPointDepart().getAbscisse()-segment1.getPointArrivee().getAbscisse();
        double coteB1 = segment1.getPointDepart().getOrdonnee()-segment1.getPointArrivee().getOrdonnee();
        double coteA2 = segment2.getPointDepart().getAbscisse()-segment2.getPointArrivee().getAbscisse();
        double coteB2 = segment2.getPointDepart().getOrdonnee()-segment2.getPointArrivee().getOrdonnee();
        double coteA3 = segment3.getPointDepart().getAbscisse()-segment3.getPointArrivee().getAbscisse();
        double coteB3 = segment3.getPointDepart().getOrdonnee()-segment3.getPointArrivee().getOrdonnee();
        // Calculs des côtés avec la formule de Pythagore : AB²+ AC² = BC²
        double length1 = Math.sqrt(Math.pow(coteA1,2) + Math.pow(coteB1,2));
        double length2 = Math.sqrt(Math.pow(coteA2,2) + Math.pow(coteB2,2));
        double length3 = Math.sqrt(Math.pow(coteA3,2) + Math.pow(coteB3,2));

        if(length1 > length2+length3 || length2 > length1+length3 || length3 > length1 + length2) throw new SegmentGreaterThanSumOfOther();
        if((segment1.getPointDepart().getAbscisse() == segment1.getPointArrivee().getAbscisse() && segment1.getPointDepart().getOrdonnee() == segment1.getPointArrivee().getOrdonnee())
                || (segment2.getPointDepart().getAbscisse() == segment2.getPointArrivee().getAbscisse() && segment2.getPointDepart().getOrdonnee() == segment2.getPointArrivee().getOrdonnee())
                || (segment3.getPointDepart().getAbscisse() == segment3.getPointArrivee().getAbscisse() && segment3.getPointDepart().getOrdonnee() == segment3.getPointArrivee().getOrdonnee()))
            throw new LengthSegmentZero();
    }
    public ArrayList<ardoise.Segment> dessiner(){
        if(this.points.size() == 0) return null;
        try {
            Segment segment1 = new Segment(this.getPoint(0), this.getPoint(1));
            Segment segment2 = new Segment(this.getPoint(1), this.getPoint(2));
            Segment segment3 = new Segment(this.getPoint(2), this.getPoint(0));
            this.SegmentsValides(segment1,segment2,segment3);
            return new ArrayList<Segment>(List.of(segment1, segment2,segment3));
        } catch (LengthSegmentZero e){
            e.printStackTrace();
        } catch (SegmentGreaterThanSumOfOther e) {
            System.out.println(e);
        }
        return null;
    }
    public void deplacer(int x, int y){
        this.points.get(0).deplacer(x,y);
        this.points.get(1).deplacer(x,y);
        this.points.get(2).deplacer(x,y);
    }
    public String typeForme(){
        return "T";
    }

    public String toString(){
        if(this.points.size() == 0) return "Aucun point du triangle n'existe, sorry";
        String msg = "";
        for(int i=0; i<3; i++){
            msg+= "Point " + (i+1) + " de coordonées: " + this.points.get(i) + "\n";
        }
        return msg;
    }
}

