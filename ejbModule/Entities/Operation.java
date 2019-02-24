package Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(length=1)

public class Operation implements Serializable
{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long numeroOperation;
    private Date dateOperation;
    private double montant;
    @ManyToOne
    @JoinColumn(name="Code_CPT")
    private Compte compte;
    @ManyToOne
    @JoinColumn(name="Code_Employe")
    private Employes employe;
    
    public void setNumeroOperation(Long numeroOperation)
    {
    	this.numeroOperation=numeroOperation;
    }
    
    public Long getNumeroOperation()
    {
    	return this.numeroOperation;
    }
    
    public void setDateOperation(Date dateOperation)
    {
    	this.dateOperation=dateOperation;
    }
    
    public Date getDateOperation()
    {
    	return this.dateOperation;
    }
    
    public void setMontant(double montant)
    {
    	this.montant=montant;
    }
    
    public double getMontant()
    {
    	return this.montant;
    }
    
    public void setCompte(Compte compte)
    {
    	this.compte=compte;
    }
    
    public Compte getCompte()
    {
    	return this.compte;
    }
    
    public void setEmployes(Employes employe)
    {
    	this.employe=employe;
    }
    
    public Employes getEmployes()
    {
    	return this.employe;
    }
}
