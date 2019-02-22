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

	public Compte() {
		super();
	}
   
}
