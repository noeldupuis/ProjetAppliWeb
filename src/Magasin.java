import java.util.ArrayList;
import java.util.List;

public class Magasin {

	private List<Rayon> rayons;	
	private Point positionEntree; //poisition absolue du magasin	
	private Point caisses;
	
	public Magasin() {}
	
	public void init() {
		this.rayons = new ArrayList<Rayon>();
	}
	
	public void ajouterRayon(Rayon r) {		
		if (this.rayons.size() == r.getNumero()) {
			this.rayons.add(r);
		}
	}
	
	public void deplacerRayon(int n, Point p1, Point p2) {
		this.rayons.get(n).setExt(p1, p2);
	}
	
	public Rayon getRayon(int n) {
		return this.rayons.get(n);
	}
	
	public void setRayon(Rayon r) {
		this.rayons.set(r.getNumero(),r);
	}


	public Point getEntree() {
		return positionEntree;
	}


	public void setEntree(Point entree) {
		this.positionEntree = entree;
	}


	public Point getCaisses() {
		return caisses;
	}


	public void setCaisses(Point caisses) {
		this.caisses = caisses;
	}
	
	
}
