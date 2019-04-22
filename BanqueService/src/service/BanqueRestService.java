package service;

import java.util.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import metier.Compte;
import metier.IBanqueLocal;

@Stateless
@Path("/banque")
public class BanqueRestService 
{
	@EJB
	IBanqueLocal metier;
	
	@POST
	@Path("/comptes")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void addCompte(@PathParam (value="solde")double solde)
	{
		metier.addCompte(new Compte(solde));
	}
	
	@GET
	@Path("/comtes/{code}")
	@Produces(value={MediaType.APPLICATION_JSON})
	public Compte getCompte(@PathParam(value="code")Long code)
	{
		return null; //metier.getCompte(code);
	}
	
	@GET
	@Path("/comptes")
	@Produces(value={MediaType.APPLICATION_JSON})
	public List<Compte> getComptes()
	{
		return metier.getAllComptes();
	}
	
	@PUT
	@Path("comptes/verser")
	public void verser(@FormParam("code") Long code , @FormParam("montant") double montant)
	{
		metier.verser(code, montant);
	}
	
	@PUT
	@Path("comptes/retirer")
	public void retirer(@FormParam("code") Long code , @FormParam("montant") double montant)
	{
		metier.retirer(code, montant);
	}
	
	@PUT
	@Path("/comptes/virement")
	@Produces(value={MediaType.APPLICATION_JSON})
	public void virement (@FormParam("cpte1") Long cpte1, @FormParam("cpte2") Long cpte2,@FormParam("montant") Long montant )
	{
		metier.virement(cpte1, cpte2, montant);
	}
	
	@DELETE
	@Path("/comptes/{code}")
	public void supprimer(@PathParam("code") Long code)
	{
		//metier.deleteCompte(code);
	}
	
}
