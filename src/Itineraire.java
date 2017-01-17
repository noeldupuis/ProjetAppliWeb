//import com.sun.corba.se.spi.activation.RepositoryOperations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Itineraire {

	private Magasin magasin;
	private Point courant;
	private ListeCourses listeCourses;

	
	public Itineraire(){}
	
	public void init(Magasin m, List<Produit> produits) {
		this.magasin = m;
		this.courant = this.magasin.getEntree();
		this.listeCourses = new ListeCourses();
		this.listeCourses.init();
		for (Produit p : produits) {
			this.listeCourses.ajouterArticle(p);
		}
	}

	public Point getCourant() {
		return courant;
	}

	public void setCourant(Point courant) {
		this.courant = courant;
	}

	public Magasin getMagasin() { 
		return this.magasin; 
	}

	public void setMagasin(Magasin mag) {
		this.magasin = mag;
	}

    public ListeCourses getListeCourses() {
    	return listeCourses;
    }

    public List<Produit> getListe() {
    	return this.listeCourses.getListeCourses();
    }

    public void setListeCourses(ListeCourses listeCourses) {
    	this.listeCourses = listeCourses;
    }

	public List<PositionProduit> sortList() {
		// Liste des articles et de leur position
        List<PositionProduit> positionProduits = new ArrayList<PositionProduit>();
        for (int i=0 ; i < this.getListe().size(); i++) {
        	PositionProduit pp = new PositionProduit();
        	pp.init(this.getListe().get(i), this.getListe().get(i).getPosition());
            positionProduits.add(pp);
        }

        // Points de départ et d'arrivée
        final Point entree = this.magasin.getEntree();

        // Liste à trier
        List<PositionProduit> sortedList = new LinkedList<PositionProduit>();
        sortedList.addAll(positionProduits);
        // Defined Custom Comparator here
     		Collections.sort(sortedList, new Comparator<PositionProduit>() {
				@SuppressWarnings({ "unchecked", "rawtypes" })
				@Override
				public int compare(PositionProduit p1, PositionProduit p2) {
					return ((Comparable)p1.getPositionsArticle().getDistance(entree)).
							compareTo((Comparable)p2.getPositionsArticle().getDistance(entree));
				}
     		});
		
		return sortedList;		
	}
	
	public String toString() {
		List<PositionProduit> list = new ArrayList<PositionProduit>();
		list = this.sortList();
		String s = "Liste des produits par ordre : \n";
		for (PositionProduit pp : list) {
			s += pp.getArticle().getName() + "\n";
		}
		return s;
	}
	
	
	public static void main(String args[]) {		
		Magasin m = new Magasin();
		m.init(1.0, 2.0);
		
		Point entree = new Point();
		entree.init(0.0, 0.0);
		
		m.setEntree(entree);
		
		Point p1 = new Point();
		p1.init(2.0, 3.0);
		Produit oeuf = new Produit();
		oeuf.init("oeuf", null, p1);
		
		Point p2 = new Point();
		p2.init(4.0, 5.0);
		Produit lait = new Produit();
		lait.init("lait", null, p2);
		
		Point p3 = new Point();
		p3.init(7.0, 9.0);
		Produit pain = new Produit();
		pain.init("pain", null, p3);
		
		Point p4 = new Point();
		p4.init(3.0, 4.0);
		Produit sucre = new Produit();
		sucre.init("sucre", null, p3);
		
		ListeCourses listeC = new ListeCourses();
		listeC.init();
		listeC.ajouterArticle(lait);
		listeC.ajouterArticle(sucre);
		listeC.ajouterArticle(oeuf);
		listeC.ajouterArticle(pain);
		
		List<Produit> list = new ArrayList<Produit>();
		list.add(oeuf);
		list.add(lait);
		list.add(pain);
		list.add(sucre);
		
		Itineraire itineraire = new Itineraire();
		itineraire.init(m, list);
		
		itineraire.setListeCourses(listeC);
		
		List<PositionProduit> liste = new ArrayList<PositionProduit>();
		liste = itineraire.sortList();
		
		for (PositionProduit p : liste) {
			System.out.println(p.getArticle().getName());
		}
		
	}

}
