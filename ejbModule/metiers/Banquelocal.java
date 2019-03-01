package metiers;
import java.util.List;
import javax.ejb.Local;
import Entities.Client;
import Entities.Compte;
import Entities.Employes;
import Entities.Groupe;
import Entities.Operation;

@Local
public interface Banquelocal
{
	public void addClient(Client c);
	public void addEmploye(Employes e , Long numEmSup);
	public void addGroupe(Groupe g);
	public void addEmployeToGroupe(Long idGroupe , Long idEmp);
	public void addCompte(Compte c , Long nulCli , Long numEmp  );
	public void addOperation(Operation op , String numCpte , Long numEmp );
	public Compte consulterCompte(String numCpte);
	public Compte consulterCompte(Long code);
	public List<Client> cosnulterClientParNom(String mc);
	public List<Client> consulterClients();
	public List<Groupe>  consulterGroupes();
	public List<Employes> consulterEmployes();
	public List<Employes> consulterEmployesParGroupe(Long idG);
	public Employes consulterEmploye(Long idEmp);
}