import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Stats {
	
	@Id
	/** Attributs. */
	private List<ArticlePondere> statistics;	// liste des articles et leurs occurences
	
	
	/** Construit Stats. */
	public Stats() {}
	
	public void init() {
		statistics = new ArrayList<ArticlePondere>();
	}

	/** Getter de statistics.
	 * @return statistics
	 */
	public List<ArticlePondere> getStatistiques() {
		return statistics;
	}

	/** Setter de statistics.
	 * @param statistiques
	 */
	public void setStatistics(List<ArticlePondere> statistiques) {
		this.statistics = statistiques;
	}
	
	/** Mise à jour des stats.
	 * @param article
	 * @param occurence
	 */
	public void majStats(Article article, int occurence) {
		ArticlePondere ap = new ArticlePondere();
		ap.init(article, occurence);
		if (!statistics.contains(ap)) {
			statistics.add(ap);
		} else {
			for (ArticlePondere arp : statistics) {
				if (arp.getArticle() == article) {
					arp.setOccurence(arp.getOccurence() + occurence);
				}
			}
		}
	}
	
	/** Retourne une liste des nb articles préférés du client.
	 * @param nb, le nombre voulu d'articles préférés
	 * @return
	 */
	public List<ArticlePondere> preferedArticles(int nb) {
		// Trier la map
		this.sortByValues();
		
		// Si nb est plus grand que le nombre d'articles déjà listés, retourner toute la liste
		if (nb > statistics.size()) {			
			return statistics;			
		// Sinon, retourner une sous-liste comprenant les nb articles préférés
		} else {
			return statistics.subList(0, nb);
		}
	}

	/** Tri de la liste statistics.
	 * pas de paramètre, on travaille sur l'attribut statistics
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void sortByValues() { 		
		// Creation d'une LinkedList contenant statistics
		List<ArticlePondere> sortedList = new LinkedList<ArticlePondere>();
		sortedList.addAll(statistics);
		
		// Defined Custom Comparator here
		Collections.sort(sortedList, new Comparator<ArticlePondere>() {
			public int compare(ArticlePondere a1, ArticlePondere a2) {
				return -((Comparable)a1.getOccurence()).compareTo(a2.getOccurence());
	        }
		});
	
		statistics = sortedList;
	}
	
	/** Afficher les statistiques du client.
	 * @param client
	 */
	public void toString(Client client) {
		System.out.println("Statistiques du client : " + client.getPrenom() + " " + client.getNom());
		for (ArticlePondere a : statistics) {
			System.out.println("- Article " + a.getArticle().getName() + " commandé " + a.getOccurence() + " fois");
		}
	}

}