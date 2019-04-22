package metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name="BP")
public class BanqueEJBImp implements IBanqueLocal
{
    @PersistenceContext
    EntityManager em;
    
	@Override
	public Compte addCompte(Compte c) 
	{
		em.persist(c);
		return c;
	}

	@Override
	public List<Compte> getAllComptes() 
	{
		Query req= em.createQuery("select c from Compte c");
		return req.getResultList();
	}

	@Override
	public void verser(Long code, double montant)
	{
		if(montant<=0) throw new RuntimeException("Le montant doit être supérieur ç zero");
		Compte c = em.find(Compte.class, code);
		
	}

	@Override
	public void retirer(Long code, double montant) 
	{
		if(montant<=0) throw new RuntimeException
		("Le montant doit etre supérieur à zero");
		Compte c = em.find(Compte.class, code);
		if(c.getSolde()<=montant) throw new RuntimeException
		("Solde Insuffisant");
		c.setSolde(c.getSolde()-montant);
	}

	@Override
	public Compte consulterCompte(Long code)
	{
		return null;
	}
	


@Override
	public void remove(Long id) {
	    Compte c = em.find(Compte.class, id);
	    em.remove(c);
	}
@Override
	public void virement(long codeCpte1, long codeCpte2, double montant) {
		// TODO Auto-generated method stub
		
	}


}
