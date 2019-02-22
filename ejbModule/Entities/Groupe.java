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
}
