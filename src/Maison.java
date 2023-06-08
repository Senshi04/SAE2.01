import Exceptions.InvalidOrder;
import Exceptions.LengthSegmentZero;
import ardoise.Forme;
import ardoise.PointPlan;
import ardoise.Segment;

import java.util.ArrayList;
import java.util.Scanner;

public class Maison extends Forme{
    private Quadrilatere porte;
    private Quadrilatere corps;
    private Chapeau toit;

    public Maison() throws InvalidOrder, LengthSegmentZero {
        this.init();
    }
    public Maison(Maison maison){
        this.corps = maison.getCorps();
        this.toit = maison.getToit();
        this.porte = maison.getPorte();
    }
    private void init() throws InvalidOrder, LengthSegmentZero {
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
    public Quadrilatere getCorps(){
        return this.corps;
    }
    public Chapeau getToit(){
        return this.toit;
    }
    public Quadrilatere getPorte(){
        return this.porte;
    }

    public void setCorps(Quadrilatere corps){
        this.corps = corps;
    }
    public void setToit(Chapeau toit){
        this.toit = toit;
    }
    public ArrayList<Segment> dessiner() {
        ArrayList<Segment> seg = new ArrayList<Segment>();
        seg.addAll(this.corps.dessiner());
        seg.addAll(this.toit.dessiner());
        seg.addAll(this.porte.dessiner());

        return seg;
    }

    public void deplacer(int dx, int dy) {
        this.corps.deplacer(dx,dy);
        this.porte.deplacer(dx,dy);
        //Pour le toit on deplace que le sommet du toit car les autres points font référence aux coins supérieurs de la maison, ils se deplacent avec le corps.
        this.toit.getPoint(1).deplacer(dx,dy);
    }

    public String typeForme() {
        return "CF";
    }
}
