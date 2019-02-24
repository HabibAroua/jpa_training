package Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Type_CPT",
discriminatorType=DiscriminatorType.STRING, length=2)

public class Compte implements Serializable 
{
	
	@Id
	private String codeCompte;
	private Date dateCreation;
	private double solde;
	@ManyToOne
	@JoinColumn(name="Code_Cli")
	private Client client;
	@ManyToOne
	@JoinColumn(name="Code_Emp")
	private Employes employe;
	@OneToMany( mappedBy="compte")
	private Collection <Operation> operations;

	
	private static final long serialVersionUID = 1L;
	
	public String getCodeCompte() 
	{
		return codeCompte;
	}
	
	public void setCodeCompte(String codeCompte) 
	{
		this.codeCompte = codeCompte;
	}
	
	public Date getDateCreation()
	{
		return this.dateCreation;
	}
	
	public void setDateCreation(Date dateCreation)
	{
		this.dateCreation = dateCreation;
	}
	
	public double getSolde()
	{
		return this.solde;
	}
	
	public void setSolde(double solde) 
	{
		this.solde = solde;
	}
	
	public Client getClient() 
	{
		return this.client;
	}
	
	public void setClient(Client client)
	{
		this.client = client;
	}
	
	public Employes getEmploye() 
	{
		return this.employe;
	}
	
	public void setEmploye(Employes employe)
	{
		this.employe = employe;
	}
	
	public Collection<Operation> getOperations()
	{
		return this.operations;
	}
	
	public void setOperations(Collection<Operation> operations) 
	{
		this.operations = operations;
	}
	
	public Compte() 
	{
		super();
	}
}
