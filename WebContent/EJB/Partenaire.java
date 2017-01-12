import java.util.Date;

public class Partenaire {
	
	private Magasin magasin;
	
	private String nom;
	
	private Date adh;
	
	public Partenaire(String n, Magasin m, Date d){
		this.adh = d;
		this.nom = n;
		this.magasin = m;
	}

	public Magasin getMagasin() {
		return magasin;
	}

	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getAdh() {
		return adh;
	}

	public void setAdh(Date adh) {
		this.adh = adh;
	}

}
