
public class Client {

	private String nom;
	private String prenom;
	private String adresse;
	private Stats stats;
	private ListeCourses listeCourses;
	
	public Client() {}
	
	public void init(String name, String fName, String adress) {
		nom = name;
		prenom = fName;
		adresse = adress;
		stats = new Stats();
		listeCourses = new ListeCourses();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}

	public ListeCourses getListeCourses() {
		return listeCourses;
	}

	public void setListeCourses(ListeCourses listeCourses) {
		this.listeCourses = listeCourses;
	}
	
}
