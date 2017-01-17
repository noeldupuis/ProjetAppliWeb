import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Point {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int num;
	
	private double longitude;	
	private double latitude;
	
	public Point() {}
	
	public void init(double longitude, double latitude){	
		this.longitude = longitude;		
		this.latitude = latitude;
	}
	
	public double getDistance(Point p2){
		double d;
		
		d = Math.sqrt(Math.pow(this.latitude-p2.getLatitude(), 2) + Math.pow(this.longitude - p2.getLongitude(), 2));
		
		return d;
	}
	
	public double getLongitude(){
		
		return this.longitude;
	}
	
	public double getLatitude(){
		
		return this.latitude;
	}
	
	
	public void setLongitude(double l){
		this.longitude = l;
	}
	
	public void setLatitude(double l){
		this.latitude = l;
	}
	
}
