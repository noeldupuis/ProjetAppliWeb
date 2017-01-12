import java.util.ArrayList;
import java.util.List;

public class Itineraire {

	private Magasin magasin;
	
	private Point courant;
	
	private List<Point>  points;
	
	public Itineraire(Magasin m){
		this.magasin = m;
		this.courant = this.magasin.getEntree();
		
		this.points = new ArrayList<Point>();
	}

	public Point getCourant() {
		return courant;
	}

	public void setCourant(Point courant) {
		this.courant = courant;
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public Magasin getMagasin() { return this.magasin; }

	public void setMagasin(Magasin mag){ this.magasin = mag; }

}
