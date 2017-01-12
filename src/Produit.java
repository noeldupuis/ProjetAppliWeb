
public class Produit implements Article {

	
	private String name;
	
	private String description;
	
	public Produit(String n, String d){
		
		this.description = d;
		
		this.name = n;
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
	
	

}
