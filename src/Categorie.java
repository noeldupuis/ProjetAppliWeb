import java.util.ArrayList;
import java.util.List;

public class Categorie implements Article{
	
	private String name;	
	private List<Article> articles;	
	private String description;
	
	
	public Categorie() {}
	
	public void init(String name, String description) {	
		this.name = name;		
		this.description = description;		
		this.articles = new ArrayList<Article>();
	}
	
	public void addArticle(Article a){		
		this.articles.add(a);
	}
	
	public void remArtile(Article a){	
		this.articles.remove(a);
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	public List<Article> getArticles(){		
		return this.articles;
	}
	
	
	@Override
	public void setName(String name) {
		this.name = name;
		
	}

	@Override
	public void setDescription(String desc) {
		this.description = desc;
		
	}
	
	

}
