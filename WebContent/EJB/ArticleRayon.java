
public class ArticleRayon {

	private Produit article;
	
	private double taille;
	
	

	public ArticleRayon(Produit article, double taille) {
		this.article = article;
		this.taille = taille;
	}

	public Produit getArticle() {
		return article;
	}

	public void setArticle(Produit article) {
		this.article = article;
	}

	public double getTaille() {
		return taille;
	}

	public void setTaille(double taille) {
		this.taille = taille;
	}
	
	
}
