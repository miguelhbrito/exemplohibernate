package com.mkyong.rest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.mkyong.model.Assinante;
import com.mkyong.model.Champion;
import com.mkyong.util.HibernateUtil;

public class HibernateTest {
	public static void main(String[] args) throws ParseException {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
  
        session.beginTransaction();
        
        Assinante ass = session.find(Assinante.class, 15);
		session.delete(ass);
		
		session.getTransaction().commit();
        
//        Assinante assinante = new Assinante();
//        
//        assinante.setNome("Ekko");
//        DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
//        Date date = formatter.parse("11/02/1993");
//        assinante.setNascimento(date);
//        assinante.setSexo("Masculino");
//        
//        session.save(assinante);
//        session.getTransaction().commit();
        
 
//        Champion champion = new Champion("Twisted Fate", "mid");
//        session.save(champion);
//        session.getTransaction().commit();
        
//        session.beginTransaction();
//        Champion ob1 = session.find(Champion.class, 1);
//        session.delete(ob1);
//        session.getTransaction().commit();
 
         // Usando Criteria
       Criteria criteria = session.createCriteria(Assinante.class);
        List<Assinante> resultList = criteria.list(); 
        
        // select refereciando a classe Java e nao a tabela do banco
        // USANDO HQL
        //Query q = session.createQuery("from com.mkyong.model.Champion ");
        //List<Champion> resultList = q.getResultList();
        
        System.out.println("Assinante:" + resultList.size());
        for (Assinante next : resultList) {
           System.out.println("next assiante: " + next);
        }
 
    }
}
