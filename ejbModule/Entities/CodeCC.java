package Entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
public class CodeCC extends Compte
{
	private double decouvert;
	
	public void setDecouvert(double decouvert)
	{
		this.decouvert=decouvert;
	}
	
	public double getDecouvert()
	{
		return this.decouvert;
	}
}
