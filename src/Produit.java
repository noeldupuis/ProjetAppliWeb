import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Produit extends Article {
	
	private String name;
	private String description;
	@OneToOne
	private Point position;
	
	public void init(String n, String d, Point p){	
		this.description = d;		
		this.name = n;
		this.position = p;
	}	
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public void setName(String name) {
		this.name = name;
		
	}

	@Override
	public void setDescription(String desc) {
		this.description = desc;
		
	}


	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
}
