package Entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable
{
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long codeClient;
    private String nomClient;
    @OneToMany (mappedBy="client",
    fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private Collection<Compte> comptes;
    
    public Long getCodeClient()
    {
    	return this.codeClient;
    }
    
    public void setCodeClient(Long codeClient)
    {
    	this.codeClient=codeClient;
    }
    
    public void setNomClient(String nomClient)
    {
    	this.nomClient=nomClient;
    }
    
    public String getNomClient()
    {
    	return this.nomClient;
    }
    
    public void setComptes(Collection<Compte> comptes)
    {
    	this.comptes=comptes;
    }
    
    public Collection<Compte> getComptes()
    {
    	return this.comptes;
    }
}
