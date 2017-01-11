import java.util.ArrayList;
import java.util.List;

public class ListeCourses {

	private List<Article> listeCourses;
	
	public ListeCourses() {
		setListeCourses(new ArrayList<Article>());
	}
	
	public void ajouterArticle(Article article) {
		listeCourses.add(article);
	}

	public List<Article> getListeCourses() {
		return listeCourses;
	}

	public void setListeCourses(List<Article> listeCourses) {
		this.listeCourses = listeCourses;
	}
	
}
