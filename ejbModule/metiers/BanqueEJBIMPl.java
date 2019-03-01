package metiers;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import Entities.Client;
import Entities.Compte;
import Entities.Employes;
import Entities.Groupe;
import Entities.Operation;

@Stateless(name="BANQUE")
public class BanqueEJBIMPl implements Banquelocal
{
    private EntityManager em;
	@Override
	public void addClient(Client c) 
	{
		em.persist(c);
	}

	@Override
	public void addEmploye(Employes e, Long numEmpSup) 
	{
		Employes empSup;
		if(numEmpSup!=null)
		{
			empSup=em.find(Employes.class, numEmpSup);
			e.setEmployesSup(empSup);
		}
		em.persist(e);
	}

	@Override
	public void addGroupe(Groupe g)
	{
		em.persist(g);
	}

	@Override
	public void addEmployeToGroupe(Long idGroupe, Long idEmp) 
	{
		Employes emp=em.find(Employes.class, idEmp);
		Groupe g=em.find(Groupe.class, idGroupe);
		emp.getGroupes().add(g);
		g.getEmployes().add(emp);
	}

	@Override
	public void addCompte(Compte c, Long nulCli, Long numEmp)
	{
		Client cl1=em.find(Client.class, nulCli);
		Employes e=em.find(Employes.class, numEmp);
		c.setClient(cl1);
		c.setEmploye(e);
		em.persist(c);
		
	}

	@Override
	public void addOperation(Operation op, String numCpte, Long numEmp) 
	{
		Compte c=em.find(Compte.class, numCpte);
		Employes emp=em.find(Employes.class, numEmp);
		op.setEmployes(emp);
		op.setCompte(c);
		em.persist(op);
	}

	@Override
	public Compte consulterCompte(String numCpte) 
	{
		Compte cpte=em.find(Compte.class, numCpte);
		if(cpte==null)throw new RuntimeException("Compte "+numCpte+" n'existe pas");
		cpte.getOperations().size();
		return cpte;
	}
	
	@Override
	public Compte consulterCompte(Long code) 
	{
		Compte cp=em.find(Compte.class,code);
		if(cp==null) throw new RuntimeException("Ce compte n'existe pas !!");
		return cp;
	}

	@Override
	public List<Client> cosnulterClientParNom(String mc)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> consulterClients() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Groupe> consulterGroupes()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employes> consulterEmployes() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employes> consulterEmployesParGroupe(Long idG)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employes consulterEmploye(Long idEmp)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
