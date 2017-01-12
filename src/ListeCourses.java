import java.util.ArrayList;
import java.util.List;

public class ListeCourses {

	private List<Article> listeCourses;
	
	public ListeCourses() {}
	
	public void init() {
		setListeCourses(new ArrayList<Article>());
	}
	
	public void ajouterArticle(Article article) {
		listeCourses.add(article);
	}
	
	public void supprimerArticle(Article article) {
		if (listeCourses.contains(article)){
			listeCourses.remove(article);
		}
	}

	public List<Article> getListeCourses() {
		return listeCourses;
	}

	public void setListeCourses(List<Article> listeCourses) {
		this.listeCourses = listeCourses;
	}
	
}
