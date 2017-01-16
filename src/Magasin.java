import java.util.ArrayList;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Magasin {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	
	private String name;
	private List<Rayon> rayons;	
	private Point positionEntree; //poisition absolue du magasin	
	private Point caisses;
	
	private double longitude;
	private double latitude;
	
	public Magasin() {}
	
	public void init(double lon, double lat ) {
		this.rayons = new ArrayList<Rayon>();
		this.longitude = lon;
		this.latitude = lat;
	}
	
	public double distance(double lon1, double lat1){
		double d;
		double R = 6372.8; // rayon de la terre
		double lat2 = this.latitude;
		double lon2 = this.longitude;
		
		double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
 
        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return R * c;
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

	public List<Rayon> getRayons() { return this.rayons; }
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	
}
