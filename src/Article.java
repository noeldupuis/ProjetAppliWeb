import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Article {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int num;

	String getName(){return null;}
	
	String getDescription(){return null;}


	
	void setName(String name){}
	
	void setDescription(String desc){}

}
