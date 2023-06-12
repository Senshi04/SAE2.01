import Exceptions.InvalidDistanceChapeau;
import Exceptions.InvalidOrder;
import Exceptions.LengthSegmentZero;
import ardoise.Forme;
import ardoise.PointPlan;
import ardoise.Segment;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Maison extends Forme{
    private Quadrilatere porte;
    private Quadrilatere corps;
    private Chapeau toit;

    /**
     * Constructeur champ à champ indirectement
     * Créée la maison dynamiquement avec des input
     * @throws InvalidOrder : Exception pour les formes Quadrilatères
     * @throws InvalidDistanceChapeau : Exception pour la forme Chapeau
     */
    public Maison(String nomForme) throws InvalidOrder, InvalidDistanceChapeau {
        super(nomForme);
        this.init();
    }

    /**
     * Constructeur par copie
     * On copie les PointPlan de chaque composant
     * @param m
     */
    public Maison(Maison m) throws InvalidOrder, InvalidDistanceChapeau {
        super(m.getNomForme());
        PointPlan c1 = new PointPlan(m.getCorps().getPoint(0).getAbscisse(), m.getCorps().getPoint(0).getOrdonnee());
        PointPlan c2 = new PointPlan(m.getCorps().getPoint(1).getAbscisse(), m.getCorps().getPoint(1).getOrdonnee());
        PointPlan t1 = new PointPlan(m.getToit().getPoint(0).getAbscisse(), m.getToit().getPoint(0).getOrdonnee());
        PointPlan t2 = new PointPlan(m.getToit().getPoint(1).getAbscisse(), m.getToit().getPoint(1).getOrdonnee());
        PointPlan t3 = new PointPlan(m.getToit().getPoint(2).getAbscisse(), m.getToit().getPoint(2).getOrdonnee());
        PointPlan p1 = new PointPlan(m.getPorte().getPoint(0).getAbscisse(), m.getPorte().getPoint(0).getOrdonnee());
        PointPlan p2 = new PointPlan(m.getPorte().getPoint(1).getAbscisse(), m.getPorte().getPoint(1).getOrdonnee());
        this.corps = new Quadrilatere(m.getCorps().getNomForme(), c1, c2);
        this.toit = new Chapeau(m.getToit().getNomForme(), t1, t2, t3);
        this.porte = new Quadrilatere(m.getPorte().getNomForme(), p1, p2);
    }

    /**
     * Construit le corps, la porte et le toit en fonction des valeurs entrées par l'utilisateur
     * Valeurs :
     * - position de la maison : abscisse du 1er point du corps de la maison
     * - hauteur de la maison : avec le périmètre d'ardoise on en déduit l'ordonnée du 1er point du corps
     * - largeur de la maison : avec la position de la maison on en déduit l'abscisse du 2e point du corps
     * - hauteur du toit : avec la hauteur de la maison on en déduit l'ordonnée du 2e point du toit
     * Les coordonnées de la porte sont déduites par le milieu du corps sauf pour la hauteur qu'on a attribué comme fixe.
     * @throws InvalidOrder
     * @throws InvalidDistanceChapeau
     */
    private void init() throws InvalidOrder, InvalidDistanceChapeau {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez la position de la Maison : ");
        int positionMaison = sc.nextInt();
        int largeurMaison = 0;
        int hauteurMaison = 0;
        int hauteurToit = 0;
        while(largeurMaison <= 20 || hauteurMaison <= 30 || hauteurToit < 0) {
            System.out.println("Respectez ces conditions :\n-Hauteur maison > 30 \n-Largeur maison < 20\n-Hauteur toit > 0");
            System.out.println("Entrez la largeur de la Maison : ");
            largeurMaison = sc.nextInt();
            System.out.println("Entrez la hauteur de la Maison : ");
            hauteurMaison = 200 - sc.nextInt();
            System.out.println("Entrez la hauteur du toit : ");
            hauteurToit = hauteurMaison - sc.nextInt();
        }
        int milieuMaison = positionMaison + (largeurMaison/2);

        PointPlan coteHautGauche = new PointPlan(positionMaison, hauteurMaison);
        this.corps = new Quadrilatere("Corps",coteHautGauche, new PointPlan(positionMaison + largeurMaison,200));
        //Les paramètres 2 et 4 du toit sont les références des côtés supérieur du corps de la maison, ainsi le toit sera toujours sur la maison
        this.toit = new Chapeau("Toit",coteHautGauche, new PointPlan(milieuMaison,hauteurToit), this.corps.getPoint(2));

        PointPlan p1 = new PointPlan(milieuMaison-10,170);
        PointPlan p2 = new PointPlan(milieuMaison+10,200);
        this.porte = new Quadrilatere("Porte",p1,p2);
    }

    /**
     * Retourne le corps de la maison
     * @return Quadrilatere
     */
    public Quadrilatere getCorps(){
        return this.corps;
    }

    /**
     * Retoure le toit de la maison
     * @return Chapeau
     */
    public Chapeau getToit(){
        return this.toit;
    }

    /**
     * Retourne la porte de la maison
     * @return Quadrilatere
     */
    public Quadrilatere getPorte(){
        return this.porte;
    }
    /**
     * Modifie la maison en rentrant a nouveau les valeurs hauteur maison, largeur maison etc.
     * @throws InvalidOrder
     * @throws InvalidDistanceChapeau
     */
    public void setMaison() throws InvalidOrder, InvalidDistanceChapeau {
        this.init();
    }

    /**
     * Retourne une collection de segments pour dessiner la maison
     * @return ArrayList<Segment>
     */
    public ArrayList<Segment> dessiner() {
        ArrayList<Segment> seg = new ArrayList<Segment>();
        seg.addAll(this.corps.dessiner());
        seg.addAll(this.toit.dessiner());
        seg.addAll(this.porte.dessiner());

        return seg;
    }

    /**
     * Deplace le corps, la porte et le toit
     * Pour le toit on deplace que le sommet du toit car les autres points font référence aux coins supérieurs de la maison, ils se deplacent avec le corps.
     * @param dx
     * @param dy
     */
    public void deplacer(int dx, int dy) {
        this.corps.deplacer(dx,dy);
        this.porte.deplacer(dx,dy);
        this.toit.getPoint(1).deplacer(dx,dy);
    }

    /**
     * Retourne le type de la forme: CF
     * @return String
     */
    public String typeForme() {
        return "GF";
    }

    public String toString(){
        String msg = "";
        msg += "Corps:\n" + this.corps + "\n";
        msg += "Toit:\n" + this.toit + "\n";
        msg += "Porte:\n" + this.porte + "\n";
        return msg;
    }
}
