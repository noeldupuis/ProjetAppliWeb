//import com.sun.corba.se.spi.activation.RepositoryOperations;

import java.util.ArrayList;
import java.util.List;

public class Itineraire {

	private Magasin magasin;
	private Point courant;
	private ListeCourses listeCourses;

	
	public Itineraire(){}
	
	public void init(Magasin m) {
		this.magasin = m;
		this.courant = this.magasin.getEntree();
		this.listeCourses = null;
		this.listeCourses.init();
	}

	public Point getCourant() {
		return courant;
	}

	public void setCourant(Point courant) {
		this.courant = courant;
	}

	public Magasin getMagasin() { return this.magasin; }

	public void setMagasin(Magasin mag){ this.magasin = mag; }

    public ListeCourses getListeCourses() { return listeCourses; }

    public List<Produit> getListe() { return this.listeCourses.getListeCourses(); }

    public void setListeCourses(ListeCourses listeCourses) { this.listeCourses = listeCourses; }

	/** Constuire la liste des articles.
	 * @return la liste triée
	 */
	public List<Produit> sortListe() {

		// Liste des articles et de leur position
        List<PositionProduit> positionProduits = null;
        for (int i=0 ; i < this.getListe().size(); i++) {
            positionProduits.get(i).init(this.getListe().get(i), this.getListe().get(i).getPosition());
        }

        // Points de départ et d'arrivée
        Point entree = this.magasin.getEntree();
        Point caisses = this.magasin.getCaisses();

        // Liste à trier
        List<Produit> produitsTries = null;

        Point tampon = entree;
        Produit produittampon=null;

        for (int i = 0; i < positionProduits.size(); i++) {
            // On sélectionne le point le plus proche du point précédent
            double distancePrec = positionProduits.get(i).getPositionsArticle().getDistance(tampon);
            PositionProduit positionProduit = null;

            for (PositionProduit posprod : positionProduits) {
                double distanceCourante = posprod.getArticle().getPosition().getDistance(tampon);
                positionProduit = posprod;

                if (distancePrec > distanceCourante) {
                    // J'ajoute le produit le plus proche à ma liste triée
                    distancePrec = distanceCourante;
                    positionProduit = posprod;
                    tampon = posprod.getPositionsArticle();
                    produittampon = posprod.getArticle();
                }

            }

            produitsTries.add(produittampon);

            if (positionProduits.contains(produittampon)) {
                positionProduits.remove(produittampon);
            }
        }

        return produitsTries;
    }

}
