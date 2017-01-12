
public class ArticleRayon {

	private Produit article;	
	private int position;

	public ArticleRayon() {}

	public void init(Produit article, int position) {
		this.article = article;
		this.position = position;
	}
	
	public Produit getArticle() {
		return article;
	}

	public void setArticle(Produit article) {
		this.article = article;
	}

	public int getPosition() {
		return position;
	}

	public void setTaille(int position) {
		this.position = position;
	}
	
	
}
