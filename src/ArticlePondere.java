import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ArticlePondere {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int num;
	
	@OneToOne
	private Article article;
	private int occurence;
	
	public ArticlePondere() {}
	
	public void init(Article a, int o) {
		article = a;
		occurence = o;
	}
	
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public int getOccurence() {
		return occurence;
	}
	public void setOccurence(int occurence) {
		this.occurence = occurence;
	}
	
}