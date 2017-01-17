import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ArticleRayon {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int num;

	@OneToOne
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



	public void setPosition(int position) {
		this.position = position;
	}
	
	
}
