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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stats {
	
	@Id
	/** Attributs. */
	private Map<Article, Integer> statistics;	// liste des articles et leurs occurences
	
	
	/** Construit Stats. */
	public Stats() {}
	
	public void init() {
		statistics = new HashMap<Article, Integer>();
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
			Iterator<Entry<Article, Integer>> it = statistics.entrySet().iterator();
			while (it.hasNext()) {
				Entry<Article, Integer> pair = it.next();
				if (pair.getKey() == article) {
					pair.setValue(pair.getValue() + occurence);
				}
			}
		}
	}
	
	/** Retourne une liste des nb articles préférés du client.
	 * @param nb, le nombre voulu d'articles préférés
	 * @return
	 */
	public List<Article> preferedArticles(int nb) {
		// Trier la map
		this.sortByValues();
		
		// Créer une liste d'articles
		List<Article> list = new ArrayList<Article>();
				
		// Itérer sur la map pour récupérer les articles
		Iterator<Entry<Article, Integer>> it = statistics.entrySet().iterator();
		while (it.hasNext()) {
			System.out.println("iteration");
			Entry<Article, Integer> pair = it.next();
			list.add(pair.getKey());
		}
				
		// Si nb est plus grand que le nombre d'articles déjà listés, retourner toute la liste
		if (nb > statistics.size()) {			
			return list;			
		// Sinon, retourner une sous-liste comprenant les nb articles préférés
		} else {
			return list.subList(0, nb);
		}
	}

	/** Tri de la map statistics.
	 * pas de paramètre, on travaille sur l'attribut statistics
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void sortByValues() { 
		List<?> list = new LinkedList(statistics.entrySet());
		// Defined Custom Comparator here
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o2)).getValue()).compareTo(((Map.Entry) (o1)).getValue());
	        }
		});
	
		// Here I am copying the sorted list in HashMap
		// using LinkedHashMap to preserve the insertion order
		HashMap sortedHashMap = new LinkedHashMap<Article, Integer>();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		} 
		statistics = sortedHashMap;
	}
	
	/** Tri de la map statistics. /OBSOLETE/
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
	
	/** Afficher les statistiques du client.
	 * @param client
	 */
	public void toString(Client client) {
		System.out.println("Statistiques du client : " + client.getPrenom() + " " + client.getNom());
		Iterator<Entry<Article, Integer>> it = statistics.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Article, Integer> pair = it.next();
			System.out.println("- Article " + pair.getKey().getName() + " commandé " + pair.getValue() + " fois");
		}
	}
	
	/** Afficher les composants d'une liste.
	 * @param list
	 */
	public static void listToString(List<Article> list) {
		for (Article a : list) {
			System.out.println(a.getName());
		}
	}
	
	/**public static void main(String[] args) {
		Stats stats = new Stats();
		
		Article jambon = new Produit("jambon", null);
		Article tomate = new Produit("tomate", null);
		Article fromage = new Produit("fromage", null);
		Article beurre = new Produit("beurre", null);
		Article coca = new Produit("coca", null);
		
		stats.majStats(jambon, 1);
		stats.majStats(tomate, 5);
		stats.majStats(fromage, 3);
		stats.majStats(beurre, 2);
		stats.majStats(coca, 4);
		
		stats.sortByValues();
		stats.toString(new Client("Bennani", "Omar", "Toulouse"));	
		
		List<Article> list1 = new ArrayList<Article>();
		list1 = stats.preferedArticles(7);
		listToString(list1);
		
		List<Article> list2 = new ArrayList<Article>();
		list2 = stats.preferedArticles(3);
		listToString(list2);
	}*/

}
