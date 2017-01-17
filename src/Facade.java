import java.util.ArrayList;

import java.util.Date;
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
		
		if(em.createQuery("select c from Client c where c.adresse like" + adresse, Client.class).getResultList().get(0) == null){
			c.init(nom, prenom, adresse,mdp);
			done = true;
			em.persist(c);
		}
		
		return done;
	}
	
	public Client getSubscriber(String a){
		
		Client c = null;
		try{
			c = em.createQuery("select c from Client c where c.adresse like" + a, Client.class).getResultList().get(0);
		}
		catch(IndexOutOfBoundsException e){}
		
		return c;
	}
	
	public List<Magasin> localiser(double longitude, double latitude){
		List<Magasin> l = new ArrayList<Magasin>();
		
		double distMax = 100;
		
		l = em.createQuery("select m from Magasin", Magasin.class).getResultList();
		
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
		
		l = em.createQuery("select m from Magasin", Magasin.class).getResultList();
				
		for(Magasin m : l){
			if( !m.getName().contains(recherche) ){
				l.remove(m);
			}
		}
		
		return l;
	}
	
	
	
}
