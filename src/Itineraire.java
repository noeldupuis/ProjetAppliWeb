import java.util.ArrayList;
import java.util.List;

public class Itineraire {

	private Magasin magasin;
	
	private Point courant;
	
	private List<Point>  points;
	
	public Itineraire(){}
	
	public void init(Magasin m) {
		this.magasin = m;
		this.courant = this.magasin.getEntree();
		this.points = new ArrayList<Point>();
	}

	public Point getCourant() {
		return courant;
	}

	public void setCourant(Point courant) {
		this.courant = courant;
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public Magasin getMagasin() { return this.magasin; }

	public void setMagasin(Magasin mag){ this.magasin = mag; }

	/** Constuire la liste des articles à acheter.
	 * @return la liste triée
	 */
	public List<PositionProduitArticle> setPositionsArticles() {
		// Liste des articles et de leur position cf classe PositionProduitArticle
		List positionProduitArticle = new ArrayList<PositionProduitArticle>();

		// ordre des articles dans le rayon
		// on attribue un entier qui détermine la position de l'article dans le rayon
		for (Rayon rayon : this.magasin.getRayons()) {
			int k = 1;
			for (ArticleRayon articleRayon : rayon.getArticles()) {
				articleRayon.setPosition(k);
				// on construit l'objet unique par magasin qui positionne le produit courant
				PositionProduitArticle positionProduitArticlek = null;
				positionProduitArticlek.init(articleRayon.getArticle(), rayon.getNumero(), articleRayon.getPosition());
				// on l'ajoute dans la liste
				positionProduitArticle.add(positionProduitArticlek);
				// on passe à l'article suivant
				k += 1;
			}
		}
		return positionProduitArticle;
	}

	/** Trier une liste de courses selon différents critères.
	 * Un produit d'une liste peut être lourd, fragile, frais, surgelé...
	 */
	public List<PositionProduitArticle> sortListeCourse() {
		// Listes tampons pour le triage
		List<PositionProduitArticle> listeSurgeles = new ArrayList<PositionProduitArticle>();
		List<PositionProduitArticle> listeFragiles = new ArrayList<PositionProduitArticle>();
		List<PositionProduitArticle> listeLourds = new ArrayList<PositionProduitArticle>();
		List<PositionProduitArticle> listeFrais = new ArrayList<PositionProduitArticle>();

		for (PositionProduitArticle positionProduitArticle : this.setPositionsArticles()) {
			if (positionProduitArticle.getCategorie().equals(Caracteristique.SURGELES)) {
				listeSurgeles.add(positionProduitArticle);
			}
			if (positionProduitArticle.getCategorie().equals(Caracteristique.FRAGILES)) {
				listeFragiles.add(positionProduitArticle);
			}
			if (positionProduitArticle.getCategorie().equals(Caracteristique.LOURD)) {
				listeLourds.add(positionProduitArticle);
			}
			if (positionProduitArticle.getCategorie().equals(Caracteristique.FRAIS)) {
				listeFrais.add(positionProduitArticle);
			}
		}
		// Concaténation des listes.
		List<PositionProduitArticle> listeTriee = new ArrayList<PositionProduitArticle>(listeFragiles);
		listeTriee.addAll(listeFrais);
		listeTriee.addAll(listeSurgeles);
		listeTriee.addAll(listeLourds);

		return listeTriee;
	}

}
