package metier;
import java.util.List;
import javax.ejb.Local;


public interface IBanqueLocal 
{
	public Compte addCompte( Compte c);
	public List<Compte> getAllComptes();
	public void verser(Long code , double montant);
	public void retirer(Long code , double montant);
	public Compte consulterCompte(Long code);
	public void remove(Long code);
	public void virement(long codeCpte1, long codeCpte2, double montant);
}
