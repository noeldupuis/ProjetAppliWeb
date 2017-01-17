import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ListeCourses {

	@Id
	@GeneratedValue
	private int id;

	@OneToMany
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

	public int getSize() {
		return listeCourses.size();
	}
	
	public List<Produit> getListeCourses() {
		return listeCourses;
	}

	public void setListeCourses(List<Produit> listeCourses) {
		this.listeCourses = listeCourses;
	}


}
