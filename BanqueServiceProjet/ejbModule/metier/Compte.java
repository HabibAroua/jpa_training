package metier;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COMPTES")
public class Compte implements Serializable 
{	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long code;
	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	private double solde;
	private Date dateCreation;
	
	public Compte()
	{
		
	}
	
	public Compte(double solde , Date dateCreation)
	{
		this.solde=solde;
		this.dateCreation=dateCreation;
	}	
	
	public Compte(double solde )
	{
		this.solde=solde;
	}
}
