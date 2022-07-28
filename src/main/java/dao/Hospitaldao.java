package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Hospital;
import dto.Patient;

public class Hospitaldao 
{
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("ui");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void insertHos(Hospital h)
	{
		entityTransaction.begin();
		entityManager.persist(h);
		entityTransaction.commit();	
	}
	public Hospital findHos(int i)
	{
		Hospital hs1=entityManager.find(Hospital.class,i);
		return hs1;
	}
	
	public void deleteHospital(int i)
	{
		Hospital hs1=entityManager.find(Hospital.class,i);
		if(hs1!=null)
		{
			entityTransaction.begin();
			entityManager.remove(hs1);
			entityTransaction.commit();
		}
		else
		System.out.println("no data found");
	}

	public void updateHos(Hospital h2)
	{
		//Hospital h1=entityManager.find(Hospital.class, id);
		if(h2!=null)
		{
		entityTransaction.begin();
		entityManager.merge(h2);
		entityTransaction.commit();
		}
	}
	
	public List<Hospital> fetchHos()
	{	
		Query q=entityManager.createQuery("select h from Hospital h",Hospital.class);
		List<Hospital> lt=q.getResultList();
		return lt; 
	}
} 
