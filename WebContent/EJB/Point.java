

public class Point {

	private double longitude;
	
	private double latitude;
	
	public Point (double longitude, double latitude){
		
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
