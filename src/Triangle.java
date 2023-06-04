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
    public Triangle(String nomForme, PointPlan p1, PointPlan p2, PointPlan p3) throws IndexOutOfBoundsException, LengthSegmentZero{
        super(nomForme);
        this.points = new ArrayList<PointPlan>(3);
        this.setPoint(0, p1);
        this.setPoint(1, p2);
        this.setPoint(2, p3);
    }
    public Triangle(Triangle t) throws IndexOutOfBoundsException, LengthSegmentZero{
        super(t.getNomForme);
        this.points = new ArrayList<PointPlan>(3);
        this.setPoint(0, t.getPoint(0));
        this.setPoint(1, t.getPoint(0));
        this.setPoint(2, t.getPoint(0));
    }

    public PointPlan getPoint(int index) throws IndexOutOfBoundsException{
        if(index > this.points.size() || index < this.points.size()) throw new IndexOutOfBoundsException();
        return this.points.get(index);
    }
    public void setPoint(int index, PointPlan p) throws IndexOutOfBoundsException, LengthSegmentZero {
        if(index > this.points.size() || index < this.points.size()) throw new IndexOutOfBoundsException();
        if(p.getAbscisse() == p.getOrdonnee()) throw new LengthSegmentZero(p);

        this.points.set(index, p) ;
    }

    public void SegmentsValides(Segment segment1, Segment segment2, Segment segment3) throws SegmentGreaterThanSumOfOther{
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
    }
    public ArrayList<ardoise.Segment> dessiner() {
        Segment segment1 = new Segment(this.getPoint(0), this.getPoint(1));
        Segment segment2 = new Segment(this.getPoint(1), this.getPoint(2));
        Segment segment3 = new Segment(this.getPoint(2), this.getPoint(0));

        try {
            this.SegmentsValides(segment1,segment2,segment3);
        } catch (SegmentGreaterThanSumOfOther e) {
            System.out.println(e);
        }
        return new ArrayList<Segment>(List.of(segment1, segment2,segment3));
    }
    public void deplacer(int x, int y){
        this.points.get(0).deplacer(x,y);
        this.points.get(1).deplacer(x,y);
        this.points.get(2).deplacer(x,y);
    }
    public String typeForme(){
        return "T";
    }
}

