import java.util.ArrayList;
import java.util.List;

public class ListeCourses {

	private List<Produit> listeCourses;
	
	public ListeCourses() {}
	
	public void init() {
		setListeCourses(new ArrayList<Produit>());
	}
	
	public void ajouterArticle(Produit article) {
		listeCourses.add(article);
	}
	
	public void supprimerArticle(Produit article) {
		if (listeCourses.contains(article)){
			listeCourses.remove(article);
		}
	}

	public List<Produit> getListeCourses() {
		return listeCourses;
	}

	public void setListeCourses(List<Produit> listeCourses) {
		this.listeCourses = listeCourses;
	}


}
