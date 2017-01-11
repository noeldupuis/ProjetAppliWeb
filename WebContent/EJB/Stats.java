import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Stats {
	
	/** Attributs. */
	private Map<Article, Integer> statistics;	// liste des articles et leurs occurences
	private Iterator<Entry<Article, Integer>> it;	// itérateur sur la map
	
	
	/** Construit Stats. */
	public Stats() {
		statistics = new HashMap<Article, Integer>();
		it = statistics.entrySet().iterator();
	}

	/** Getter de statistics.
	 * @return statistics
	 */
	public Map<Article, Integer> getStatistiques() {
		return statistics;
	}

	/** Setter de statistics.
	 * @param statistiques
	 */
	public void setStatistics(Map<Article, Integer> statistiques) {
		this.statistics = statistiques;
	}

	
	/** Mise à jour des stats.
	 * @param article
	 * @param occurence
	 */
	public void majStats(Article article, int occurence) {
		if (!statistics.containsKey(article)) {
			statistics.put(article, occurence);
		} else {
			while (it.hasNext()) {
				Entry<Article, Integer> pair = it.next();
				if (pair.getKey() == article) {
					pair.setValue(pair.getValue() + occurence);
				}
				it.remove();
			}
		}
	}

	
	/** Retourne une liste des nb articles préférés du client.
	 * @param nb, le nombre voulu d'articles préférés
	 * @return
	 */
	public List<Article> preferedArticles(int nb) {
		ArrayList<Article> list = sortMap();
		
		// Si nb est plus grand que le nombre d'articles déjà listés, retourner toute la liste
		if (nb > statistics.size()) {			
			return list;
			
		// Sinon, retourner une sous-liste comprenant les nb articles préférés
		} else {
			return list.subList(0, nb - 1);
		}
	}

	
	/** Tri de la map statistics.
	 * pas de paramètre, on travaille sur l'attribut statistics
	 * NB : statistics n'est en aucun cas modifié
	 * @return une liste d'articles triés en fonction de leur occurrence
	 */
	public ArrayList<Article> sortMap() {		
		// Liste à retourner
		ArrayList<Article> list = new ArrayList<Article>();
		// Entier pour comparer les occurences des articles
		int n = 0;
		// Copie de la map en attribut
		Map<Article, Integer> copy = statistics;
		// Itérateur sur la copie
		Iterator<Entry<Article, Integer>> it1 = copy.entrySet().iterator();
		
		// Tant que la liste n'est pas complète
		while (list.size() < statistics.size()) {			
			// Parcours de la copie
			while (it1.hasNext()) {
				Entry<Article, Integer> pair = it1.next();
				// Recherche de la plus grande occurrence
				if (pair.getValue() > n) {
					n = pair.getValue();
				}			
				it1.remove();
			}
			
			// Récupération de l'article avec la plus grande occurrence
			Article article = null;
			for (Article tmp : copy.keySet()) {
				if (copy.get(tmp) == n) {
					article = tmp;
					break;
				}
			}
			list.add(article);
			
			// Suppression de l'article trouvé de la copie
			copy.remove(article);			
		}	
		
		return list;	
	}
	
	public void toString(Client client) {
		System.out.println("Statistiques du client : " + client.getPrenom() + " " + client.getNom());
		while (it.hasNext()) {
			System.out.println("1");
			Entry<Article, Integer> pair = it.next();
			System.out.println("- Article " + pair.getKey().getNom() + " commandé " + pair.getValue() + " fois");
			it.remove();
		}
	}
	
	public void toString(List<Article> list) {
		for (Article a : list) {
			System.out.println(a.toString());
		}
	}
	
	public static void main(String[] args) {
		Stats stats = new Stats();
		stats.majStats(new Article("jambon"), 1);
		stats.majStats(new Article("coca"), 5);
		stats.majStats(new Article("tomate"), 3);
		stats.majStats(new Article("fromage"), 2);
		stats.majStats(new Article("beurre"), 4);
		stats.toString(new Client("Bennani", "Omar", "Toulouse"));
		List<Article> list1 = new ArrayList<Article>();
		list1 = stats.preferedArticles(7);
		stats.toString();
		List<Article> list2 = new ArrayList<Article>();
		list2 = stats.preferedArticles(3);
		stats.toString();
	}

}
