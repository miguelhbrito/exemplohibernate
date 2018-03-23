package com.mkyong.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.mkyong.model.Assinante;
import com.mkyong.util.HibernateUtil;

@Path("/rest/")
public class RestService {

	@GET
	@Path("/clientes")
	@Produces("application/json")
	public List<Assinante> getAssinanteInJSON() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Criteria criteria = session.createCriteria(Assinante.class);
        List<Assinante> resultList = criteria.list();
        
		return resultList; 

	}
	
	@POST
	@Path("/clientes")
	@Consumes("application/json")
	public boolean insereCliente(Assinante assinante) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(assinante);
		session.getTransaction().commit();
		return true;
	    
	}
	
	@DELETE
	@Path("/clientes/{id}")
	@Produces("application/json")
	public List<Assinante> deletaCliente(@PathParam("id") int idAssinante) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//Assinante ass = session.find(Assinante.class, idAssinante);
		//session.delete(ass);
		
		//Assinante assinante = (Assinante) session.createCriteria(Assinante.class).add(Restrictions.eq("idassinante", idAssinante)).uniqueResult();
		//session.delete(assinante);
		
		Query query = session.createQuery("delete assinante_cliente where idassinante = :idAssinante");
		query.setParameter("idAssinante", idAssinante);
		query.executeUpdate();
		
		session.getTransaction().commit();
		
		Criteria criteria = session.createCriteria(Assinante.class);
        List<Assinante> resultList = criteria.list();
        
		return resultList; 
		}
	
	@PUT
	@Path("/clientes/{id}")
	@Consumes("application/json")
	public Assinante updateCliente(@PathParam("id") int idAssinante, Assinante assinante) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Assinante ass = session.find(Assinante.class, idAssinante);
		ass.setNascimento(assinante.getNascimento());
		ass.setNome(assinante.getNome());
		ass.setSexo(assinante.getSexo());
		
		session.save(ass);
		
		session.getTransaction().commit();
		
		return assinante;
	}

}