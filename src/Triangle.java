import Exceptions.LengthSegmentZero;
import ardoise.Forme;
import ardoise.PointPlan;
import ardoise.Segment;

import java.util.ArrayList;
import java.util.List;

public class Triangle extends Forme {
    private ArrayList<PointPlan> points;

    /**
     * Constructeur par défaut qui initialise la collection points
     */
    public Triangle() {
        new ArrayList<PointPlan>(3);
    }

    /**
     * Constructeur champ à champ
     * @param nomForme
     * @param p1
     * @param p2
     * @param p3
     * @throws LengthSegmentZero : verifie que les coordonnées des Points sont toutes différentes
     */
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

    /**
     * Constructeur par copie
     * Création de 3 PointPlan en donnant la valeur des abscisses et ordonnées des 3 du Triangle t
     * @param t
     */
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

    /**
     * Retourne le PointPlan se trouvant à l'indice index
     * @param index
     * @return
     */
    public PointPlan getPoint(int index) {
        return this.points.get(index);
    }

    /**
     * Modifie le PointPlan de d'indice index par le PointPlan p
     * @param index
     * @param p
     * @throws LengthSegmentZero : entre dans la condition où index == n (avec n = 0, 1 ou 2) et vérifie que les coordonnées de p != coordonnées d'un autre PointPlan
     */
    public void setPoint(int index, PointPlan p) throws LengthSegmentZero {
        PointPlan p0 = this.getPoint(0);
        PointPlan p1 = this.getPoint(1);
        PointPlan p2 = this.getPoint(2);

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

    /**
     * Retoure une collection de segments pour dessiner le triangle
     * @return ArrayList<Segment>
     */
    public ArrayList<ardoise.Segment> dessiner() {
        if (this.points.size() == 0) return null;
        Segment segment1 = new Segment(this.getPoint(0), this.getPoint(1));
        Segment segment2 = new Segment(this.getPoint(1), this.getPoint(2));
        Segment segment3 = new Segment(this.getPoint(2), this.getPoint(0));
        return new ArrayList<Segment>(List.of(segment1, segment2, segment3));
    }

    /**
     * Deplace chaque PointPlan
     * @param x
     * @param y
     */
    public void deplacer(int x, int y) {
        this.points.get(0).deplacer(x, y);
        this.points.get(1).deplacer(x, y);
        this.points.get(2).deplacer(x, y);
    }

    /**
     * Renvoie le type de la forme: T
     * @return String
     */
    public String typeForme() {
        return "T";
    }

    /**
     * Décrit le triangle en renvoyant les coordonnées de ses Points
     * S'il n'existe pas de Triangle elle revoie une phrase adéquate à la situation
     * @return String
     */
    public String toString() {
        if (this.points.size() == 0) return "Aucun point du triangle n'existe, sorry";
        String msg = "";
        for (int i = 0; i < 3; i++) {
            msg += "Côté " + (i + 1) + ": " + this.dessiner().get(i) + "\n";
        }
        return msg;
    }
}


