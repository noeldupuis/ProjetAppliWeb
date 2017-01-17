import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Rayon {

	@Id
	@GeneratedValue
	private int id;
	private int numero;
	
	@OneToMany
	private List<Produit> articles;
	private int longueur;
	@OneToOne
	private Point ext1;
	@OneToOne
	private Point ext2;
	
	public Rayon(int n, int l, Point e1, Point e2){
		
		this.numero = n;
		this.longueur = l;
		this.ext1 = e1;
		this.ext2 = e2;
		
		this.articles = new ArrayList<Produit>();
	}
	
	public Rayon(int n, int l, List<Produit> liste){
		this.numero = n;
		this.longueur = l;
		
		this.articles = liste;
	}
	
	public void setExt(Point e1, Point e2){
		this.ext1 = e1;
		this.ext2 = e2;
	}
	
	public void setExt1(Point e){
		this.ext1 = e;
	}
	
	public void setExt2(Point e){
		this.ext2 = e;
	}
	
	public void setLongueur(int l){
		this.longueur = l;
	}
	
	public void setNumero(int n){
		this.numero = n;
	}
	
	public void setArticles(List<Produit> liste){
		this.articles = liste;
	}
	
	public int getNumero(){
		return this.numero;
	}
	
	public int getLongueur(){
		return this.longueur;
	}
	
	public List<Produit> getArticles(){
		return this.articles;
	}
	
	public Point getExt1(){
		return this.ext1;
	}
	
	public Point getExt2(){
		return this.ext2;
	}
}
