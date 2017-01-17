
public class ArticlePondere {

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
