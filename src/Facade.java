import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class Facade {

	@PersistenceContext
	EntityManager em;
	
	public boolean subscribe( String nom, String prenom, String adresse, String mdp ){
		Client c = new Client();
		
		boolean done = false;
		
		try{
			em.createQuery("select c from Client c where c.adresse = '" + adresse + "'", Client.class).getResultList().get(0);
		}
		catch(IndexOutOfBoundsException e){
			c.init(nom, prenom, adresse,mdp);
			done = true;
			em.persist(c);
		}
		
		return done;
	}
	
	public Client getSubscriber(String a, String mdp){
		
		Client c = null;
		try{
			c = em.createQuery("select c from Client c where c.adresse = '" + a + "' and c.mdp = '" + a + "'", Client.class).getResultList().get(0);
		}
		catch(IndexOutOfBoundsException e){}
		
		return c;
	}
	
	public List<Magasin> localiser(double longitude, double latitude){
		List<Magasin> l = new ArrayList<Magasin>();
		
		double distMax = 100;
		
		l = em.createQuery("select m from Magasin m", Magasin.class).getResultList();
		
		for(Magasin m :l){
			if( m.distance(longitude, latitude) > distMax){
				l.remove(m);
			}
		}
		
		return l;
	}
	
	public List<Magasin> choisirMagasin(String recherche){
		List<Magasin> l = new ArrayList<Magasin>();
		
		l = null;
		
		l = em.createQuery("select m from Magasin m", Magasin.class).getResultList();
				
		for(Magasin m : l){
			if( !m.getName().contains(recherche) ){
				l.remove(m);
			}
		}
		
		return l;
	}
	public List<String> nomsMagasin(String recherche){
		List<Magasin> l = new ArrayList<Magasin>();
		List<String> l2 = new ArrayList<String>();
		l = null;
		
		l = em.createQuery("select m from Magasin m", Magasin.class).getResultList();
		
		for(Magasin m : l){
			if( m.getName().contains(recherche) ){
				l2.add(m.getName());
			}
		}
		
		return l2;
	}
	public List<Produit> getProductList(String a){
		
		Client c = null;
		try{
			c = em.createQuery("select c from Client c where c.adresse = '" + a + "'", Client.class).getResultList().get(0);
		}
		catch(IndexOutOfBoundsException e){}
		
		List<Produit> l = c.getListeCourses().getListeCourses();
		
		return l;
		
	}
	
	public List<Produit> productMagasin(int id){
		
		List<Produit> l = new ArrayList<Produit>();
		
		Magasin m = null;
		
		try{
			m = em.createQuery("select m from Magasin m where m.num = '" + id + "'", Magasin.class).getResultList().get(0);
		}
		catch(IndexOutOfBoundsException e){}
		
		l = m.allProducts();
		
		return l;
	}
	
	public void registerProductList(String adresse, List<Produit> liste){
		Client c = null;
		ListeCourses l = new ListeCourses();
		l.init();
		l.setListeCourses(liste);
		
		try{
			c = em.createQuery("select c from Client c where c.adresse = '" + adresse + "'", Client.class).getResultList().get(0);
			
			em.getTransaction().begin();
			c.setListeCourses(l);
			em.getTransaction().commit();
		}
		catch(IndexOutOfBoundsException e){}
		
	}
	
	
	
}
