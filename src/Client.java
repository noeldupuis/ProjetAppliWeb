import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Client implements Compte {
	
	@Id
@GeneratedValue(strategy=GenerationType.AUTO)
	private int num;
	
	private String adresse;
	private String nom;
	private String prenom;
	private String mdp;
	
	@OneToOne
	private ListeCourses listeCourses;
	
	@OneToOne
	private Stats stats;
	
	public Client() {}
	
	public void init(String name, String fName, String adress, String password) {
		this.setNom(name);
		this.setPrenom(fName);;
		this.setAdresse(adress);
		//stats = new Stats();
		this.setMdp(password);
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

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public ListeCourses getListeCourses() {
		return listeCourses;
	}

	public void setListeCourses(ListeCourses listeCourses) {
		this.listeCourses = listeCourses;
	}
	
}
