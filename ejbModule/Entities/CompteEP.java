package Entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class CompteEP extends Compte
{
	private double taux;
	
	public void setTaux(double taux)
	{
		this.taux=taux;
	}
	
	public double getTaux()
	{
		return this.taux;
	}
}
