import java.util.ArrayList;
import java.util.List;

public class Rayon {

	private int numero;
	private List<ArticleRayon> articles;
	private int longueur;
	private Point ext1;
	private Point ext2;
	
	public Rayon(int n, int l, Point e1, Point e2){
		
		this.numero = n;
		this.longueur = l;
		this.ext1 = e1;
		this.ext2 = e2;
		
		this.articles = new ArrayList<ArticleRayon>();
	}
	
	public Rayon(int n, int l, List<ArticleRayon> liste){
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
	
	public void setArticles(List<ArticleRayon> liste){
		this.articles = liste;
	}
	
	public int getNumero(){
		return this.numero;
	}
	
	public int getLongueur(){
		return this.longueur;
	}
	
	public List<ArticleRayon> getArticles(){
		return this.articles;
	}
	
	public Point getExt1(){
		return this.ext1;
	}
	
	public Point getExt2(){
		return this.ext2;
	}
}
