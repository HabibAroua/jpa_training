package Entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Groupes")
public class Groupe implements Serializable 
{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long codeGroupe;
    private String nomGroupe;

    @ManyToMany(mappedBy="groupes")
    private Collection<Employes> employes;
    
    public void setCodeGroupe(Long codeGroupe)
    {
    	this.codeGroupe=codeGroupe;
    }
    
    public Long getCodeGroupe()
    {
    	return this.codeGroupe;
    }
    
    public void setNomGroupe(String nomGroupe)
    {
    	this.nomGroupe=nomGroupe;
    }
    
    public String getNomGroupe()
    {
    	return this.nomGroupe;
    }
    
    public void setEmployes(Collection<Employes> employes)
    {
    	this.employes=employes;
    }
    
    public Collection<Employes> getEmployes()
    {
    	return this.employes;
    }
    
}
