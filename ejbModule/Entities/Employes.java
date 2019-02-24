package Entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Employes implements Serializable
{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long codeEmploye;
    private String nomEmploye;

    @ManyToOne
    @JoinColumn(name="Code_emp_sup")
    private Employes EmployesSup;
    @ManyToMany
    @JoinTable(name="Emp_Gr", joinColumns=
    @JoinColumn(name="Num_EMP"), inverseJoinColumns=
    @JoinColumn (name="Num_Groupe"))
    private Collection<Groupe> groupes;
    
    public void setCodeEmploye(Long codeEmploye)
    {
    	this.codeEmploye=codeEmploye;
    }
    
    public Long getCodeEmploye()
    {
    	return this.codeEmploye;
    }
    
    public String getNomEmploye()
    {
    	return this.nomEmploye;
    }
    
    public void setNomEmploye(String nomEmploye)
    {
    	this.nomEmploye=nomEmploye;
    }
    
    public void setEmployesSup(Employes EmployesSup)
    {
    	this.EmployesSup=EmployesSup;
    }
    
    public void setGroupes(Collection<Groupe> groupes)
    {
    	this.groupes=groupes;
    }
    
    public Collection<Groupe> getGroupes()
    {
    	return this.groupes;
    }
}